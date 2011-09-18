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

public class Player extends Entity {

	private Channel channel;
	private Packet packet;
	private Rank rank;
	private Appearance appearance;
	private Equipment equipment;
	private Chat chat;
	private LoggedState loggedState;
	private Status status;
	private Membership membership;
	private Inventory inventory;
	private OptionsSettings optionsSettings;
	private Emotes emotes;
	private Eat eat;
	private PacketSender packetSender;
	private Queue<Chat> chatMessageList;
	private Skill[] skills;
	private Bank bankStuff;
	private Energy energy;
	private List<Item> groundItemList;
	private Follow follow;
	private BankPin bankPin;
	private GrandExchange grandExchange;
	private Server server;
	private Character character;

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

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public Channel getChannel() {
		return this.channel;
	}

	public void setPacket(Packet packet) {
		this.packet = packet;
	}

	public Packet getPacket() {
		return this.packet;
	}

	public boolean isPacket() {
		return this.getPacket() != null;
	}

	public void resetPacket() {
		this.setPacket(null);
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public Rank getRank() {
		return this.rank;
	}

	public void setAppearance(Appearance appearance) {
		this.appearance = appearance;
	}

	public Appearance getAppearance() {
		return this.appearance;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public Equipment getEquipment() {
		return this.equipment;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	public Chat getChat() {
		return this.chat;
	}

	public void setLoggedState(LoggedState loggedState) {
		this.loggedState = loggedState;
	}

	public LoggedState getLoggedState() {
		return this.loggedState;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setMembership(Membership membership) {
		this.membership = membership;
	}

	public Membership getMembership() {
		return this.membership;
	}

	public boolean isMembership() {
		return this.getMembership() != null;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public Inventory getInventory() {
		return this.inventory;
	}

	public void setOptionsSettings(OptionsSettings optionsSettings) {
		this.optionsSettings = optionsSettings;
	}

	public OptionsSettings getOptionsSettings() {
		return this.optionsSettings;
	}

	public void setEmotes(Emotes emotes) {
		this.emotes = emotes;
	}

	public Emotes getEmotes() {
		return this.emotes;
	}

	public void setEat(Eat eat) {
		this.eat = eat;
	}

	public Eat getEat() {
		return this.eat;
	}

	public boolean isEating() {
		return this.getEat() != null;
	}

	public void resetEat() {
		this.setEat(null);
	}

	public void setPacketSender(PacketSender packetSender) {
		this.packetSender = packetSender;
	}

	public PacketSender getPacketSender() {
		return this.packetSender;
	}

	public boolean isPacketSending() {
		return this.getPacketSender() != null;
	}

	public void resetPacketSender() {
		this.setPacketSender(null);
	}

	public void setChatMessageList(Queue<Chat> chatMessageList) {
		this.chatMessageList = chatMessageList;
	}

	public Queue<Chat> getChatMessageList() {
		return this.chatMessageList;
	}

	public void setSkills(Skill[] skills) {
		this.skills = skills;
	}

	public Skill[] getSkills() {
		return this.skills;
	}

	public boolean isSkilling(SkillType skillType) {
		return this.getSkills()[skillType.getID()] != null;
	}

	public void resetSkill() {
		this.setSkills(null);
	}

	public void setBank(Bank bankStuff) {
		this.bankStuff = bankStuff;
	}

	public Bank getBank() {
		return this.bankStuff;
	}

	public void setEnergy(Energy energy) {
		this.energy = energy;
		this.getPacketSender().energy();
	}

	public Energy getEnergy() {
		return this.energy;
	}

	public void setGroundItemList(List<Item> groundItemList) {
		this.groundItemList = groundItemList;
	}

	public List<Item> getGroundItemList() {
		return this.groundItemList;
	}

	public void setFollow(Follow follow) {
		this.follow = follow;
	}

	public Follow getFollow() {
		return this.follow;
	}

	public boolean isFollowing() {
		return this.getFollow() != null;
	}

	public boolean isMaging() {
		int[] mageWeapons = {
				841, 843, 845, 847, 849, 851, 853, 855, 857, 859, 861, 4212, 4214, 4734
		};
		for (int i : mageWeapons) {
			return this.getEquipment().isSlotUsed(Equipment.getSlotWeapon()) && (this.getEquipment().getItem(i) == new Item(i, 0));
		}
		return false;
	}

	public boolean isMeleeing() {
		int[] meleeWeapons = {
				841, 843, 845, 847, 849, 851, 853, 855, 857, 859, 861, 4212, 4214, 4734
		};
		for (int i : meleeWeapons) {
			return this.getEquipment().isSlotUsed(Equipment.getSlotWeapon()) && (this.getEquipment().getItem(i) == new Item(i, 0));
		}
		return false;
	}

	public boolean isRanging() {
		int[] rangeWeapons = {
				841, 843, 845, 847, 849, 851, 853, 855, 857, 859, 861, 4212, 4214, 4734
		};
		for (int i : rangeWeapons) {
			return this.getEquipment().isSlotUsed(Equipment.getSlotWeapon()) && (this.getEquipment().getItem(i) == new Item(i, 0));
		}
		return false;
	}

	public void setBankPin(BankPin bankPin) {
		this.bankPin = bankPin;
	}

	public BankPin getBankPin() {
		return this.bankPin;
	}

	public void setGrandExchange(GrandExchange grandExchange) {
		this.grandExchange = grandExchange;
	}

	public GrandExchange getGrandExchange() {
		return this.grandExchange;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	public Server getServer() {
		return this.server;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public Character getCharacter() {
		return this.character;
	}
}