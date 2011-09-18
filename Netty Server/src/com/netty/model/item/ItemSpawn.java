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
import com.netty.world.Location;
import com.netty.world.World;

public class ItemSpawn {

	private DocumentBuilder documentBuilder;
	private DocumentBuilderFactory documentBuilderFactory;

	public ItemSpawn() {
		this.setDocumentBuilderFactory(DocumentBuilderFactory.newInstance());
		try {
			this.setDocumentBuilder(this.getDocumentBuilderFactory().newDocumentBuilder());
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		}
	}

	public void parseItemsSpawned() {
		Timing time = new Timing();
		int itemSpawnsLoaded = 0;
		Document doc = null;
		try {
			doc = this.getDocumentBuilder().parse(new File(ItemConstants.ITEM_SPAWN_PATH));
		} catch (SAXException saxe) {
			saxe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		doc.getDocumentElement().normalize();
		NodeList spawnsList = doc.getElementsByTagName("ITEM_SPAWN");
		for (int i = 0; i < spawnsList.getLength(); i++) {
			Element spawnElement = (Element) spawnsList.item(i);
			int itemID = Integer.parseInt(spawnElement.getAttribute("ID"));
			int itemAmount = Integer.parseInt(spawnElement.getAttribute("AMOUNT"));
			boolean isActivated = Boolean.parseBoolean(spawnElement.getAttribute("IS_ACTIVATED"));
			Element attackBonusElement = (Element) spawnElement.getElementsByTagName("ATTACK_BONUS").item(0);
			short attackStab = Short.parseShort(attackBonusElement.getAttribute("ATTACK_STAB"));
			short attackSlash = Short.parseShort(attackBonusElement.getAttribute("ATTACK_SLASH"));
			short attackCrush = Short.parseShort(attackBonusElement.getAttribute("ATTACK_CRUSH"));
			short attackMagic = Short.parseShort(attackBonusElement.getAttribute("ATTACK_MAGIC"));
			short attackRange = Short.parseShort(attackBonusElement.getAttribute("ATTACK_RANGE"));
			Element defenceBonusElement = (Element) spawnElement.getElementsByTagName("DEFENCE_BONUS").item(0);
			short defenceStab = Short.parseShort(defenceBonusElement.getAttribute("DEFENCE_STAB"));
			short defenceSlash = Short.parseShort(defenceBonusElement.getAttribute("DEFENCE_SLASH"));
			short defenceCrush = Short.parseShort(defenceBonusElement.getAttribute("DEFENCE_CRUSH"));
			short defenceMagic = Short.parseShort(defenceBonusElement.getAttribute("DEFENCE_MAGIC"));
			short defenceRange = Short.parseShort(defenceBonusElement.getAttribute("DEFENCE_RANGE"));
			Element otherBonusElement = (Element) spawnElement.getElementsByTagName("OTHER_BONUS").item(0);
			short strength = Short.parseShort(otherBonusElement.getAttribute("STRENGTH"));
			short prayer = Short.parseShort(otherBonusElement.getAttribute("PRAYER"));
			short weight = Short.parseShort(otherBonusElement.getAttribute("WEIGHT"));
			Element locationElement = (Element) spawnElement.getElementsByTagName("LOCATION").item(0);
			short x = Short.parseShort(locationElement.getAttribute("X"));
			short y = Short.parseShort(locationElement.getAttribute("Y"));
			byte z = Byte.parseByte(locationElement.getAttribute("Z"));
			Item item = new Item(itemID, itemAmount);
			item.setActivated(isActivated);
			item.setLocation(new Location(x, y, z));
			item.setAttackStab(attackStab);
			item.setAttackSlash(attackSlash);
			item.setAttackCrush(attackCrush);
			item.setAttackMagic(attackMagic);
			item.setAttackRange(attackRange);
			item.setDefenceStab(defenceStab);
			item.setDefenceSlash(defenceSlash);
			item.setDefenceCrush(defenceCrush);
			item.setDefenceMagic(defenceMagic);
			item.setDefenceRange(defenceRange);
			item.setStrength(strength);
			item.setPrayer(prayer);
			item.setWeight(weight);
			World.getWorld().getItemList().add(item);
			itemSpawnsLoaded++;
		}
		World.getWorld().getLogger().info("Loaded " + itemSpawnsLoaded + " Item spawns in " + time + "...");
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