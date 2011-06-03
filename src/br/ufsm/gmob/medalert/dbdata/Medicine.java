package br.ufsm.gmob.medalert.dbdata;

import com.j256.ormlite.field.DatabaseField;

public final class Medicine {
	@DatabaseField(generatedId = true)
	private int id;
	@DatabaseField(canBeNull = false, unique = true)
	private String name;
	
	public Medicine(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
