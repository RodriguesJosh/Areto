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

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:55:51 AM
 */
public class NPCDrop {

	/**
	 * 
	 */
	private DocumentBuilder documentBuilder;

	/**
	 * 
	 */
	private DocumentBuilderFactory documentBuilderFactory;

	/**
	 * 
	 */
	public NPCDrop() {
		this.setDocumentBuilderFactory(DocumentBuilderFactory.newInstance());
		try {
			this.setDocumentBuilder(this.getDocumentBuilderFactory().newDocumentBuilder());
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public void parseNPCDrops() {
		Timing time = new Timing();
		int npcDropsLoaded = 0;
		Document document = null;
		try {
			document = this.getDocumentBuilder().parse(new File(NPCConstants.NPC_DROP_PATH));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (document == null) {
			throw new NullPointerException();
		}
		document.getDocumentElement().normalize();
		NodeList spawnsList = document.getElementsByTagName("NPC_DROPS");
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

	/**
	 * 
	 * @param documentBuilder
	 * 			The id to set.
	 */
	public void setDocumentBuilder(DocumentBuilder documentBuilder) {
		this.documentBuilder = documentBuilder;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public DocumentBuilder getDocumentBuilder() {
		return this.documentBuilder;
	}

	/**
	 * 
	 * @param documentBuilderFactory
	 * 			The id to set.
	 */
	public void setDocumentBuilderFactory(DocumentBuilderFactory documentBuilderFactory) {
		this.documentBuilderFactory = documentBuilderFactory;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public DocumentBuilderFactory getDocumentBuilderFactory() {
		return this.documentBuilderFactory;
	}
}