package br.ufg.iiisea.sea.interactor;

import android.content.Context;
import br.ufg.iiisea.sea.bean.Evento;
import br.ufg.iiisea.sea.bean.Noticia;
import br.ufg.iiisea.sea.dao.NoticiaDAO;

import java.util.Date;
import java.util.List;

/**
 * Created by fellipe on 23/09/16.
 */
public class NoticiaInteractorImpl implements NoticiaInteractor {

    private NoticiaDAO noticiaDAO;

    public NoticiaInteractorImpl(Context context) {
        this.noticiaDAO = new NoticiaDAO(context);
//        Noticia noticia = new Noticia();
//        noticia.setConteudo("fadfasdfa dfasd fa fasd fa");
//        noticia.setTitulo("noticia1");
//        noticia.setData(new Date());
//        noticia.setEvento(new Evento(1));
//        noticia.setId(1);
//        noticiaDAO.save(noticia);
    }

    @Override
    public List<Noticia> getNoticiasInicio() {

        return noticiaDAO.getAllNoticiaByEvento(new Evento(1));
    }
}
