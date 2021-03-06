package com.example.hobbitus.passwordskeeper10;

/**
 * Created by Hobbitus on 01-Jun-16.
 */

        import android.content.Context;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteException;
        import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "passwords.db";
    public static final String TABLE_PASSWORDS = "passwords";

    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_ADDRESS = "address";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_COMMENTS = "comments";
    public static final String KEY_STATUS = "status";

    /**
     * Check if the database exist and can be read.
     *
     * @return true if it exists and can be read, false if it doesn't
     */
    private boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        try {
            checkDB = SQLiteDatabase.openDatabase(DATABASE_NAME, null,
                    SQLiteDatabase.OPEN_READONLY);
            checkDB.close();
        } catch (SQLiteException e) {
            // database doesn't exist yet.
        }
        return checkDB != null;
    }

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    if (!checkDataBase()){
        db.execSQL("create table " + TABLE_PASSWORDS + "(" + KEY_ID + " integer," + KEY_NAME + " text primary key," + KEY_ADDRESS + " text," + KEY_USERNAME + " text," + KEY_PASSWORD + " text," + KEY_COMMENTS + " text," + KEY_STATUS + " text)");}
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_PASSWORDS);
        onCreate(db);
    }
}
