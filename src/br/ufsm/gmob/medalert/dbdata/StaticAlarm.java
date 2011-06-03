package br.ufsm.gmob.medalert.dbdata;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;

public class StaticAlarm {
	@DatabaseField(id = true)
	private int id;
	@DatabaseField
	private Date time;
	@DatabaseField
	private byte days;
	@DatabaseField(foreign = true)
	private Alarm id_alarm;
	
	public static final byte MONDAY = 1;
	public static final byte TUESDAY = 2;
	public static final byte WEDNESDAY = 4;
	public static final byte THURSDAY = 8;
	public static final byte FRIDAY = 16;
	public static final byte SATURDAY = 32;
	public static final byte SUNDAY = 64;
	
	public StaticAlarm(int id, Date time, byte days, Alarm id_alarm) {
		super();
		this.id = id;
		this.time = time;
		this.days = days;
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
	public int getDays() {
		return days;
	}
	public void setDays(byte days) {
		this.days = days;
	}
	public Alarm getId_alarm() {
		return id_alarm;
	}
	public void setId_alarm(Alarm id_alarm) {
		this.id_alarm = id_alarm;
	}
}
