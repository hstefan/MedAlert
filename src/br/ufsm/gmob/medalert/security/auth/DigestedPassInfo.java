package br.ufsm.gmob.medalert.security.auth;

public class DigestedPassInfo {
	private byte[] hash;
	private byte[] salt;
	private int rounds;
		
	public DigestedPassInfo(byte[] hash, byte[] salt, int rounds) {
		super();
		this.hash = hash;
		this.salt = salt;
		this.rounds = rounds;
	}

	public byte[] getHash() {
		return hash;
	}

	public void setHash(byte[] hash) {
		this.hash = hash;
	}

	public byte[] getSalt() {
		return salt;
	}

	public void setSalt(byte[] salt) {
		this.salt = salt;
	}

	public int getRounds() {
		return rounds;
	}

	public void setRounds(int rounds) {
		this.rounds = rounds;
	}
}
