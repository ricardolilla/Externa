package com.example.ricardo.externa;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import se.emilsjolander.sprinkles.Query;

public class Edit2Acitivity extends AppCompatActivity {
    private Dados dados;
    EditText editTextCliente;
    EditText editTextKmIni;
    EditText editTextKmFinal;
    EditText editTextHoraEnt;
    EditText editTextHoraSaida;
    EditText editTextData;
    private Dados dado;
    private long id;
    private AlertDialog alert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        alert=new AlertDialog.Builder(this).create();
        setContentView(R.layout.activity_edit2_acitivity);
        Bundle extras=getIntent().getExtras();
        id=extras.getLong("id");
        dados = Query.one(Dados.class,"select * from Externas where id=?",id).get();
        editTextCliente = (EditText) findViewById(R.id.editTextCliente);
        editTextKmIni = (EditText) findViewById(R.id.editTextKmIni);
        editTextKmFinal = (EditText) findViewById(R.id.editTextKmFinal);
        editTextHoraEnt = (EditText) findViewById(R.id.editTextHoraEnt);
        editTextHoraSaida = (EditText) findViewById(R.id.editTextHoraSaida);
        editTextData = (EditText) findViewById(R.id.editTextData);
        editTextCliente.setText(dados.getCliente());
        editTextKmIni.setText(dados.getKmIni());
        editTextKmFinal.setText(dados.getKmFinal());
        editTextHoraEnt.setText(dados.getHoraIni());
        editTextHoraSaida.setText(dados.getHoraSaida());
        editTextData.setText(dados.getData());

    }
    void salvar(View view){
        boolean isEmpty=editTextCliente.getText().toString().isEmpty();
        isEmpty=isEmpty || editTextData.getText().toString().isEmpty();
        isEmpty=isEmpty || editTextHoraEnt.getText().toString().isEmpty();
        isEmpty=isEmpty || editTextHoraSaida.getText().toString().isEmpty();
        isEmpty=isEmpty || editTextKmIni.getText().toString().isEmpty();
        isEmpty=isEmpty || editTextKmFinal.getText().toString().isEmpty();
        if(!isEmpty){
            dado=new Dados();
            dado.setId(id);
            dado.setCliente(editTextCliente.getText().toString());
            dado.setKmIni(editTextKmIni.getText().toString());
            dado.setKmFinal(editTextKmFinal.getText().toString());
            dado.setHoraIni(editTextHoraEnt.getText().toString());
            dado.setHoraSaida(editTextHoraSaida.getText().toString());
            dado.setData(editTextData.getText().toString());
            dado.save();
            finish();

        }else{
            Log.d("TESTE","Vazio");
            alert.setTitle("FALHA");
            alert.setMessage("Existem campos em branco!");
            alert.show();
        }

    }
}
