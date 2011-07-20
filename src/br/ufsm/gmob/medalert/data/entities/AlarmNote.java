package br.ufsm.gmob.medalert.data.entities;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "AlarmNote")
public final class AlarmNote {
	@DatabaseField(generatedId = true)
	private int id;
	@DatabaseField
	private String note;
	
	public AlarmNote(String note) {
		super();
		this.note = note;
	}
	
	public AlarmNote() {

	}
	
	public int getId() {
		return id;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
}
