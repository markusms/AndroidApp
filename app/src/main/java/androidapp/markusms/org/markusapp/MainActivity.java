package androidapp.markusms.org.markusapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("MainActivity", "onCreate()");
        super.onCreate(savedInstanceState);
        Log.d("MainActivity", "super.onCreate()");
        setContentView(R.layout.activity_main);
        Toast.makeText(this,R.string.activity,Toast.LENGTH_SHORT).show();

        Button button = (Button) findViewById(R.id.NewButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getBaseContext(), Activity2.class);
                Log.d("MainActivity", "startActivity()");
                startActivity(intent);
                Log.d("MainActivity", "finish()");
                finish();
            }
        });

        Button buttonAct3 = (Button) findViewById(R.id.NewButton3);
        buttonAct3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent();
                intent3.setClass(getBaseContext(), Activity3.class);
                EditText editText3 = (EditText) findViewById(R.id.EditText3);
                String text3 = editText3.getText().toString();
                if (!text3.equals("")){
                    intent3.putExtra("text3", text3);
                }
                EditText editText4 = (EditText) findViewById(R.id.EditText4);
                String text4 = editText4.getText().toString();
                intent3.putExtra("text4", text4);
                startActivity(intent3);
                Log.d("MainActivity", "startActivity()");
            }
        });

        Button buttonEx3 = (Button) findViewById(R.id.ex3Button);
        buttonEx3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getBaseContext(), Activityex3.class);
                startActivity(intent);
                Log.d("MainActivity", "startActivity()");
            }
        });

        Button buttonList = (Button)findViewById(R.id.ButtonList);
        buttonList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getBaseContext(), List.class);
                startActivity(intent);
                Log.d("MainActivity", "startActivity()");
            }
        });

        Button buttonEx10 = (Button) findViewById(R.id.ex10Button);
        buttonEx10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getBaseContext(), Activityex10.class);
                startActivity(intent);
                Log.d("MainActivity", "startActivity()");
            }
        });

        Button sqlButton = (Button) findViewById(R.id.sqlActButton);
        sqlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getBaseContext(), ActivitySql.class);
                startActivity(intent);
                Log.d("MainActivity", "startActivity()");
            }
        });
    }
    public void onBackPressed() {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        Log.d("MainActivity", "finish()");
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
                Toast.makeText(this,R.string.boop,Toast.LENGTH_SHORT).show();
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
        Log.d("MainActivity", "onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("MainActivity", "onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("MainActivity", "onStop()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "onDestroy()");
    }

}

