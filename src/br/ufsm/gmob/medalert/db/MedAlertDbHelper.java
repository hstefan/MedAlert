package br.ufsm.gmob.medalert.db;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import br.ufsm.gmob.medalert.db.entities.Alarm;
import br.ufsm.gmob.medalert.db.entities.AlarmNote;
import br.ufsm.gmob.medalert.db.entities.Medicine;
import br.ufsm.gmob.medalert.db.entities.PeriodicAlarm;
import br.ufsm.gmob.medalert.db.entities.StaticAlarm;
import br.ufsm.gmob.medalert.db.entities.User;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class MedAlertDbHelper extends OrmLiteSqliteOpenHelper {

	public static String DATABASE_NAME = "medalert.db";
	public static int DATABASE_VERSION = 1;
	
	private Dao<Alarm, Integer> alarmDao;
	private Dao<AlarmNote, Integer> alarmNoteDao;
	private Dao<Medicine, Integer> medicineDao;
	private Dao<PeriodicAlarm, Integer> periodicAlarmDao;
	private Dao<StaticAlarm, Integer> staticAlarmDao;
	private Dao<User, Integer> userDao;
	
	public MedAlertDbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
		Log.i(MedAlertDbHelper.class.getName(), "onCreate event");
		try {
			//creates tables for each entity
			TableUtils.createTable(connectionSource, User.class);
			TableUtils.createTable(connectionSource, Medicine.class);
			TableUtils.createTable(connectionSource, AlarmNote.class);
			TableUtils.createTable(connectionSource, Alarm.class);
			TableUtils.createTable(connectionSource, PeriodicAlarm.class);
			TableUtils.createTable(connectionSource, StaticAlarm.class);	
			//
		} catch (SQLException e) {
			Log.e(MedAlertDbHelper.class.getName(), "Unable to create database.");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, ConnectionSource connectionSource, int arg2,
			int arg3) {
		try {
			TableUtils.dropTable(connectionSource, User.class, true);
			TableUtils.dropTable(connectionSource, Medicine.class, true);
			TableUtils.dropTable(connectionSource, AlarmNote.class, true);
			TableUtils.dropTable(connectionSource, Alarm.class, true);
			TableUtils.dropTable(connectionSource, PeriodicAlarm.class, true);
			TableUtils.dropTable(connectionSource, StaticAlarm.class, true);
			onCreate(arg0, connectionSource);
		} catch (SQLException e) {
			Log.e(MedAlertDbHelper.class.getName(), "Unable to create database.");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public Dao<Alarm, Integer> getAlarmDao() throws SQLException{
		if(alarmDao == null) {
			alarmDao = getDao(Alarm.class);
		}
		return alarmDao;
	}
	
	public Dao<AlarmNote, Integer> getAlarmNoteDao() throws SQLException{
		if(alarmNoteDao == null) {
			alarmNoteDao = getDao(AlarmNote.class);
		}
		return alarmNoteDao;
	}
	
	public Dao<Medicine, Integer> getMedicineDao() throws SQLException {
		if(medicineDao == null) {
			medicineDao = getDao(Medicine.class);
		}
		return medicineDao;
	}
	
	public Dao<PeriodicAlarm, Integer> getPeriodicAlarmDao() throws SQLException{
		if(periodicAlarmDao == null) {
			periodicAlarmDao = getDao(PeriodicAlarm.class);
		}
		return periodicAlarmDao;
	}
	
	public Dao<StaticAlarm, Integer> getStaticAlarmDao() throws SQLException{
		if(staticAlarmDao == null) {
			staticAlarmDao = getDao(StaticAlarm.class);
		}
		return staticAlarmDao;
	}
	
	public Dao<User, Integer> getUserDao() throws SQLException{
		if(userDao == null) {
			userDao = getDao(User.class);
		}
		return userDao;
	}

}
