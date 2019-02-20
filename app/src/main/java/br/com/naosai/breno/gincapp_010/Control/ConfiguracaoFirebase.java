package br.com.naosai.breno.gincapp_010.Control;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConfiguracaoFirebase {
    private static DatabaseReference referenceFirebase;
    private static FirebaseAuth firebaseAuth;

    public static DatabaseReference getFirebase(){
        if (referenceFirebase == null){
            referenceFirebase = FirebaseDatabase.getInstance().getReference();
        }


        return  referenceFirebase;
    }

    public static FirebaseAuth getFirebaseAuth(){

        if (firebaseAuth == null){
            firebaseAuth = FirebaseAuth.getInstance();
        }
        return firebaseAuth;
    }





}
