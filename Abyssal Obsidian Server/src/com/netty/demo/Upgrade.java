package com.netty.demo;

/**
 * Upgrades your account from the demo
 * version to the full play game.
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 5:31:12 PM
 */
public class Upgrade {

	/**
	 * The name of the player.
	 */
	private String name;

	/**
	 * The password for the player.
	 */
	private String pass;

	/**
	 * The email address the player signed
	 * up with.
	 */
	private String emailAddress;

	/**
	 * Constructs a new Upgrade for the player to
	 * use when he's finished with the demo. In
	 * order to "upgrade", we must check for certain
	 * criteria to be met in order to move on with the
	 * gameplay.
	 * 
	 * @param name
	 * 			The name of the Player so we can
	 * 			figure out who's who.
	 * @param pass
	 * 			The password of the Player so we can
	 * 			match it up with the name.
	 * @param emailAddress
	 * 			The email address used when creating the
	 * 			character.
	 */
	public Upgrade(String name, String pass, String emailAddress) {
		this.setName(name);
		this.setPass(pass);
		this.setEmailAddress(emailAddress);
	}

	/**
	 * In order to find who the player is, we must
	 * create its name. This is by far the most
	 * important/used when it comes to identification
	 * and clarification.
	 * 
	 * @param name
	 * 			The name of the player.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the name in order to see who is able to
	 * upgrade and who isn't.
	 * 
	 * @return name
	 * 			Returns the name of the player.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * The name of the player along with the password
	 * will be matched up to see if it is the player.
	 * 
	 * @param pass
	 * 			The password to set.
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	/**
	 * Gets the password the player used
	 * to upgrade with.
	 * 
	 * @return pass
	 * 			Returns the user's password.
	 */
	public String getPass() {
		return this.pass;
	}

	/**
	 * Sets the email address for the player to
	 * sign up with.
	 * 
	 * @param emailAddress
	 * 			The email address to set.
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * Gets the email address the player used
	 * to sign up with.
	 * 
	 * @return emailAddress
	 * 			Returns user's the email address.
	 */
	public String getEmailAddress() {
		return this.emailAddress;
	}
}