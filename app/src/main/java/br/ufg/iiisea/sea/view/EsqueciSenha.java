package br.ufg.iiisea.sea.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.ufg.iiisea.sea.R;

public class EsqueciSenha extends AppCompatActivity {

    private EditText etEmail = null;
    private Button btnConcluir = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esqueci_senha);

        etEmail = (EditText) findViewById(R.id.etEsquciSenhaEmail);
        btnConcluir = (Button) findViewById(R.id.btnEsqueciSenhaEnviar);

        btnConcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Enviar email com senha", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
