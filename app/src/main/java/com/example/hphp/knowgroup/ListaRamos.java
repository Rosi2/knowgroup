package com.example.hphp.knowgroup;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListaRamos extends ListActivity {
    public static String pais;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Generamos un arreglo de Strings a partir de el string-array declarado
        // en strings.xml
        String[] countries = getResources().getStringArray(R.array.countries_array);

        // Adaptador que contendr� el dise�o de cada elemento de la lista y el arreglo
        // con los nombres de los pa�ses
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, R.layout.activity_lista_ramos,
                countries);

        // Cargamos el adaptador para que se muestre la lista
        setListAdapter(adaptador);

        // Relacionamos la lista de mi actividad con un objeto de tipo ListView
        ListView lv = getListView();

        // Habilitamos el filtrado de texto de la lista
        lv.setTextFilterEnabled(true);

        // Creamos un escuchador que est� pendiente cuando el usuario
        // hace click en un item de la lista
        OnItemClickListener escuchador = new OnItemClickListener() {

            // Método que se ejecuta cuando se hace click en un item
            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int pos, long id) {

                TextView tv = (TextView) view;
                pais = tv.getText().toString();

                // Creamos una burbuja emergente que despliega el país elegido
                // por un tiempo largo
                Toast.makeText(ListaRamos.this, "Usted elegió " + pais,
                        Toast.LENGTH_LONG).show();
                Intent myintent = new Intent(getApplicationContext(),panel.class);
                startActivity(myintent);
            }

        };

        // Le asignamos un escuchador al ListView
        lv.setOnItemClickListener(escuchador);
    }

}
