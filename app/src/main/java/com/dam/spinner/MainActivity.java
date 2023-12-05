package com.dam.spinner;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lista desplegable (Spinner con adaptador)
        // Enlace a la vista
        Spinner listadoOpciones = findViewById(R.id.spinner);
        TextView resultado = findViewById(R.id.textView);

        // Conjunto de datos -> array
        String[] datos = new String[]{"Suzuki", "Kawasaki", "Honda", "BMW", "Ducati", "Aprilia"};

        // Construye el adaptador para la fuente de datos
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, datos);

        // Tipo de Spinner
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Enlaza el adaptador al Spinner
        listadoOpciones.setAdapter(adaptador);

        // Gestión del evento
        listadoOpciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                Toast.makeText(getBaseContext(), datos[position], Toast.LENGTH_LONG).show();
                resultado.setText("Opción de índice: " + (position + 1));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                resultado.setText("");
            }
        });
    }
}
