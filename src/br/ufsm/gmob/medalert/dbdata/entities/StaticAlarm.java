package br.ufsm.gmob.medalert.dbdata.entities;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "StaticAlarm")
public class StaticAlarm {
	@DatabaseField(id = true)
	private int id;
	@DatabaseField
	private Date time;

	@DatabaseField(foreign = true)
	private Alarm id_alarm;
	
	public StaticAlarm() {
		
	}
	
	public StaticAlarm(int id, Date time, Alarm id_alarm) {
		super();
		this.id = id;
		this.time = time;
		this.id_alarm = id_alarm;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Alarm getId_alarm() {
		return id_alarm;
	}
	public void setId_alarm(Alarm id_alarm) {
		this.id_alarm = id_alarm;
	}
}
