package br.com.naosai.breno.gincapp_010.Activitys;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import br.com.naosai.breno.gincapp_010.Adapter.GincanaAdapter;
import br.com.naosai.breno.gincapp_010.Control.Base64Custom;
import br.com.naosai.breno.gincapp_010.Control.ConfiguracaoFirebase;
import br.com.naosai.breno.gincapp_010.Control.ControlGincana;
import br.com.naosai.breno.gincapp_010.Control.ControlUsuario;
import br.com.naosai.breno.gincapp_010.Entidades.Gincana;
import br.com.naosai.breno.gincapp_010.R;

public class MainActivity extends AppCompatActivity {

    private Button buttonGincana;
    private AlertDialog.Builder dialogo;
    private FloatingActionButton botaoCadastrar;
    private android.support.v7.widget.Toolbar toolbar;
    private FirebaseAuth firebaseAuth;


    private ListView listViewGincanas;
    private ArrayAdapter adapter;
    private ArrayList<Gincana> gincanas;
    private Gincana gincana;
    Gincana gincanaSelecionada;

    // Databasereference em vez do query. Pois eu queria mudar a ordem da listagem e com o databasereference não achei um jeito prático
    private Query databaseReference;
    private ValueEventListener valueEventListenerGincana;
    private FirebaseUser firebaseUser;


    @Override
    protected void onStart() {
        super.onStart();
        databaseReference.addValueEventListener(valueEventListenerGincana);
    }

    @Override
    protected void onStop() {
        super.onStop();
        databaseReference.removeEventListener(valueEventListenerGincana);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //toolbar
        toolbar = findViewById(R.id.toolbar_main);
        toolbar.setTitle("Gincapp");
        setSupportActionBar(toolbar);

        firebaseAuth = ConfiguracaoFirebase.getFirebaseAuth();


        botaoCadastrar = findViewById(R.id.floatingActionButton_addGincana);

        listViewGincanas = findViewById(R.id.listViewGincanasId);

        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, CadastroCompeticaoActivity.class);

                startActivity(intent);

               /*
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

            */}
        });

        gincanas = new ArrayList<>();


        listViewGincanas = findViewById(R.id.listViewGincanasId);
        adapter = new GincanaAdapter(MainActivity.this, gincanas );


        listViewGincanas.setAdapter(adapter);

        // puxando o email do usuário, para codificar em base 64, para selecionar cada competição em cada usuário
        ControlUsuario controlUsuario = new ControlUsuario();
        String emailCodificado = controlUsuario.recoverEmailBase64();



        databaseReference = ConfiguracaoFirebase.getFirebase().child("Gincana").child(emailCodificado).orderByChild("nome");

        //Listener para recuperar gincanas
        valueEventListenerGincana = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Limpar lista

                gincanas.clear();

                //Listando gincanas
                for (DataSnapshot dados: dataSnapshot.getChildren()){

                    Gincana gincana = dados.getValue(Gincana.class);
                    gincanas.add(gincana);
                }

                // atualizacao da mudança
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };


        listViewGincanas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Gincana gincana = gincanas.get(position);

                String valor = gincana.getChaveamento();

                if (valor.equals("Semi-Final")){

                    Intent intent = new Intent(MainActivity.this, SemiFinalActivity.class);

                    intent.putExtra("chave", gincana.getChaveamento());
                    intent.putExtra("nome", gincana.getNome());
                    intent.putExtra("id", gincana.getId());

                    startActivity(intent);


                }else{

                    Intent intent = new Intent(MainActivity.this, GincanaActivity.class);
                    intent.putExtra("chave", gincana.getChaveamento());
                    intent.putExtra("nome", gincana.getNome());
                    intent.putExtra("id", gincana.getId());
                    startActivity(intent);
                }


            }
        });

        listViewGincanas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long l) {



                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);

                alertDialog.setTitle("Você deseja excluir a gincana?");

                alertDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ControlGincana control = new ControlGincana();

                        Gincana g = gincanas.get(position);

                        control.excluirGincana(g.getId());



                    }

                });

                alertDialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                alertDialog.create();
                alertDialog.show();


                return true;
            }
        });





    }



    //implementar o menu na activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    // a seleção do menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_sair:
                deslogarUsuario();
                return true;

                default:
                    return super.onOptionsItemSelected(item);
        }

    }

    public void deslogarUsuario(){
        firebaseAuth.signOut();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}
