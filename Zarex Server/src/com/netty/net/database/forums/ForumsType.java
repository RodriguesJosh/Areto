package com.netty.net.database.forums;

public enum ForumsType {

	SMF("smf_members", "memberName", "passwd", "passwordSalt", "ID_GROUP"),
	VBULLETIN("user", "username", "password", "salt", "usergroupid"),
	PHPBB("users", "username", "user_password", "user_password", "group_id"),
	IPB("members", "members_display_name", "members_pass_hash", "members_pass_salt", "member_group_id"),
	MYBB("mybb_users", "username", "password", "salt", "usergroupid");

	private String databaseName;
	private String name;
	private String pass;
	private String salt;
	private String id;

	private ForumsType(String databaseName, String name, String pass, String salt, String id) {
		this.setDatabaseName(databaseName);
		this.setName(name);
		this.setPass(pass);
		this.setSalt(salt);
		this.setID(id);
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getDatabaseName() {
		return this.databaseName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPass() {
		return this.pass;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getSalt() {
		return this.salt;
	}

	public void setID(String id) {
		this.id = id;
	}

	public String getID() {
		return this.id;
	}
}