package br.ufg.iiisea.sea.presenter;

import android.app.ProgressDialog;
import android.widget.Toast;
import br.ufg.iiisea.sea.R;
import br.ufg.iiisea.sea.interactor.EsqueciSenhaInteractor;
import br.ufg.iiisea.sea.interactor.EsqueciSenhaInteractorImpl;
import br.ufg.iiisea.sea.utils.PresenterGeneric;
import br.ufg.iiisea.sea.view.EsqueciSenha;
import br.ufg.iiisea.sea.view.EsqueciSenhaView;
import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

/**
 * Created by fellipe on 21/09/16.
 */
public class EsqueciSenhaPresenterImpl extends PresenterGeneric implements EsqueciSenhaPresenter, EsqueciSenhaCallback.OnEsqueciSenhaListener {

    private EsqueciSenhaInteractor interactor;
    private EsqueciSenhaView view;

    public EsqueciSenhaPresenterImpl() {
        interactor = new EsqueciSenhaInteractorImpl(this);
    }

    public EsqueciSenhaPresenterImpl(EsqueciSenhaView view) {
        this();
        this.view = view;
    }

    @Override
    public void validaEsqueciSenha(String email) {
       interactor.realizaEsqueciSenha(email);
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void onSucess() {
        view.hideProgress();
        view.showToastMessage(R.string.msgLinkEnviado);
        view.finish();
    }

    @Override
    public void onLoad() {
        view.showProgress();
        view.showToastMessage(R.string.aguarde);
    }

    @Override
    public void onErrorEmailInvalido() {
        view.hideProgress();
        view.showToastMessage(R.string.erroCampoVazio);
    }

    @Override
    public void onError(String error) {
        view.showToastByString(error);
        view.hideProgress();
    }
}
