package br.ufsm.gmob.medalert.dbdata;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;

public final class Alarm {
	@DatabaseField(generatedId = true)
	private int id;
	@DatabaseField
	private boolean is_active;
	@DatabaseField(foreign = true)
	private User id_user;
	@DatabaseField
	private Date created_on;
	@DatabaseField(foreign = true)
	private Medicine id_medicine;
	@DatabaseField
	private Date inits_on;
	@DatabaseField
	private int type;
	@DatabaseField(foreign = true)
	private AlarmNote id_alarmNote;
	
	public Alarm(int id, boolean is_active, User id_user, Date created_on,
			Medicine id_medicine, Date inits_on, int type,
			AlarmNote id_alarmNote) {
		super();
		this.id = id;
		this.is_active = is_active;
		this.id_user = id_user;
		this.created_on = created_on;
		this.id_medicine = id_medicine;
		this.inits_on = inits_on;
		this.type = type;
		this.id_alarmNote = id_alarmNote;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isIs_active() {
		return is_active;
	}
	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}
	public User getId_user() {
		return id_user;
	}
	public void setId_user(User id_user) {
		this.id_user = id_user;
	}
	public Date getCreated_on() {
		return created_on;
	}
	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}
	public Medicine getId_medicine() {
		return id_medicine;
	}
	public void setId_medicine(Medicine id_medicine) {
		this.id_medicine = id_medicine;
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
	public AlarmNote getId_alarmNote() {
		return id_alarmNote;
	}
	public void setId_alarmNote(AlarmNote id_alarmNote) {
		this.id_alarmNote = id_alarmNote;
	}
	
}
