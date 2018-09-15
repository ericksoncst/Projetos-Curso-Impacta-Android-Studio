package br.com.impacta.curso.lab_02_credito;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private Context context;
    //
    private LinearLayout ll_nome;
    private LinearLayout ll_idade;

    private EditText et_nome;
    private EditText et_idade;
    //
    private CheckBox cb_cidade;
    //
    private Button btn_ac;

    private String msgErro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        initVars();
        initActions();
    }

    /**
     * Inicializar as minhas variaveis locais.
     */
    private void initVars() {
        context = getBaseContext();
        //
        ll_nome = (LinearLayout) findViewById(R.id.ll_nome);
        ll_idade = (LinearLayout) findViewById(R.id.ll_idade);
        //
        et_nome = (EditText) findViewById(R.id.et_nome);
        et_idade = (EditText) findViewById(R.id.et_idade);
        //
        cb_cidade = (CheckBox) findViewById(R.id.cb_cidade);
        //
        btn_ac = (Button) findViewById(R.id.btn_ac);
    }

    private void initActions() {
        btn_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validacao()) {
                    analise_credito();
                } else {
                    exibirErro();
                }
            }
        });
    }

    private boolean validacao() {
        String nome = et_nome.getText().toString().trim();
        String idade = et_idade.getText().toString().trim();

        if (nome.length() == 0) {
            ToolBox.mostrarErroLL(context, ll_nome, true);
            //
            msgErro = "Erro: Nome é Obrigatório!!!";
            //
            return false;
        } else {
            ToolBox.mostrarErroLL(context, ll_nome, false);
        }
        //
        if (idade.length() == 0) {
            ToolBox.mostrarErroLL(context, ll_idade, true);

            msgErro = "Erro: Idade é Obrigatória!!!";
            //
            return false;
        } else {
            ToolBox.mostrarErroLL(context, ll_idade, false);
        }
        //
        if (ToolBox.conversorInt(idade) == -1) {
            ToolBox.mostrarErroLL(context, ll_idade, true);

            msgErro = "Erro: Idade Invalida!!!";
            //
            return false;
        } else {
            ToolBox.mostrarErroLL(context, ll_idade, false);
        }
        //
        return true;
    }

    private void analise_credito() {
        double credito = 0.0;
        //
        int idade = ToolBox.conversorInt(et_idade.getText().toString());

        //cidade
        if (cb_cidade.isChecked()) { // sp
            if (idade >= 25) {
                credito = 5000.0;
            } else {
                credito = 1000.0;
            }

        } else {
            if (idade >= 25) {
                credito = 2500.0;
            }
        }
        //
        ToolBox.mostrarMsg(
                context,
                String.valueOf(credito)
        );
    }

    private void exibirErro() {
        ToolBox.mostrarMsg(
                context,
                msgErro
        );
    }


}
