package com.netty.net.packet;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.netty.game.Client;
import com.netty.util.Constants;
import com.netty.util.Timing;
import com.netty.world.World;

public class PacketManager {

	private static Map<Integer, PacketHandler> packetHandlerMap = new HashMap<Integer, PacketHandler>();
	private static Map<Integer, PacketAttribute> packetAttributeMap = new HashMap<Integer, PacketAttribute>();

	public static boolean execute(int opcode, Client client, Packet packet) {
		try {
			if (!PacketManager.getPacketHandlerMap().containsKey(opcode) || !PacketManager.getPacketAttributeMap().containsKey(opcode)) {
				return false;
			}
			PacketHandler packetHandler = PacketManager.getPacketHandlerMap().get(opcode);
			PacketAttribute packetAttribute = PacketManager.getPacketAttributeMap().get(opcode);
			return packetHandler.handlePacket(PacketManager.getPacketAttributeValue(client, packetAttribute, packet), client, packet);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private static PacketAttribute getPacketAttributeValue(Client client, PacketAttribute packetAttributes, Packet packet) {
		PacketAttribute packetAttribute = packetAttributes;
		for (PacketField packetField : packetAttribute.getPacketField()) {
			for (int i = 0; i < packetField.getRepeatedAmount(); i++) {
				Object value = new Object();
				switch (packetField.getPacketFieldType()) {
				case UBYTE:
					value = (int) packet.getUnsignedByte();
					break;
				case USHORT:
					value = (int) packet.getUnsignedShort();
					break;
					// case UINT:
					// 	value = (int) packet.getUnsignedInt();
					// 	break;
				case INT:
					value = (int) packet.getInt();
					break;
				case BYTE:
					value = (int) packet.getByte();
					break;
				case LONG:
					value = (long) packet.getLong();
					break;
				case SHORT:
					value = (int) packet.getShort();
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

	public static void parsePackets() {
		try {
			Timing time = new Timing();
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document loginDocument = documentBuilder.parse(new File(Constants.LOGIN_XML));
			Document gameDocument = documentBuilder.parse(new File(Constants.GAME_XML));
			NodeList loginPacketList = loginDocument.getElementsByTagName("LOGIN_PACKET");
			NodeList gamePacketList = gameDocument.getElementsByTagName("GAME_PACKET");
			ClassLoader classLoader = ClassLoader.getSystemClassLoader();
			int packetsLoaded = 0;
			for (int i = 0; i < loginPacketList.getLength(); i++) {
				Element packetElement = (Element) loginPacketList.item(i);
				int opcode = Short.parseShort(packetElement.getAttribute("OPCODE"));
				String className = packetElement.getAttribute("CLASS_NAME");
				Class<?> classes = classLoader.loadClass(className);
				PacketHandler packetHandler = (PacketHandler) classes.newInstance();
				PacketManager.getPacketHandlerMap().put(opcode, packetHandler);
				NodeList attributeList = packetElement.getElementsByTagName("FIELD");
				PacketField[] packetFields = new PacketField[attributeList.getLength()];
				for (int x = 0; x < attributeList.getLength(); x++) {
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
				PacketManager.getPacketAttributeMap().put(opcode, packetAttribute);
				packetsLoaded++;
			}
			for (int i = 0; i < gamePacketList.getLength(); i++) {
				Element packetElement = (Element) gamePacketList.item(i);
				int opcode = Short.parseShort(packetElement.getAttribute("OPCODE"));
				String className = packetElement.getAttribute("CLASS_NAME");
				Class<?> classes = classLoader.loadClass(className);
				PacketHandler packetHandler = (PacketHandler) classes.newInstance();
				PacketManager.getPacketHandlerMap().put(opcode, packetHandler);
				NodeList attributeList = packetElement.getElementsByTagName("FIELD");
				PacketField[] packetFields = new PacketField[attributeList.getLength()];
				for (int x = 0; x < attributeList.getLength(); x++) {
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
				PacketManager.getPacketAttributeMap().put(opcode, packetAttribute);
				packetsLoaded++;
			}
			World.getWorld().getLogger().info("Loaded " + packetsLoaded + " packets in " + time + "...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void setPacketHandlerMap(Map<Integer, PacketHandler> packetHandlerMap) {
		PacketManager.packetHandlerMap = packetHandlerMap;
	}

	public static Map<Integer, PacketHandler> getPacketHandlerMap() {
		return PacketManager.packetHandlerMap;
	}

	public static void setPacketAttributeMap(Map<Integer, PacketAttribute> packetAttributeMap) {
		PacketManager.packetAttributeMap = packetAttributeMap;
	}

	public static Map<Integer, PacketAttribute> getPacketAttributeMap() {
		return PacketManager.packetAttributeMap;
	}
}