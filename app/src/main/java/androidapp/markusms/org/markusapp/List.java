package androidapp.markusms.org.markusapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class List extends Activity {
    ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d("List", "onCreate()");
        super.onCreate(savedInstanceState);
        Log.d("List", "super.onCreate()");
        setContentView(R.layout.list);
        Toast.makeText(this,R.string.activity,Toast.LENGTH_SHORT).show();

        listView = (ListView) findViewById(android.R.id.list);
        String[] values = new String[]{"Option 1", "Option 2", "Option 3", "Option 4", "Option 5", "Option 6", "Option 7", "Option 8",
                "Option 9", "Option 10", "Option 11", "Option 12", "Option 13", "Option 14"};
        String[] valuesEmpty = new String[]{};

        listView.setEmptyView(findViewById(android.R.id.empty));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.rowlayout, R.id.label, values);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition = position;
                String itemValue = (String) listView.getItemAtPosition(position);
                System.out.println("Position " + itemPosition + " - ListItem: " + itemValue);
            }
        });
    }

    public void onBackPressed() {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        Log.d("List", "finish()");
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
        Log.d("List", "onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("List", "onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("List", "onStop()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("List", "onDestroy()");
    }
}