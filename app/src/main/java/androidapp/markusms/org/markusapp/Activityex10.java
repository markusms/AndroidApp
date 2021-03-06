package androidapp.markusms.org.markusapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class Activityex10 extends Activity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d("Activityex10", "onCreate()");
        super.onCreate(savedInstanceState);
        Log.d("Activityex10", "super.onCreate()");
        setContentView(R.layout.layoutex10);
        Toast.makeText(this, R.string.activity, Toast.LENGTH_SHORT).show();
    }

    public void onBackPressed() {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        Log.d("Activityex10", "finish()");
                        finish();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        break;
                }
            }
        };
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.back)).setPositiveButton(getResources().getString(R.string.yes), dialogClickListener)
                .setNegativeButton(getResources().getString(R.string.no), dialogClickListener).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("Activityex10", "onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("Activityex10", "onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("Activityex10", "onStop()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Activityex10", "onDestroy()");
    }
}
