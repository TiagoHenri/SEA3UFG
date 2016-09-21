package br.ufg.iiisea.sea.interactor;

import android.content.Intent;
import android.widget.Toast;
import br.ufg.iiisea.sea.R;
import br.ufg.iiisea.sea.control.InitialConfig;
import br.ufg.iiisea.sea.presenter.EntrarCallback;
import br.ufg.iiisea.sea.view.Entrar;
import br.ufg.iiisea.sea.view.Home;
import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

/**
 * Created by fellipe on 20/09/16.
 */
public class EntrarInteractorImpl implements EntrarInteractor {


    @Override
    public void login(String email, String senha, final EntrarCallback.OnLoginListener onLoginFinishedObj) {
        if(email.equalsIgnoreCase("") || senha.equalsIgnoreCase("")){
            onLoginFinishedObj.onErrorCampoVazio();
        } else if(senha.length() < 6) {
            onLoginFinishedObj.onErrorTamanhoSenha();
        } else {
            Backendless.UserService.login(email, senha, new AsyncCallback<BackendlessUser>() {
                @Override
                public void handleResponse(BackendlessUser backendlessUser) {
                    InitialConfig.isLogged = true;
                    InitialConfig.user = backendlessUser;
//                    Intent intent = new Intent(Entrar.this, Home.class);
//                    startActivity(intent);
                    onLoginFinishedObj.onSucess();
//                    finish();
                }

                @Override
                public void handleFault(BackendlessFault backendlessFault) {
//                    progress.dismiss();
                    //Tomar cuidado com esse 1 pois é só um tipo
                    onLoginFinishedObj.onError(1, backendlessFault.getMessage());
                }
            }, true);
        }
    }
}
