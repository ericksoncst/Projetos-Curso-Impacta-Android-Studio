package br.com.impacta.curso.prj_007_listview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Context context;
    //
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
        lv_contatos.setAdapter(
                new ArrayAdapter<HMAux>(
                        context,
                        R.layout.simple_list_item_1,
                        gerarContatos(100)
                )
        );
    }

    private ArrayList<HMAux> gerarContatos(int quantidade) {
        ArrayList<HMAux> contatos = new ArrayList<>();
        //
        for (int i = 1; i <= quantidade; i++) {
            HMAux aux = new HMAux();
            aux.put(HMAux.ID, String.valueOf(i));
            aux.put(HMAux.TEXTO_01, "Nome - " + String.valueOf(i));
            //
            contatos.add(aux);
        }
        //
        return contatos;
    }

    private void initActions() {
        lv_contatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HMAux item = (HMAux) parent.getItemAtPosition(position);
                //
                Toast.makeText(context, item.get(HMAux.ID), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
