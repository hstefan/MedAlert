/**
 * 
 */
package br.ufsm.gmob.medalert.security.auth;


/**
 * @author hstefan
 *
 */
public interface UserAuthenticator {
	public boolean authenticate(String username, String password);
}
