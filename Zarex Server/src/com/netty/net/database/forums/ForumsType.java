package com.netty.net.database.forums;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 1:25:27 PM
 */
public enum ForumsType {

	/**
	 * 
	 */
	SMF("smf_members", "memberName", "passwd", "passwordSalt", "ID_GROUP"),

	/**
	 * 
	 */
	VBULLETIN("user", "username", "password", "salt", "usergroupid"),

	/**
	 * 
	 */
	PHPBB("users", "username", "user_password", "user_password", "group_id"),

	/**
	 * 
	 */
	IPB("members", "members_display_name", "members_pass_hash", "members_pass_salt", "member_group_id"),

	/**
	 * 
	 */
	MYBB("mybb_users", "username", "password", "salt", "usergroupid");

	/**
	 * 
	 */
	private String databaseName;

	/**
	 * 
	 */
	private String name;

	/**
	 * 
	 */
	private String pass;

	/**
	 * 
	 */
	private String salt;

	/**
	 * 
	 */
	private String id;

	/**
	 * 
	 * @param databaseName
	 * 			The id to set.
	 * @param name
	 * 			The id to set.
	 * @param pass
	 * 			The id to set.
	 * @param salt
	 * 			The id to set.
	 * @param id
	 * 			The id to set.
	 */
	private ForumsType(String databaseName, String name, String pass, String salt, String id) {
		this.setDatabaseName(databaseName);
		this.setName(name);
		this.setPass(pass);
		this.setSalt(salt);
		this.setID(id);
	}

	/**
	 * 
	 * @param databaseName
	 * 			The id to set.
	 */
	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public String getDatabaseName() {
		return this.databaseName;
	}

	/**
	 * 
	 * @param name
	 * 			The id to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param pass
	 * 			The id to set.
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public String getPass() {
		return this.pass;
	}

	/**
	 * 
	 * @param salt
	 * 			The id to set.
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public String getSalt() {
		return this.salt;
	}

	/**
	 * 
	 * @param id
	 * 			The id to set.
	 */
	public void setID(String id) {
		this.id = id;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public String getID() {
		return this.id;
	}
}