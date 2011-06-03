package br.ufsm.gmob.medalert.dbdata;

import com.j256.ormlite.field.DatabaseField;

public final class AlarmNote {
	@DatabaseField(generatedId = true)
	private int id;
	@DatabaseField
	private String note;
	
	public AlarmNote(int id, String note) {
		super();
		this.id = id;
		this.note = note;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
}
