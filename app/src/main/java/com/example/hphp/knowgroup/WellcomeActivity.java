package com.example.hphp.knowgroup;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class WellcomeActivity extends AppCompatActivity {
    public static final String user="names";
    TextView txtUser;
    DatabaseReference databaseReference;
    Button boton1, boton2, boton3, boton4;
    public static String seleccionado1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcome);

        boton1 = (Button)findViewById(R.id.mate1);
        boton2 = (Button)findViewById(R.id.mate2);
        boton3 = (Button)findViewById(R.id.mate3);
        boton4 = (Button)findViewById(R.id.mate4);
        databaseReference= FirebaseDatabase.getInstance().getReference();
        txtUser =(TextView)findViewById(R.id.textser);
        String user = getIntent().getStringExtra("names");
        txtUser.setText("Bienvenido ");
        MainActivity.contador+=1;

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionado1 = boton1.getText().toString();
                grupos p1 = new grupos(seleccionado1);
                //String id=databaseReference.push().getKey();
                databaseReference.child(Integer.toString(MainActivity.contador)).child("Primero").setValue(seleccionado1);
                Intent myintent = new Intent(getApplicationContext(),panel.class);
                startActivity(myintent);

            }
        });
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionado1 = boton2.getText().toString();
                grupos p1 = new grupos(seleccionado1);
                //String id=databaseReference.push().getKey();
                databaseReference.child(Integer.toString(MainActivity.contador)).child("Primero").setValue(seleccionado1);
                Intent myintent = new Intent(getApplicationContext(),panel.class);
                startActivity(myintent);

            }
        });
        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionado1 = boton3.getText().toString();
                grupos p1 = new grupos(seleccionado1);
                //String id=databaseReference.push().getKey();
                databaseReference.child(Integer.toString(MainActivity.contador)).child("Primero").setValue(seleccionado1);
                Intent myintent = new Intent(getApplicationContext(),panel.class);
                startActivity(myintent);

            }
        });
        boton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionado1 = boton4.getText().toString();
                grupos p1 = new grupos(seleccionado1);
                //String id=databaseReference.push().getKey();
                databaseReference.child(Integer.toString(MainActivity.contador)).child("Primero").setValue(seleccionado1);
                Intent myintent = new Intent(getApplicationContext(),panel.class);
                startActivity(myintent);

            }
        });
    }
}