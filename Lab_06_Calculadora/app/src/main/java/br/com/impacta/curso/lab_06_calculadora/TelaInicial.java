package br.com.impacta.curso.lab_06_calculadora;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelaInicial extends AppCompatActivity {

    private static final int PROCESSO_SOMA = 1;

    private Context context;

    private EditText et_x;
    private EditText et_y;

    private Button btn_somar;

    private String mensagem;

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
        et_x = (EditText) findViewById(R.id.telainicial_tv_x);
        et_y = (EditText) findViewById(R.id.telainicial_tv_y);
        //
        btn_somar = (Button) findViewById(R.id.telainicial_btn_somar);
    }

    private void initActions() {
        btn_somar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validacao()) {
                    chamarDetalhe(
                            et_x.getText().toString(),
                            et_y.getText().toString()
                    );
                } else {
                    exibirMensagem(mensagem);
                }
            }
        });
    }

    private boolean validacao() {
        String var_x = et_x.getText().toString().trim();
        String var_y = et_y.getText().toString().trim();

        if (var_x.length() == 0) {
            mensagem = "Erro: X é Obrigatório!!!";

            return false;
        }
        //
        if (var_y.length() == 0) {
            mensagem = "Erro: Y é Obrigatório!!!";

            return false;
        }
        //
        try {
            int x = converterInteger(var_x);
        } catch (Exception e) {
            mensagem = "Erro: Valor de X é Invalido!!!";

            return false;
        }
        //
        try {
            int y = converterInteger(var_y);
        } catch (Exception e) {
            mensagem = "Erro: Valor de Y é Invalido!!!";

            return false;
        }

        return true;
    }

    private int converterInteger(String valor) throws Exception {
        return Integer.parseInt(valor);
    }

    private void chamarDetalhe(String x, String y) {
        Intent mIntent = new Intent(context, Detalhe.class);
        mIntent.putExtra(Constantes.VAR_X, x);
        mIntent.putExtra(Constantes.VAR_Y, y);
        //
        startActivityForResult(mIntent, PROCESSO_SOMA);
    }

    private void exibirMensagem(String mensagem) {
        Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case PROCESSO_SOMA:
                processar_soma(resultCode, data);
                break;
            default:
                break;
        }

    }

    private void processar_soma(int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            exibirMensagem(String.valueOf(data.getIntExtra(Constantes.VAR_X_Y, -1)));
        } else {
            exibirMensagem("Cancelado!!!");
        }
    }
}
