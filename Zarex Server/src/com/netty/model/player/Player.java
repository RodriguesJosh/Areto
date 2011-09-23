package com.netty.model.player;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.jboss.netty.channel.Channel;

import com.netty.model.Entity;
import com.netty.model.Follow;
import com.netty.model.item.Item;
import com.netty.model.player.bank.Bank;
import com.netty.model.player.bank.BankPin;
import com.netty.model.player.dialogue.DialogueList;
import com.netty.model.player.eat.Eat;
import com.netty.model.player.grandexchange.GrandExchange;
import com.netty.model.player.skill.Skill;
import com.netty.model.player.skill.SkillConstants;
import com.netty.model.player.skill.SkillType;
import com.netty.model.player.tab.Emotes;
import com.netty.model.player.tab.Inventory;
import com.netty.model.player.tab.OptionsSettings;
import com.netty.model.player.tab.equipment.Equipment;
import com.netty.model.update.Appearance;
import com.netty.model.update.Chat;
import com.netty.model.update.UpdateFlag;
import com.netty.net.packet.Packet;
import com.netty.net.packet.PacketSender;
import com.netty.world.LoggedState;
import com.netty.world.Server;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:16:38 AM
 */
public class Player extends Entity {

	/**
	 * 
	 */
	private Channel channel;

	/**
	 * 
	 */
	private Packet packet;

	/**
	 * 
	 */
	private Rank rank;

	/**
	 * 
	 */
	private Appearance appearance;

	/**
	 * 
	 */
	private Equipment equipment;

	/**
	 * 
	 */
	private Chat chat;

	/**
	 * 
	 */
	private LoggedState loggedState;

	/**
	 * 
	 */
	private Status status;

	/**
	 * 
	 */
	private Membership membership;

	/**
	 * 
	 */
	private Inventory inventory;

	/**
	 * 
	 */
	private OptionsSettings optionsSettings;

	/**
	 * 
	 */
	private Emotes emotes;

	/**
	 * 
	 */
	private Eat eat;

	/**
	 * 
	 */
	private PacketSender packetSender;

	/**
	 * 
	 */
	private Queue<Chat> chatMessageList;

	/**
	 * 
	 */
	private Skill[] skills;

	/**
	 * 
	 */
	private Bank bankStuff;

	/**
	 * 
	 */
	private Energy energy;

	/**
	 * 
	 */
	private List<Item> groundItemList;

	/**
	 * 
	 */
	private Follow follow;

	/**
	 * 
	 */
	private BankPin bankPin;

	/**
	 * 
	 */
	private GrandExchange grandExchange;


	/**
	 * 
	 */
	private Server server;


	/**
	 * 
	 */
	private Character character;


	/**
	 * 
	 * @param channel
	 * 			The id to set.
	 */
	public Player(Channel channel) {
		super();
		this.setChannel(channel);
		this.setRank(Rank.PLAYER);
		this.setAppearance(new Appearance());
		this.setEquipment(new Equipment());
		this.getUpdateFlags().setUpdateFlag(UpdateFlag.APPEARANCE);
		this.setMapChanging(true);
		this.setStatus(new Status());
		this.setMembership(new Membership());
		this.setInventory(new Inventory(this));
		// this.getInventory().registerItem(new Item(1163 , 1));
		// this.getInventory().registerItem(new Item(1127, 1));
		// this.getInventory().registerItem(new Item(1079, 1));
		// this.getInventory().registerItem(new Item(4131, 1));
		// this.getInventory().registerItem(new Item(1201, 1));
		// this.getInventory().registerItem(new Item(6585, 1));
		// this.getInventory().registerItem(new Item(4151, 1));
		this.setOptionsSettings(new OptionsSettings());
		this.setEmotes(new Emotes());
		this.setEat(new Eat(null));
		this.setPacketSender(new PacketSender(this));
		this.setDialogueList(new DialogueList(this));
		this.setChatMessageList(new LinkedList<Chat>());
		this.setSkills(new Skill[SkillConstants.MAX_SKILLS]);
		// for (byte i = 0; i < this.getSkills().length; i++) {
		// this.getSkills()[i] = new Skill(this, i);
		// }
		// this.setBank(new Bank());
		// this.getBank().depositItem(this, 0, new Item(1163, 1));
		// this.getBank().depositItem(this, 1, new Item(1127, 1));
		// this.getBank().depositItem(this, 2, new Item(1079, 1));
		// this.getBank().depositItem(this, 3, new Item(4131, 1));
		// this.getBank().depositItem(this, 4, new Item(1201, 1));
		// this.getBank().depositItem(this, 5, new Item(6585, 1));
		// this.getBank().depositItem(this, 6, new Item(4151, 1));
		this.setEnergy(new Energy(100));
		this.setGroundItemList(new ArrayList<Item>());
	}

	/**
	 * 
	 * @param channel
	 * 			The id to set.
	 */
	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Channel getChannel() {
		return this.channel;
	}

	/**
	 * 
	 * @param packet
	 * 			The id to set.
	 */
	public void setPacket(Packet packet) {
		this.packet = packet;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Packet getPacket() {
		return this.packet;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public boolean isPacket() {
		return this.getPacket() != null;
	}

	/**
	 * 
	 */
	public void resetPacket() {
		this.setPacket(null);
	}

	/**
	 * 
	 * @param rank
	 * 			The id to set.
	 */
	public void setRank(Rank rank) {
		this.rank = rank;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Rank getRank() {
		return this.rank;
	}

	/**
	 * 
	 * @param appearance
	 * 			The id to set.
	 */
	public void setAppearance(Appearance appearance) {
		this.appearance = appearance;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Appearance getAppearance() {
		return this.appearance;
	}

	/**
	 * 
	 * @param equipment
	 * 			The id to set.
	 */
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Equipment getEquipment() {
		return this.equipment;
	}

	/**
	 * 
	 * @param chat
	 * 			The id to set.
	 */
	public void setChat(Chat chat) {
		this.chat = chat;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Chat getChat() {
		return this.chat;
	}

	/**
	 * 
	 * @param loggedState
	 * 			The id to set.
	 */
	public void setLoggedState(LoggedState loggedState) {
		this.loggedState = loggedState;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public LoggedState getLoggedState() {
		return this.loggedState;
	}

	/**
	 * 
	 * @param status
	 * 			The id to set.
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Status getStatus() {
		return this.status;
	}

	/**
	 * 
	 * @param membership
	 * 			The id to set.
	 */
	public void setMembership(Membership membership) {
		this.membership = membership;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Membership getMembership() {
		return this.membership;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public boolean isMembership() {
		return this.getMembership() != null;
	}

	/**
	 * 
	 * @param inventory
	 * 			The id to set.
	 */
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Inventory getInventory() {
		return this.inventory;
	}

	/**
	 * 
	 * @param optionsSettings
	 * 			The id to set.
	 */
	public void setOptionsSettings(OptionsSettings optionsSettings) {
		this.optionsSettings = optionsSettings;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public OptionsSettings getOptionsSettings() {
		return this.optionsSettings;
	}

	/**
	 * 
	 * @param emotes
	 * 			The id to set.
	 */
	public void setEmotes(Emotes emotes) {
		this.emotes = emotes;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Emotes getEmotes() {
		return this.emotes;
	}

	/**
	 * 
	 * @param eat
	 * 			The id to set.
	 */
	public void setEat(Eat eat) {
		this.eat = eat;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Eat getEat() {
		return this.eat;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public boolean isEating() {
		return this.getEat() != null;
	}

	/**
	 * 
	 */
	public void resetEat() {
		this.setEat(null);
	}

	/**
	 * 
	 * @param packetSender
	 * 			The id to set.
	 */
	public void setPacketSender(PacketSender packetSender) {
		this.packetSender = packetSender;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public PacketSender getPacketSender() {
		return this.packetSender;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public boolean isPacketSending() {
		return this.getPacketSender() != null;
	}

	/**
	 * 
	 */
	public void resetPacketSender() {
		this.setPacketSender(null);
	}

	/**
	 * 
	 * @param chatMessageList
	 * 			The id to set.
	 */
	public void setChatMessageList(Queue<Chat> chatMessageList) {
		this.chatMessageList = chatMessageList;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Queue<Chat> getChatMessageList() {
		return this.chatMessageList;
	}

	/**
	 * 
	 * @param skills
	 * 			The id to set.
	 */
	public void setSkills(Skill[] skills) {
		this.skills = skills;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Skill[] getSkills() {
		return this.skills;
	}

	/**
	 * 
	 * @param skillType
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public boolean isSkilling(SkillType skillType) {
		return this.getSkills()[skillType.getID()] != null;
	}

	/**
	 * 
	 */
	public void resetSkill() {
		this.setSkills(null);
	}

	/**
	 * 
	 * @param bankStuff
	 * 			The id to set.
	 */
	public void setBank(Bank bankStuff) {
		this.bankStuff = bankStuff;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Bank getBank() {
		return this.bankStuff;
	}

	/**
	 * 
	 * @param energy
	 * 			The id to set.
	 */
	public void setEnergy(Energy energy) {
		this.energy = energy;
		this.getPacketSender().energy();
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Energy getEnergy() {
		return this.energy;
	}

	/**
	 * 
	 * @param groundItemList
	 * 			The id to set.
	 */
	public void setGroundItemList(List<Item> groundItemList) {
		this.groundItemList = groundItemList;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public List<Item> getGroundItemList() {
		return this.groundItemList;
	}

	/**
	 * 
	 * @param follow
	 * 			The id to set.
	 */
	public void setFollow(Follow follow) {
		this.follow = follow;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Follow getFollow() {
		return this.follow;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public boolean isFollowing() {
		return this.getFollow() != null;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public boolean isMaging() {
		int[] mageWeapons = {
				841, 843, 845, 847, 849, 851, 853, 855, 857, 859, 861, 4212, 4214, 4734
		};
		for (int i : mageWeapons) {
			return this.getEquipment().isSlotUsed(Equipment.getSlotWeapon()) && (this.getEquipment().getItem(i) == new Item(i, 0));
		}
		return false;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public boolean isMeleeing() {
		int[] meleeWeapons = {
				841, 843, 845, 847, 849, 851, 853, 855, 857, 859, 861, 4212, 4214, 4734
		};
		for (int i : meleeWeapons) {
			return this.getEquipment().isSlotUsed(Equipment.getSlotWeapon()) && (this.getEquipment().getItem(i) == new Item(i, 0));
		}
		return false;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public boolean isRanging() {
		int[] rangeWeapons = {
				841, 843, 845, 847, 849, 851, 853, 855, 857, 859, 861, 4212, 4214, 4734
		};
		for (int i : rangeWeapons) {
			return this.getEquipment().isSlotUsed(Equipment.getSlotWeapon()) && (this.getEquipment().getItem(i) == new Item(i, 0));
		}
		return false;
	}

	/**
	 * 
	 * @param bankPin
	 * 			The id to set.
	 */
	public void setBankPin(BankPin bankPin) {
		this.bankPin = bankPin;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public BankPin getBankPin() {
		return this.bankPin;
	}

	/**
	 * 
	 * @param grandExchange
	 * 			The id to set.
	 */
	public void setGrandExchange(GrandExchange grandExchange) {
		this.grandExchange = grandExchange;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public GrandExchange getGrandExchange() {
		return this.grandExchange;
	}

	/**
	 * 
	 * @param server
	 * 			The id to set.
	 */
	public void setServer(Server server) {
		this.server = server;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Server getServer() {
		return this.server;
	}

	/**
	 * 
	 * @param character
	 * 			The id to set.
	 */
	public void setCharacter(Character character) {
		this.character = character;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Character getCharacter() {
		return this.character;
	}
}