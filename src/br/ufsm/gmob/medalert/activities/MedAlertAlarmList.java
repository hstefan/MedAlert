package br.ufsm.gmob.medalert.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import br.ufsm.gmob.medalert.R;

public class MedAlertAlarmList extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.main);
		
		initStaticAlarmButton();
	}

	private void initStaticAlarmButton() {
		Button btn = (Button)findViewById(R.id.StaticAlarmButton);
		btn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent(MedAlertAlarmList.this, 
						CreateAlarmActivity.class);
				startActivity(i);
			}
		});
	}
}
