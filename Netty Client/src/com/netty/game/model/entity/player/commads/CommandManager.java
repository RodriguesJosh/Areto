package com.netty.game.model.entity.player.commads;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.netty.game.model.entity.player.Player;
import com.netty.game.model.entity.player.Rank;
import com.netty.util.Constants;
import com.netty.util.Timing;
import com.netty.world.World;

public class CommandManager {

	private static Map<String, CommandHandler> commandMap = new HashMap<String, CommandHandler>();

	public static void execute(Player player, String commandName) {
		try {
			if (!CommandManager.getCommandMap().containsKey(commandName)) {
				return;
			}
			CommandHandler commandHandler = CommandManager.getCommandMap().get(commandName);
			commandHandler.handleCommand(player, new Command(commandName, player.getRank()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void parsePackets() {
		try {
			Timing time = new Timing();
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document commandsDocument = documentBuilder.parse(new File(Constants.COMMANDS_XML));
			NodeList commandList = commandsDocument.getElementsByTagName("COMMAND");
			ClassLoader classLoader = ClassLoader.getSystemClassLoader();
			int commandsLoaded = 0;
			for (int i = 0; i < commandList.getLength(); i++) {
				Element commandElement = (Element) commandList.item(i);
				String name = commandElement.getAttribute("NAME");
				byte rankID = Byte.parseByte(commandElement.getAttribute("RANK_ID"));
				Rank rank = Rank.PLAYER;
				rank.setID(rankID);
				String className = commandElement.getAttribute("CLASS_NAME");
				Class<?> classes = classLoader.loadClass(className);
				CommandHandler commandHandler = (CommandHandler) classes.newInstance();
				CommandManager.getCommandMap().put(name, commandHandler);
				commandsLoaded++;
			}
			World.getWorld().getLogger().info("Loaded " + commandsLoaded + " commands in " + time + "...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void setCommandMap(Map<String, CommandHandler> commandMap) {
		CommandManager.commandMap = commandMap;
	}

	public static Map<String, CommandHandler> getCommandMap() {
		return CommandManager.commandMap;
	}
}