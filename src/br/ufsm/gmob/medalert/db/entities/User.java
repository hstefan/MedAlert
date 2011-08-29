package br.ufsm.gmob.medalert.db.entities;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import android.util.Base64;

@DatabaseTable(tableName = "User")
public final class User {
	@DatabaseField(generatedId = true)
	private int id;
	
	@DatabaseField(canBeNull = false)
	private String name;
	
	@DatabaseField(canBeNull = false, index = true)
	private String login;
	
	@DatabaseField(canBeNull = false)
	private String password;
	
	@DatabaseField(canBeNull = false)
	private String salt;
	
	@DatabaseField(canBeNull = false)
	private int hash_rounds;
	
	public User(String name, String login, byte[] password_hash, byte[] salt, int hash_rounds) {
		super();
		this.name = name;
		this.login = login;
		this.password = Base64.encodeToString(password_hash, Base64.DEFAULT);
		this.salt = Base64.encodeToString(salt, Base64.DEFAULT);
		this.hash_rounds = hash_rounds;
	}
	
	public User() {
		
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(byte[] password_hash) {
		this.password = Base64.encodeToString(password_hash, Base64.DEFAULT);
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public int getHashRounds() {
		return hash_rounds;
	}

	public void setHashRounds(int hash_rounds) {
		this.hash_rounds = hash_rounds;
	}	
}
