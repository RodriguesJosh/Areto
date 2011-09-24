package com.netty.net.database;

import java.sql.Connection;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 1:27:20 PM
 */
public class Database {

	/**
	 * 
	 */
	private String databaseName;
	/**
	 * 
	 */
	private String url;

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
	private String host;

	/**
	 * 
	 */
	private Connection connection;

	/**
	 * 
	 * @param databaseName
	 * 			The id to set.
	 * @param url
	 * 			The id to set.
	 * @param name
	 * 			The id to set.
	 * @param pass
	 * 			The id to set.
	 * @param host
	 * 			The id to set.
	 * @param connection
	 * 			The id to set.
	 */
	public Database(String databaseName, String url, String name, String pass, String host, Connection connection) {
		this.setDatabaseName(databaseName);
		this.setURL(url);
		this.setName(name);
		this.setPass(pass);
		this.setHost(host);
		this.setConnection(connection);
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
	 * @param url
	 * 			The id to set.
	 */
	public void setURL(String url) {
		this.url = url;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public String getURL() {
		return this.url;
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
	 * @param host
	 * 			The id to set.
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public String getHost() {
		return this.host;
	}

	/**
	 * 
	 * @param connection
	 * 			The id to set.
	 */
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Connection getConnection() {
		return this.connection;
	}
}