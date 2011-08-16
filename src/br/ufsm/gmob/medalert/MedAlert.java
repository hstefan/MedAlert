package br.ufsm.gmob.medalert;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import br.ufsm.gmob.medalert.db.MedAlertDbHelper;
import br.ufsm.gmob.medalert.db.entities.AlarmNote;
import br.ufsm.gmob.medalert.db.entities.User;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.Dao;

public class MedAlert extends OrmLiteBaseActivity<MedAlertDbHelper> {
    /** Called when the activity is first created. */
	public MedAlert() {
		File f = new File("medalert.db");
		if(f.exists()) {
			f.delete();
			Log.i(f.getName(), "Erasing DBfile");
		} 
	}
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	
    	User u = new User("Hugo Puhlmann", "23423423", "123");
    	User v = new User("Hugo Puhlmann", "foofofofo", "123");
    	MedAlertDbHelper helper = getHelper();

    	try {
			Dao<User, Integer> userDao = helper.getUserDao();
			Dao<AlarmNote, Integer> noteDao = helper.getAlarmNoteDao();
			AlarmNote note = new AlarmNote("Foo");
			noteDao.create(note);
			userDao.delete(userDao.queryForAll());
			userDao.create(u);
			userDao.create(v);
			List<User> users = userDao.queryForAll();
			StringBuilder sb = new StringBuilder();
			for(User us : users) {
				sb.append(us.getLogin());
				sb.append("\n");
			}
			AlertDialog al = new AlertDialog.Builder(this).setMessage(sb.toString()).setTitle("Usuarios encontrados").create();
			al.show();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        setContentView(R.layout.main);
    }
}