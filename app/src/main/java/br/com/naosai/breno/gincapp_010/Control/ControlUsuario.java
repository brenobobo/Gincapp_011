package br.com.naosai.breno.gincapp_010.Control;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.com.naosai.breno.gincapp_010.Activitys.CadastroUsuarioActivity;
import br.com.naosai.breno.gincapp_010.Entidades.Gincana;
import br.com.naosai.breno.gincapp_010.Entidades.Usuario;

public class ControlUsuario {

    FirebaseDatabase database = FirebaseDatabase.getInstance();



    public void salvarUsuario( Usuario usuario){
        DatabaseReference referenceFirebase = ConfiguracaoFirebase.getFirebase();
        referenceFirebase.child("Usuario").child(usuario.getId()).setValue(usuario);


    }
}
