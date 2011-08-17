package br.ufsm.gmob.medalert.security.auth;

public interface PasswordDigester {
	public DigestedPassInfo digest(String password, byte[] salt, int rounds);
	public DigestedPassInfo digest(String password);
}