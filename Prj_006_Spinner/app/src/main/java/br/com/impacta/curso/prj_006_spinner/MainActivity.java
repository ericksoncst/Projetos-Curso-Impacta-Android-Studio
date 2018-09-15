package br.com.impacta.curso.prj_006_spinner;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private Context context;

    // Spinner Educacional
    private Spinner sp_nomes; // combobox
    private ArrayAdapter<String> adapter_nomes; // adaptador
    private ArrayList<String> nomes; // colecao de nomes

    // Spinner Produtos
    private Spinner sp_produtos; // combobox
    private ArrayAdapter<Produto> adapter_produtos; // adaptador
    private ArrayList<Produto> produtos; // colecao de produtos

    // Spinner Produtos_HM
    private Spinner sp_produtos_hm; // combobox
    private ArrayAdapter<HMAux> adapter_produtos_hm; // adaptador
    private ArrayList<HMAux> produtos_hm; // colecao de produtos


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
        // Inicializacao do Spinner Educacional
        initEducacional();
        initClasse();
        initEspecial();

    }

    private void initEducacional() {
        sp_nomes = (Spinner) findViewById(R.id.sp_nomes);
        //
        gerarNomes(100); // Gerador de Carga
        //
        adapter_nomes = new ArrayAdapter<String>(
                context,
                android.R.layout.simple_spinner_item,
                nomes
        );
        adapter_nomes.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );
        //
        sp_nomes.setAdapter(adapter_nomes);
        // selecionar a opcao do banco
        sp_nomes.setSelection(procuraIndice(sp_nomes, "Nome - 5000"));
        // ler da tela para grava no BD.
        String nome = (String) sp_nomes.getSelectedItem();
    }

    private int procuraIndice(Spinner sp_nomes, String texto) {
        for (int i = 1; i < sp_nomes.getCount(); i++) {
            String nome = (String) sp_nomes.getItemAtPosition(i);
            //
            if (nome.equalsIgnoreCase(texto)) {
                return i;
            }
        }

        return 0;
    }

    private void gerarNomes(int quantidade) {
        nomes = new ArrayList<>(); // criei uma lista VAZIA
        //
        nomes.add("< Selecionar um Nome >");
        //
        for (int i = 1; i <= quantidade; i++) {
            nomes.add("Nome - " + String.valueOf(i));
        }
    }

    private void initEspecial() {
        sp_produtos_hm = (Spinner) findViewById(R.id.sp_produtos_hm);
        //
        gerarProdutos_hm(100); // Gerador de Carga
        //
        adapter_produtos_hm = new ArrayAdapter<HMAux>(
                context,
                android.R.layout.simple_spinner_item,
                produtos_hm
        );
        adapter_produtos_hm.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );
        //
        sp_produtos_hm.setAdapter(adapter_produtos_hm);
    }

    private void gerarProdutos_hm(int quantidade) {
        produtos_hm = new ArrayList<>(); // criei uma lista VAZIA
        //
        HMAux coringa = new HMAux();
        coringa.put(HMAux.ID, "-1");
        coringa.put(HMAux.TEXTO_01, "< Selecionar um Produto >");
        //
        produtos_hm.add(coringa);
        //
        for (int i = 1; i <= quantidade; i++) {
            HMAux pAux = new HMAux();
            pAux.put(HMAux.ID, String.valueOf(i));
            pAux.put(HMAux.TEXTO_01, "Produto - " + String.valueOf(i));
            //
            produtos_hm.add(pAux);
        }
    }


    private void gerarProdutos(int quantidade) {
        produtos = new ArrayList<>(); // criei uma lista VAZIA
        //
        Produto coringa = new Produto();
        coringa.setNome("< Selecionar um Produto >");
        //
        produtos.add(coringa);
        //
        for (int i = 1; i <= quantidade; i++) {
            Produto pAux = new Produto();
            pAux.setIdproduto(i);
            pAux.setNome("Produto - " + String.valueOf(i));
            pAux.setPreco(0.5 * i);
            pAux.setQtd(2 * i);
            pAux.setBarcode("BarCode - " + String.valueOf(i));
            //
            produtos.add(pAux);
        }
    }

    private void initClasse() {
        sp_produtos = (Spinner) findViewById(R.id.sp_produtos);
        //
        gerarProdutos(100); // Gerador de Carga
        //
        adapter_produtos = new ArrayAdapter<Produto>(
                context,
                android.R.layout.simple_spinner_item,
                produtos
        );
        adapter_produtos.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );
        //
        sp_produtos.setAdapter(adapter_produtos);

    }


    private void initActions() {

    }

}
