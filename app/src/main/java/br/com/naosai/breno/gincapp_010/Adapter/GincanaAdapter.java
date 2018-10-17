package br.com.naosai.breno.gincapp_010.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.naosai.breno.gincapp_010.Entidades.Gincana;
import br.com.naosai.breno.gincapp_010.R;

public class GincanaAdapter extends ArrayAdapter<Gincana> {

    private ArrayList<Gincana> gincanas;
    private Context context;


    public GincanaAdapter(@NonNull Context c, @NonNull ArrayList<Gincana> objects) {
        super(c, 0, objects);
        this.gincanas = objects;
        this.context = c;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = null;

        if (gincanas != null ){

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.lista_gincana,parent, false);

            TextView nomeGincana = view.findViewById(R.id.tv_nome);

            Gincana gincana = gincanas.get(position);

            nomeGincana.setText(gincana.getNome());

        }
        return view;
    }
}
