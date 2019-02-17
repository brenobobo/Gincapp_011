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

import br.com.naosai.breno.gincapp_010.Control.Base64Custom;
import br.com.naosai.breno.gincapp_010.Control.ControlEquipe;
import br.com.naosai.breno.gincapp_010.Entidades.Equipe;
import br.com.naosai.breno.gincapp_010.R;

public class AdicionarEquipeActivity extends AppCompatActivity {

    private EditText campoNomeEquipe;
    private Button prontoCadastroTime;
    private RadioGroup grupoPosicao;
    private RadioButton radioSelecionado;

    ControlEquipe controlEquipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_equipe);

        campoNomeEquipe = findViewById(R.id.editTextNomeEquipe);
        prontoCadastroTime = findViewById(R.id.button_prontoCadastroEquipe);
        grupoPosicao = findViewById(R.id.radioGroupPosicao);

        prontoCadastroTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (campoNomeEquipe != null){

                    Equipe equipe = new Equipe();

                    int grupo = grupoPosicao.getCheckedRadioButtonId();

                    if (grupo > 0){
                        String nome = campoNomeEquipe.getText().toString();
                        radioSelecionado = findViewById(grupo);
                        String lugarNaTela = radioSelecionado.getText().toString();


                        equipe.setId(UUID.randomUUID().toString());
                        equipe.setNome(nome);
                        equipe.setLugar(lugarNaTela);
                        controlEquipe.salvarEquipe(equipe);

                        Intent intent = new Intent(AdicionarEquipeActivity.this, SemiFinalActivity.class);

                        intent.putExtra("lugar", lugarNaTela);
                        intent.putExtra("nomeDoTime", nome);

                        startActivity(intent);

                        finish();

                    }else {
                        Toast.makeText(AdicionarEquipeActivity.this, "Selecione uma posicao", Toast.LENGTH_LONG);
                    }

                }else {
                    Toast.makeText(AdicionarEquipeActivity.this, "Digite um nome", Toast.LENGTH_LONG);
                }
            }
        });

    }
}
