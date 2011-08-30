package br.ufsm.gmob.medalert.activities;

import java.sql.SQLException;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import br.ufsm.gmob.medalert.R;
import br.ufsm.gmob.medalert.db.MedAlertDbHelper;
import br.ufsm.gmob.medalert.db.entities.User;
import br.ufsm.gmob.medalert.security.auth.BasicPasswordDigester;
import br.ufsm.gmob.medalert.security.auth.DigestedPassInfo;
import br.ufsm.gmob.medalert.security.auth.SqliteValidationQuerier;
import br.ufsm.gmob.medalert.security.auth.UserAuthenticator;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;

public class LoginActivity extends Activity{
	static User active_user = null;
	MedAlertDbHelper helper = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		Button login_button = (Button) findViewById(R.id.login_button_id);
		setupButton(login_button);
		
		ereaseTestOnlyData();
		insertTestOnlyData();
	}

	private void ereaseTestOnlyData() {
		try {
			Dao<User, Integer> d = null;
			d.delete(d.deleteBuilder().prepare());	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void insertTestOnlyData() {
		BasicPasswordDigester bpd = new BasicPasswordDigester();
		DigestedPassInfo dpi = bpd.digest("1234");
		
		User u = new User("Test", "test", dpi.getHash(), dpi.getSalt(), dpi.getRounds());
		try {
			Dao<User, Integer> d = getHelper().getDao(User.class);
			d.create(u);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void setupButton(Button login_button) {
		login_button.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				EditText login_et = (EditText) findViewById(R.id.login_edittext);
				EditText pass_et = (EditText)findViewById(R.id.pass_edittext);
				
				String login = login_et.getText().toString();
				String pass = pass_et.getText().toString();
				
				UserAuthenticator authenticator;
				try {
					authenticator = new UserAuthenticator(new SqliteValidationQuerier(getHelper().getDao(User.class)), new BasicPasswordDigester());
					if(authenticator.authenticate(login, pass)) {
						Toast.makeText(getApplicationContext(),"Valid credentials.", Toast.LENGTH_SHORT).show();
					} else {
						login_et.setText("");
						pass_et.setText("");
						active_user = getHelper().getDao(User.class).queryForEq("login", login).get(0);
						OpenHelperManager.releaseHelper();
						Toast.makeText(getApplicationContext(), "Invalid username/password.", Toast.LENGTH_LONG).show();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	public static User getActive() {
		return active_user;
	}
	
	public OrmLiteSqliteOpenHelper getHelper() {
		return OpenHelperManager.getHelper(getApplicationContext());
	}
}
