package br.ufsm.gmob.medalert.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import br.ufsm.gmob.medalert.R;

public class MedAlertAlarmList extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.main);
		
		initTypeSpinner();
	}

	private void initTypeSpinner() {
		Spinner spinner = (Spinner)findViewById(R.id.alarmTypeSP);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, 
				R.array.SpinnerAlarmTypes, android.R.layout.simple_spinner_dropdown_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
	}
}
