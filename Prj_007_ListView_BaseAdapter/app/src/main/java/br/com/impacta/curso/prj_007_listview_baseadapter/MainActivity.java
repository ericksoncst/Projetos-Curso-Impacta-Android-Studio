package br.com.impacta.curso.prj_007_listview_baseadapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private ListView lv_contatos;
    private ImpactaAdapter adapter_contatos;
    private ArrayList<HMAux> contatos;

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
        lv_contatos = (ListView)
                findViewById(R.id.telainicial_lv_contatos);
        //
        gerarContatos(100);
        //
        adapter_contatos = new ImpactaAdapter(
                context,
                R.layout.celula,
                contatos
        );
        //
        lv_contatos.setAdapter(adapter_contatos);
    }

    private void gerarContatos(int quantidade) {
        contatos = new ArrayList<>();
        //
        for (int i = 1; i <= quantidade; i++) {
            HMAux item = new HMAux();
            item.put(HMAux.ID, String.valueOf(i));
            item.put(HMAux.TEXTO_01, "Nome - " + String.valueOf(i));
            item.put(HMAux.TEXTO_02, "Telefone - " + String.valueOf(i));
            //
            contatos.add(item);
        }
    }

    private void initActions() {
        lv_contatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter_contatos.setItem_selecionado(id);
            }
        });
    }

}
