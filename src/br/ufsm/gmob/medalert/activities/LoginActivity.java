package br.ufsm.gmob.medalert.activities;

import java.sql.SQLException;

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

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedDelete;

public class LoginActivity extends OrmLiteBaseActivity<MedAlertDbHelper> {

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
			Dao<User, Integer> d = getHelper().getUserDao();
			int f = d.delete(d.deleteBuilder().prepare());
			System.out.println("Rows updated: " + f);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void insertTestOnlyData() {
		BasicPasswordDigester bpd = new BasicPasswordDigester();
		DigestedPassInfo dpi = bpd.digest("1234");
		
		User u = new User("Test", "testador", new String(dpi.getHash()), new String(dpi.getSalt()), dpi.getRounds());
		try {
			Dao<User, Integer> d = getHelper().getUserDao();
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
					authenticator = new UserAuthenticator(new SqliteValidationQuerier(getHelper().getUserDao()), new BasicPasswordDigester());
					if(authenticator.authenticate(login, pass)) {
						Toast.makeText(getApplicationContext(),"Valid credentials.", Toast.LENGTH_SHORT).show();
					} else {
						Toast.makeText(getApplicationContext(), "Invalid username/password.", Toast.LENGTH_SHORT).show();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
}
