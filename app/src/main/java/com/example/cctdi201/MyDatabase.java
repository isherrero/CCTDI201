package com.example.cctdi201;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabase extends SQLiteOpenHelper {
    private static String DB_NAME="societes.db";
    private static String TB_NAME="societe";
    private static String COL1="id";
    private static String COL2="raison_sociale";
    private static String COL3="secteur_activite";
    private static String COL4="nb_employe";

    public MyDatabase(Context c){
        super(c,DB_NAME,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String req="CREATE TABLE "+TB_NAME+"("+COL1 +" integer primary key autoincrement,"+COL2 +" text,"+COL3+" text,"+COL4 +"integer)";
        sqLiteDatabase.execSQL(req);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
