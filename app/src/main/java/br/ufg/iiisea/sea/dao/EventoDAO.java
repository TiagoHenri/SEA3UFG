package br.ufg.iiisea.sea.dao;

import android.content.ContentValues;
import android.content.Context;
import br.ufg.iiisea.sea.bean.Evento;

/**
 * Created by fellipe on 23/09/16.
 */
public class EventoDAO extends AbstractDAO<Evento> {

    public EventoDAO(Context context) {
        super(context);
    }

    @Override
    public String getTableName() {
        return DBContract.EventoEntry.TABLE_NAME;
    }

    @Override
    public String getKeyPrimaryColumnName() {
        return DBContract.EventoEntry.COLUMN_ID;
    }

    @Override
    public String getSQLCreateEntries() {
        return DBContract.EventoEntry.SQL_CREATE_ENTRIES;
    }

    @Override
    public String getSQLDeleteEntries() {
        return DBContract.EventoEntry.SQL_DELETE_ENTRIES;
    }

    @Override
    public Evento toEntity(ContentValues contentValues) {
        Evento entity = new Evento();
        entity.setId(contentValues.getAsInteger(DBContract.EventoEntry.COLUMN_ID));
        entity.setNome(contentValues.getAsString(DBContract.EventoEntry.COLUMN_NAME_NOME));
        entity.setDescricao(contentValues.getAsString(DBContract.EventoEntry.COLUMN_NAME_DESCRICAO));
//        entity.setDataInicio(contentValues.getAsString(DBContract.EventoEntry.COLUMN_NAME_DATA_INICIO));
//        entity.setDataFim(contentValues.getAsString(DBContract.EventoEntry.COLUMN_NAME_DATA_FIM));
        return entity;
    }

    @Override
    public ContentValues toContentValues(Evento entity) {
        ContentValues values = new ContentValues();
        values.put(DBContract.EventoEntry.COLUMN_ID, entity.getId());
        values.put(DBContract.EventoEntry.COLUMN_NAME_NOME, entity.getNome());
        values.put(DBContract.EventoEntry.COLUMN_NAME_DESCRICAO, entity.getDescricao());
//        values.put(DBContract.EventoEntry.COLUMN_NAME_DATA_FIM, entity.getDataFim().toString());
//        values.put(DBContract.EventoEntry.COLUMN_NAME_DATA_INICIO, entity.getDataInicio().toString());
        return null;
    }
}
