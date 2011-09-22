package com.netty.net.database.forums;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.netty.model.player.Rank;
import com.netty.net.database.Database;
import com.netty.net.database.SQL;
import com.netty.net.packet.login.ReturnCode;

public class Forums {

	private ForumsType forumsType;
	private SQL sql;
	private ReturnCode returnCode;

	public Forums(ForumsType forumsType, Database database) {
		this.setForumsType(forumsType);
		this.setSQL(new SQL(new Database(null, null, null, null, null, null)));
		this.connectForums();
	}

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

	public void setForumsType(ForumsType forumsType) {
		this.forumsType = forumsType;
	}

	public ForumsType getForumsType() {
		return this.forumsType;
	}

	public void setSQL(SQL sql) {
		this.sql = sql;
	}

	public SQL getSQL() {
		return this.sql;
	}

	public void setReturnCode(ReturnCode returnCode) {
		this.returnCode = returnCode;
	}

	public ReturnCode getReturnCode() {
		return this.returnCode;
	}
}