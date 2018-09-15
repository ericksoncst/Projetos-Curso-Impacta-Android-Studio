package br.com.impacta.curso.lab_06_calculadora;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by nalmir on 10/03/2018.
 */

public class Detalhe extends AppCompatActivity {

    private Context context;

    private TextView tv_parametros;
    private Button btn_rs;

    private int mX;
    private int mY;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalhe);

        initVars();
        initActions();
    }

    private void initVars() {
        context = getBaseContext();
        //
        recuperarParametros();
        //
        tv_parametros = (TextView)
                findViewById(R.id.detalhe_tv_parametros);
        btn_rs = (Button)
                findViewById(R.id.detalhe_btn_rs);
        //
        StringBuilder sb = new StringBuilder();
        sb
                .append(mX)
                .append(" + ")
                .append(mY);

        tv_parametros.setText(sb.toString());
    }

    private void recuperarParametros() {
        mX = Integer.parseInt(
                getIntent().getStringExtra(Constantes.VAR_X));
        //
        mY = Integer.parseInt(
                getIntent().getStringExtra(Constantes.VAR_Y));
    }

    private void initActions() {
        btn_rs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soma = mX + mY;
                //
                Intent data = new Intent();
                data.putExtra(Constantes.VAR_X_Y, soma);
                //
                setResult(RESULT_OK, data);
                //
                finish();
            }
        });

    }

}
