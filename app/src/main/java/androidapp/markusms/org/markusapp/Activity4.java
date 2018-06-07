package androidapp.markusms.org.markusapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Activity4 extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d("Activity4", "onCreate()");
        super.onCreate(savedInstanceState);
        Log.d("Activity4", "super.onCreate()");
        setContentView(R.layout.layout4);
        Toast.makeText(this,R.string.activity,Toast.LENGTH_SHORT).show();

        TextView text = (TextView) findViewById(R.id.textView4);
        Intent intent = getIntent();
        if (intent.hasExtra("text4")) {
            text.setText(intent.getStringExtra(("text4")));
        }

    }
    public void onBackPressed() {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        Log.d("Activity4", "finish()");
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int option = item.getItemId();
        switch (option)
        {
            case R.id.optionMain:
                onBackPressed();
                break;
            case R.id.option1:
                Toast.makeText(this,R.string.toastShort,Toast.LENGTH_SHORT).show();
                break;
            case R.id.option2:
                Toast.makeText(this,R.string.toastLong,Toast.LENGTH_LONG).show();
                break;
        }
        return false;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("Activity4", "onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("Activity4", "onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("Activity4", "onStop()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Activity4", "onDestroy()");
    }
}
