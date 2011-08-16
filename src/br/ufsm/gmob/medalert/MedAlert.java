package br.ufsm.gmob.medalert;

import java.io.File;

import android.os.Bundle;
import android.util.Log;
import br.ufsm.gmob.medalert.db.MedAlertDbHelper;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;

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
        setContentView(R.layout.main);
    }
}