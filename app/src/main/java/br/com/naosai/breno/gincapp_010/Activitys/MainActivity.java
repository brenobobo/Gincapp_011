package br.com.naosai.breno.gincapp_010.Activitys;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import br.com.naosai.breno.gincapp_010.Adapter.ViewPagerAdapter;
import br.com.naosai.breno.gincapp_010.Control.ConfiguracaoFirebase;
import br.com.naosai.breno.gincapp_010.Entidades.Gincana;
import br.com.naosai.breno.gincapp_010.Fragments.ConvidadoFragment;
import br.com.naosai.breno.gincapp_010.Fragments.MainFragment;
import br.com.naosai.breno.gincapp_010.R;

public class MainActivity extends AppCompatActivity {

    private Button buttonGincana;
    private AlertDialog.Builder dialogo;
    private FloatingActionButton botaoCadastrar;
    private Toolbar toolbar;
    private FirebaseAuth firebaseAuth;



    private ArrayAdapter adapter;
    private ArrayList<Gincana> gincanas;
    private Gincana gincana;
    Gincana gincanaSelecionada;
    private ViewPager viewPager;

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;

    // Databasereference em vez do query. Pois eu queria mudar a ordem da listagem e com o databasereference não achei um jeito prático
    private Query databaseReference;
    private ValueEventListener valueEventListenerGincana;
    private FirebaseUser firebaseUser;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //toolbar
        toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.tabs);


        viewPager = findViewById(R.id.pager);
        // adicionando os fragmentos

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new MainFragment(), "Gincanas");
        adapter.AddFragment(new ConvidadoFragment(), "Convidados");
        //adpter setup

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        firebaseAuth = ConfiguracaoFirebase.getFirebaseAuth();




      /*  botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, CadastroCompeticaoActivity.class);

                startActivity(intent);


              ATINGO JEITO DE CRIAR COMPETIÇÕES

               AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Nova Gincana");
                alertDialog.setMessage("Qual o nome da Gincana?");
                alertDialog.setCancelable(true);

                final EditText textoNome = new EditText(MainActivity.this);
                final RadioButton radioEsporte = new RadioButton(MainActivity.this);
                radioEsporte.setText("Futsal");


                alertDialog.setView(textoNome);


                alertDialog.setPositiveButton("CRIAR GINCANA", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String novoNome = textoNome.getText().toString();
                        if (novoNome.equals("")) {
                            Toast.makeText(getApplicationContext(), "O campo está vazio", Toast.LENGTH_SHORT);
                        } else {


                            Gincana gincana = new Gincana();
                            ControlGincana controladoraGincana = new ControlGincana();


                            gincana.setId(UUID.randomUUID().toString());
                            gincana.setNome(novoNome);
                            controladoraGincana.salvarGincana(gincana);


                        }
                    }
                });

                alertDialog.setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                alertDialog.create();
                alertDialog.show();


        });


    }
    */



    }



    //implementar o menu na activity

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }


    // a seleção do menu


    public void deslogarUsuario(){
        firebaseAuth.signOut();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}
