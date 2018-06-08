package androidapp.markusms.org.markusapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class UserSQLiteHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Users.db";
    public static final int DATABASE_VERSION = 1;
    private String createSQL = "CREATE TABLE user (id INTEGER, name TEXT)";
    private String dropSQL = "DROP TABLE IF EXISTS user";

    public UserSQLiteHelper(Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createSQL);
        insertDefaultData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(dropSQL);
        onCreate(db);
    }

    public void insertDefaultData(SQLiteDatabase db) {
        //We will insert 5 new rows
        for(int i=1; i<=5; i++)
        {
            //Insert the record in the database
            insertUser(db, i, "User" + i);
        }
    }

    public void insertUser(SQLiteDatabase db, int id, String name) {
        ContentValues newRecord = new ContentValues();
        newRecord.put("id", id);
        newRecord.put("name", name);
        db.insert("user", null, newRecord);
    }

    public Cursor getUser(SQLiteDatabase db, String name){
        String[] fields = new String[] {"id", "name"};
        String[] args = new String[] {name};
        Cursor c = db.query("user", fields, "name=?",
                args, null, null, null);
        return c;
    }

}
