package com.example.pc_gaming.madridcontaminacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListaCiudades extends AppCompatActivity {

    ArrayList<Ciudad> ciudades;
    private GridView gridView;

        /*Dióxido de azufre      SO2  μg/m³
          Monóxido de nitrógeno  NO   μg/m³
          Dióxido de nitrógeno   NO2  μg/m³
          Monóxido de Carbono    CO   mg/m³*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciudades);

        ciudades = new ArrayList<Ciudad>();
        gridView = findViewById(R.id.gridView);

        ciudades.add(new Ciudad("Alcalá de Henares", R.drawable.alcaladehenares));
        ciudades.add(new Ciudad("Torrejón de Ardoz", R.drawable.torrejondeardoz));
        ciudades.add(new Ciudad("Camarma De Esteruelas", R.drawable.camarmadeesteruelas));

        AdaptadorGrid myAdaptor = new AdaptadorGrid(getApplicationContext(), ciudades);
        gridView.setAdapter(myAdaptor);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuordenacion, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.ordenAlfabetico:
                Collections.sort(ciudades, new Comparator<Ciudad>() {
                    @Override
                    public int compare(Ciudad ciudad, Ciudad t1) {
                        return ciudad.getNombre().compareTo(t1.getNombre());
                    }
                });
                //LOS MUESTRO ORDENADOS
                AdaptadorGrid myAdaptor = new AdaptadorGrid(getApplicationContext(), ciudades);
                gridView.setAdapter(myAdaptor);
                break;
        }

        return true;
    }
}
