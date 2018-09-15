package br.com.impacta.curso.lab_01_credencais;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private EditText et_nome;
    private EditText et_senha;

    private Button btn_cancelar;
    private Button btn_login;

    private String msgAux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        initVars();
        initActions();
    }

    /**
     * Inicializacao de Variavies
     */
    private void initVars() {
        context = getBaseContext();
        //
        et_nome = (EditText) findViewById(R.id.et_nome);
        et_senha = (EditText) findViewById(R.id.et_senha);
        //
        btn_cancelar = (Button) findViewById(R.id.btn_cancelar);
        btn_login = (Button) findViewById(R.id.btn_login);
    }

    /**
     * Inicializacao das acoes dos botoes Cancelar / Login
     */
    private void initActions() {
        btn_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparFormulario();
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validar()) {
                    validar_credencais();
                } else {
                    exibirErro(msgAux);
                }
            }
        });
    }

    private void limparFormulario() {
        et_nome.setText("");
        et_senha.setText("");
        //
        et_nome.requestFocus();
    }

    private boolean validar() {
        String nome = et_nome.getText().toString().trim();
        String senha = et_senha.getText().toString().trim();

        if (nome.length() == 0) {
            msgAux = getString(R.string.warning_nome);

            return false;
        }

        if (senha.length() == 0) {
            msgAux = getString(R.string.warning_senha);

            return false;
        }

        return true;
    }

    private void validar_credencais() {
        String nome = et_nome.getText().toString().trim();
        String senha = et_senha.getText().toString().trim();
        //
        if (!nome.equalsIgnoreCase("Hugo") ||
                !senha.equals("T123")  ){
            ToolBox.exibirMensagem(context, getString(R.string.warning_credenciais));
        } else {
            ToolBox.exibirMensagem(context, getString(R.string.mensagem_credenciais_validas));
        }

    }

    private void exibirErro(String msgAux) {
        ToolBox.exibirMensagem(context, msgAux);
    }

}
