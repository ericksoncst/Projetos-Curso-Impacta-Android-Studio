package br.com.impacta.curso.lab_03_produtos;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private ListView lv_promocao;

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
        lv_promocao = (ListView) findViewById(R.id.lv_promocao);
        //
        initColecao();
    }

    private void initColecao() {
        lv_promocao.setAdapter(
                new ArrayAdapter<HMAux>(
                        context,
                        android.R.layout.simple_list_item_1,
                        gerarPromocao(100)
                )
        );
    }

    private ArrayList<HMAux> gerarPromocao(int quantidade) {
        ArrayList<HMAux> promocoes = new ArrayList<>();
        //
        for (int i = 1; i <= quantidade; i++) {
            HMAux hmAux = new HMAux();
            hmAux.put(HMAux.ID, String.valueOf(i));
            hmAux.put(HMAux.TEXTO_01, "Promocao - " + String.valueOf(i));
            hmAux.put(HMAux.TEXTO_02, String.valueOf(i * 0.5));
            //
            promocoes.add(hmAux);
        }
        //
        return promocoes;
    }

    private void initActions() {

        lv_promocao.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HMAux item = (HMAux) parent.getItemAtPosition(position);
                //
                int index = Integer.parseInt(item.get(HMAux.ID));
                //
                String resultado = null;
                //
                if ((index % 2) == 0) {
                    resultado = "Promocao - " + item.get(HMAux.TEXTO_02);
                } else {
                    resultado = item.get(HMAux.TEXTO_02);
                }
                //
                Toast.makeText(context, resultado, Toast.LENGTH_SHORT).show();
            }
        });

    }

}
