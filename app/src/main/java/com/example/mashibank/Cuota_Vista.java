package com.example.mashibank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;

import com.example.mashibank.adapters.AdapterCuota;
import com.example.mashibank.enums.EstadoCuota;
import com.example.mashibank.models.Cuota;
import com.example.mashibank.Inicio;

import java.util.List;

public class Cuota_Vista extends AppCompatActivity {
    private List<Cuota> cuotas;
    private AdapterCuota adaptador;
    private RecyclerView rvCuotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuota__vista);
        cuotas = Inicio.cuotas;
        adaptador = new AdapterCuota();
        for (Cuota cuota: cuotas) {
            if(cuota.getEstado() == EstadoCuota.VENCIDA){
                adaptador.addCuota(cuota);
            }
        }

        rvCuotas = findViewById(R.id.rVCuotas);
        rvCuotas.setAdapter(adaptador);
        rvCuotas.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_back, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
