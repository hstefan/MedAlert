package br.ufsm.gmob.medalert.dbdata.entities;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Alarm")
public final class Alarm {
	@DatabaseField(generatedId = true)
	private int id;
	@DatabaseField
	private boolean is_active;
	@DatabaseField(foreign = true, columnName = "id_user")
	private User user;
	@DatabaseField
	private Date created_on;
	@DatabaseField(foreign = true, columnName = "id_medicine")
	private Medicine medicine;
	@DatabaseField
	private Date inits_on;
	@DatabaseField
	private int type;
	@DatabaseField
	private byte days;
	@DatabaseField(foreign = true, columnName = "id_alarmNote")
	private AlarmNote note;
	
	/**
	 * Macros to work with the days field.
	 * Example: if you want you want to set an Alarm that rings on tuesday, friday and sunday,
	 * 		days = TUESDAY | FRIDAY | SUNDAY
	 */
	public static final byte MONDAY = 1;
	public static final byte TUESDAY = 2;
	public static final byte WEDNESDAY = 4;
	public static final byte THURSDAY = 8;
	public static final byte FRIDAY = 16;
	public static final byte SATURDAY = 32;
	public static final byte SUNDAY = 64;
	
	public Alarm(boolean is_active, User id_user, Date created_on,
			Medicine id_medicine, Date inits_on, int type, byte days,
			AlarmNote id_alarmNote) {
		super();
		this.is_active = is_active;
		this.user = id_user;
		this.created_on = created_on;
		this.medicine = id_medicine;
		this.inits_on = inits_on;
		this.type = type;
		this.days = days;
		this.note = id_alarmNote;
	}
	
	public Alarm() {
		
	}
	
	public int getId() {
		return id;
	}
	
	public boolean isIs_active() {
		return is_active;
	}
	
	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}
	
	public User getId_user() {
		return user;
	}
	
	public void setId_user(User id_user) {
		this.user = id_user;
	}
	
	public Date getCreated_on() {
		return created_on;
	}
	
	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}
	
	public Medicine getId_medicine() {
		return medicine;
	}
	
	public void setId_medicine(Medicine id_medicine) {
		this.medicine = id_medicine;
	}
	
	public Date getInits_on() {
		return inits_on;
	}
	
	public void setInits_on(Date inits_on) {
		this.inits_on = inits_on;
	}
	
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public byte getDays() {
		return days;
	}
	
	public void setDays(byte days) {
		this.days = days;
	}
	
	public AlarmNote getNote() {
		return note;
	}
	
	public void setNote(AlarmNote note) {
		this.note = note;
	}
}
