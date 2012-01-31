package br.ufsm.gmob.medalert.activities;

import br.ufsm.gmob.medalert.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class CreateAlarmActivity extends Activity {
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_alarm);
		
		initSpinner();
	}

	private void initSpinner() {
		Spinner s = (Spinner)findViewById(R.id.alarmTypeSP);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, 
				R.array.SpinnerAlarmTypes, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
		s.setAdapter(adapter);
	}
}
