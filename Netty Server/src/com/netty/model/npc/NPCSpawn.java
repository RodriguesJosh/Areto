package com.netty.model.npc;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.netty.util.Timing;
import com.netty.world.Location;
import com.netty.world.World;

public class NPCSpawn {

	private DocumentBuilder documentBuilder;
	private DocumentBuilderFactory documentBuilderFactory;

	public NPCSpawn() {
		this.setDocumentBuilderFactory(DocumentBuilderFactory.newInstance());
		try {
			this.setDocumentBuilder(this.getDocumentBuilderFactory().newDocumentBuilder());
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		}
	}

	public void parseNPCSSpawned() {
		Timing time = new Timing();
		int npcSpawnsLoaded = 0;
		Document doc = null;
		try {
			doc = this.getDocumentBuilder().parse(new File(NPCConstants.NPC_SPAWN_PATH));
		} catch (SAXException saxe) {
			saxe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		doc.getDocumentElement().normalize();
		NodeList spawnsList = doc.getElementsByTagName("NPC_SPAWN");
		for (int i = 0; i < spawnsList.getLength(); i++) {
			Element spawnElement = (Element) spawnsList.item(i);
			short npcID = Short.parseShort(spawnElement.getAttribute("ID"));
			Element statsElement = (Element) spawnElement.getElementsByTagName("STATS").item(0);
			byte health = Byte.parseByte(statsElement.getAttribute("HEALTH"));
			Element locationElement = (Element) spawnElement.getElementsByTagName("LOCATION").item(0);
			short x = Short.parseShort(locationElement.getAttribute("X"));
			short y = Short.parseShort(locationElement.getAttribute("Y"));
			byte z = Byte.parseByte(locationElement.getAttribute("Z"));
			byte xRange = Byte.parseByte(locationElement.getAttribute("X_RANGE"));
			byte yRange = Byte.parseByte(locationElement.getAttribute("Y_RANGE"));
			NPC npc = new NPC(npcID);
			npc.setLocation(new Location(x, y, z));
			npc.setWalkableLocations((short) (x - xRange), (short) (y - yRange), (short) (x + xRange), (short) (y + yRange));
			npc.setHealth(health);
			World.getWorld().getNPCList().add(npc);
			npcSpawnsLoaded++;
		}
		World.getWorld().getLogger().info("Loaded " + npcSpawnsLoaded + " NPC spawns in " + time + "...");
	}

	public void setDocumentBuilder(DocumentBuilder documentBuilder) {
		this.documentBuilder = documentBuilder;
	}

	public DocumentBuilder getDocumentBuilder() {
		return this.documentBuilder;
	}

	public void setDocumentBuilderFactory(DocumentBuilderFactory documentBuilderFactory) {
		this.documentBuilderFactory = documentBuilderFactory;
	}

	public DocumentBuilderFactory getDocumentBuilderFactory() {
		return this.documentBuilderFactory;
	}
}