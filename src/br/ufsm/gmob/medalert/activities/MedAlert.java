package br.ufsm.gmob.medalert.activities;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;

import br.ufsm.gmob.medalert.db.MedAlertDbHelper;
import br.ufsm.gmob.medalert.db.entities.User;
import android.content.Intent;
import android.os.Bundle;

public class MedAlert extends OrmLiteBaseActivity<MedAlertDbHelper> {
	User active_user = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		if(active_user != null) {
			Intent i = new Intent(this.getApplicationContext(), LoginActivity.class);
			startActivityForResult(i, 0);
		} else {
			
		}
		
	}
}
