package com.example.ricardo.externa;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import se.emilsjolander.sprinkles.Query;


public class InsertActivity extends AppCompatActivity {
    EditText editTextCliente;
    EditText editTextKmIni;
    EditText editTextKmFinal;
    EditText editTextHoraEnt;
    EditText editTextHoraSaida;
    EditText editTextData;
    private Dados dado;
    private AlertDialog alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        alert=new AlertDialog.Builder(this).create();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        editTextCliente = (EditText) findViewById(R.id.editTextCliente);
        editTextKmIni = (EditText) findViewById(R.id.editTextKmIni);
        editTextKmFinal = (EditText) findViewById(R.id.editTextKmFinal);
        editTextHoraEnt = (EditText) findViewById(R.id.editTextHoraEnt);
        editTextHoraSaida = (EditText) findViewById(R.id.editTextHoraSaida);
        editTextData = (EditText) findViewById(R.id.editTextData);
        //Formatar data atua pata dia, mes e ano e escrever no campos Data
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date data=new Date();
        editTextData.setText(dateFormat.format(data));
        /*
        dado = Query.one(Dados.class,"select * from Externas where Data=?",editTextData.getText().toString()).get();
        if (dado!=null){
            Log.d("TESTE",dado.getCliente());
        }
        */
    }
    public void salvar(View view){
        boolean isEmpty=editTextCliente.getText().toString().isEmpty();
        isEmpty=isEmpty || editTextData.getText().toString().isEmpty();
        isEmpty=isEmpty || editTextHoraEnt.getText().toString().isEmpty();
        isEmpty=isEmpty || editTextHoraSaida.getText().toString().isEmpty();
        isEmpty=isEmpty || editTextKmIni.getText().toString().isEmpty();
        isEmpty=isEmpty || editTextKmFinal.getText().toString().isEmpty();
        if(!isEmpty){
            dado=new Dados();
            dado.setId(0L);
            dado.setCliente(editTextCliente.getText().toString());
            dado.setKmIni(editTextKmIni.getText().toString());
            dado.setKmFinal(editTextKmFinal.getText().toString());
            dado.setHoraIni(editTextHoraEnt.getText().toString());
            dado.setHoraSaida(editTextHoraSaida.getText().toString());
            dado.setData(editTextData.getText().toString());
            dado.save();
            Log.d("TESTE","OK");
        }else{
            Log.d("TESTE","Vazio");
            alert.setTitle("FALHA");
            alert.setMessage("Existem campos em branco!");
            alert.show();
        }



    }
}
