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

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:56:08 AM
 */
public class World {

	/**
	 * 
	 */
	private static World world;

	/**
	 * 
	 */
	private ChannelLocal<Player> channelLocal;

	/**
	 * 
	 */
	private List<Player> playerList;

	/**
	 * 
	 */
	private List<NPC> npcList;

	/**
	 * 
	 */
	private List<Item> itemList;

	/**
	 * 
	 */
	private List<Object> objectList;

	/**
	 * 
	 */
	private List<Friend> friendsList;

	/**
	 * 
	 */
	private List<Ignore> ignoresList;

	/**
	 * 
	 */
	private List<NPC> npcDropList;

	/**
	 * 
	 */
	private List<Item> itemDropList;

	/**
	 * 
	 */
	private List<Clan> clanList;

	/**
	 * 
	 */
	private Logger logger;

	/**
	 * 
	 */
	private Revision revision;

	/**
	 * 
	 */
	private ServerState serverState;

	/**
	 * 
	 */
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

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 */
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

			/*
			 * (non-Javadoc)
			 * @see org.jboss.netty.channel.ChannelFutureListener#operationComplete(org.jboss.netty.channel.ChannelFuture)
			 */
			@Override
			public void operationComplete(ChannelFuture channelFuture) {
				World.this.getPlayerList().add(player);
				player.setIndex((short) (World.this.getPlayerList().indexOf(player) + 1));
				player.setLoggedState(LoggedState.LOGGED_IN);
				player.getPacketSender().getLogin();
			}
		});
	}

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
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

	/**
	 * 
	 * @param npc
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public boolean unregisterNPC(NPC npc) {
		if (npc == null) {
			return false;
		}
		npc.getUpdateFlags().resetUpdateFlags();
		return this.getNPCList().remove(npc);
	}

	/**
	 * 
	 * @param friend
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public boolean unregisterFriend(Friend friend) {
		if (friend == null) {
			return false;
		}
		friend.setOnline(false);
		return this.getFriendsList().remove(friend);
	}

	/**
	 * 
	 * @param name
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
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

	/**
	 * 
	 * @param name
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
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

	/**
	 * 
	 * @param name
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
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

	/**
	 * 
	 * @param name
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
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

	/**
	 * 
	 * @param name
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
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

	/**
	 * 
	 * @param entity
	 * 			The id to set.
	 * @param message
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
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

	/**
	 * 
	 * @param world
	 * 			The id to set.
	 */
	public static void setWorld(World world) {
		World.world = world;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public static World getWorld() {
		if (World.world == null) {
			World.setWorld(new World());
		}
		return World.world;
	}

	/**
	 * 
	 * @param channelLocal
	 * 			The id to set.
	 */
	public void setChannelLocal(ChannelLocal<Player> channelLocal) {
		this.channelLocal = channelLocal;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public ChannelLocal<Player> getChannelLocal() {
		return this.channelLocal;
	}

	/**
	 * 
	 * @param playerList
	 * 			The id to set.
	 */
	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public List<Player> getPlayerList() {
		return this.playerList;
	}

	/**
	 * 
	 * @param npcList
	 * 			The id to set.
	 */
	public void setNPCList(List<NPC> npcList) {
		this.npcList = npcList;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public List<NPC> getNPCList() {
		return this.npcList;
	}

	/**
	 * 
	 * @param itemList
	 * 			The id to set.
	 */
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public List<Item> getItemList() {
		return this.itemList;
	}

	/**
	 * 
	 * @param objectList
	 * 			The id to set.
	 */
	public void setObjectList(List<Object> objectList) {
		this.objectList = objectList;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public List<Object> getObjectList() {
		return this.objectList;
	}

	/**
	 * 
	 * @param friendsList
	 * 			The id to set.
	 */
	public void setFriendsList(List<Friend> friendsList) {
		this.friendsList = friendsList;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public List<Friend> getFriendsList() {
		return this.friendsList;
	}

	/**
	 * 
	 * @param ignoresList
	 * 			The id to set.
	 */
	public void setIgnoresList(List<Ignore> ignoresList) {
		this.ignoresList = ignoresList;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public List<Ignore> getIgnoresList() {
		return this.ignoresList;
	}

	/**
	 * 
	 * @param npcDropList
	 * 			The id to set.
	 */
	public void setNPCDropList(List<NPC> npcDropList) {
		this.npcDropList = npcDropList;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public List<NPC> getNPCDropList() {
		return this.npcDropList;
	}

	/**
	 * 
	 * @param itemDropList
	 * 			The id to set.
	 */
	public void setItemDropList(List<Item> itemDropList) {
		this.itemDropList = itemDropList;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public List<Item> getItemDropList() {
		return this.itemDropList;
	}

	/**
	 * 
	 * @param clanList
	 * 			The id to set.
	 */
	public void setClanList(List<Clan> clanList) {
		this.clanList = clanList;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public List<Clan> getClanList() {
		return this.clanList;
	}

	/**
	 * 
	 * @param logger
	 * 			The id to set.
	 */
	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Logger getLogger() {
		return this.logger;
	}

	/**
	 * 
	 * @param revision
	 * 			The id to set.
	 */
	public void setRevision(Revision revision) {
		this.revision = revision;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Revision getRevision() {
		return this.revision;
	}

	/**
	 * 
	 * @param serverState
	 * 			The id to set.
	 */
	public void setServerState(ServerState serverState) {
		this.serverState = serverState;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public ServerState getServerState() {
		return this.serverState;
	}
}