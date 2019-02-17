package br.com.naosai.breno.gincapp_010.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.UUID;

import br.com.naosai.breno.gincapp_010.Control.ControlGincana;
import br.com.naosai.breno.gincapp_010.Entidades.Gincana;
import br.com.naosai.breno.gincapp_010.R;


public class ConfiguracaoEsportesActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbar;
    private Button botaoPronto;
    private EditText editText_nomeGincana;
    private RadioGroup grupoChaveamento;
    private RadioButton radioEscolhido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracao_esportes);

        toolbar = findViewById(R.id.toolbar_main);
        toolbar.setTitle("Criação da Gincana");

        botaoPronto = findViewById(R.id.button_pronto);
        editText_nomeGincana = findViewById(R.id.editText_nomeGincana);
        grupoChaveamento = findViewById(R.id.radioGroupChaveamento);


        botaoPronto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomeDaGincana = editText_nomeGincana.getText().toString();

                int idRadioEscolhido = grupoChaveamento.getCheckedRadioButtonId();


                if (nomeDaGincana == null){
                    Toast.makeText(ConfiguracaoEsportesActivity.this, "Digite um nome.", Toast.LENGTH_SHORT).show();
                }else {
                    if (idRadioEscolhido > 0) {
                        radioEscolhido = findViewById(idRadioEscolhido);
                        final String rEscolhido = radioEscolhido.getText().toString();


                        ControlGincana controlGincana = new ControlGincana();
                        Gincana gincana = new Gincana();
                        gincana.setId(UUID.randomUUID().toString());
                        gincana.setNome(nomeDaGincana);
                        gincana.setChaveamento(rEscolhido);
                        controlGincana.salvarGincana(gincana);


                        Intent intent = new Intent(ConfiguracaoEsportesActivity.this, MainActivity.class);
                        startActivity(intent);

                        finish();
                    } else {
                        Toast.makeText(ConfiguracaoEsportesActivity.this, "Marque uma das opções.", Toast.LENGTH_SHORT);
                    }

                }





            }
        });


    }
}
