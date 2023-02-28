package com.example.apijorgeprimos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.apijorgeprimos.vm.PrimosAdapter;
import com.example.apijorgeprimos.vm.PrimosViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etInicio, etFin;
    Button btnCalcular;
    RecyclerView rv;
    ProgressBar progressBar;
    PrimosViewModel pVm;
    PrimosAdapter adapter;
    int in=1,fin=104;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etInicio=findViewById(R.id.etInicio);
        etFin=findViewById(R.id.etFin);
        rv=findViewById(R.id.recycler);
        btnCalcular=findViewById(R.id.btnCalcular);
        progressBar=findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);
        //adaptador
        adapter= new PrimosAdapter();
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

        //view model
        pVm=new ViewModelProvider(this).get(PrimosViewModel.class);
        pVm.init();
        btnCalcular.setOnClickListener((v)->{
            btnCalcular.setVisibility(View.INVISIBLE);
            progressBar.setVisibility(View.VISIBLE);
            new CountDownTimer(10000, 1000) {
                public void onTick(long millisUntilFinished) {
                    // Actualiza la ProgressBar con el progreso del temporizador
                    int progress = (int) (millisUntilFinished / 1000);
                    progressBar.setProgress(progress);
                }
                public void onFinish() {
                    // Oculta la ProgressBar cuando el temporizador ha finalizado
                    progressBar.setVisibility(View.INVISIBLE);
                    btnCalcular.setVisibility(View.VISIBLE);
                    pVm.obtenerPrimos(Integer.parseInt(etInicio.getText().toString()),Integer.parseInt(etFin.getText().toString()));
                }
            }.start();

        });
        pVm.getObtenerPrimosLD().observe(this,(dato)->{
            Toast.makeText(this, (dato+""), Toast.LENGTH_SHORT).show();
            Log.d("dato: ",(dato+""));
            adapter.setResults(dato.getPrimos());
        });
    }
}
