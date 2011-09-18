function handleCommand(command, player) {
	if (command.indexOf("yell") != -1) {
		String message = command.getCommand().substring(5);
		for (Player p : World.getWorld().getPlayerList()) {
			p.getPacketSender().getMessage(player.getName() + ": " + message);
		}
	}
}