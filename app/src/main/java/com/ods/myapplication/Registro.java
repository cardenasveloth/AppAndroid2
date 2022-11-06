package com.ods.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class Registro extends AppCompatActivity {

    EditText usua, cla, nombre, apellido, documento, telefono ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombre = findViewById(R.id.txtNombre);
        apellido = findViewById(R.id.txtApellido);
        documento = findViewById(R.id.txtDocumento);
        telefono = findViewById(R.id.txtTelefono);
        usua = findViewById(R.id.txtUsuarior);
        cla = findViewById(R.id.txtClaver);

    }

    public void Guardar(View view){

        String nom = nombre.getText().toString();
        String ape = apellido.getText().toString();
        int doc = Integer.parseInt(documento.getText().toString());
        int tel = Integer.parseInt(telefono.getText().toString());
        String usual = usua.getText().toString();
        String cla1 = cla.getText().toString();

        Usuario user = new Usuario(nom, ape, doc, tel, usual, cla1);
        user.save();

        nombre.setText("");
        apellido.setText("");
        documento.setText("");
        telefono.setText("");
        usua.setText("");
        cla.setText("");

        Toast.makeText(getApplicationContext(), "Usuario guardado con exito", Toast.LENGTH_LONG).show();

    }

    public void Consultar(View view){
        int doc = Integer.parseInt(documento.getText().toString());

        List<Usuario> usu = Usuario.find(Usuario.class,"documento="+doc,null);
        if(usu.size()<=0) {
            Toast.makeText(getApplicationContext(),"No existe usuario",Toast.LENGTH_LONG).show();
        }
        else{
            Usuario user = usu.get(0);
            nombre.setText(user.getNombre());
            apellido.setText(user.getApellido());
            telefono.setText(""+user.getTelefono());
            usua.setText(user.getUselog());
            cla.setText(user.getClav());
        }

    }

    public void Eliminar(View view){
        int doc = Integer.parseInt(documento.getText().toString());

        List<Usuario> usu = Usuario.find(Usuario.class,"documento="+doc,null);
        Usuario user = usu.get(0);
        user.delete();
    }

    public void Actualizar(View view){
        int doc = Integer.parseInt(documento.getText().toString());

        List<Usuario> usu = Usuario.find(Usuario.class,"documento="+doc,null);
        if(usu.size()<=0) {
            Toast.makeText(getApplicationContext(),"No existe usuario",Toast.LENGTH_LONG).show();
        }
        else {
            Usuario user = usu.get(0);
            user.setNombre(nombre.getText().toString());
            user.setApellido(apellido.getText().toString());
            user.setTelefono(Integer.parseInt(telefono.getText().toString()));
            user.setUselog(usua.getText().toString());
            user.setClav(cla.getText().toString());
            user.save();
        }
    }

}