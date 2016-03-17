package com.example.ricardo.externa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.List;

import se.emilsjolander.sprinkles.Query;

public class EditActivity extends AppCompatActivity {

    EditText editTextCliente;
    List<Dados> dados;
    List<String> lista;
    ListView listView;
    private int index;
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        i=0;
        dados=Query.all(Dados.class).get().asList();
        editTextCliente = (EditText) findViewById(R.id.editTextCliente);
        listView=(ListView) findViewById(R.id.listView);
        if(dados!=null){
            index=dados.size();
            editTextCliente.setText(dados.get(i).getCliente());
            lista=new ArrayList<String>();
            for(Dados dado:dados){
                lista.add(String.valueOf(dado.getId())+" - "+dado.getCliente()+" - "+dado.getData());
            }
            ArrayAdapter adaptador=new ArrayAdapter(EditActivity.this,android.R.layout.simple_list_item_1,lista);
            listView.setAdapter(adaptador);
            AdapterView.OnItemClickListener itemOnClick=new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    editTextCliente.setText(dados.get(position).getCliente());
                    Intent intent=new Intent(EditActivity.this,Edit2Acitivity.class);
                    intent.putExtra("id",dados.get(position).getId());
                    startActivity(intent);
                }
            };
            listView.setOnItemClickListener(itemOnClick);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        dados=Query.all(Dados.class).get().asList();
        editTextCliente = (EditText) findViewById(R.id.editTextCliente);
        listView=(ListView) findViewById(R.id.listView);
        if(dados!=null){
            index=dados.size();
            editTextCliente.setText(dados.get(i).getCliente());
            lista=new ArrayList<String>();
            for(Dados dado:dados){
                lista.add(String.valueOf(dado.getId())+" - "+dado.getCliente()+" - "+dado.getData());
            }
            ArrayAdapter adaptador=new ArrayAdapter(EditActivity.this,android.R.layout.simple_list_item_1,lista);
            listView.setAdapter(adaptador);
            AdapterView.OnItemClickListener itemOnClick=new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    editTextCliente.setText(dados.get(position).getCliente());
                    Intent intent=new Intent(EditActivity.this,Edit2Acitivity.class);
                    intent.putExtra("id",dados.get(position).getId());
                    startActivity(intent);
                }
            };
            listView.setOnItemClickListener(itemOnClick);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if(action == MotionEvent.ACTION_UP ){
            i++;
            if(i==index){
                i=0;
            }

            editTextCliente.setText(dados.get(i).getCliente());
        }

        return super.onTouchEvent(event);

    }
}
