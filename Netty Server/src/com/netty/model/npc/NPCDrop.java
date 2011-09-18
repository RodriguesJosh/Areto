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

import com.netty.model.item.Item;
import com.netty.util.Timing;
import com.netty.world.World;

public class NPCDrop {

	private DocumentBuilder documentBuilder;
	private DocumentBuilderFactory documentBuilderFactory;

	public NPCDrop() {
		this.setDocumentBuilderFactory(DocumentBuilderFactory.newInstance());
		try {
			this.setDocumentBuilder(this.getDocumentBuilderFactory().newDocumentBuilder());
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		}
	}

	public void parseNPCDrops() {
		Timing time = new Timing();
		int npcDropsLoaded = 0;
		Document doc = null;
		try {
			doc = this.getDocumentBuilder().parse(new File(NPCConstants.NPC_DROP_PATH));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		doc.getDocumentElement().normalize();
		NodeList spawnsList = doc.getElementsByTagName("NPC_DROPS");
		for (int i = 0; i < spawnsList.getLength(); i++) {
			Element spawnElement = (Element) spawnsList.item(i);
			int npcID = Integer.parseInt(spawnElement.getAttribute("NPC_ID"));
			int itemID = Integer.parseInt(spawnElement.getAttribute("ITEM_ID"));
			int itemAmount = Integer.parseInt(spawnElement.getAttribute("ITEM_AMOUNT"));
			byte chance = Byte.parseByte(spawnElement.getAttribute("CHANCE"));
			NPC npc = new NPC(npcID);
			npc.setItemDrops(new Item[] { new Item(itemID, itemAmount) });
			npc.setChance(chance);
			World.getWorld().getNPCDropList().add(npc);
			npcDropsLoaded++;
		}
		World.getWorld().getLogger().info("Loaded " + npcDropsLoaded + " NPC drops in " + time + "...");
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