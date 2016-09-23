package br.ufg.iiisea.sea.dao;

import android.content.ContentValues;
import android.content.Context;
import br.ufg.iiisea.sea.bean.Evento;
import br.ufg.iiisea.sea.bean.Noticia;

/**
 * Created by fellipe on 23/09/16.
 */
public class NoticiaDAO extends AbstractDAO<Noticia> {

    public NoticiaDAO(Context context) {
        super(context);
    }

    @Override
    public String getTableName() {
        return DBContract.NoticiaEntry.TABLE_NAME;
    }

    @Override
    public String getKeyPrimaryColumnName() {
        return DBContract.NoticiaEntry.COLUMN_ID;
    }

    @Override
    public String getSQLCreateEntries() {
        return DBContract.NoticiaEntry.SQL_CREATE_ENTRIES;
    }

    @Override
    public String getSQLDeleteEntries() {
        return DBContract.NoticiaEntry.SQL_DELETE_ENTRIES;
    }

    @Override
    public Noticia toEntity(ContentValues contentValues) {
        Noticia entity = new Noticia();
        entity.setId(contentValues.getAsInteger(DBContract.NoticiaEntry.COLUMN_ID));
        //entity.setData(contentValues.getAsString(DBContract.NoticiaEntry.COLUMN_NAME_DATA));
        entity.setTitulo(contentValues.getAsString(DBContract.NoticiaEntry.COLUMN_NAME_TITULO));
        entity.setConteudo(contentValues.getAsString(DBContract.NoticiaEntry.COLUMN_NAME_CONTEUDO));

        Evento evento = new Evento(contentValues.getAsInteger(DBContract.NoticiaEntry.COLUMN_EVEN_ID));
        entity.setEvento(evento);

        return entity;
    }

    @Override
    public ContentValues toContentValues(Noticia entity) {
        ContentValues values = new ContentValues();
        values.put(DBContract.NoticiaEntry.COLUMN_ID, entity.getId());
        values.put(DBContract.NoticiaEntry.COLUMN_EVEN_ID, entity.getEvento().getId());
        //values.put(DBContract.NoticiaEntry.COLUMN_NAME_DATA, entity.getData().toString());
        values.put(DBContract.NoticiaEntry.COLUMN_NAME_TITULO, entity.getTitulo());
        values.put(DBContract.NoticiaEntry.COLUMN_NAME_CONTEUDO, entity.getConteudo());
        return values;
    }
}
