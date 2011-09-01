package br.ufsm.gmob.medalert.activities;

import br.ufsm.gmob.medalert.R;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MedAlertAlarmList extends ListActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String[] sample = {"Xanax", "Diazepan", "Valium", "Prozac"};
		this.setListAdapter(new ArrayAdapter<String>(this, R.layout.alarm_list_item, R.id.medicine, sample));
	}
}
