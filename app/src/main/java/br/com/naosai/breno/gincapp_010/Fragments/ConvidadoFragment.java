package br.com.naosai.breno.gincapp_010.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import br.com.naosai.breno.gincapp_010.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConvidadoFragment extends Fragment {


    public ConvidadoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_convidado, container, false);
        return view;
    }

}
