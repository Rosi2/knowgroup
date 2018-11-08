package com.example.hphp.knowgroup;

import com.example.hphp.knowgroup.Modelo.Ramo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import com.example.hphp.knowgroup.Modelo.Ramo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class panel extends AppCompatActivity {
    ListView listView;
    public static final String user="names";
    TextView txtUser;
    DatabaseReference databaseReference;
    Button boton1;
    String seleccionado;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel);

        txtUser =(TextView)findViewById(R.id.textser);
        txtUser.setText(ListaRamos.pais);

        final ArrayList<Ramo> lista = new ArrayList<Ramo>();

        listView = findViewById(R.id.listita);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,valores);
        //listView.setAdapter(adapter);
        boton1 = (Button)findViewById(R.id.grupo);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference();
        databaseReference.child(ListaRamos.pais).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                showData(dataSnapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        //ArrayAdapter<Ramo> adapter = new ArrayAdapter<Ramo>(this,android.R.layout.simple_expandable_list_item_1,lista);
        //listView.setAdapter(adapter);
        //System.out.println(adapter);



        //databaseReference= FirebaseDatabase.getInstance().getReference();




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

    private void showData(DataSnapshot dataSnapshot) {
        Iterable<DataSnapshot> children = dataSnapshot.getChildren();
        ArrayList<String> array  = new ArrayList<>();
        for (DataSnapshot child: children) {
            Ramo mate1 = child.getValue(Ramo.class);


            array.add(mate1.getNombre());

            ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,array);
            listView.setAdapter(adapter);
            System.out.print(array);
        }
    }


}



