package com.netty.net.packet;

import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;

import com.netty.model.item.Item;
import com.netty.model.object.Object;
import com.netty.model.player.Player;
import com.netty.model.player.skill.SkillConstants;
import com.netty.model.player.skill.SkillType;
import com.netty.model.update.UpdateFlag;
import com.netty.util.TextUtility;
import com.netty.world.World;

public class PacketSender {

	private Player player;

	public PacketSender(Player player) {
		this.setPlayer(player);
	}

	public PacketSender getLogin() {
		this.getPlayerID().getCamera().getMapRegion().getMessage("Welcome!");// .interfaces().skills();
		// this.privateMessageStatus(2).menuOption(4, 0, "Trade With", 3).menuOption(5, 0, "Follow", 4);
		// this.inventory().equipment().bank();
		// File characterFile = new File(Constants.SAVE_CHARACTER_XML + this.getPlayer().getName() + ".xml");
		// if (!characterFile.exists()) {
		// this.showInterface(3559);
		// }
		return this;
	}

	public PacketSender getPlayerID() {
		if (this.getPlayer() != null) {
			this.getPlayer().getChannel().write(new PacketBuilder(PacketConstants.PLAYER_INFORMATION).putByteA(this.getPlayer().isMembership() ? 1 : 0).putLEShortA(this.getPlayer().getIndex()));
		}
		return this;
	}

	public PacketSender getCamera() {
		if (this.getPlayer() != null) {
			this.getPlayer().getChannel().write(new PacketBuilder(PacketConstants.RESET_CAMERA));
		}
		return this;
	}

	public PacketSender getInterfaces() {
		int[] interfaces = { 2423, 3917, 638, 3213, 1644, 5608, 1151, 12855, 5065, 5715, 2449, 4445, 147, 6299 };
		if (this.getPlayer() != null) {
			for (int i = 0; i < interfaces.length; i++) {
				this.getPlayer().getChannel().write(new PacketBuilder(PacketConstants.SKILL_INTERFACE).putShort(interfaces[i]).putByteA(i).toPacket());
			}
		}
		return this;
	}

	public PacketSender getMapRegion() {
		if (this.getPlayer() != null) {
			this.getPlayer().setLastLocation(this.getPlayer().getLocation());
			this.getPlayer().getChannel().write(new PacketBuilder(PacketConstants.MAP_REGION).putShortA(this.getPlayer().getLocation().getRegionX() + 6).putShort(this.getPlayer().getLocation().getRegionY() + 6));
			this.getPlayer().setMapChanging(false);
		}
		return this;
	}

	public PacketSender getMessage(String message) {
		if (this.getPlayer() != null) {
			this.getPlayer().getChannel().write(new PacketBuilder(PacketConstants.MESSAGE, PacketType.VARIABLE_BYTE).putString(World.getWorld().getGoogleTranslatedLanguage(this.getPlayer(), message)));
		}
		return this;
	}

	public PacketSender getSkills() {
		for (byte b = 0; b < SkillConstants.MAX_SKILLS; b++) {
			this.getSkills(b);
		}
		return this;
	}

	public PacketSender getSkills(byte id) {
		if (this.getPlayer() != null) {
			this.getPlayer().getChannel().write(new PacketBuilder(PacketConstants.SKILLS).putByte(id).putInt1(this.getPlayer().getSkills()[id].getExperience()).putByte(this.getPlayer().getSkills()[id].getLevel()).toPacket());
		}
		return this;
	}

	public PacketSender getPrivateMessage(String name, String text, int size) {
		if (this.getPlayer() != null) {
			this.getPlayer().getChannel().write(new PacketBuilder(PacketConstants.PRIVATE_MESSAGE).putString(name).putInt(text.length()).putByte(this.getPlayer().getRank().getID()).putBytes(World.getWorld().getGoogleTranslatedLanguage(this.getPlayer(), text).getBytes(), size, 0).toPacket());
		}
		return this;
	}

	public PacketSender getLogout() {
		if (this.getPlayer() != null) {
			if (this.getPlayer().isCombatting()) {
				return this;
			}
			this.getPlayer().getChannel().write(new PacketBuilder(PacketConstants.LOGOUT).toPacket()).addListener(new ChannelFutureListener() {
				@Override
				public void operationComplete(ChannelFuture channelFuture) throws Exception {
					World.getWorld().unregisterPlayer(PacketSender.this.getPlayer());
				}
			});
		}
		return this;
	}

	public PacketSender getInventory() {
		PacketBuilder packetBuilder = new PacketBuilder(PacketConstants.TYPE_CONTAINER, PacketType.VARIABLE_SHORT).putShort((short) 3214);
		int itemLength = this.getPlayer().getInventory().getInventoryContainer().getItems().length;
		for (int i = 0; i < itemLength; i++) {
			packetBuilder.putShort(itemLength);
			Item item = this.getPlayer().getInventory().getInventoryContainer().getItem(i);
			if (item != null) {
				if (item.getAmount() > 254) {
					packetBuilder.putByte((byte) 255);
					packetBuilder.putInt2(item.getAmount());
				} else {
					packetBuilder.putByte((byte) item.getAmount());
				}
				packetBuilder.putLEShortA(item.getID());
			}
		}
		this.getPlayer().getChannel().write(packetBuilder.toPacket());
		return this;
	}

	public PacketSender getEquipment() {
		PacketBuilder packetBuilder = new PacketBuilder(PacketConstants.EQUIPMENT, PacketType.VARIABLE_SHORT).putShort(1688);
		int itemLength = this.getPlayer().getEquipment().getEquipmentContainer().getItems().length;
		for (int i = 0; i < itemLength; i++) {
			packetBuilder.putByte((byte) i);
			Item item = this.getPlayer().getEquipment().getItem(i);
			if (item != null) {
				packetBuilder.putShort(item.getID() + 1);
				if (item.getAmount() > 254) {
					packetBuilder.putByte((byte) 255);
					packetBuilder.putShort(item.getAmount());
				} else {
					packetBuilder.putByte((byte) item.getAmount());
				}
			}
		}
		this.getPlayer().getChannel().write(packetBuilder.toPacket());
		this.getPlayer().getUpdateFlags().setUpdateFlag(UpdateFlag.APPEARANCE);
		return this;
	}

	public PacketSender getBank() {
		PacketBuilder packetBuilder = new PacketBuilder(PacketConstants.TYPE_CONTAINER, PacketType.VARIABLE_SHORT).putShort(5382);
		int itemLength = this.getPlayer().getEquipment().getEquipmentContainer().getItems().length;
		packetBuilder.putShort(itemLength);
		for (int i = 0; i < itemLength; i++) {
			Item item = this.getPlayer().getBank().getBankContainer().getItem(i);
			if (item != null) {
				if (item.getAmount() > 254) {
					packetBuilder.putByte((byte) 255);
					packetBuilder.putInt2(item.getAmount());
				} else {
					packetBuilder.putByte((byte) item.getAmount());
				}
				packetBuilder.putLEShortA(item.getID());
			}
		}
		this.getPlayer().getChannel().write(packetBuilder.toPacket());
		return this;
	}

	public PacketSender getInventoryBank() {
		PacketBuilder packetBuilder = new PacketBuilder(PacketConstants.TYPE_CONTAINER, PacketType.VARIABLE_SHORT).putShort(5064);
		int itemLength = this.getPlayer().getEquipment().getEquipmentContainer().getItems().length;
		packetBuilder.putShort(itemLength + 1);
		for (int i = 0; i < (itemLength + 1); i++) {
			Item item = this.getPlayer().getInventory().getInventoryContainer().getItem(i);
			if (item != null) {
				if (item.getAmount() > 254) {
					packetBuilder.putByte((byte) 255);
					packetBuilder.putInt2(item.getAmount());
				} else {
					packetBuilder.putByte((byte) item.getAmount());
				}
				packetBuilder.putLEShortA(item.getID());
			}
		}
		this.getPlayer().getChannel().write(packetBuilder.toPacket());
		return this;
	}

	public PacketSender getOpenBank() {
		if (this.getPlayer() != null) {
			PacketBuilder packetBuilder = new PacketBuilder(PacketConstants.BANK).putShortA(5292).putShort(5063);
			this.getInventoryBank();
			this.getPlayer().getChannel().write(packetBuilder.toPacket());
		}
		return this;
	}

	public PacketSender getText(String text, int id) {
		if (this.getPlayer() != null) {
			this.getPlayer().getChannel().write(new PacketBuilder(PacketConstants.TEXT, PacketType.VARIABLE_SHORT).putString(text).putShortA(id).toPacket());
		}
		return this;
	}

	public PacketSender getShownInterface(int interfaceID) {
		if (this.getPlayer() != null) {
			this.getPlayer().getChannel().write(new PacketBuilder(97).putShort(interfaceID).toPacket());
		}
		return this;
	}

	public PacketSender getPrivateMessageStatus(byte status) {
		if (this.getPlayer() != null) {
			this.getPlayer().getChannel().write(new PacketBuilder(221).putByte(status).toPacket());
		}
		return this;
	}

	public PacketSender getRemovedWindows() {
		if (this.getPlayer() != null) {
			this.getPlayer().getChannel().write(new PacketBuilder(219).toPacket());
		}
		return this;
	}

	public PacketSender getRegisteredObject(Object object) {
		if ((this.getPlayer() != null) && (object != null)) {
			this.getPlayer().getChannel().write(new PacketBuilder(PacketConstants.ENTITY_LOCATION).putByteC(object.getLocation().getY() - (this.getPlayer().getLocation().getRegionY() * 8)).putByteC((object.getLocation().getX() - (this.getPlayer().getLocation().getRegionX() * 8))).toPacket());
			this.getPlayer().getChannel().write(new PacketBuilder(PacketConstants.OBJECT_DEFINITION).putByteC((object.getType() << 2) + (object.getDirection() & 3)).putByte((byte) 0).toPacket());
			if (object.getID() != -1) {
				this.getPlayer().getChannel().write(new PacketBuilder(PacketConstants.OBJECT_ID).putByteS(0).putLEShort(object.getID()).putByteS((byte) ((object.getType() << 2) + (object.getDirection() & 3))).toPacket());
			}
		}
		return this;
	}

	public PacketSender energy() {
		if (this.getPlayer() != null) {
			this.getPlayer().getChannel().write(new PacketBuilder(PacketConstants.ENERGY).putByte((byte) this.getPlayer().getEnergy().getEnergyAmount()).toPacket());
		}
		return this;
	}

	public PacketSender getUnregisteredObject(Object object) {
		if (this.getPlayer() != null) {
		}
		return this;
	}

	public PacketSender getChoice(String s, String s1) {
		if (this.getPlayer() != null) {
			this.getText("Select an Option", 2460).getText(s, 2461).getText(s1, 2462).getFrame164(2459);
		}
		return this;
	}

	public PacketSender getChoice(String s, String s1, String s2) {
		if (this.getPlayer() != null) {
			this.getText("Select an Option", 2460).getText(s, 2461).getText(s1, 2462).getText(s2, 2462).getFrame164(2459);
		}
		return this;
	}

	public PacketSender getChoice(String s, String s1, String s2, String s3) {
		if (this.getPlayer() != null) {
			this.getText("Select an Option", 2481).getText(s, 2482).getText(s1, 2483).getText(s2, 2484).getText(s3, 2485).getFrame164(2480);
		}
		return this;
	}

	public PacketSender getChoice(String s, String s1, String s2, String s3, String s4) {
		if (this.getPlayer() != null) {
			this.getText("Select an Option", 2493).getText(s, 2494).getText(s1, 2495).getText(s2, 2496).getText(s3, 2497).getText(s4, 2498).getFrame164(2492);
		}
		return this;
	}

	public PacketSender getNPCTalk(String s, int chatNPC, String name) {
		if (this.getPlayer() != null) {
			this.getFrame200(4883, 591).getText(name, 4884).getText(s, 4885).getFrame75(chatNPC, 4883).getFrame164(4882);
		}
		return this;
	}

	public PacketSender getNPCTalk(String s, String s1, int chatNPC, String name) {
		if (this.getPlayer() != null) {
			this.getFrame200(4888, 591).getText(name, 4889).getText(s, 4890).getText(s1, 4891).getFrame75(chatNPC, 4888).getFrame164(4887);
		}
		return this;
	}

	public PacketSender getNPCTalk(String s, String s1, String s2, int chatNPC, String name) {
		if (this.getPlayer() != null) {
			this.getFrame200(4894, 591).getText(name, 4895).getText(s, 4896).getText(s1, 4897).getFrame75(chatNPC, 4893).getFrame164(4893);
		}
		return this;
	}

	public PacketSender getNPCTalk(String s, String s1, String s2, String s3, int chatNPC, String name) {
		if (this.getPlayer() != null) {
			this.getFrame200(4901, 591).getText(name, 4902).getText(s, 4903).getText(s1, 4904).getText(s2, 4905).getText(s3, 4906).getFrame75(chatNPC, 4901).getFrame164(4900);
		}
		return this;
	}

	public PacketSender playerTalk(String s) {
		if (this.getPlayer() != null) {
			this.getFrame200(969, 591).getText(this.getPlayer().getName(), 970).getText(s, 971).getFrame185(969).getFrame164(968);
		}
		return this;
	}

	public PacketSender playerTalk(String s, String s1) {
		if (this.getPlayer() != null) {
			this.getFrame200(974, 591).getText(this.getPlayer().getName(), 975).getText(s, 976).getText(s1, 977).getFrame185(974).getFrame164(973);
		}
		return this;
	}

	public PacketSender getPlayerTalk(String s, String s1, String s2) {
		if (this.getPlayer() != null) {
			this.getFrame200(980, 591).getText(this.getPlayer().getName(), 981).getText(s, 982).getText(s1, 983).getText(s2, 984).getFrame185(980).getFrame164(979);
		}
		return this;
	}

	public PacketSender getPlayerTalk(String s, String s1, String s2, String s3) {
		if (this.getPlayer() != null) {
			this.getFrame200(987, 591).getText(this.getPlayer().getName(), 988).getText(s, 989).getText(s1, 990).getText(s2, 991).getText(s3, 992).getFrame185(987).getFrame164(986);
		}
		return this;
	}

	public PacketSender getFrame200(int mainFrame, int subFrame) {
		if (this.getPlayer() != null) {
			this.getPlayer().getChannel().write(new PacketBuilder(PacketConstants.PACKET_200).putShort(mainFrame).putShort(subFrame).toPacket());
		}
		return this;
	}

	public PacketSender getFrame164(int frame) {
		if (this.getPlayer() != null) {
			this.getPlayer().getChannel().write(new PacketBuilder(PacketConstants.PACKET_164).putLEShort(frame).toPacket());
		}
		return this;
	}

	public PacketSender getFrame248(int mainFrame, int subFrame) {
		if (this.getPlayer() != null) {
			this.getPlayer().getChannel().write(new PacketBuilder(PacketConstants.PACKET_248).putShortA(mainFrame).putShort((short) subFrame).toPacket());
		}
		return this;
	}

	public PacketSender getFrame185(int frame) {
		if (this.getPlayer() != null) {
			this.getPlayer().getChannel().write(new PacketBuilder(PacketConstants.PACKET_185).putLEShortA(frame).toPacket());
		}
		return this;
	}

	public PacketSender getFrame75(int mainFrame, int subFrame) {
		if (this.getPlayer() != null) {
			this.getPlayer().getChannel().write(new PacketBuilder(PacketConstants.PACKET_75).putLEShortA(mainFrame).putLEShortA(subFrame).toPacket());
		}
		return this;
	}

	public PacketSender getMenuOption(int i, int l, String text, int a) {
		if (this.getPlayer() != null) {
			this.getPlayer().getChannel().write(new PacketBuilder(PacketConstants.MENU_OPTION, PacketType.VARIABLE_BYTE).putByteC((byte) i).putByteA((byte) l).putString(text).toPacket());
		}
		return this;
	}

	public PacketSender getInterfaceInventory(int interfaceID, int inventoryInterfaceID) {
		if (this.getPlayer() != null) {
			this.getPlayer().getChannel().write(new PacketBuilder(PacketConstants.INVENTORY).putShortA(interfaceID).putShort(inventoryInterfaceID).toPacket());
		}
		return this;
	}

	public PacketSender getRegisteredGroundItem(Item item) {
		if (this.getPlayer() != null) {
			int x = item.getLocation().getX() - (this.getPlayer().getLastLocation().getRegionX() * 8);
			int y = item.getLocation().getY() - (this.getPlayer().getLastLocation().getRegionY() * 8);
			this.getPlayer().getChannel().write(new PacketBuilder(PacketConstants.ENTITY_LOCATION).putByteC(y).putByteC(x).toPacket());
			this.getPlayer().getChannel().write(new PacketBuilder(PacketConstants.ITEM_DEFINITION).putLEShortA(item.getID()).putShort(item.getAmount()).putByte((byte) 0).toPacket());
		}
		return this;
	}

	public PacketSender getUnregisteredGroundItem(Item item) {
		if (this.getPlayer() != null) {
			int x = item.getLocation().getX() - (this.getPlayer().getLastLocation().getRegionX() * 8);
			int y = item.getLocation().getY() - (this.getPlayer().getLastLocation().getRegionY() * 8);
			this.getPlayer().getChannel().write(new PacketBuilder(PacketConstants.ENTITY_LOCATION).putByteC(y).putByteC(x).toPacket());
			this.getPlayer().getChannel().write(new PacketBuilder(PacketConstants.ITEM_ID).putByteS(0).putShort(item.getID()).toPacket());
		}
		return this;
	}

	public PacketSender getLevelSkill(SkillType skillType, int firstID, int secondID, int thirdID) {
		if (this.getPlayer() != null) {
			String firstMessage = "Congratulations, you just advanced " + TextUtility.getVowel(skillType.getName()) + " level!";
			String secondMessage = "Your " + skillType.getName() + " level is now " + /** getLevelForXP(c.playerXP[skillType.getID()]) */0 + ".";
			String thirdMessage = "Congratulations, you just advanced " + TextUtility.getVowel(skillType.getName()) + " level.";
			this.getText(World.getWorld().getGoogleTranslatedLanguage(this.getPlayer(), firstMessage), firstID);
			this.getText(World.getWorld().getGoogleTranslatedLanguage(this.getPlayer(), secondMessage), secondID);
			this.getMessage(World.getWorld().getGoogleTranslatedLanguage(this.getPlayer(), thirdMessage));
			this.getFrame164(thirdID);
		}
		return this;
	}

	public PacketSender getDepositBox() {
		if (this.getPlayer() != null) {
			this.getInterfaceInventory(4465, 197);
			// player.getInterfaceState().addListener(player.getInventory(), new InterfaceContainerListener(player, 7423));
		}
		return this;
	}

	public PacketSender getBankPin(String message) {
		if (this.getPlayer() != null) {
			this.getPlayer().getChannel().write(new PacketBuilder(PacketConstants.BANK_PIN).putLEShortA(1).toPacket());
			this.getBankPin(message);
			this.getPlayer().getChannel().write(new PacketBuilder(218).putLEShortA(-1).toPacket());
		}
		return this;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return this.player;
	}
}