/**
 * 
 */
package br.ufsm.gmob.medalert.auth;

import java.security.AuthProvider;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;


/**
 * @author hstefan
 *
 */
public class UserAuthentication extends AuthProvider {
	
	public UserAuthentication() {
		super("foo", 1.0, "lol");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void login(Subject arg0, CallbackHandler arg1) throws LoginException {
		// TODO Auto-generated method stub
	}

	@Override
	public void logout() throws LoginException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCallbackHandler(CallbackHandler arg0) {
		// TODO Auto-generated method stub
		
	}

}
