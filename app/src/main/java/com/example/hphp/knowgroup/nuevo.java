package com.example.hphp.knowgroup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class nuevo extends AppCompatActivity {
    public static final String user="names";
    TextView txtUser;
    DatabaseReference databaseReference;
    Button boton1;
    String seleccionado;
    private EditText nombre, lugar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        boton1 = (Button)findViewById(R.id.guardar);
        nombre = (EditText) findViewById(R.id.nombre);
        lugar = (EditText) findViewById(R.id.lugar);
        databaseReference= FirebaseDatabase.getInstance().getReference();
        txtUser =(TextView)findViewById(R.id.textser);
        String user = getIntent().getStringExtra("names");

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionado = nombre.getText().toString();
                grupos p1 = new grupos(seleccionado);
                //String id=databaseReference.push().getKey();
                databaseReference.child(Integer.toString(MainActivity.contador)).child("Grupo").setValue(seleccionado);
                Intent myintent = new Intent(getApplicationContext(),WellcomeActivity.class);
                startActivity(myintent);

            }
        });
    }
}

