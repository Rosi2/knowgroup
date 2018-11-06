package com.example.hphp.knowgroup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListaRamos extends AppCompatActivity {

    ListView listView;

    // Un placeholder, se deberia obtener de la base de datos:
    String[] siglaCursos = new String[] {"Programacion", "Matematicas I", "Introduccion a la Fisica", "Quimica y Sociedad", "Matematicas II", "Fisica General I"
    ,"Introduccion a la Ingenieria", "Estructura de Datos", "Matematicas III", "Fisica General III", "Estructuras Discretas"
    ,"Teoria de Sistemas", "Lenguajes de Programacion", "Matematicas IV", "Fisica General II", "Informatica Teorica"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_ramos);

        listView = (ListView) findViewById(R.id.lista);

        ArrayAdapter<String> adapSiglaCursos = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, siglaCursos);

        listView.setAdapter(adapSiglaCursos);
    }


    public void onClick(View view) {
        Intent intencion = new Intent(getApplication(), WellcomeActivity.class);
        startActivity(intencion);
    }
}
