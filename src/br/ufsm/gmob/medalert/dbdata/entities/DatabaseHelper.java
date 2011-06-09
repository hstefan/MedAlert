package br.ufsm.gmob.medalert.dbdata.entities;

import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
	private static final String DB_NAME = "medaler.db";
	private static final int DB_VERSION = 1;
	private Dao<Alarm, Integer> alarmDao;
	private Dao<AlarmNote, Integer> alarmNoteDao;
	private Dao<Medicine, Integer> medicineDao;
	private Dao<PeriodicAlarm, Integer> periodicAlarmDao;
	private Dao<StaticAlarm, Integer> staticAlarmDao;
	private Dao<User, Integer> userDao;

	public DatabaseHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase arg0, ConnectionSource connectionSource) {
		Log.i(DatabaseHelper.class.getName(), "onCreate");
		try {
			//creates tables for each entity
//			TableUtils.createTable(connectionSource, Alarm.class);
//			TableUtils.createTable(connectionSource, AlarmNote.class);
//			TableUtils.createTable(connectionSource, Medicine.class);
//			TableUtils.createTable(connectionSource, PeriodicAlarm.class);
//			TableUtils.createTable(connectionSource, StaticAlarm.class);
			TableUtils.createTable(connectionSource, User.class);
			//
			
		} catch (SQLException e) {
			Log.e(DatabaseHelper.class.getName(), "Unable to create database.");
			e.printStackTrace();
			//throw new RuntimeException(e);
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, ConnectionSource arg1, int arg2,
			int arg3) {
		// TODO drop tables and recreate them
		
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
