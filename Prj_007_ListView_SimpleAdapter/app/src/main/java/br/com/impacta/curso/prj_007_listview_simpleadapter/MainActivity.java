package br.com.impacta.curso.prj_007_listview_simpleadapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private ListView lv_contatos;

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
        lv_contatos = (ListView) findViewById(R.id.lv_contatos);
        //
        initCol();
    }

    private void initCol() {
        String[] De = {HMAux.TEXTO_01, HMAux.TEXTO_02};
        int[] Para = {R.id.celula_tv_nome, R.id.celula_tv_telefone};
        lv_contatos.setAdapter(
                new SimpleAdapter(
                        context,
                        gerarContatos(20),
                        R.layout.celula,
                        De,
                        Para
                )
        );
    }

    private ArrayList<HMAux> gerarContatos(int quantidade) {
        ArrayList<HMAux> hmAuxes = new ArrayList<>();
        //
        for (int i = 1; i <= quantidade; i++) {
            HMAux aux = new HMAux();
            aux.put(HMAux.ID, String.valueOf(i));
            aux.put(HMAux.TEXTO_01, "Nome - " + String.valueOf(i));
            aux.put(HMAux.TEXTO_02, "Telefone - " + String.valueOf(i));
            //
            hmAuxes.add(aux);
        }
        //
        return hmAuxes;
    }

    private void initActions() {

    }

}
