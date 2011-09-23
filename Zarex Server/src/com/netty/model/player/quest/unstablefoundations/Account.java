package com.netty.model.player.quest.unstablefoundations;

import com.netty.model.player.quest.Quest;
import com.netty.world.Server;

/**
 * An <code>Account</code> that you will
 * make when you start off the {@link Quest}.
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:46:04 PM
 */
public class Account {

	/**
	 * The type of an <code>Account</code>
	 * to be/play on.
	 */
	private AccountType accountType;

	/**
	 * Creates a new type of <code>Account</code>
	 * for appearance and gender purposes along
	 * with log in credentials.
	 * @param accountType
	 * 			The type of <code>Account</code> used
	 * 			throughout the {@link Server}.
	 */
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	/**
	 * Returns the type of <code>Account</code> that
	 * you will use throughout the {@link UnstableFoundations}
	 * <code> Quest</code>.
	 * @return accountType
	 * 			The type of <code>Account</code> for
	 * 			your <code>Account</code>.
	 */
	public AccountType getAccountType() {
		return this.accountType;
	}
}