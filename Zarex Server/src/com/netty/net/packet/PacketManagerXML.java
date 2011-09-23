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

import com.netty.model.player.Player;
import com.netty.util.Timing;
import com.netty.world.LoggedState;
import com.netty.world.World;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:41:26 PM
 */
public class PacketManagerXML {

	/**
	 * 
	 */
	private static ConcurrentMap<Boolean, ConcurrentMap<Short, PacketHandler>> packetHandlerMap = new ConcurrentHashMap<Boolean, ConcurrentMap<Short, PacketHandler>>();
	/**
	 * 
	 */
	private static ConcurrentMap<Boolean, ConcurrentMap<Short, PacketAttribute>> packetAttributeMap = new ConcurrentHashMap<Boolean, ConcurrentMap<Short, PacketAttribute>>();

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 * @param packet
	 * 			The id to set.
	 */
	public static void execute(Player player, Packet packet) {
		try {
			short opcode = (short) packet.getOpcode();
			boolean isLoggedIn = player.getLoggedState() == LoggedState.LOGGED_IN;
			if (!PacketManagerXML.getPacketHandlerMap().get(new Boolean(isLoggedIn)).containsKey(new Short(opcode)) || !PacketManagerXML.getPacketAttributeMap().get(new Boolean(isLoggedIn)).containsKey(new Short(opcode))) {
				return;
			}
			PacketHandler packetHandler = PacketManagerXML.getPacketHandlerMap().get(new Boolean(isLoggedIn)).get(new Short(opcode));
			PacketAttribute packetAttribute = PacketManagerXML.getPacketAttributeMap().get(new Boolean(isLoggedIn)).get(new Short(opcode));
			packetHandler.handlePacket(PacketManagerXML.getPacketAttributeValue(packetAttribute, packet), player);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param packetAttributes
	 * 			The id to set.
	 * @param packet
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	private static PacketAttribute getPacketAttributeValue(PacketAttribute packetAttributes, Packet packet) {
		PacketAttribute packetAttribute = packetAttributes;
		for (PacketField packetField : packetAttribute.getPacketField()) {
			for (int i = 0; i < packetField.getRepeatedAmount(); i++) {
				Object value = new Object();
				switch (packetField.getPacketFieldType()) {
					case UBYTE:
						value = new Integer(packet.getChannelBuffer().readUnsignedByte());
						break;
					case USHORT:
						value = new Integer(packet.getChannelBuffer().readUnsignedShort());
						break;
					case UMEDIUM:
						break;
					case UINT:
						value = new Integer((int) packet.getChannelBuffer().readUnsignedInt());
						break;
					case INT:
						value = new Integer(packet.getChannelBuffer().readInt());
						break;
					case BYTE:
						value = new Integer(packet.getChannelBuffer().readByte());
						break;
					case LONG:
						value = new Long(packet.getChannelBuffer().readLong());
						break;
					case SHORT:
						value = new Integer(packet.getChannelBuffer().readShort());
						break;
					case STRING:
						StringBuffer stringBuffer = new StringBuffer();
						byte currentChar;
						while (packet.getChannelBuffer().readable() && ((currentChar = packet.getChannelBuffer().readByte()) != 10)) {
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
		PacketManagerXML.getPacketAttributeMap().put(new Boolean(true), new ConcurrentHashMap<Short, PacketAttribute>());
		PacketManagerXML.getPacketAttributeMap().put(new Boolean(false), new ConcurrentHashMap<Short, PacketAttribute>());
		PacketManagerXML.getPacketHandlerMap().put(new Boolean(true), new ConcurrentHashMap<Short, PacketHandler>());
		PacketManagerXML.getPacketHandlerMap().put(new Boolean(false), new ConcurrentHashMap<Short, PacketHandler>());
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = null;
		Document loginDocument = null;
		Document gameDocument = null;
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			loginDocument = documentBuilder.parse(new File(PacketConstants.LOGIN_XML));
			gameDocument = documentBuilder.parse(new File(PacketConstants.GAME_XML));
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SAXException saxe) {
			saxe.printStackTrace();
		}
		if (loginDocument == null) {
			return;
		}
		if (gameDocument == null) {
			return;
		}
		NodeList loginPacketList = loginDocument.getElementsByTagName("LOGIN_PACKET");
		NodeList gamePacketList = gameDocument.getElementsByTagName("GAME_PACKET");
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		byte packetsLoaded = 0;
		for (byte i = 0; i < loginPacketList.getLength(); i++) {
			Element packetElement = (Element) loginPacketList.item(i);
			short opcode = Short.parseShort(packetElement.getAttribute("OPCODE"));
			String className = packetElement.getAttribute("CLASS_NAME");
			PacketHandler packetHandler = null;
			try {
				Class<?> classes = classLoader.loadClass(className);
				packetHandler = (PacketHandler) classes.newInstance();
			} catch (ClassNotFoundException cnfe) {
				cnfe.printStackTrace();
			} catch (IllegalAccessException iae) {
				iae.printStackTrace();
			} catch (InstantiationException ie) {
				ie.printStackTrace();
			}
			PacketManagerXML.getPacketHandlerMap().get(new Boolean(false)).put(new Short(opcode), packetHandler);
			NodeList attributeList = packetElement.getElementsByTagName("FIELD");
			PacketField[] packetFields = new PacketField[attributeList.getLength()];
			for (byte x = 0; x < attributeList.getLength(); x++) {
				Element fieldElement = (Element) attributeList.item(x);
				PacketFieldType packetFieldType = PacketFieldType.valueOf(fieldElement.getAttribute("TYPE"));
				String name = fieldElement.getTextContent().trim();
				byte repeatedAmount = 1;
				if (fieldElement.hasAttribute("REPEATED_AMOUNT")) {
					repeatedAmount = Byte.parseByte(fieldElement.getAttribute("REPEATED_AMOUNT"));
				}
				packetFields[x] = new PacketField(name, packetFieldType, repeatedAmount);
			}
			PacketAttribute packetAttribute = new PacketAttribute(packetFields);
			PacketManagerXML.getPacketAttributeMap().get(new Boolean(false)).put(new Short(opcode), packetAttribute);
			packetsLoaded++;
		}
		for (int i = 0; i < gamePacketList.getLength(); i++) {
			Element packetElement = (Element) gamePacketList.item(i);
			short opcode = Short.parseShort(packetElement.getAttribute("OPCODE"));
			String className = packetElement.getAttribute("CLASS_NAME");
			PacketHandler packetHandler = null;
			try {
				Class<?> classes = classLoader.loadClass(className);
				packetHandler = (PacketHandler) classes.newInstance();
			} catch (ClassNotFoundException cnfe) {
				cnfe.printStackTrace();
			} catch (IllegalAccessException iae) {
				iae.printStackTrace();
			} catch (InstantiationException ie) {
				ie.printStackTrace();
			}
			PacketManagerXML.getPacketHandlerMap().get(new Boolean(false)).put(new Short(opcode), packetHandler);
			NodeList attributeList = packetElement.getElementsByTagName("FIELD");
			PacketField[] packetFields = new PacketField[attributeList.getLength()];
			for (byte x = 0; x < attributeList.getLength(); x++) {
				Element fieldElement = (Element) attributeList.item(x);
				PacketFieldType packetFieldType = PacketFieldType.valueOf(fieldElement.getAttribute("TYPE"));
				String name = fieldElement.getTextContent().trim();
				byte repeatedAmount = 1;
				if (fieldElement.hasAttribute("REPEATED_AMOUNT")) {
					repeatedAmount = Byte.parseByte(fieldElement.getAttribute("REPEATED_AMOUNT"));
				}
				packetFields[x] = new PacketField(name, packetFieldType, repeatedAmount);
			}
			PacketAttribute packetAttribute = new PacketAttribute(packetFields);
			PacketManagerXML.getPacketAttributeMap().get(new Boolean(false)).put(new Short(opcode), packetAttribute);
			packetsLoaded++;
		}
		World.getWorld().getLogger().info("Loaded " + packetsLoaded + " packets in " + time + "...");
	}

	/**
	 * 
	 * @param packetHandlerMap
	 * 			The id to set.
	 */
	public static void setPacketHandlerMap(ConcurrentMap<Boolean, ConcurrentMap<Short, PacketHandler>> packetHandlerMap) {
		PacketManagerXML.packetHandlerMap = packetHandlerMap;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public static ConcurrentMap<Boolean, ConcurrentMap<Short, PacketHandler>> getPacketHandlerMap() {
		return PacketManagerXML.packetHandlerMap;
	}

	/**
	 * 
	 * @param packetAttributeMap
	 * 			The id to set.
	 */
	public static void setPacketAttributeMap(ConcurrentMap<Boolean, ConcurrentMap<Short, PacketAttribute>> packetAttributeMap) {
		PacketManagerXML.packetAttributeMap = packetAttributeMap;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public static ConcurrentMap<Boolean, ConcurrentMap<Short, PacketAttribute>> getPacketAttributeMap() {
		return PacketManagerXML.packetAttributeMap;
	}
}