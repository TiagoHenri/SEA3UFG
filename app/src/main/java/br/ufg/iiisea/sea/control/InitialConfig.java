package br.ufg.iiisea.sea.control;

import android.app.Application;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.local.UserTokenStorageFactory;

import br.ufg.iiisea.sea.R;
import br.ufg.iiisea.sea.view.Home;

/**
 * Created by Tiago on 16/03/2016.
 */
public class InitialConfig extends Application {

    private final String YOUR_APP_ID = "82CFB9FC-2313-8D03-FFA2-A644C2A64700";
    private final String YOUR_SECRET_KEY = "98B0AE47-0E85-0EDB-FFE3-176347E79D00";
    private final String APP_VERSION = "v1";

    public static boolean isLogged = false;
    public static BackendlessUser user = null;

    @Override
    public void onCreate(){
        super.onCreate();

        Backendless.initApp(this, YOUR_APP_ID, YOUR_SECRET_KEY, APP_VERSION);

        String userToken = Backendless.UserService.loggedInUser();
        if(userToken != null && !userToken.equals("")){
            //Log.e("UserToken", userToken);
            isLogged = true;
            Backendless.UserService.findById(userToken, new AsyncCallback<BackendlessUser>() {
                @Override
                public void handleResponse(BackendlessUser backendlessUser) {
                    user = backendlessUser;
                    Toast.makeText(getApplicationContext(),
                            getResources().getString(R.string.msgBemVindo) + user.getProperty("name").toString(),
                            Toast.LENGTH_LONG).show();
                }

                @Override
                public void handleFault(BackendlessFault backendlessFault) {
                    //Log.e("Backendless ERROR", backendlessFault.getMessage());
                    Toast.makeText(getApplicationContext(),
                            backendlessFault.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
