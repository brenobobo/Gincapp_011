package br.com.naosai.breno.gincapp_010.Control;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.com.naosai.breno.gincapp_010.Entidades.Gincana;

public class ControlGincana {

    FirebaseDatabase database = FirebaseDatabase.getInstance();


    public void salvarGincana(Gincana gincana){
        DatabaseReference referenceFirebase = ConfiguracaoFirebase.getFirebase();
        referenceFirebase.child("Gincana").child(gincana.getId()).setValue(gincana);

    }

    public void excluirGincana(String id){
        DatabaseReference referenceFirebase = ConfiguracaoFirebase.getFirebase();
        referenceFirebase.child("Gincana").child(id).removeValue();
    }
}
