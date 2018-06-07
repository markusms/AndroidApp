package androidapp.markusms.org.markusapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Activity3 extends Activity{

    private String editText4 = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d("Activity3", "onCreate()");
        super.onCreate(savedInstanceState);
        Log.d("Activity3", "super.onCreate()");
        setContentView(R.layout.layout3);
        Toast.makeText(this,R.string.activity,Toast.LENGTH_SHORT).show();

        TextView text = (TextView) findViewById(R.id.textView3);
        Intent intent = getIntent();
        if (intent.hasExtra("text3")) {
            text.setText(intent.getStringExtra(("text3")));
        }
        if (intent.hasExtra("text4")) {
            this.editText4 = intent.getStringExtra(("text4"));
        }

        Button buttonAct4 = (Button) findViewById(R.id.NewButton4);
        buttonAct4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getBaseContext(), Activity4.class);
                if (!editText4.equals("")) {
                    intent.putExtra("text4", editText4);
                }
                startActivity(intent);
                Log.d("Activity3", "startActivity()");
                Log.d("Activity3", "finish()");
                finish();
            }
        });
    }

    public void onBackPressed() {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        Log.d("Activity3", "finish()");
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
        Log.d("Activity3", "onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("Activity3", "onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("Activity3", "onStop()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Activity3", "onDestroy()");
    }
}
