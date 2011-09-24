package com.netty.lobby;

import com.netty.annotations.AnnotationType;
import com.netty.annotations.Finished;

/**
 * The player's information for when need
 * to gain access to something such as bans,
 * mutes, etc.
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 4:22:55 PM
 */
@Finished(getAnnotationType = AnnotationType.FINISHED)
public class PlayerInfo {

	/**
	 * Your IP address that you are connecting
	 * from.
	 */
	private String ipAddress;

	/**
	 * Whether or not your email has been
	 * registered for your account to be
	 * validated.
	 */
	private boolean emailRegistration;

	/**
	 * Whether or not your recovery questions
	 * are set.
	 */
	private boolean recoveryQuestions;

	/**
	 * Whether or not your inbox contains
	 * unread messages.
	 */
	private boolean messages;

	/**
	 * Whether or not you are a member.
	 */
	private boolean membership;

	/**
	 * Constructs a new player information for
	 * each player.
	 * 
	 * @param ipAddress
	 * 			Your IP address of where you are
	 * 			connecting from.
	 * @param emailRegistration
	 * 			Whether or not your email has been
	 * 			registered.
	 * @param recoveryQuestions
	 * 			Whether or not your have set recovery
	 * 			questions for your account.
	 * @param messages
	 * 			Whether or not you have messages within
	 * 			your inbox.
	 * @param membership
	 * 			Whether or not you are a member.
	 */
	public PlayerInfo(String ipAddress, boolean emailRegistration, boolean recoveryQuestions, boolean messages, boolean membership) {
		this.setIPAddress(ipAddress);
		this.setEmailRegistration(emailRegistration);
		this.setRecoveryQuestions(recoveryQuestions);
		this.setMessages(messages);
		this.setMembership(membership);
	}

	/**
	 * Sets the IP address from where you
	 * connected from.
	 * 
	 * @param ipAddress
	 * 			The IP address to set.
	 */
	public void setIPAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/**
	 * Gets the IP address of the player we
	 * are checking.
	 * 
	 * @return ipAddress
	 * 			Returns the IP address.
	 */
	public String getIPAddress() {
		return this.ipAddress;
	}

	/**
	 * Sets whether or not the user has
	 * registered his/her email yet.
	 * 
	 * @param emailRegistration
	 * 			The email registration to set.
	 */
	public void setEmailRegistration(boolean emailRegistration) {
		this.emailRegistration = emailRegistration;
	}

	/**
	 * Gets whether the email registration was
	 * valid or not for the player.
	 * 
	 * @return emailRegistration
	 * 			Returns the email registration of
	 * 			the user.
	 */
	public boolean isEmailRegistration() {
		return this.emailRegistration;
	}

	/**
	 * Sets whether or not your account has
	 * recovery questions enabled.
	 * 
	 * @param recoveryQuestions
	 * 			The recovery questions to set.
	 */
	public void setRecoveryQuestions(boolean recoveryQuestions) {
		this.recoveryQuestions = recoveryQuestions;
	}

	/**
	 * Gets the recovery questions for hacking
	 * purposes.
	 * 
	 * @return recoveryQuestions
	 * 			Returns the recovery questions.
	 */
	public boolean isRecoveryQuestions() {
		return this.recoveryQuestions;
	}

	/**
	 * Sets whether or not your inbox contains
	 * unread messages.
	 * 
	 * @param messages
	 * 			The messages to set.
	 */
	public void setMessages(boolean messages) {
		this.messages = messages;
	}

	/**
	 * Gets whether or not your player has unread
	 * messages.
	 * 
	 * @return messages
	 * 			Returns whether your player has
	 * 			unread messages.
	 */
	public boolean isMessages() {
		return this.messages;
	}

	/**
	 * Sets whether or not your player has
	 * membership in-game.
	 * 
	 * @param membership
	 * 			The membership to set.
	 */
	public void setMembership(boolean membership) {
		this.membership = membership;
	}

	/**
	 * Gets the membership from the player if
	 * he has membership.
	 * 
	 * @return membership
	 * 			Returns whether or not your player
	 * 			has membership in-game.
	 */
	public boolean isMembership() {
		return this.membership;
	}
}