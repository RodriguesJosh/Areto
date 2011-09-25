package com.netty.net.packet.buttons;

import com.netty.model.player.Player;
import com.netty.model.update.Animation;
import com.netty.net.packet.PacketAttribute;
import com.netty.net.packet.PacketHandler;
import com.netty.world.World;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:37:48 PM
 */
public class ButtonsPacketHandler implements PacketHandler {

	/* (non-Javadoc)
	 * @see com.netty.net.packet.PacketHandler#handlePacket(com.netty.net.packet.PacketAttribute, com.netty.model.player.Player)
	 */
	@Override
	public void handlePacket(PacketAttribute packetAttribute, Player player) {
		short button = ((Short) packetAttribute.getAttribute("BUTTON")).shortValue();// getShort();
		World.getWorld().getLogger().info("Button ID : " + button);
		switch (button) {
			case 152:
				break;
			case 153:
				if (!player.getWalking().isRunningToggled()) {
					player.getWalking().setRunningToggled(true);
				}
				break;
			case 161:
				player.getEmotes().setCryAnimation(new Animation(860, 0));
				break;
			case 162:
				player.getEmotes().setThinkAnimation(new Animation(857, 0));
				break;
			case 163:
				player.getEmotes().setWaveAnimation(new Animation(863, 0));
				break;
			case 164:
				player.getEmotes().setBowAnimation(new Animation(858, 0));
				break;
			case 165:
				player.getEmotes().setAngryAnimation(new Animation(859, 0));
				break;
			case 166:
				player.getEmotes().setDanceAnimation(new Animation(866, 0));
				break;
			case 167:
				player.getEmotes().setBeckonAnimation(new Animation(864, 0));
				break;
			case 168:
				player.getEmotes().setYesAnimation(new Animation(855, 0));
				break;
			case 169:
				player.getEmotes().setNoAnimation(new Animation(856, 0));
				break;
			case 170:
				player.getEmotes().setLaughAnimation(new Animation(861, 0));
				break;
			case 171:
				player.getEmotes().setCheerAnimation(new Animation(862, 0));
				break;
			case 172:
				player.getEmotes().setClapAnimation(new Animation(865, 0));
				break;
			case 666:
				player.getEmotes().setGlassWallAnimation(new Animation(1128, 0));
				break;
			case 667:
				player.getEmotes().setGlassBoxAnimation(new Animation(1131, 0));
				break;
			case 2458:
				player.getPacketSender().getLogout();
				break;
			case 6503:
				player.getEmotes().setClimbRopeAnimation(new Animation(1130, 0));
				break;
			case 6506:
				player.getEmotes().setLeanAnimation(new Animation(1129, 0));
				break;
			case 11100:
				player.getEmotes().setBlowKissAnimation(new Animation(1368, 0));
				break;
			case 13362:
				player.getEmotes().setPanicAnimation(new Animation(2105, 0));
				break;
			case 13363:
				player.getEmotes().setJigAnimation(new Animation(2106, 0));
				break;
			case 13364:
				player.getEmotes().setSpinAnimation(new Animation(2107, 0));
				break;
			case 13365:
				player.getEmotes().setHeadbangAnimation(new Animation(2108, 0));
				break;
			case 13366:
				player.getEmotes().setJumpForJoyAnimation(new Animation(2109, 0));
				break;
			case 13367:
				player.getEmotes().setRaspberryAnimation(new Animation(2110, 0));
				break;
			case 13368:
				player.getEmotes().setYawnAnimation(new Animation(2111, 0));
				break;
			case 13369:
				player.getEmotes().setSaluteAnimation(new Animation(2112, 0));
				break;
			case 13370:
				player.getEmotes().setShrugAnimation(new Animation(2113, 0));
				break;
			case 13383:
				player.getEmotes().setGoblinBowAnimation(new Animation(2127, 0));
				break;
		}
	}
}