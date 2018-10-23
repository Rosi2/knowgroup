package com.example.hphp.knowgroup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListaRamos extends AppCompatActivity {

    ListView listView;

    // Un placeholder, se deberia obtener de la base de datos:
    String[] siglaCursos = new String[] {"INF-000", "INF-666", "INF-999"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_ramos);

        listView = (ListView) findViewById(R.id.lista);

        ArrayAdapter<String> adapSiglaCursos = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, siglaCursos);

        listView.setAdapter(adapSiglaCursos);
    }
}
