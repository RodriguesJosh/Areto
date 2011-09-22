function handleCommand(command, player) {
	if (command.indexOf("hello") != -1) {
		player.getPacketSender().getMessage("Hello! - JavaScript");
	}
}