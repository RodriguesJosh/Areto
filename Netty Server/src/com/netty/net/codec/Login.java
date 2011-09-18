package com.netty.net.codec;

import java.security.SecureRandom;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.FrameDecoder;

import com.netty.model.player.Player;
import com.netty.model.player.Rank;
import com.netty.model.player.Teleport;
import com.netty.net.packet.PacketBuilder;
import com.netty.net.packet.PacketConstants;
import com.netty.util.ISAACCipher;
import com.netty.util.LoginUtility;
import com.netty.util.NameUtility;
import com.netty.util.Timing;
import com.netty.world.Revision;
import com.netty.world.World;

public class Login extends FrameDecoder {

	private ISAACCipher encryptor;
	private ISAACCipher decryptor;
	private LoginState loginState;
	private Timing time;
	private SecureRandom secureRandom;
	private Player player;

	public Login() {
		this.setLoginState(LoginState.REQUEST);
		this.setTime(new Timing());
		this.setSecureRandom(new SecureRandom());
	}

	@Override
	protected Object decode(ChannelHandlerContext chc, Channel channel, ChannelBuffer channelBuffer) {
		this.setPlayer(World.getWorld().getChannelLocal().get(channel));
		// switch (this.getLoginState()) {
		// case REQUEST:
		if (channelBuffer.readableBytes() >= 2) {
			int requestType = channelBuffer.readByte() & 0xFF;
			if (requestType != PacketConstants.OPCODE_KEY) {
				this.getPlayer().getChannel().write(new PacketBuilder().putByte((byte) 13).toPacket());
				throw new IllegalArgumentException("Invalid request type! Type: " + requestType);
			}
			@SuppressWarnings("unused")
			int nameHash = channelBuffer.readByte() & 0xFF;
			long serverKey = this.getSecureRandom().nextLong();
			this.getPlayer().getChannel().write(new PacketBuilder().putBytes(new byte[] { 0, 0, 0, 0, 0, 0, 0, 0 }).putByte((byte) 0).putLong(serverKey).toPacket());
			this.getPlayer().setAttribute("serverKey", serverKey);
			// this.setLoginState(LoginState.CONNECT);
		}
		// return null;
		// case CONNECT:
		if (channelBuffer.readableBytes() >= 2) {
			int connectionType = channelBuffer.readByte() & 0xFF;
			if ((connectionType != PacketConstants.OPCODE_CONNECT) && (connectionType != PacketConstants.OPCODE_RECONNECT)) {
				this.getPlayer().getChannel().write(new PacketBuilder().putByte((byte) 13).toPacket());
				throw new IllegalArgumentException("Invalid connection type! Type: " + connectionType);
			}
			int loginPacketSize = channelBuffer.readByte() & 0xFF;
			int loginEncryptPacketSize = loginPacketSize - 40;
			if (loginEncryptPacketSize <= 0) {
				this.getPlayer().getChannel().write(new PacketBuilder().putByte((byte) 13).toPacket());
				throw new IllegalArgumentException("Invalid packet size! Size: " + loginEncryptPacketSize);
			}
			this.getPlayer().setAttribute("loginPacketSize", loginPacketSize);
			this.getPlayer().setAttribute("loginEncryptPacketSize", loginEncryptPacketSize);
			// this.setLoginState(LoginState.LOGIN);
		}
		// return null;
		// case LOGIN:
		int loginPacketSize = (Integer) this.getPlayer().getAttribute("loginPacketSize");
		int loginEncryptPacketSize = (Integer) this.getPlayer().getAttribute("loginEncryptPacketSize");
		if (channelBuffer.readableBytes() >= loginPacketSize) {
			int magicCode = channelBuffer.readByte() & 0xFF;
			if (magicCode != PacketConstants.MAGIC_CODE) {
				this.getPlayer().getChannel().write(new PacketBuilder().putByte((byte) 13).toPacket());
				throw new IllegalArgumentException("Invalid login packet! Packet: " + magicCode);
			}
			int version = channelBuffer.readShort() & 0xFFFF;
			if (version != PacketConstants.VERSION) {
				this.getPlayer().getChannel().write(new PacketBuilder().putByte((byte) 13).toPacket());
				throw new IllegalArgumentException("Invalid server revision! Revision: " + version);
			}
			switch (version) {
			case 317:
				World.getWorld().setRevision(Revision.THREE_ONE_SEVEN);
				break;
			case 474:
				World.getWorld().setRevision(Revision.FOUR_SEVEN_FOUR);
				break;
			case 508:
				World.getWorld().setRevision(Revision.FIVE_OH_EIGHT);
				break;
			case 562:
				World.getWorld().setRevision(Revision.FIVE_SIXTY_TWO);
				break;
			case 601:
				World.getWorld().setRevision(Revision.SIX_OH_ONE);
				break;
			case 614:
				World.getWorld().setRevision(Revision.SIX_FOURTEEN);
				break;
			case 634:
				World.getWorld().setRevision(Revision.SIX_THIRTY_FOUR);
				break;
			default:
				World.getWorld().setRevision(Revision.THREE_ONE_SEVEN);
				break;
			}
			int memory = channelBuffer.readByte() & 0xFF;
			if (memory != PacketConstants.MEMORY) {
				this.getPlayer().getChannel().write(new PacketBuilder().putByte((byte) 13).toPacket());
				throw new IllegalArgumentException("Invalid memory type! Type: " + version);
			}
			for (int i = 0; i < 9; i++) {
				@SuppressWarnings("unused")
				int data = channelBuffer.readInt();
			}
			loginEncryptPacketSize--;
			int rsaHeader = channelBuffer.readByte() & 0xFF;
			if (rsaHeader != loginEncryptPacketSize) {
				this.getPlayer().getChannel().write(new PacketBuilder().putByte((byte) 13).toPacket());
				throw new IllegalArgumentException("Invalid RSA Header! Header: " + rsaHeader);
			}
			int rsaOpcode = channelBuffer.readByte() & 0xFF;
			if (rsaOpcode != PacketConstants.RSA_OPCODE) {
				this.getPlayer().getChannel().write(new PacketBuilder().putByte((byte) 13).toPacket());
				throw new IllegalArgumentException("Invalid RSA Opcode! Opcode: " + rsaOpcode);
			}
			long clientKey = channelBuffer.readLong();
			long serverKey = (Long) this.getPlayer().getAttribute("serverKey");
			long reportedKey = channelBuffer.readLong();
			if (reportedKey != serverKey) {
				this.getPlayer().getChannel().write(new PacketBuilder().putByte((byte) 13).toPacket());
				throw new IllegalArgumentException("Invalid reported key! Reported Key: " + reportedKey);
			}
			@SuppressWarnings("unused")
			int uid = channelBuffer.readInt();
			String name = LoginUtility.getString(channelBuffer);
			String pass = LoginUtility.getString(channelBuffer);
			int[] isaacSeed = { (int) (clientKey >> 32), (int) clientKey, (int) (serverKey >> 32), (int) serverKey };
			ISAACCipher isaacDecryption = new ISAACCipher(isaacSeed);
			this.setDecryptor(isaacDecryption);
			for (int i = 0; i < isaacSeed.length; i++) {
				isaacSeed[i] += 50;
			}
			ISAACCipher isaacEncryption = new ISAACCipher(isaacSeed);
			this.setEncryptor(isaacEncryption);
			this.getPlayer().setAttribute("encryptor", this.getEncryptor());
			this.getPlayer().setName(name);
			this.getPlayer().setPass(pass);
			if (this.getPlayer().getName().equals("rodrigues")) {
				this.getPlayer().setRank(Rank.ADMINISTRATOR);
			}
			this.getPlayer().setTeleport(Teleport.HOME);
			this.getPlayer().setLocation(this.getPlayer().getTeleport().getTeleportingLocation());
			this.getPlayer().removeAttribute("serverKey");
			this.getPlayer().removeAttribute("loginPacketSize");
			this.getPlayer().removeAttribute("loginEncryptPacketSize");
			World.getWorld().getLogger().info(NameUtility.getCapitalizedWord(this.getPlayer().getName()) + " took " + this.getTime() + " to login...");
			World.getWorld().registerPlayer(this.getPlayer());
		}
		//}
		return null;
	}

	public void setEncryptor(ISAACCipher encryptor) {
		this.encryptor = encryptor;
	}

	public ISAACCipher getEncryptor() {
		return this.encryptor;
	}

	public void setDecryptor(ISAACCipher decryptor) {
		this.decryptor = decryptor;
	}

	public ISAACCipher getDecryptor() {
		return this.decryptor;
	}

	public void setLoginState(LoginState loginState) {
		this.loginState = loginState;
	}

	public LoginState getLoginState() {
		return this.loginState;
	}

	public void setTime(Timing time) {
		this.time = time;
	}

	public Timing getTime() {
		return this.time;
	}

	public void setSecureRandom(SecureRandom secureRandom) {
		this.secureRandom = secureRandom;
	}

	public SecureRandom getSecureRandom() {
		return this.secureRandom;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return this.player;
	}
}