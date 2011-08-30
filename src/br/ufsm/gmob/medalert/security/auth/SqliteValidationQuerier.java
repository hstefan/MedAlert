package br.ufsm.gmob.medalert.security.auth;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import android.util.Log;
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
			int sz = f.size();
			if(sz == 1) {
				User u = f.get(0); //TODO: exception when more than one user is found with the same login.
				if(u != null) {
					return new DigestedPassInfo(u.getPassword(), u.getSalt(), 
							u.getHashRounds());
				}
			} else {
				Log.d("Auth failure", "Results differ from expectations " + sz);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
