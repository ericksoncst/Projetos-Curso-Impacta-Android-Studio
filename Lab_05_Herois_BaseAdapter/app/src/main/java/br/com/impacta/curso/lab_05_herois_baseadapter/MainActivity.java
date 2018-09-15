package br.com.impacta.curso.lab_05_herois_baseadapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private ListView lv_herois;
    private ArrayList<HMAux> herois;
    private ImpactaAdapter adapter_herois;

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
        lv_herois = (ListView)
                findViewById(R.id.telainicial_lv_herois);
        //
        gerarHerois();
        //
        adapter_herois = new ImpactaAdapter(
                context,
                R.layout.celula,
                herois
        );
        //
        lv_herois.setAdapter(adapter_herois);
    }

    private int[] fotos = {
            R.drawable.avenger01,
            R.drawable.avenger02,
            R.drawable.avenger03,
            R.drawable.avenger04,
            R.drawable.avenger05,
            R.drawable.avenger06,
            R.drawable.avenger07,
            R.drawable.avenger08,
            R.drawable.avenger09,
            R.drawable.avenger10,
            R.drawable.avenger11
    };

    private String nomes[] = {
            "Nome 1",
            "Nome 2",
            "Nome 3",
            "Nome 4",
            "Nome 5",
            "Nome 6",
            "Nome 7",
            "Nome 8",
            "Nome 9",
            "Nome 10",
            "Nome 11"
    };

    private void gerarHerois() {
        herois = new ArrayList<>();
        //
        for (int i = 0; i < fotos.length; i++) {
            HMAux item = new HMAux();
            item.put(HMAux.ID, String.valueOf(i + 1));
            item.put(HMAux.TEXTO_01, String.valueOf(fotos[i]));
            item.put(HMAux.TEXTO_02, nomes[i]);
            //
            herois.add(item);
        }
    }

    private void initActions() {
        lv_herois.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter_herois.setItem_selecionado(id);
            }
        });

    }

}
