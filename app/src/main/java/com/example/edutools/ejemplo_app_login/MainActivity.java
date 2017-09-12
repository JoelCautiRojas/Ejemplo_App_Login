package com.example.edutools.ejemplo_app_login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.util.Objects;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    EditText user,pass;
    Button boton;
    String url = "http://www.programadoresperuanos.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = (EditText) findViewById(R.id.editText);
        pass = (EditText) findViewById(R.id.editText2);
        boton = (Button) findViewById(R.id.button);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncHttpClient cliente = new AsyncHttpClient();
                RequestParams datos = new RequestParams();
                datos.put("usuario",user.getText().toString());
                datos.put("clave",pass.getText().toString());
                cliente.post(getApplicationContext(), url, datos, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        if(statusCode == 200)
                        {
                            String respuesta = new String(responseBody);
                            if("valido".equals(respuesta))
                            {
                                Toast.makeText(getApplicationContext(),"Datos Correctos",Toast.LENGTH_LONG).show();
                                Intent intento = new Intent(MainActivity.this,Main2Activity.class);
                                startActivity(intento);
                            }
                            else if("invalido".equals(respuesta))
                            {
                                Toast.makeText(getApplicationContext(),"Datos Incorrectos",Toast.LENGTH_LONG).show();
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),"No se mandaron los datos correctamente",Toast.LENGTH_LONG).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        Toast.makeText(getApplicationContext(),"Error sin conexion al servidor",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
