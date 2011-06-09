package br.ufsm.gmob.medalert.dbdata.entities;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Medicine")
public final class Medicine {
	@DatabaseField(generatedId = true)
	private int id;
	@DatabaseField(canBeNull = false, unique = true)
	private String name;
	
	public Medicine(String name) {
		super();
		this.name = name;
	}
	
	public Medicine() {
		
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
