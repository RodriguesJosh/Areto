package com.netty.net.database.forums;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.netty.model.player.Rank;
import com.netty.net.database.Database;
import com.netty.net.database.SQL;
import com.netty.net.packet.login.ReturnCode;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 1:23:18 PM
 */
public class Forums {

	/**
	 * 
	 */
	private ForumsType forumsType;

	/**
	 * 
	 */
	private SQL sql;

	/**
	 * 
	 */
	private ReturnCode returnCode;

	/**
	 * 
	 * @param forumsType
	 * 			The id to set.
	 * @param database
	 * 			The id to set.
	 */
	public Forums(ForumsType forumsType, Database database) {
		this.setForumsType(forumsType);
		this.setSQL(new SQL(database));
		this.connectForums();
	}

	/**
	 * 
	 */
	private void connectForums() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String host = this.getSQL().getDatabase().getHost();
			String name = this.getSQL().getDatabase().getName();
			String pass = this.getSQL().getDatabase().getPass();
			Connection connection = this.getSQL().getDatabase().getConnection();
			if (connection == null) {
				connection = DriverManager.getConnection(host, name, pass);
				String query = "SELECT * FROM " + this.getForumsType().getDatabaseName() + " WHERE " + this.getForumsType().getPass() + " LIKE 'null312'";
				this.getSQL().queryResults(query);
			}
		} catch (Exception e) {
			System.out.println("Connetion rejected, Wrong username or password, or ip is banned, or host is down.");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param name
	 * 			The id to set.
	 * @param pass
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public Rank login(String name, String pass) {
		String query = "SELECT * FROM " + this.getForumsType().getDatabaseName() + " WHERE " + this.getForumsType().getName() + " LIKE '" + name + "'";
		ResultSet resultSet = this.getSQL().queryResults(query);
		try {
			if (resultSet.next()) {
				String salt = resultSet.getString(this.getForumsType().getSalt());
				String password = resultSet.getString(this.getForumsType().getPass());
				String groupID = resultSet.getString(this.getForumsType().getID());
				int rankID = Integer.parseInt(groupID);
				String encryptedPass = null;
				switch (this.getForumsType()) {
					case SMF:
						encryptedPass = Encryption.encrypt(name.toLowerCase() + pass, "SHA");
						break;
					case VBULLETIN:
						encryptedPass = Encryption.encrypt(pass, "MD5");
						encryptedPass = Encryption.encrypt(encryptedPass + salt, "MD5");
						break;
					case PHPBB:
						encryptedPass = Encryption.encrypt(pass, "MD5");
						break;
					case IPB:
						encryptedPass = Encryption.encrypt((Encryption.encrypt(salt, "MD5") + Encryption.encrypt(pass, "MD5")), "MD5");
						break;
					case MYBB:
						encryptedPass = Encryption.encrypt((Encryption.encrypt(salt, "MD5") + Encryption.encrypt(pass, "MD5")), "MD5");
						break;
				}
				if (password.equals(encryptedPass)) {
					this.setReturnCode(ReturnCode.LOGIN);
				} else {
					this.setReturnCode(ReturnCode.INVALID_USER_PASS);
				}
				switch (rankID) {
					case 0:
						return Rank.PLAYER;
					case 1:
						return Rank.MODERATOR;
					case 2:
						return Rank.ADMINISTRATOR;
					case 3:
						return Rank.OWNER;
				}
			} else {
				this.setReturnCode(ReturnCode.NO_ACCOUNT);
			}
		} catch (SQLException ioe) {
			ioe.printStackTrace();
			return Rank.PLAYER;
		}
		return Rank.PLAYER;
	}

	/**
	 * 
	 * @param forumsType
	 * 			The id to set.
	 */
	public void setForumsType(ForumsType forumsType) {
		this.forumsType = forumsType;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public ForumsType getForumsType() {
		return this.forumsType;
	}

	/**
	 * 
	 * @param sql
	 * 			The id to set.
	 */
	public void setSQL(SQL sql) {
		this.sql = sql;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public SQL getSQL() {
		return this.sql;
	}

	/**
	 * 
	 * @param returnCode
	 * 			The id to set.
	 */
	public void setReturnCode(ReturnCode returnCode) {
		this.returnCode = returnCode;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public ReturnCode getReturnCode() {
		return this.returnCode;
	}
}