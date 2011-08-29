/**
 * 
 */
package br.ufsm.gmob.medalert.security.auth;

import java.util.Arrays;

import android.util.Log;


/**
 * @author hstefan
 *
 */
public class UserAuthenticator {
	private ValidationQuerier querier;
	private PasswordDigester digester;
		
	public UserAuthenticator(ValidationQuerier querier,
			PasswordDigester digester) {
		super();
		this.querier = querier;
		this.digester = digester;
	}

	public boolean authenticate(String username, String password){
		DigestedPassInfo userinfo = querier.queryForUser(username);
		
		if(userinfo != null) {
			DigestedPassInfo digest_pass = digester.digest(password, userinfo.getSalt(), userinfo.getRounds());
			
			if(Arrays.equals(digest_pass.getHash(), userinfo.getHash())) {
				return true;
			} else {
				System.err.println(new String(digest_pass.getHash()));
				System.err.println(new String(userinfo.getHash()));
			}
		}
		
		return false;
	}
}
