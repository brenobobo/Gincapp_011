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

import br.com.naosai.breno.gincapp_010.R;

public class AdicionarEquipeActivity extends AppCompatActivity {

    private EditText campoNomeEquipe;
    private Button prontoCadastroTime;
    private RadioGroup grupoPosicao;
    private RadioButton radioSelecionado;

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

                    int grupo = grupoPosicao.getCheckedRadioButtonId();
                    if (grupo > 0){
                        String nome = campoNomeEquipe.getText().toString();
                        radioSelecionado = findViewById(grupo);
                        String posicao = radioSelecionado.getText().toString();
                        Intent intent = new Intent(AdicionarEquipeActivity.this, SemiFinalActivity.class);

                        intent.putExtra("posicao", posicao);
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
