package com.netty.game.model.entity.player.commads;

import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

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

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 2:44:42 PM
 */
public class CommandManager {

	/**
	 * 
	 */
	private static ConcurrentMap<String, CommandHandler> commandMap;

	/**
	 * 
	 */
	public CommandManager() {
		CommandManager.setCommandMap(new ConcurrentHashMap<String, CommandHandler>());
	}

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 * @param commandName
	 * 			The id to set.
	 */
	public static void execute(Player player, String commandName) {
		if (player == null) {
			throw new NullPointerException();
		}
		if (commandName == null) {
			throw new NullPointerException();
		}
		if (commandName.equals("")) {
			throw new IllegalArgumentException();
		}
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

	/**
	 * 
	 */
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

	/**
	 * 
	 * @param commandMap
	 * 			The id to set.
	 */
	public static void setCommandMap(ConcurrentMap<String, CommandHandler> commandMap) {
		CommandManager.commandMap = commandMap;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public static ConcurrentMap<String, CommandHandler> getCommandMap() {
		return CommandManager.commandMap;
	}
}