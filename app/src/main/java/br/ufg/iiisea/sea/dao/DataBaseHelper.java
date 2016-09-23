package br.ufg.iiisea.sea.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import br.ufg.iiisea.sea.bean.Noticia;

/**
 * Created by fellipe on 22/09/16.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String BD_NOME = "SEA3UFG.DB";
    public static final int    BD_VERSION = 1;

    private static DataBaseHelper instance;

    private DataBaseHelper(Context context) {
        super(context, BD_NOME, null, BD_VERSION);
    }

    public static DataBaseHelper getInstance(Context context) {
        if(instance == null)
            return new DataBaseHelper(context);
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DBContract.UsuarioEntry.SQL_CREATE_ENTRIES);
        db.execSQL(DBContract.EventoEntry.SQL_CREATE_ENTRIES);
        db.execSQL(DBContract.NoticiaEntry.SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(DBContract.UsuarioEntry.SQL_DELETE_ENTRIES);
        db.execSQL(DBContract.EventoEntry.SQL_DELETE_ENTRIES);
        db.execSQL(DBContract.NoticiaEntry.SQL_DELETE_ENTRIES);
        onCreate(db);
    }

}
