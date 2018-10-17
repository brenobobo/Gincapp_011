package br.com.naosai.breno.gincapp_010.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.naosai.breno.gincapp_010.R;

public class SemiFinalActivity extends AppCompatActivity {

    private Button botaoAdcionarEquipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semi_final);

        botaoAdcionarEquipe = findViewById(R.id.button_addEquipe);

        botaoAdcionarEquipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SemiFinalActivity.this, AdicionarEquipeActivity.class);

                startActivity(intent);
            }
        });

    }



}
