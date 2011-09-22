package com.netty.world;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.ChannelLocal;

import com.google.api.detect.Detect;
import com.google.api.translate.Language;
import com.google.api.translate.Translate;
import com.netty.model.Entity;
import com.netty.model.item.Item;
import com.netty.model.item.ItemConstants;
import com.netty.model.npc.NPC;
import com.netty.model.npc.NPCConstants;
import com.netty.model.object.Object;
import com.netty.model.object.ObjectConstants;
import com.netty.model.player.Player;
import com.netty.model.player.PlayerConstants;
import com.netty.model.player.Rank;
import com.netty.model.player.tab.Friend;
import com.netty.model.player.tab.Ignore;
import com.netty.model.player.tab.TabConstants;
import com.netty.model.player.tab.clan.Clan;
import com.netty.model.player.tab.clan.ClanConstants;
import com.netty.net.packet.PacketBuilder;

public class World {

	private static World world;
	private ChannelLocal<Player> channelLocal;
	private List<Player> playerList;
	private List<NPC> npcList;
	private List<Item> itemList;
	private List<Object> objectList;
	private List<Friend> friendsList;
	private List<Ignore> ignoresList;
	private List<NPC> npcDropList;
	private List<Item> itemDropList;
	private List<Clan> clanList;
	private Logger logger;
	private Revision revision;
	private ServerState serverState;

	public World() {
		this.setChannelLocal(new ChannelLocal<Player>());
		this.setPlayerList(new ArrayList<Player>(PlayerConstants.MAX_PLAYERS));
		this.setNPCList(new ArrayList<NPC>(NPCConstants.MAX_NPCS));
		this.setItemList(new ArrayList<Item>(ItemConstants.MAX_ITEMS));
		this.setObjectList(new ArrayList<Object>(ObjectConstants.MAX_OBJECTS));
		this.setFriendsList(new ArrayList<Friend>(TabConstants.MAX_FRIENDS));
		this.setIgnoresList(new ArrayList<Ignore>(TabConstants.MAX_IGNORES));
		this.setNPCDropList(new ArrayList<NPC>(NPCConstants.MAX_NPC_DROPS));
		this.setItemDropList(new ArrayList<Item>(ItemConstants.MAX_ITEM_DROPS));
		this.setClanList(new ArrayList<Clan>(ClanConstants.MAX_CLANS));
		this.setLogger(Logger.getLogger(this.getClass().getName()));
	}

	public void registerPlayer(final Player player) {
		if (player == null) {
			return;
		}
		if (player.getChannel() == null) {
			return;
		}
		byte response = 2;
		/** if (this.getPlayerList().contains(player)) {
			this.getLogger().info("Player list already contains player...");
			response = 5;
		}
		if (player.getPass().equals("") || !player.getPass().equals(this.getCharacter().getPlayer().getPass())) {
			this.getLogger().info("Invalid user or pass...");
			response = 3;
		}
		if (player.getStatus().isBanned(player)) {
			this.getLogger().info("Player " + NameUtility.getCapitalizedWord(player.getName()) + " is banned...");
			response = 4;
		}
		if (this.getPlayerList().size() > Constants.MAX_PLAYERS) {
			this.getLogger().info("Could not register the player...");
			response = 7;
		}
		if (player.isUpdatingServer()) {
			this.getLogger().info("Updating the server...");
			response = 14;
		} */
		// player.setCharacter(new Character(player));
		// player.getCharacter().loadCharacterXML();
		if (player.getName().equals("Rodrigues")) {
			player.setRank(Rank.ADMINISTRATOR);
		}
		player.getChannel().write(new PacketBuilder().putByte(response).putByte(player.getRank().getID()).putByte((byte) 0)).addListener(new ChannelFutureListener() {
			@Override
			public void operationComplete(ChannelFuture channelFuture) {
				World.this.getPlayerList().add(player);
				player.setIndex((short) (World.this.getPlayerList().indexOf(player) + 1));
				player.setLoggedState(LoggedState.LOGGED_IN);
				player.getPacketSender().getLogin();
			}
		});
	}

	public boolean unregisterPlayer(Player player) {
		if (player == null) {
			return false;
		}
		if (player.getCharacter() == null) {
			return false;
		}
		player.getCharacter().saveCharacterXML();
		player.getUpdateFlags().resetUpdateFlags();
		player.getChannel().close();
		return this.getPlayerList().remove(player);
	}

	public boolean unregisterNPC(NPC npc) {
		if (npc == null) {
			return false;
		}
		npc.getUpdateFlags().resetUpdateFlags();
		return this.getNPCList().remove(npc);
	}

	public boolean unregisterFriend(Friend friend) {
		if (friend == null) {
			return false;
		}
		friend.setOnline(false);
		return this.getFriendsList().remove(friend);
	}

	public Player getPlayerName(String name) {
		if (name == null) {
			return null;
		}
		if (name.equals("")) {
			return null;
		}
		for (Player player : this.getPlayerList()) {
			if (name.equals(player.getName())) {
				return player;
			}
		}
		return null;
	}

	public NPC getNPCName(String name) {
		if (name == null) {
			return null;
		}
		if (name.equals("")) {
			return null;
		}
		for (NPC npc : this.getNPCList()) {
			if (name.equals(npc.getName())) {
				return npc;
			}
		}
		return null;
	}

	public Object getObjectName(String name) {
		if (name == null) {
			return null;
		}
		if (name.equals("")) {
			return null;
		}
		for (Object object : this.getObjectList()) {
			if (name.equals(object.getName())) {
				return object;
			}
		}
		return null;
	}

	public Friend getFriendsName(String name) {
		if (name == null) {
			return null;
		}
		if (name.equals("")) {
			return null;
		}
		for (Friend friend : this.getFriendsList()) {
			if (name.equals(friend.getName())) {
				return friend;
			}
		}
		return null;
	}

	public Ignore getIgnoresName(String name) {
		if (name == null) {
			return null;
		}
		if (name.equals("")) {
			return null;
		}
		for (Ignore ignore : this.getIgnoresList()) {
			if (name.equals(ignore.getName())) {
				return ignore;
			}
		}
		return null;
	}

	public String getGoogleTranslatedLanguage(Entity entity, String message) {
		String text = null;
		if (entity.getLanguage() == Language.ENGLISH) {
			return message;
		}
		try {
			text = Translate.execute(message, Detect.execute(message).getLanguage(), entity.getLanguage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return text;
	}

	public static void setWorld(World world) {
		World.world = world;
	}

	public static World getWorld() {
		if (World.world == null) {
			World.setWorld(new World());
		}
		return World.world;
	}

	public void setChannelLocal(ChannelLocal<Player> channelLocal) {
		this.channelLocal = channelLocal;
	}

	public ChannelLocal<Player> getChannelLocal() {
		return this.channelLocal;
	}

	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}

	public List<Player> getPlayerList() {
		return this.playerList;
	}

	public void setNPCList(List<NPC> npcList) {
		this.npcList = npcList;
	}

	public List<NPC> getNPCList() {
		return this.npcList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public List<Item> getItemList() {
		return this.itemList;
	}

	public void setObjectList(List<Object> objectList) {
		this.objectList = objectList;
	}

	public List<Object> getObjectList() {
		return this.objectList;
	}

	public void setFriendsList(List<Friend> friendsList) {
		this.friendsList = friendsList;
	}

	public List<Friend> getFriendsList() {
		return this.friendsList;
	}

	public void setIgnoresList(List<Ignore> ignoresList) {
		this.ignoresList = ignoresList;
	}

	public List<Ignore> getIgnoresList() {
		return this.ignoresList;
	}

	public void setNPCDropList(List<NPC> npcDropList) {
		this.npcDropList = npcDropList;
	}

	public List<NPC> getNPCDropList() {
		return this.npcDropList;
	}

	public void setItemDropList(List<Item> itemDropList) {
		this.itemDropList = itemDropList;
	}

	public List<Item> getItemDropList() {
		return this.itemDropList;
	}

	public void setClanList(List<Clan> clanList) {
		this.clanList = clanList;
	}

	public List<Clan> getClanList() {
		return this.clanList;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public Logger getLogger() {
		return this.logger;
	}

	public void setRevision(Revision revision) {
		this.revision = revision;
	}

	public Revision getRevision() {
		return this.revision;
	}

	public void setServerState(ServerState serverState) {
		this.serverState = serverState;
	}

	public ServerState getServerState() {
		return this.serverState;
	}
}
