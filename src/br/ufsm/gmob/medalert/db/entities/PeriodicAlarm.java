package br.ufsm.gmob.medalert.db.entities;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "PeriodicAlarm")
public class PeriodicAlarm {
	@DatabaseField(generatedId = true)
	private int id;
	@DatabaseField
	private Date alert_interval;
	@DatabaseField(columnName = "id_alarm", foreign = true)
	Alarm id_alarm;
	
	private Alarm alarm;
	
	public PeriodicAlarm(Date alert_interval, Alarm alarm) {
		super();
		this.alert_interval = alert_interval;
		id_alarm = alarm;
	}
	
	public PeriodicAlarm() {
		
	}
	
	public Date getAlert_interval() {
		return alert_interval;
	}

	public void setAlert_interval(Date alert_interval) {
		this.alert_interval = alert_interval;
	}

	public Alarm getAlarm() {
		return alarm;
	}

	public void setAlarm(Alarm alarm) {
		this.alarm = alarm;
	}

	public int getId() {
		return id;
	}
}
