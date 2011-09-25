package com.netty.lobby;

import com.netty.annotations.AnnotationType;
import com.netty.annotations.Edit;

/**
 * A lobby where players can wait before
 * actually going in-game to play.
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 1:45:16 PM
 */
@Edit(getAnnotationType = AnnotationType.EDIT)
public class Lobby {

	/**
	 * The player's information on his/her account.
	 */
	private PlayerInfo playerInfo;

	/**
	 * A selection of worlds to choose from for when
	 * you wish to change worlds.
	 */
	private WorldSelect worldSelect;

	/**
	 * A list of friends, ignores and clan chat users
	 * that you contain within the server.
	 */
	private Friends friends;

	/**
	 * The chatting between yourself and your friends
	 * among the lobby.
	 */
	private FriendsChat friendsChat;

	/**
	 * The chatting between yourself and your friends
	 * within the clan chat.
	 */
	private ClanChat clanChat;

	/**
	 * A set of options/settings to choose from for
	 * in-game.
	 */
	private Options options;

	/**
	 * Construct a new lobby where players may
	 * "redeisgn" their settings, so to speak.
	 * 
	 * @param playerInfo
	 * 			The player's information to set.
	 * @param worldSelect
	 * 			The selection of worlds to select from.
	 * @param friends
	 * 			The friends/ignores/clan list to set.
	 * @param friendsChat
	 * 			The friends chat to set.
	 * @param clanChat
	 * 			The clan chat to set.
	 * @param options
	 * 			The in-game options to set.
	 */
	public Lobby(PlayerInfo playerInfo, WorldSelect worldSelect, Friends friends, FriendsChat friendsChat, ClanChat clanChat, Options options) {
		this.setPlayerInfo(playerInfo);
		this.setWorldSelect(worldSelect);
		this.setFriends(friends);
		this.setFriendsChat(friendsChat);
		this.setClanChat(clanChat);
		this.setOptions(options);
	}

	/**
	 * Sets the player's information for confirmation
	 * on a things about their character.
	 * 
	 * @param playerInfo
	 * 			The player's information to set.
	 */
	public void setPlayerInfo(PlayerInfo playerInfo) {
		this.playerInfo = playerInfo;
	}

	/**
	 * Gets the player's information to notify users
	 * about things they still need to confirm.
	 * 
	 * @return playerInfo
	 * 			Returns the player's information on
	 * 			a panel.
	 */
	public PlayerInfo getPlayerInfo() {
		return this.playerInfo;
	}

	/**
	 * Sets the selection of worlds you are
	 * allowed to choose from.
	 * 
	 * @param worldSelect
	 * 			The selection of worlds to set.
	 */
	public void setWorldSelect(WorldSelect worldSelect) {
		this.worldSelect = worldSelect;
	}

	/**
	 * Gets the selection of worlds to choose
	 * from.
	 * 
	 * @return worldSelect
	 * 			Returns the selection of worlds
	 * 			listed on a panel.
	 */
	public WorldSelect getWorldSelect() {
		return this.worldSelect;
	}

	/**
	 * Sets the friends, ignores and clan chat
	 * list.
	 * 
	 * @param friends
	 * 			The friends, ignores, and clan chat
	 * 			users to set on the panel.
	 */
	public void setFriends(Friends friends) {
		this.friends = friends;
	}

	/**
	 * Gets the friends, ignores, and clan chat list
	 * from in-game.
	 * 
	 * @return friends
	 * 			Returns the friends, ignores and clan
	 * 			chat users on the panel.
	 */
	public Friends getFriends() {
		return this.friends;
	}

	/**
	 * Sets the friend's chat to chat in.
	 * 
	 * @param friendsChat
	 * 			The friend's chat to set.
	 */
	public void setFriendsChat(FriendsChat friendsChat) {
		this.friendsChat = friendsChat;
	}

	/**
	 * Gets the friend's chat to chat in.
	 * 
	 * @return friendsChat
	 * 			Returns the friend's chat.
	 */
	public FriendsChat getFriendsChat() {
		return this.friendsChat;
	}

	/**
	 * Sets the clan chat to chat in.
	 * 
	 * @param clanChat
	 * 			The clan chat to set.
	 */
	public void setClanChat(ClanChat clanChat) {
		this.clanChat = clanChat;
	}

	/**
	 * Gets the clan chat to chat in.
	 * 
	 * @return clanChat
	 * 			Returns the clan chat panel.
	 */
	public ClanChat getClanChat() {
		return this.clanChat;
	}

	/**
	 * Sets the options for in-game settings.
	 * 
	 * @param options
	 * 			The options/settings to set.
	 */
	public void setOptions(Options options) {
		this.options = options;
	}

	/**
	 * Gets the options for in-game settings.
	 * 
	 * @return options
	 * 			Returns the options/settings for
	 * 			in-game.
	 */
	public Options getOptions() {
		return this.options;
	}
}