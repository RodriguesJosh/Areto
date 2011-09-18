class Teleport:

	def teleport(command, player):
		teleportingLocation = command[1]
		player.setTeleport(Teleport.valueOf(teleportingLocation));
