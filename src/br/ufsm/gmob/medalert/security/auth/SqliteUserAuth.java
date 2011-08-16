package br.ufsm.gmob.medalert.security.auth;

import br.ufsm.gmob.medalert.db.entities.User;

import com.j256.ormlite.dao.Dao;

public class SqliteUserAuth implements UserAuthenticator {
	private Dao<User, Integer> user_dao;
	
	public SqliteUserAuth(Dao<User, Integer> user_dao) {
		this.user_dao = user_dao;
	}
	
	public boolean authenticate(String username, String password) {
		return false;
	}

}
