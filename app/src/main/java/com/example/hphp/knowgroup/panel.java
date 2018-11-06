package com.example.hphp.knowgroup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class panel extends AppCompatActivity {
    public static final String user="names";
    TextView txtUser;
    DatabaseReference databaseReference;
    Button boton1;
    String seleccionado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel);

        boton1 = (Button)findViewById(R.id.grupo);
        databaseReference= FirebaseDatabase.getInstance().getReference();
        txtUser =(TextView)findViewById(R.id.textser);
        String user = getIntent().getStringExtra("names");
        txtUser.setText("Bienvenido a "+ WellcomeActivity.seleccionado1);

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //seleccionado = boton1.getText().toString();
                //grupos p1 = new grupos(seleccionado);
                //String id=databaseReference.push().getKey();
                //databaseReference.child(Integer.toString(MainActivity.contador)).child("Segundo").setValue(seleccionado);
                Intent myintent = new Intent(getApplicationContext(),nuevo.class);
                startActivity(myintent);

            }
        });
    }
}
