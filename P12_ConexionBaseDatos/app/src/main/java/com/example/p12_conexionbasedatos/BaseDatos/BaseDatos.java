package com.example.p12_conexionbasedatos.BaseDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.p12_conexionbasedatos.config.Config_DB;

public class BaseDatos extends SQLiteOpenHelper {

    public BaseDatos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        for(String query: Config_DB.SCRIPT_DB){
            db.execSQL(query);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
