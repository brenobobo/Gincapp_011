package br.com.naosai.breno.gincapp_010.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import br.com.naosai.breno.gincapp_010.R;

public class SemiFinalActivity extends AppCompatActivity {

    private Button botaoAdcionarEquipe;
    private TextView campo1;
    private TextView campo2;
    private TextView campo3;
    private TextView campo4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semi_final);

        final Bundle extra = getIntent().getExtras();

        botaoAdcionarEquipe = findViewById(R.id.button_addEquipe);
        campo1 = findViewById(R.id.campo1);
        campo2 = findViewById(R.id.campo2);
        campo3 = findViewById(R.id.campo3);
        campo4 = findViewById(R.id.campo4);








        botaoAdcionarEquipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SemiFinalActivity.this, AdicionarEquipeActivity.class);

                if (extra != null) {
                    String idGincana = extra.getString("id");
                    intent.putExtra("id", idGincana);
                    startActivity(intent);
                }else {
                    Toast.makeText(SemiFinalActivity.this,"ERROR: Necessita do id da gincana  idGincana",Toast.LENGTH_LONG).show();
                }

            }
        });






        final String posicao = extra.getString("lugar");
        String nomeDaEquipe = extra.getString("nome");

        if (posicao == "1"){
            campo1.setText(nomeDaEquipe);

        }
        if (posicao == "3"){
            campo1.setText(nomeDaEquipe);

        }
        if (posicao == "4"){
            campo1.setText(nomeDaEquipe);

        }
        if (posicao == "5"){
            campo1.setText(nomeDaEquipe);

        }


    }



}

