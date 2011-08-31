package br.ufsm.gmob.medalert.activities;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;

import br.ufsm.gmob.medalert.db.MedAlertDbHelper;
import android.os.Bundle;

public class MedAlert extends OrmLiteBaseActivity<MedAlertDbHelper> {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
}
