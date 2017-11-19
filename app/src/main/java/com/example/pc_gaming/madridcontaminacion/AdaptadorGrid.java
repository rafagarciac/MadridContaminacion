package com.example.pc_gaming.madridcontaminacion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by PC_Gaming on 19/11/2017.
 */

public class AdaptadorGrid extends BaseAdapter{

    Context context;
    ArrayList <Ciudad> listaCiudades;

    public AdaptadorGrid(Context context, ArrayList listaCiudades){
        this.context = context;
        this.listaCiudades = listaCiudades;
    }

    @Override
    public int getCount() {
        return listaCiudades.size();
    }

    @Override
    public Object getItem(int i) {
        return listaCiudades.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {View vista = view;
        LayoutInflater inflate = LayoutInflater.from(context);
        vista = inflate.inflate(R.layout.item_ciudades, null);

        TextView tvCalidad = vista.findViewById(R.id.tvCiudad);
        ImageView imagenGV = vista.findViewById(R.id.ivImagenGrid);

        tvCalidad.setText(listaCiudades.get(i).getNombre());
        imagenGV.setImageResource(listaCiudades.get(i).getImagenGV());

        return vista;
    }
}
