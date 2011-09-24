from com.netty.world import World

class Yell:

	def yell(command, player):
		message = command[1]
		for p in World.getWorld().getPlayerList():
			p.getPacketSender().getMessage(player.getName() + ": " + message);
