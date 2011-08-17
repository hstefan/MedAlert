package br.ufsm.gmob.medalert.security.auth;

public interface ValidationQuerier {
	public DigestedPassInfo queryForUser(String username);
}
