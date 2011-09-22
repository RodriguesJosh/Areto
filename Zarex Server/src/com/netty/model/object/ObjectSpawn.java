package com.netty.model.object;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.netty.model.player.Player;
import com.netty.util.Timing;
import com.netty.world.Location;
import com.netty.world.World;

public class ObjectSpawn {

	private DocumentBuilder documentBuilder;
	private DocumentBuilderFactory documentBuilderFactory;

	public ObjectSpawn() {
		this.setDocumentBuilderFactory(DocumentBuilderFactory.newInstance());
		try {
			this.setDocumentBuilder(this.getDocumentBuilderFactory().newDocumentBuilder());
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		}
	}

	public void parseObjectsSpawned(Player player) {
		Timing time = new Timing();
		int objectSpawnsLoaded = 0;
		Document doc = null;
		try {
			doc = this.getDocumentBuilder().parse(new File(ObjectConstants.OBJECT_SPAWN_PATH));
		} catch (SAXException saxe) {
			saxe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		doc.getDocumentElement().normalize();
		NodeList spawnsList = doc.getElementsByTagName("OBJECT_SPAWN");
		for (int i = 0; i < spawnsList.getLength(); i++) {
			Element spawnElement = (Element) spawnsList.item(i);
			short objectID = Short.parseShort(spawnElement.getAttribute("ID"));
			byte direction = Byte.parseByte(spawnElement.getAttribute("DIRECTION"));
			byte type = Byte.parseByte(spawnElement.getAttribute("TYPE"));
			Element posElement = (Element) spawnElement.getElementsByTagName("LOCATION").item(0);
			short x = Short.parseShort(posElement.getAttribute("X"));
			short y = Short.parseShort(posElement.getAttribute("Y"));
			byte z = Byte.parseByte(posElement.getAttribute("Z"));
			Object object = new Object(objectID, direction, type);
			object.setLocation(new Location(x, y, z));
			World.getWorld().getObjectList().add(object);
			objectSpawnsLoaded++;
		}
		World.getWorld().getLogger().info("Loaded " + objectSpawnsLoaded + " Object spawns in " + time + "...");
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