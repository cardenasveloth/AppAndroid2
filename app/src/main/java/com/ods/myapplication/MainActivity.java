package com.ods.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText usuario,pass;
    Button ingreso, registro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = findViewById(R.id.txtUsuario);
        pass = findViewById(R.id.txtPass);

        ingreso = findViewById(R.id.btnIngreso);
        registro = findViewById(R.id.btnRegistro);

        ingreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usu = usuario.getText().toString();
                String passw = pass.getText().toString();

                if(usu.isEmpty() && passw.isEmpty()){
                    usuario.setError("Diligencie el campo usuario");
                    pass.setError("Diligencie el campo usuario");
                    return;
                }


                List<Usuario> nameuser = Usuario.findWithQuery(Usuario.class,"Select * from Usuario where uselog =? ", usu);
                Usuario user = nameuser.get(0);
                String name = user.getUselog();
                String passwo = user.getClav();

                if (name.equals(usu) && passwo.equals(passw)) {
                    Intent i = new Intent(MainActivity.this, Aplicacion.class);
                    i.putExtra("usuario",usu);
                    i.putExtra("pass", passw);
                    startActivity(i);
                    limpiar();

                    Toast.makeText(getApplicationContext(), "Ingreso satisfactorio", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Usario o contraseña invalidos", Toast.LENGTH_LONG).show();
                }
            }
        });

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Pulsado registro",Toast.LENGTH_LONG).show();
                Intent i = new Intent(MainActivity.this,Registro.class);
                startActivity(i);

            }
        });


        }
        public void limpiar(){
        usuario.setText("");
        pass.setText("");
        }
}