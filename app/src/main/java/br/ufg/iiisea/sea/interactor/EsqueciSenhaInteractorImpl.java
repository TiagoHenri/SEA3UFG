package br.ufg.iiisea.sea.interactor;

import br.ufg.iiisea.sea.presenter.EsqueciSenhaCallback;
import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

/**
 * Created by fellipe on 21/09/16.
 */
public class EsqueciSenhaInteractorImpl implements EsqueciSenhaInteractor {

    private EsqueciSenhaCallback.OnEsqueciSenhaListener onEsqueciSenhaListener;

    public EsqueciSenhaInteractorImpl(EsqueciSenhaCallback.OnEsqueciSenhaListener onEsqueciSenhaListener) {
        this.onEsqueciSenhaListener = onEsqueciSenhaListener;
    }

    @Override
    public void realizaEsqueciSenha(String email) {
        if(email.equalsIgnoreCase("")){
//            Toast.makeText(getApplicationContext(),
//                    getResources().getString(R.string.erroCampoVazio), Toast.LENGTH_LONG).show();
            onEsqueciSenhaListener.onErrorEmailInvalido();
        } else {
//            progress = ProgressDialog.show(EsqueciSenha.this, getResources().getString(R.string.aguarde),
//                    getResources().getString(R.string.aguarde), true);
            onEsqueciSenhaListener.onLoad();

            Backendless.UserService.restorePassword(email,
                    new AsyncCallback<Void>() {
                        @Override
                        public void handleResponse(Void aVoid) {
//                            progress.dismiss();
//                            Toast.makeText(getApplicationContext(),
//                                    getResources().getString(R.string.msgLinkEnviado),
//                                    Toast.LENGTH_LONG).show();
//                            finish();
                            onEsqueciSenhaListener.onSucess();
                        }

                        @Override
                        public void handleFault(BackendlessFault backendlessFault) {
//                            Toast.makeText(getApplicationContext(),
//                                    backendlessFault.getMessage(), Toast.LENGTH_LONG).show();
                            onEsqueciSenhaListener.onError(backendlessFault.getMessage()    );
                        }
                    });
        }
    }
}
