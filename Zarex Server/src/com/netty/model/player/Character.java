package com.netty.model.player;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.netty.net.database.SQL;
import com.netty.util.NameUtility;
import com.netty.util.Timing;
import com.netty.world.Location;
import com.netty.world.World;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:08:31 AM
 */
public class Character {

	/**
	 * 
	 */
	private Player player;

	/**
	 * 
	 */
	private DocumentBuilder documentBuilder;

	/**
	 * 
	 */
	private DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

	/**
	 * 
	 */
	private SQL sql;

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 */
	public Character(Player player) {
		this.setPlayer(player);
		// this.setDocumentBuilderFactory(DocumentBuilderFactory.newInstance());
		// this.setSQL(new SQL());
	}

	/**
	 * 
	 */
	public void saveCharacterXML() {
		if (this.getPlayer() != null) {
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
			Document document = documentBuilder.newDocument();
			Element characterElement = document.createElement("CHARACTER");
			document.appendChild(characterElement);
			Element playerElement = document.createElement("PLAYER");
			playerElement.setAttribute("NAME", this.getPlayer().getName());
			playerElement.setAttribute("PASS", this.getPlayer().getPass());
			playerElement.setAttribute("RIGHT", this.getPlayer().getRank().getID() + "");
			characterElement.appendChild(playerElement);
			if (this.getPlayer().getLocation() != null) {
				Element locationElement = document.createElement("LOCATION");
				locationElement.setAttribute("X", this.getPlayer().getLocation().getX() + "");
				locationElement.setAttribute("Y", this.getPlayer().getLocation().getY() + "");
				locationElement.setAttribute("Z", this.getPlayer().getLocation().getZ() + "");
				characterElement.appendChild(locationElement);
			}
			if (this.getPlayer().getAppearance() != null) {
				Element appearanceElement = document.createElement("APPEARANCE");
				appearanceElement.setAttribute("GENDER", this.getPlayer().getAppearance().getGender() + "");
				appearanceElement.setAttribute("HEAD", this.getPlayer().getAppearance().getHead() + "");
				appearanceElement.setAttribute("CHEST", this.getPlayer().getAppearance().getChest() + "");
				appearanceElement.setAttribute("ARMS", this.getPlayer().getAppearance().getArms() + "");
				appearanceElement.setAttribute("HANDS", this.getPlayer().getAppearance().getHands() + "");
				appearanceElement.setAttribute("LEGS", this.getPlayer().getAppearance().getLegs() + "");
				appearanceElement.setAttribute("FEET", this.getPlayer().getAppearance().getFeet() + "");
				appearanceElement.setAttribute("BEARD", this.getPlayer().getAppearance().getBeard() + "");
				appearanceElement.setAttribute("HAIR_COLOR", this.getPlayer().getAppearance().getHairColor() + "");
				appearanceElement.setAttribute("TORSO_COLOR", this.getPlayer().getAppearance().getTorsoColor() + "");
				appearanceElement.setAttribute("LEG_COLOR", this.getPlayer().getAppearance().getLegColor() + "");
				appearanceElement.setAttribute("FEET_COLOR", this.getPlayer().getAppearance().getFeetColor() + "");
				appearanceElement.setAttribute("SKIN_COLOR", this.getPlayer().getAppearance().getSkinColor() + "");
				characterElement.appendChild(appearanceElement);
			}
			if (this.getPlayer().isMembership()) {
				Element memberElement = document.createElement("MEMBER");
				memberElement.setAttribute("SECONDS", this.getPlayer().getMembership().getSecondsLeft() + "");
				memberElement.setAttribute("MINUTES", this.getPlayer().getMembership().getMinutesLeft() + "");
				memberElement.setAttribute("HOURS", this.getPlayer().getMembership().getHoursLeft() + "");
				memberElement.setAttribute("DAYS", this.getPlayer().getMembership().getDaysLeft() + "");
				memberElement.setAttribute("WEEKS", this.getPlayer().getMembership().getWeeksLeft() + "");
				memberElement.setAttribute("MONTHS", this.getPlayer().getMembership().getMonthsLeft() + "");
				memberElement.setAttribute("YEARS", this.getPlayer().getMembership().getYearsLeft() + "");
				characterElement.appendChild(memberElement);
			}
			if (this.getPlayer().getBankPin() != null) {
				Element bankElement = document.createElement("BANK_PIN");
				bankElement.setAttribute("FIRST_PIN", this.getPlayer().getBankPin().getFirstPin() + "");
				bankElement.setAttribute("SECOND_PIN", this.getPlayer().getBankPin().getSecondPin() + "");
				bankElement.setAttribute("THIRD_PIN", this.getPlayer().getBankPin().getThirdPin() + "");
				bankElement.setAttribute("FOURTH_PIN", this.getPlayer().getBankPin().getFourthPin() + "");
				characterElement.appendChild(bankElement);
			}
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = null;
			try {
				transformer = transformerFactory.newTransformer();
			} catch (TransformerConfigurationException tce) {
				tce.printStackTrace();
			}
			if (transformer == null) {
				throw new NullPointerException();
			}
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			StringWriter stringWriter = new StringWriter();
			StreamResult streamResult = new StreamResult(stringWriter);
			DOMSource domSource = new DOMSource(document);
			try {
				transformer.transform(domSource, streamResult);
			} catch (TransformerException te) {
				te.printStackTrace();
			}
			String xmlString = stringWriter.toString();
			try {
				FileWriter fileWriter = new FileWriter(new File(PlayerConstants.SAVE_CHARACTER_XML + NameUtility.getCapitalizedWord(this.getPlayer().getName()) + ".xml"));
				fileWriter.write(xmlString);
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}

	/**
	 * 
	 */
	public void loadCharacterXML() {
		Timing time = new Timing();
		if (this.getPlayer() != null) {
			File file = new File(PlayerConstants.LOAD_CHARACTER_XML + NameUtility.getCapitalizedWord(this.getPlayer().getName()) + ".xml");
			if (!file.exists()) {
				return;
			}
			try {
				this.setDocumentBuilder(this.getDocumentBuilderFactory().newDocumentBuilder());
			} catch (ParserConfigurationException pce) {
				pce.printStackTrace();
			}
			Document document = null;
			try {
				document = this.getDocumentBuilder().parse(file);
			} catch (SAXException saxe) {
				saxe.printStackTrace();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			if (document == null) {
				throw new NullPointerException();
			}
			document.getDocumentElement().normalize();
			NodeList detailsList = document.getElementsByTagName("PLAYER");
			for (int i = 0; i < detailsList.getLength(); i++) {
				Element detailElement = (Element) detailsList.item(i);
				String name = detailElement.getAttribute("NAME");
				this.getPlayer().setName(name);
				String pass = detailElement.getAttribute("PASS");
				this.getPlayer().setPass(pass);
				byte right = Byte.parseByte(detailElement.getAttribute("RIGHT"));
				Rank rank = this.getPlayer().getRank();
				rank.setID(right);
				this.getPlayer().setRank(rank);
				boolean isMember = Boolean.parseBoolean(detailElement.getAttribute("MEMBER"));
				if (isMember) {
					this.getPlayer().setMembership(this.getPlayer().getMembership());
				}
			}
			NodeList locationList = document.getElementsByTagName("LOCATION");
			for (int i = 0; i < locationList.getLength(); i++) {
				Element locationElement = (Element) locationList.item(i);
				short x = Short.parseShort(locationElement.getAttribute("X"));
				short y = Short.parseShort(locationElement.getAttribute("Y"));
				byte z = Byte.parseByte(locationElement.getAttribute("Z"));
				this.getPlayer().setLocation(new Location(x, y, z));
			}
			NodeList appearanceList = document.getElementsByTagName("APPEARANCE");
			for (int i = 0; i < 1; i++) {
				Element genderElement = (Element) appearanceList.item(i);
				byte gender = Byte.parseByte(genderElement.getAttribute("GENDER"));
				byte head = Byte.parseByte(genderElement.getAttribute("HEAD"));
				byte chest = Byte.parseByte(genderElement.getAttribute("CHEST"));
				byte arms = Byte.parseByte(genderElement.getAttribute("ARMS"));
				byte hands = Byte.parseByte(genderElement.getAttribute("HANDS"));
				byte legs = Byte.parseByte(genderElement.getAttribute("LEGS"));
				byte feet = Byte.parseByte(genderElement.getAttribute("FEET"));
				byte beard = Byte.parseByte(genderElement.getAttribute("BEARD"));
				byte hairColor = Byte.parseByte(genderElement.getAttribute("HAIR_COLOR"));
				byte torsoColor = Byte.parseByte(genderElement.getAttribute("TORSO_COLOR"));
				byte legColor = Byte.parseByte(genderElement.getAttribute("LEG_COLOR"));
				byte feetColor = Byte.parseByte(genderElement.getAttribute("FEET_COLOR"));
				byte skinColor = Byte.parseByte(genderElement.getAttribute("SKIN_COLOR"));
				this.getPlayer().getAppearance().setAppearance(new byte[] {
						gender, hairColor, torsoColor, legColor, feetColor, skinColor, head, chest, arms, hands, legs,
						feet, beard
				});
			}
			NodeList memberList = document.getElementsByTagName("MEMBER");
			for (int i = 0; i < 1; i++) {
				Element memberElement = (Element) memberList.item(i);
				byte seconds = Byte.parseByte(memberElement.getAttribute("SECONDS"));
				byte minutes = Byte.parseByte(memberElement.getAttribute("MINUTES"));
				byte hours = Byte.parseByte(memberElement.getAttribute("HOURS"));
				byte days = Byte.parseByte(memberElement.getAttribute("DAYS"));
				byte weeks = Byte.parseByte(memberElement.getAttribute("WEEKS"));
				byte months = Byte.parseByte(memberElement.getAttribute("MONTHS"));
				int years = Integer.parseInt(memberElement.getAttribute("YEARS"));
				this.getPlayer().getMembership().setSeconds(seconds);
				this.getPlayer().getMembership().setMinutes(minutes);
				this.getPlayer().getMembership().setHours(hours);
				this.getPlayer().getMembership().setDays(days);
				this.getPlayer().getMembership().setWeeks(weeks);
				this.getPlayer().getMembership().setMonths(months);
				this.getPlayer().getMembership().setYears(years);
			}
			NodeList bankPinList = document.getElementsByTagName("BANK_PIN");
			for (int i = 0; i < 1; i++) {
				Element bankPinElement = (Element) bankPinList.item(i);
				byte firstPin = Byte.parseByte(bankPinElement.getAttribute("FIRST_PIN"));
				byte secondPin = Byte.parseByte(bankPinElement.getAttribute("SECOND_PIN"));
				byte thirdPin = Byte.parseByte(bankPinElement.getAttribute("THIRD_PIN"));
				byte fourthPin = Byte.parseByte(bankPinElement.getAttribute("FOURTH_PIN"));
				this.getPlayer().getBankPin().setFirstPin(firstPin);
				this.getPlayer().getBankPin().setSecondPin(secondPin);
				this.getPlayer().getBankPin().setThirdPin(thirdPin);
				this.getPlayer().getBankPin().setFourthPin(fourthPin);
			}
			World.getWorld().getLogger().info("Loaded " + NameUtility.getCapitalizedWord(this.getPlayer().getName()) + " in " + time + "...");
		}
	}

	/**
	 * 
	 */
	public void saveCharacterSQL() {
		if (this.getPlayer() != null) {
			this.getSQL().executeQuery("INSERT INTO `characters` (`id`, `name`, `pass`, `member`, `x`, `y`, `z`, `rank`," +
					"`gender`) VALUES (`" + this.getPlayer().getIndex() + "`, `" + this.getPlayer().getName() + "`, `" +
					this.getPlayer().getPass() + "`, `" + this.getPlayer().isMembership() + "`, `" +
					this.getPlayer().getLocation().getX() + "`, `" + this.getPlayer().getLocation().getY() + "`, `" +
					this.getPlayer().getLocation().getZ() + "`, `" + this.getPlayer().getRank().getID() + "`, `" +
					this.getPlayer().getAppearance().getGender());
		}
	}

	/**
	 * 
	 */
	public void loadCharacterSQL() {
		if (this.getPlayer() != null) {
			ResultSet resultSet = this.getSQL().queryResults("SELECT * FROM `characters` WHERE `characters`.`name` = `" + this.getPlayer().getName() + "`");
			try {
				this.getPlayer().setIndex(resultSet.getShort("id"));
				this.getPlayer().setName(resultSet.getString("name"));
				// this.getPlayer().getMembership().setMember(resultSet.getBoolean("member"));
				this.getPlayer().setLocation(new Location(resultSet.getShort("x"), resultSet.getShort("y"), resultSet.getByte("z")));
				Rank rank = this.getPlayer().getRank();
				rank.setID((byte) resultSet.getInt("rank"));
				this.getPlayer().setRank(rank);
				this.getPlayer().getAppearance().setGender((byte) resultSet.getInt("gender"));
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Player getPlayer() {
		return this.player;
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

	/**
	 * 
	 * @param sql
	 * 			The id to set.
	 */
	public void setSQL(SQL sql) {
		this.sql = sql;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public SQL getSQL() {
		return this.sql;
	}
}