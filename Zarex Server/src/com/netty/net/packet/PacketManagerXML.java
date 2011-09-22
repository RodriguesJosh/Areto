package com.netty.net.packet;

import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.netty.model.player.Player;
import com.netty.util.Timing;
import com.netty.world.LoggedState;
import com.netty.world.World;

public class PacketManagerXML {

	private static ConcurrentMap<Boolean, ConcurrentMap<Short, PacketHandler>> packetHandlerMap = new ConcurrentHashMap<Boolean, ConcurrentMap<Short, PacketHandler>>();
	private static ConcurrentMap<Boolean, ConcurrentMap<Short, PacketAttribute>> packetAttributeMap = new ConcurrentHashMap<Boolean, ConcurrentMap<Short, PacketAttribute>>();

	public static void execute(Player player, Packet packet) {
		try {
			int opcode = packet.getOpcode();
			boolean isLoggedIn = player.getLoggedState() == LoggedState.LOGGED_IN;
			if (!PacketManagerXML.getPacketHandlerMap().get(isLoggedIn).containsKey(opcode) || !PacketManagerXML.getPacketAttributeMap().get(isLoggedIn).containsKey(opcode)) {
				return;
			}
			PacketHandler packetHandler = PacketManagerXML.getPacketHandlerMap().get(isLoggedIn).get(opcode);
			PacketAttribute packetAttribute = PacketManagerXML.getPacketAttributeMap().get(isLoggedIn).get(opcode);
			packetHandler.handlePacket(PacketManagerXML.getPacketAttributeValue(player, packetAttribute, packet), player);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static PacketAttribute getPacketAttributeValue(Player player, PacketAttribute packetAttributes, Packet packet) {
		PacketAttribute packetAttribute = packetAttributes;
		for (PacketField packetField : packetAttribute.getPacketField()) {
			for (int i = 0; i < packetField.getRepeatedAmount(); i++) {
				Object value = new Object();
				switch (packetField.getPacketFieldType()) {
				case UBYTE:
					value = (int) packet.getChannelBuffer().readUnsignedByte();
					break;
				case USHORT:
					value = (int) packet.getChannelBuffer().readUnsignedShort();
					break;
				case UINT:
					value = (int) packet.getChannelBuffer().readUnsignedInt();
					break;
				case INT:
					value = (int) packet.getChannelBuffer().readInt();
					break;
				case BYTE:
					value = (int) packet.getChannelBuffer().readByte();
					break;
				case LONG:
					value = (long) packet.getChannelBuffer().readLong();
					break;
				case SHORT:
					value = (int) packet.getChannelBuffer().readShort();
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

	public static void parsePackets() {
		try {
			Timing time = new Timing();
			PacketManagerXML.getPacketAttributeMap().put(true, new ConcurrentHashMap<Short, PacketAttribute>());
			PacketManagerXML.getPacketAttributeMap().put(false, new ConcurrentHashMap<Short, PacketAttribute>());
			PacketManagerXML.getPacketHandlerMap().put(true, new ConcurrentHashMap<Short, PacketHandler>());
			PacketManagerXML.getPacketHandlerMap().put(false, new ConcurrentHashMap<Short, PacketHandler>());
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document loginDocument = documentBuilder.parse(new File(PacketConstants.LOGIN_XML));
			Document gameDocument = documentBuilder.parse(new File(PacketConstants.GAME_XML));
			NodeList loginPacketList = loginDocument.getElementsByTagName("LOGIN_PACKET");
			NodeList gamePacketList = gameDocument.getElementsByTagName("GAME_PACKET");
			ClassLoader classLoader = ClassLoader.getSystemClassLoader();
			byte packetsLoaded = 0;
			for (byte i = 0; i < loginPacketList.getLength(); i++) {
				Element packetElement = (Element) loginPacketList.item(i);
				short opcode = Short.parseShort(packetElement.getAttribute("OPCODE"));
				String className = packetElement.getAttribute("CLASS_NAME");
				Class<?> classes = classLoader.loadClass(className);
				PacketHandler packetHandler = (PacketHandler) classes.newInstance();
				PacketManagerXML.getPacketHandlerMap().get(false).put(opcode, packetHandler);
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
				PacketManagerXML.getPacketAttributeMap().get(false).put(opcode, packetAttribute);
				packetsLoaded++;
			}
			for (int i = 0; i < gamePacketList.getLength(); i++) {
				Element packetElement = (Element) gamePacketList.item(i);
				short opcode = Short.parseShort(packetElement.getAttribute("OPCODE"));
				String className = packetElement.getAttribute("CLASS_NAME");
				Class<?> classes = classLoader.loadClass(className);
				PacketHandler packetHandler = (PacketHandler) classes.newInstance();
				PacketManagerXML.getPacketHandlerMap().get(false).put(opcode, packetHandler);
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
				PacketManagerXML.getPacketAttributeMap().get(false).put(opcode, packetAttribute);
				packetsLoaded++;
			}
			World.getWorld().getLogger().info("Loaded " + packetsLoaded + " packets in " + time + "...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void setPacketHandlerMap(ConcurrentMap<Boolean, ConcurrentMap<Short, PacketHandler>> packetHandlerMap) {
		PacketManagerXML.packetHandlerMap = packetHandlerMap;
	}

	public static ConcurrentMap<Boolean, ConcurrentMap<Short, PacketHandler>> getPacketHandlerMap() {
		return PacketManagerXML.packetHandlerMap;
	}

	public static void setPacketAttributeMap(ConcurrentMap<Boolean, ConcurrentMap<Short, PacketAttribute>> packetAttributeMap) {
		PacketManagerXML.packetAttributeMap = packetAttributeMap;
	}

	public static ConcurrentMap<Boolean, ConcurrentMap<Short, PacketAttribute>> getPacketAttributeMap() {
		return PacketManagerXML.packetAttributeMap;
	}
}