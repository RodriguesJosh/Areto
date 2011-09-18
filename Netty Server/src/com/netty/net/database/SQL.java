package com.netty.net.database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.netty.world.World;

public class SQL {

	private Database database;

	public SQL(Database database) {
		try {
			this.setDatabase(database);
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.getDatabase().setConnection(DriverManager.getConnection(this.getDatabase().getURL(), this.getDatabase().getName(), this.getDatabase().getPass()));
			this.getDatabase().setURL("jdbc:mysql://" + this.getDatabase().getHost() + "/" + this.getDatabase().getDatabaseName());
			if (!this.getDatabase().getConnection().isClosed()) {
				World.getWorld().getLogger().info("Connection to the MySQL database is a success...");
			} else {
				World.getWorld().getLogger().info("Connection to the MySQL database was not a success...");
			}
			if (this.getDatabase().getDatabaseName().equals("netty-server")) {
				this.getNPCs();
				this.getItems();
				this.getShops();
				this.getGrandExchangeItems();
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (InstantiationException ie) {
			ie.printStackTrace();
		} catch (IllegalAccessException iae) {
			iae.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}

	private void getNPCs() {
		try {
			if (this.getDatabase().getConnection() != null) {
				Statement statement = this.getDatabase().getConnection().createStatement();
				ResultSet resultSet = this.queryResults("SELECT id FROM npcs");
				int npcAmount = 0;
				while (resultSet.next()) {
					npcAmount++;
				}
				World.getWorld().getLogger().info("Loaded " + npcAmount + " NPCs...");
				statement.close();
			} else {
				World.getWorld().getLogger().info("Could not retrieve the npcs from the database...");
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	private void getItems() {
		try {
			if (this.getDatabase().getConnection() != null) {
				Statement statement = this.getDatabase().getConnection().createStatement();
				ResultSet resultSet = this.queryResults("SELECT id FROM items");
				int itemAmount = 0;
				while (resultSet.next()) {
					itemAmount++;
				}
				World.getWorld().getLogger().info("Loaded " + itemAmount + " Items...");
				statement.close();
			} else {
				World.getWorld().getLogger().info("Could not retrieve the items from the database...");
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	private void getShops() {
		try {
			if (this.getDatabase().getConnection() != null) {
				Statement statement = this.getDatabase().getConnection().createStatement();
				ResultSet resultSet = this.queryResults("SELECT id FROM shops");
				int shopAmount = 0;
				while (resultSet.next()) {
					shopAmount++;
				}
				World.getWorld().getLogger().info("Loaded " + shopAmount + " Items...");
				statement.close();
			} else {
				World.getWorld().getLogger().info("Could not retrieve the shops from the database...");
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	private void getGrandExchangeItems() {
		try {
			if (this.getDatabase().getConnection() != null) {
				Statement statement = this.getDatabase().getConnection().createStatement();
				ResultSet resultSet = this.queryResults("SELECT id FROM grandexchange");
				int grandExchangeAmount = 0;
				while (resultSet.next()) {
					grandExchangeAmount++;
				}
				World.getWorld().getLogger().info("Loaded " + grandExchangeAmount + " GrandExchange items...");
				statement.close();
			} else {
				World.getWorld().getLogger().info("Could not retrieve the GrandExchange items from the database...");
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	public void destroyConnection() {
		try {
			if (this.getDatabase().getConnection() != null) {
				this.getDatabase().getConnection().close();
				World.getWorld().getLogger().info("Connection to the MySQL database has been terminated...");
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	public void executeQuery(String query) {
		try {
			if (this.getDatabase().getConnection() != null) {
				Statement statement = this.getDatabase().getConnection().createStatement();
				statement.executeUpdate(query);
				statement.close();
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	public ResultSet queryResults(String results) {
		try {
			if (this.getDatabase().getConnection() != null) {
				Statement statement = this.getDatabase().getConnection().createStatement();
				return statement.executeQuery(results);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return null;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}

	public Database getDatabase() {
		return this.database;
	}
}