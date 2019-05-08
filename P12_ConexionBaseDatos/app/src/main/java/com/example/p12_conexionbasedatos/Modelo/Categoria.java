package com.example.p12_conexionbasedatos.Modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.p12_conexionbasedatos.BaseDatos.BaseDatos;
import com.example.p12_conexionbasedatos.config.Config_DB;

import java.util.ArrayList;

public class Categoria {

    private int ID;
    private String categoria;
    private BaseDatos admin;
    private SQLiteDatabase base_datos;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    private void inicializarDB(Context context){
        admin=new BaseDatos(
                context,
                Config_DB.NAME_DB,
                null,
                Config_DB.VERSION_DB
        );
        base_datos=admin.getWritableDatabase();
    }

    public boolean save(Context context){
        this.inicializarDB(context);
        ContentValues valoresObjetos=new ContentValues();
        if(this.ID==0){
            valoresObjetos.put("categoria",this.categoria);
            base_datos.insert("Categoria",null,valoresObjetos);
            base_datos.close();
            return true;
        }else{
            valoresObjetos.put("categoria",this.categoria);
            int actualizado=base_datos.update("Categoria",valoresObjetos,"ID="+this.ID,null);
            base_datos.close();
            if(actualizado==1)
                return true;
        }
        return true;
    }

    public void get(Context context,int ID){
        this.inicializarDB(context);
        String query="select * from categoria where ID="+ID;
        Cursor registro=base_datos.rawQuery(query,null);
        if(registro.moveToFirst()){
            this.ID=registro.getInt(0);
            this.categoria=registro.getString(1);
        }
        base_datos.close();
    }

    public void delete(Context context){
        this.inicializarDB(context);
        int eliminado=base_datos.delete("Categoria","ID="+ID, null);
        base_datos.close();
        if(eliminado==1){
            this.ID=0;
            this.categoria="";
        }
    }
}
