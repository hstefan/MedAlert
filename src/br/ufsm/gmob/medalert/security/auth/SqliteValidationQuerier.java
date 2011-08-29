package br.ufsm.gmob.medalert.security.auth;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import br.ufsm.gmob.medalert.db.entities.User;

import com.j256.ormlite.dao.Dao;

public class SqliteValidationQuerier implements ValidationQuerier{

	private Dao<User, Integer> user_dao;
	
	public SqliteValidationQuerier(Dao<User, Integer> user_dao) {
		super();
		this.user_dao = user_dao;
	}

	public DigestedPassInfo queryForUser(String username) {
		try {
			List<User> f = user_dao.queryForEq("login", username);
			if(f.size() > 0) {
				User u = f.get(0); //TODO: exception when more than one user are found with the same login.
				if(u != null) {
					return new DigestedPassInfo(u.getPassword().getBytes(), 
							u.getSalt().getBytes(), u.getHashRounds());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
