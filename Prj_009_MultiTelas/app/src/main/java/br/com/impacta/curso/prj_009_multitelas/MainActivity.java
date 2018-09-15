package br.com.impacta.curso.prj_009_multitelas;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int PROCESSO_M100 = 10;

    private Context context;

    private Button btn_cs;
    private Button btn_cr;
    private Button btn_ct;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);
        initVars();
        initActions();
    }

    private void initVars() {
        context = getBaseContext();
        //
        btn_cs = (Button)
                findViewById(R.id.telainicial_btn_cs);
        btn_cr = (Button)
                findViewById(R.id.telainicial_btn_cr);
        btn_ct = (Button)
                findViewById(R.id.telainicial_btn_ct);
    }

    private void initActions() {
        btn_cs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mensagem para Android
                Intent mIntent = new Intent(context, Calculo.class);
                // Incluindo Parametros
                mIntent.putExtra(Constantes.PARAMETRO_TIPO, 1);
                mIntent.putExtra(Constantes.PARAMETRO_VALOR, 50);
                // Disparar a mensagem solicitando a carga da tela
                startActivity(mIntent);
                //
                finish();
                //
                Toast.makeText(context, "O Nóis aqui Véi!!!", Toast.LENGTH_SHORT).show();
            }
        });

        btn_cr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mensagem para Android
                Intent mIntent = new Intent(context, Calculo.class);
                // Incluindo Parametros
                mIntent.putExtra(Constantes.PARAMETRO_TIPO, 2);
                mIntent.putExtra(Constantes.PARAMETRO_VALOR, 100);
                // Disparar a mensagem solicitando a carga da tela
                startActivityForResult(mIntent, PROCESSO_M100);
            }
        });

        btn_ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_CALL,
                        Uri.parse("tel:" + "99999"));
                startActivity(mIntent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case PROCESSO_M100:
                processar_M100(resultCode, data);
                break;
            default:
                break;
        }
    }

    private void processar_M100(int resultCode, Intent data) {
        String resultado = null;

        if(resultCode == RESULT_OK){
            resultado = String.valueOf(data.getIntExtra(Constantes.PARAMETRO_RETORNO, -1));
        } else {
            resultado = "Cancelado!!!";
        }

        Toast.makeText(context, resultado, Toast.LENGTH_SHORT).show();
    }
}
