package br.com.naosai.breno.gincapp_010.Control;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.com.naosai.breno.gincapp_010.Entidades.ConvidadoGincana;

public class ControlConvidadoGincana {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    ControlUsuario controlUsuario = new ControlUsuario();

    public void salvarConvidadoGincana(ConvidadoGincana convidadoGincana){


        DatabaseReference referenceFirebase = ConfiguracaoFirebase.getFirebase();
        referenceFirebase.child("ConvidadoGincana").child(convidadoGincana.getIdDaGincana()).child(convidadoGincana.getIdConvidado()).setValue(convidadoGincana);
    }


}
