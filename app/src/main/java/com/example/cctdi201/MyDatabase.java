package com.example.cctdi201;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

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
    public static long AddSociete(SQLiteDatabase db, Societe e){
        ContentValues c = new ContentValues();
        c.put(COL2,e.getNom());
        c.put(COL3,e.getSecteuractivite());
        c.put(COL4,e.getNombreemploye());
        return db.insert(TB_NAME,null,c);
    }
    public static long UpdateSociete(SQLiteDatabase db, Societe e){
        ContentValues c = new ContentValues();
        c.put(COL2,e.getNom());
        c.put(COL3,e.getSecteuractivite());
        c.put(COL4,e.getNombreemploye());
        return db.update(TB_NAME,c,"id="+e.getId(),null);
    }
    public static long DeleteSociete(SQLiteDatabase db, int id){
        return db.delete(TB_NAME,"id="+id,null);
    }
    public static ArrayList<Societe> getAllSociete(SQLiteDatabase db){
        ArrayList<Societe> soci = new ArrayList<>();

        Cursor cur = db.rawQuery("SELECT * FROM " + TB_NAME,null);

        while(cur.moveToNext()){
            Societe e= new Societe();
            e.setId(cur.getInt(0));
            e.setNom(cur.getString(1));
            e.setSecteuractivite(cur.getString(2));
            e.setNombreemploye(cur.getInt(3));
            soci.add(e);
        }

        return soci;
    }
    public static Societe getOneSociete(SQLiteDatabase db, int id){
        Societe s = null;

        Cursor cur = db.rawQuery("SELECT * FROM " + TB_NAME + " WHERE id = " + id,null);

        if(cur.moveToNext()){
            s = new Societe();
            s.setId(cur.getInt(0));
            s.setNom(cur.getString(1));
            s.setSecteuractivite(cur.getString(2));
            s.setNombreemploye(cur.getInt(3));
        }

        return s;
    }

}
