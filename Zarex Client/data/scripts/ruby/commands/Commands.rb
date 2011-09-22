include Java

Java::ComNettyWorld::World
Java::ComNettyWorld::Location
Java::ComNettyModelPlayer::Teleport

class Commands

	def hello(command, player):
		player.getPacketSender().getMessage("Hello! - Python");
	end

	def location(command, player):
		player.getPacketSender().getMessage("");
	end

	def teleport(command, player):
		teleportingLocation = command[1]
		player.setTeleport(Teleport.valueOf(teleportingLocation));
	end

	def yell(command, player):
		message = command[1]
		for p in World.getWorld().getPlayerList():
			p.getPacketSender().getMessage(player.getName() + ": " + message);
	end
end
