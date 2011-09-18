package com.netty.demo;

import com.netty.model.player.Character;
import com.netty.model.player.Player;

/**
 * Upgrades your account from
 * the {@link Demo} version to the full
 * play game.
 * @author Josh
 * @since 0.1
 */
public class Upgrade {

	/**
	 * The name of the {@link Player}.
	 */
	private String name;

	/**
	 * The password for the <code>Player</code>.
	 */
	private String pass;

	/**
	 * The email address the <code>Player </code>
	 * signed up with.
	 */
	private String emailAddress;

	/**
	 * Constructs a new <code>Upgrade</code> for
	 * the <code>Player</code> to use when he's finished
	 * with the <code>Demo</code>. In order to "upgrade",
	 * we must check for certain criteria to be met
	 * in order to move on with the gameplay.
	 * @param name
	 * 			The name of the <code>Player</code> so
	 * 			we can figure out who's who.
	 * @param pass
	 * 			The password of the <code>Player</code>
	 * 			so we can match it up with the name.
	 * @param emailAddress
	 * 			The email address used when creating the
	 * 			{@link Character}.
	 */
	public Upgrade(String name, String pass, String emailAddress) {
		this.setName(name);
		this.setPass(pass);
		this.setEmailAddress(emailAddress);
	}

	/**
	 * In order to find who the <code>Player</code>
	 * is, we must create its name. This is by
	 * far the most important/used when it comes
	 * to identification and clarification.
	 * @param name
	 * 			The name of the <code>Player</code>.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * We'll get the name in order to see who is
	 * able to <code>Upgrade</code> and who isn't.
	 * @return name
	 * 			Gets the name of the <code>Player</code>.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * The name of the <code>Player</code> along
	 * with the password will be matched up to
	 * see if it is the <code>Player</code>.
	 * @param pass
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPass() {
		return this.pass;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}
}