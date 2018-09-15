package br.com.impacta.curso.prj_010_dbase.view.act02;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.impacta.curso.prj_010_dbase.R;
import br.com.impacta.curso.prj_010_dbase.banco.Constantes;
import br.com.impacta.curso.prj_010_dbase.dao.ContatoDao;
import br.com.impacta.curso.prj_010_dbase.model.Contato;
import br.com.impacta.curso.prj_010_dbase.view.act01.Act01_main;

/**
 * Created by nalmir on 10/03/2018.
 */

public class Act02_main extends AppCompatActivity {

    private Context context;
    private ContatoDao contatoDao;

    private EditText et_codigo;
    private EditText et_nome;
    private EditText et_telefone;
    private EditText et_idade;

    private Button btn_excluir;
    private Button btn_salvar;

    private long idAtual;
    private String msgErro;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act02_main);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        initVars();
        initActions();
    }

    private void initVars() {
        context = getBaseContext();
        //
        contatoDao = new ContatoDao(context);
        //
        recuperarParametros();
        //
        initControls();
        //
        prepararFormulario();
    }

    private void recuperarParametros() {
        idAtual = getIntent().getLongExtra(Constantes.PARAMETRO_ID, 0);
    }

    private void initControls() {
        et_codigo = (EditText) findViewById(R.id.act02_main_et_codigo);
        et_nome = (EditText) findViewById(R.id.act02_main_et_nome);
        et_telefone = (EditText) findViewById(R.id.act02_main_et_telefone);
        et_idade = (EditText) findViewById(R.id.act02_main_et_idade);
        //
        btn_excluir = (Button) findViewById(R.id.act02_main_btn_excluir);
        btn_salvar = (Button) findViewById(R.id.act02_main_btn_salvar);
    }

    private void prepararFormulario() {
        if (idAtual == -1) {
            btn_excluir.setEnabled(false);
            //
            et_nome.requestFocus();
        } else {
            btn_excluir.setEnabled(true);
            //
            Contato cAux = contatoDao.obterContatoByID(idAtual);
            //
            et_codigo.setText(String.valueOf(cAux.getIdcontato()));
            et_nome.setText(cAux.getNome());
            et_telefone.setText(cAux.getTelefone());
            et_idade.setText(String.valueOf(cAux.getIdade()));
        }
    }


    private void initActions() {
        btn_excluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contatoDao.apagarContato(idAtual);
                //
                chamarAct01();
            }
        });

        btn_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validacao()) {
                    salvar();
                } else {
                    exibirMensagem(msgErro);
                }
            }
        });
    }

    private boolean validacao() {
        String nome = et_nome.getText().toString().trim();
        String telefone = et_telefone.getText().toString().trim();
        String idade = et_idade.getText().toString().trim();

        if (nome.length() == 0) {
            msgErro = "Erro: Ta Loucao. Nome é Obrigatorio!!!";

            return false;
        }
        //
        if (telefone.length() == 0) {
            msgErro = "Erro: Ta Biruta. Telefone é Obrigatorio!!!";

            return false;
        }
        //
        if (idade.length() == 0) {
            msgErro = "Erro: Vá pro Inferno. Idade é Obrigatorio!!!";

            return false;
        }
        //
        try {
            Integer.parseInt(idade);
        } catch (Exception e) {
            msgErro = "Erro: Meu Deus. Qual é o seu problema? Idade Invalidade!!!";

            return false;
        }

        return true;
    }

    private void salvar() {
        String nome = et_nome.getText().toString().trim();
        String telefone = et_telefone.getText().toString().trim();
        int idade = Integer.parseInt(et_idade.getText().toString().trim());
        //
        Contato cAux = new Contato();
        cAux.setNome(nome);
        cAux.setTelefone(telefone);
        cAux.setIdade(idade);
        //
        if (idAtual != -1) {
            cAux.setIdcontato(idAtual);
            contatoDao.alterarContato(cAux);
        } else {
            idAtual = contatoDao.proximoID();
            cAux.setIdcontato(idAtual);
            contatoDao.inserirContato(cAux);
            //
            et_codigo.setText(String.valueOf(idAtual));
            btn_excluir.setEnabled(true);
        }

    }

    private void exibirMensagem(String mensagem) {
        Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show();
    }

    private void chamarAct01() {
        Intent mIntent = new Intent(context, Act01_main.class);
        startActivity(mIntent);
        //
        finish();
    }

    @Override
    public void onBackPressed() {
        alerta();
    }

    private void alerta(){
        AlertDialog.Builder alerta =
                new AlertDialog.Builder(Act02_main.this);
        alerta.setTitle("Saida de Cadastro");
        alerta.setMessage("Deseja Realmente Sair?");
        alerta.setCancelable(false);
        alerta.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                chamarAct01();
            }
        });
        alerta.setNegativeButton("Nao", null);
        //
        alerta.show();
    }
}
