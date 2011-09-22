package com.netty.net.database;

import java.sql.Connection;

public class Database {

	private String databaseName;
	private String url;
	private String name;
	private String pass;
	private String host;
	private Connection connection;

	public Database(String databaseName, String url, String name, String pass, String host, Connection connection) {
		this.setDatabaseName(databaseName);
		this.setURL(url);
		this.setName(name);
		this.setPass(pass);
		this.setHost(host);
		this.setConnection(connection);
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getDatabaseName() {
		return this.databaseName;
	}

	public void setURL(String url) {
		this.url = url;
	}

	public String getURL() {
		return this.url;
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

	public void setHost(String host) {
		this.host = host;
	}

	public String getHost() {
		return this.host;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Connection getConnection() {
		return this.connection;
	}
}