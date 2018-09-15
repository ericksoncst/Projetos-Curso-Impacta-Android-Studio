package br.com.impacta.curso.prj_008_ciclodevida;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private EditText et_valor;
    private Button btn_mudar;
    private Button btn_mostrar;

    private String valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("ciclo_de_vida", "onCreate");

        setContentView(R.layout.telainicial);
        initVars(savedInstanceState);
        initActions();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        Log.d("ciclo_de_vida", "onSaveInstanceState");

        outState.putString("valor_var", valor);

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        Log.d("ciclo_de_vida", "onDestroy");

        super.onDestroy();
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("ciclo_de_vida", "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("ciclo_de_vida", "onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("ciclo_de_vida", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("ciclo_de_vida", "onPause");
    }

    private void initVars(Bundle savedInstanceState) {
        context = getBaseContext();
        //
        et_valor = (EditText) findViewById(R.id.et_valor);
        btn_mudar = (Button) findViewById(R.id.btn_mudar);
        btn_mostrar = (Button) findViewById(R.id.btn_mostrar);
        //
        if (savedInstanceState == null) {
            valor = "sem valor";
        } else {
            valor = savedInstanceState.getString("valor_var");
        }
    }

    private void initActions() {
        btn_mudar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valor = et_valor.getText().toString();
            }
        });

        btn_mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, valor, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
