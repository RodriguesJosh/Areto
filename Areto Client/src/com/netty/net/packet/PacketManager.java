package com.netty.net.packet;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.netty.game.Client;
import com.netty.util.Constants;
import com.netty.util.Timing;
import com.netty.world.World;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 3:10:27 PM
 */
public class PacketManager {

	/** World class for singleton design. */

	/**
	 * 
	 */
	private static ConcurrentMap<Short, PacketHandler> packetHandlerMap;

	/**
	 * 
	 */
	private static ConcurrentMap<Short, PacketAttribute> packetAttributeMap;

	/**
	 * 
	 */
	public PacketManager() {
		PacketManager.setPacketHandlerMap(new ConcurrentHashMap<Short, PacketHandler>());
		PacketManager.setPacketAttributeMap(new ConcurrentHashMap<Short, PacketAttribute>());
	}

	/**
	 * 
	 * @param opcode
	 * 			The id to set.
	 * @param client
	 * 			The id to set.
	 * @param packet
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public static boolean execute(short opcode, Client client, Packet packet) {
		Short shortClass = new Short(opcode);
		try {
			if (!PacketManager.getPacketHandlerMap().containsKey(shortClass) ||
					!PacketManager.getPacketAttributeMap().containsKey(shortClass)) {
				return false;
			}
			PacketHandler packetHandler = PacketManager.getPacketHandlerMap().get(shortClass);
			PacketAttribute packetAttribute = PacketManager.getPacketAttributeMap().get(shortClass);
			return packetHandler.handlePacket(PacketManager.getPacketAttributeValue(packetAttribute, packet), client, packet);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 
	 * @param client
	 * @param packetAttributes
	 * @param packet
	 * @return
	 */
	private static PacketAttribute getPacketAttributeValue(PacketAttribute packetAttributes, Packet packet) {
		PacketAttribute packetAttribute = packetAttributes;
		for (PacketField packetField : packetAttribute.getPacketField()) {
			for (int i = 0; i < packetField.getRepeatedAmount(); i++) {
				Object value = new Object();
				switch (packetField.getPacketFieldType()) {
					case UBYTE:
						value = new Integer(packet.getUnsignedByte());
						break;
					case USHORT:
						value = new Integer(packet.getUnsignedShort());
						break;
						// case UINT:
						// 	value = (int) packet.getUnsignedInt();
						// 	break;
					case UMEDIUM:
						break;
					case UINT:
						break;
					case INT:
						value = new Integer(packet.getInt());
						break;
					case BYTE:
						value = new Integer(packet.getByte());
						break;
					case LONG:
						value = new Long(packet.getLong());
						break;
					case SHORT:
						value = new Integer(packet.getShort());
						break;
					case STRING:
						StringBuffer stringBuffer = new StringBuffer();
						byte currentChar;
						while (((currentChar = packet.getByte()) != 10)) {
							stringBuffer.append((char) currentChar);
						}
						value = stringBuffer.toString();
						break;
				}
				packetAttribute.setAttribute(packetField.getName(), value);
			}
		}
		return packetAttribute;
	}

	/**
	 * 
	 */
	public static void parsePackets() {
		Timing time = new Timing();
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = null;
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		}
		if (documentBuilder == null) {
			throw new NullPointerException();
		}
		Document loginDocument = null;
		Document gameDocument = null;
		try {
			loginDocument = documentBuilder.parse(new File(Constants.LOGIN_XML));
			gameDocument = documentBuilder.parse(new File(Constants.GAME_XML));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (loginDocument == null) {
			throw new NullPointerException();
		}
		if (gameDocument == null) {
			throw new NullPointerException();
		}
		NodeList loginPacketList = loginDocument.getElementsByTagName("LOGIN_PACKET");
		NodeList gamePacketList = gameDocument.getElementsByTagName("GAME_PACKET");
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		int packetsLoaded = 0;
		for (int i = 0; i < loginPacketList.getLength(); i++) {
			Element packetElement = (Element) loginPacketList.item(i);
			short opcode = Short.parseShort(packetElement.getAttribute("OPCODE"));
			String className = packetElement.getAttribute("CLASS_NAME");
			Class<?> classes = null;
			try {
				classes = classLoader.loadClass(className);
			} catch (ClassNotFoundException cnfe) {
				cnfe.printStackTrace();
			}
			if (classes == null) {
				throw new NullPointerException();
			}
			PacketHandler packetHandler = null;
			try {
				packetHandler = (PacketHandler) classes.newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			PacketManager.getPacketHandlerMap().put(new Short(opcode), packetHandler);
			NodeList attributeList = packetElement.getElementsByTagName("FIELD");
			PacketField[] packetFields = new PacketField[attributeList.getLength()];
			for (int x = 0; x < attributeList.getLength(); x++) {
				Element fieldElement = (Element) attributeList.item(x);
				PacketFieldType packetFieldType = PacketFieldType.BYTE;//(PacketFieldType) PacketFieldType.valueOf(classes, fieldElement.getAttribute("TYPE"));
				String name = fieldElement.getTextContent().trim();
				byte repeatedAmount = 1;
				if (fieldElement.hasAttribute("REPEATED_AMOUNT")) {
					repeatedAmount = Byte.parseByte(fieldElement.getAttribute("REPEATED_AMOUNT"));
				}
				packetFields[x] = new PacketField(name, packetFieldType, repeatedAmount);
			}
			PacketAttribute packetAttribute = new PacketAttribute(packetFields);
			PacketManager.getPacketAttributeMap().put(new Short(opcode), packetAttribute);
			packetsLoaded++;
		}
		for (int i = 0; i < gamePacketList.getLength(); i++) {
			Element packetElement = (Element) gamePacketList.item(i);
			short opcode = Short.parseShort(packetElement.getAttribute("OPCODE"));
			String className = packetElement.getAttribute("CLASS_NAME");
			Class<?> classes = null;
			try {
				classes = classLoader.loadClass(className);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			if (classes == null) {
				throw new NullPointerException();
			}
			PacketHandler packetHandler = null;
			try {
				packetHandler = (PacketHandler) classes.newInstance();
			} catch (InstantiationException ie) {
				ie.printStackTrace();
			} catch (IllegalAccessException iae) {
				iae.printStackTrace();
			}
			PacketManager.getPacketHandlerMap().put(new Short(opcode), packetHandler);
			NodeList attributeList = packetElement.getElementsByTagName("FIELD");
			PacketField[] packetFields = new PacketField[attributeList.getLength()];
			for (int x = 0; x < attributeList.getLength(); x++) {
				Element fieldElement = (Element) attributeList.item(x);
				PacketFieldType packetFieldType = PacketFieldType.BYTE;//(PacketFieldType) PacketFieldType.valueOf(classes, fieldElement.getAttribute("TYPE"));
				String name = fieldElement.getTextContent().trim();
				byte repeatedAmount = 1;
				if (fieldElement.hasAttribute("REPEATED_AMOUNT")) {
					repeatedAmount = Byte.parseByte(fieldElement.getAttribute("REPEATED_AMOUNT"));
				}
				packetFields[x] = new PacketField(name, packetFieldType, repeatedAmount);
			}
			PacketAttribute packetAttribute = new PacketAttribute(packetFields);
			PacketManager.getPacketAttributeMap().put(new Short(opcode), packetAttribute);
			packetsLoaded++;
		}
		World.getWorld().getLogger().info("Loaded " + packetsLoaded + " packets in " + time + "...");
	}

	/**
	 * 
	 * @param packetHandlerMap
	 * 			The id to set.
	 */
	public static void setPacketHandlerMap(ConcurrentMap<Short, PacketHandler> packetHandlerMap) {
		PacketManager.packetHandlerMap = packetHandlerMap;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public static ConcurrentMap<Short, PacketHandler> getPacketHandlerMap() {
		return PacketManager.packetHandlerMap;
	}

	/**
	 * 
	 * @param packetAttributeMap
	 * 			The id to set.
	 */
	public static void setPacketAttributeMap(ConcurrentMap<Short, PacketAttribute> packetAttributeMap) {
		PacketManager.packetAttributeMap = packetAttributeMap;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public static ConcurrentMap<Short, PacketAttribute> getPacketAttributeMap() {
		return PacketManager.packetAttributeMap;
	}
}