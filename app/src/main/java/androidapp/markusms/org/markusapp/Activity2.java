package androidapp.markusms.org.markusapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;
import android.graphics.Color;

public class Activity2 extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d("Activity2", "onCreate()");
        super.onCreate(savedInstanceState);
        Log.d("Activity2", "super.onCreate()");
        setContentView(R.layout.layout2);
        //Toast.makeText(this,R.string.activity,Toast.LENGTH_SHORT).show();
        Toast toast = Toast.makeText(this,R.string.activity,Toast.LENGTH_SHORT);
        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
        v.setTextColor(Color.RED);
        v.setBackgroundColor(Color.GREEN);
        toast.show();
    }

    public void onBackPressed() {
        Log.d("Activity2", "onBackPressed()");
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        Log.d("Activity2", "finish()");
                        finish();
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.quit)).setPositiveButton(getResources().getString(R.string.yes), dialogClickListener)
                .setNegativeButton(getResources().getString(R.string.no), dialogClickListener).show();

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("Activity2", "onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("Activity2", "onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("Activity2", "onStop()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Activity2", "onDestroy()");
    }
}
