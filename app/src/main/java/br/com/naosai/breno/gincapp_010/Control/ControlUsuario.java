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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.com.naosai.breno.gincapp_010.Activitys.CadastroUsuarioActivity;
import br.com.naosai.breno.gincapp_010.Entidades.Gincana;
import br.com.naosai.breno.gincapp_010.Entidades.Usuario;

public class ControlUsuario {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    FirebaseUser firebaseUser;



    public void salvarUsuario( Usuario usuario){
        DatabaseReference referenceFirebase = ConfiguracaoFirebase.getFirebase();
        referenceFirebase.child("Usuario").child(usuario.getId()).setValue(usuario);


    }

    // puxando o email do usuário, para codificar em base 64, para selecionar cada competição em cada usuário
    public String recoverEmailBase64(){
        String email;
        firebaseUser = ConfiguracaoFirebase.getFirebaseAuth().getCurrentUser();
        email = firebaseUser.getEmail();
        Base64Custom base64Custom = new Base64Custom();
        String emailCodificado = base64Custom.codificarBase64(email);
        return emailCodificado;

    }
}
