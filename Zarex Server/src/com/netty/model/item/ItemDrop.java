package com.netty.model.item;

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
import com.netty.world.World;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:49:18 AM
 */
public class ItemDrop {

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
	public ItemDrop() {
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
	public void parseItemDrops() {
		Timing time = new Timing();
		int itemDropsLoaded = 0;
		Document document = null;
		try {
			document = this.getDocumentBuilder().parse(new File(ItemConstants.ITEM_DROP_PATH));
		} catch (SAXException saxe) {
			saxe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		if (document == null) {
			throw new NullPointerException("Item drop's document is null.");
		}
		document.getDocumentElement().normalize();
		NodeList spawnsList = document.getElementsByTagName("ITEM_DROPS");
		for (int i = 0; i < spawnsList.getLength(); i++) {
			Element spawnElement = (Element) spawnsList.item(i);
			int itemID = Integer.parseInt(spawnElement.getAttribute("ID"));
			int itemAmount = Integer.parseInt(spawnElement.getAttribute("AMOUNT"));
			Item item = new Item(itemID, itemAmount);
			World.getWorld().getItemDropList().add(item);
			itemDropsLoaded++;
		}
		World.getWorld().getLogger().info("Loaded " + itemDropsLoaded + " Item drops in " + time + "...");
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