package br.com.impacta.curso.prj_009_multitelas;

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

public class Calculo extends AppCompatActivity {

    private Context context;

    private TextView tv_parametro;
    private Button btn_m100;

    private boolean status_recreate;
    private int parametro_valor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculo);

        initVars();
        initActions();
    }

    private void initVars() {
        context = getBaseContext();
        //
        recuperaParametros();
        //
        tv_parametro = (TextView)
                findViewById(R.id.calculo_tv_parametro);
        btn_m100 = (Button)
                findViewById(R.id.calculo_btn_m100);
        //
        atualizarTela();
    }

    private void atualizarTela() {
        tv_parametro.setText(String.valueOf(parametro_valor));
        //
        if (status_recreate) {
            btn_m100.setEnabled(false);
        } else {
            btn_m100.setEnabled(true);
        }
    }

    private void recuperaParametros() {
        if (getIntent().getIntExtra(Constantes.PARAMETRO_TIPO, -1) == 1) {
            status_recreate = true;
        } else {
            status_recreate = false;
        }
        //
        parametro_valor = getIntent().getIntExtra(Constantes.PARAMETRO_VALOR, -1);
    }

    private void initActions() {
        btn_m100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int resultado = parametro_valor * 100;
                //
                Intent data = new Intent();
                data.putExtra(Constantes.PARAMETRO_RETORNO, resultado);
                //
                setResult(RESULT_OK, data);
                //
                onBackPressed();
            }
        });
    }


    // Reprogramar o botao de retorno

    @Override
    public void onBackPressed() {
        chamarTelaInicial(status_recreate);
    }

    private void chamarTelaInicial(boolean recreate) {
        if (recreate) {
            Intent mIntent = new
                    Intent(context, MainActivity.class);
            startActivity(mIntent);
            //
            finish();
        } else {
            //super.onBackPressed();
            finish();
        }
    }
}
