package androidapp.markusms.org.markusapp;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivitySql extends Activity{

    private UserSQLiteHelper usdbh;
    private SQLiteDatabase db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d("Sql", "onCreate()");
        super.onCreate(savedInstanceState);
        Log.d("Sql", "super.onCreate()");
        setContentView(R.layout.sql);
        Toast.makeText(this,R.string.activity,Toast.LENGTH_SHORT).show();

        usdbh = new UserSQLiteHelper(this);

        TextView text = (TextView) findViewById(R.id.textViewSql);

        Button button1 = (Button) findViewById(R.id.SqlButton);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = usdbh.getWritableDatabase();
                if (db != null)
                {
                    usdbh.insertUser(db, 3, "Markus");
                    db.close();
                }
            }
        });

        Button buttonDelete = (Button) findViewById(R.id.SqlButtonDelete);
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.EditTextId);
                String id = editText.getText().toString();
                deleteUser(db,Integer.parseInt(id));
            }
        });

        Button buttonUpdate = (Button) findViewById(R.id.SqlButtonUpdate);
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.EditTextId);
                String id = editText.getText().toString();
                EditText editText2 = (EditText) findViewById(R.id.EditTextValue);
                String value = editText2.getText().toString();
                updateUser(db,Integer.parseInt(id),value);
            }
        });

        Button buttonQuery = (Button) findViewById(R.id.SqlButtonQuery);
        buttonQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = usdbh.getReadableDatabase();
                EditText editText2 = (EditText) findViewById(R.id.EditTextValue);
                String value = editText2.getText().toString();
                Cursor c = usdbh.getUser(db,value);
                if (c.moveToFirst()) {
                    do {
                        String code= c.getString(0);
                        String name = c.getString(1);
                        Log.d("ActivitySql", code + name);
                    } while(c.moveToNext());
                }
                db.close();
            }
        });
    }

    public void deleteUser(SQLiteDatabase db, int id){
        db = usdbh.getWritableDatabase();
        if (db != null) {
            String[] args = new String[]{Integer.toString(id)};
            db.delete("user", "id=?", args);
        }
        db.close();
    }

    public void updateUser(SQLiteDatabase db, int id, String newName){
        db = usdbh.getWritableDatabase();
        if (db != null) {
            ContentValues values = new ContentValues();
            values.put("name",newName);
            String[] args = new String[] {Integer.toString(id)};
            db.update("user", values, "id=?", args);
        }
        db.close();
    }

}
