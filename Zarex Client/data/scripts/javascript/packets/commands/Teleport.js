function handleCommand(command, player) {
	if (command.indexOf("teleport") != -1) {
		var teleportingLocation = command.split(" ")[1];
		player.setTeleport(Teleport.valueOf(teleportingLocation));
	}
}