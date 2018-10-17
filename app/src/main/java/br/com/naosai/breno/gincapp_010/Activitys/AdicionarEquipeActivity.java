package br.com.naosai.breno.gincapp_010.Activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.naosai.breno.gincapp_010.R;

public class AdicionarEquipeActivity extends AppCompatActivity {

    private EditText campoNomeEquipe;
    private Button prontoCadastroTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_equipe);

        campoNomeEquipe = findViewById(R.id.editTextNomeEquipe);
        prontoCadastroTime = findViewById(R.id.button_prontoCadastroEquipe);

        prontoCadastroTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (campoNomeEquipe != null && ){

                }
            }
        });

    }
}
