package br.com.impacta.curso.lab_04_herois;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private ListView lv_herois;



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
                findViewById(R.id.lv_herois);
        //
        criarLista();
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

    private String[] nomes = {
            "Gaviao Arqueiro",
            "War Machine",
            "Thor",
            "Nick Fury",
            "Loke",
            "Iron Man",
            "Hulk",
            "Ant Man",
            "Capitao America",
            "Viuva Negra",
            "Agento Calson"
    };

    private String[] poderes = {
            "Nao tem",
            "Ter um amigo rico",
            "Martelo",
            "Gerenciar Egos",
            "Deu po Cavalo",
            "O amigo Rico",
            "Paciencia",
            "Ser pequeno",
            "Chato",
            "Gostosa",
            "Merecia Morrer"
    };

    private void criarLista() {
        ArrayList<HMAux> herois = new ArrayList<>();
        //
        for (int i = 0; i < fotos.length; i++) {
            HMAux aux = new HMAux();
            aux.put(HMAux.ID, String.valueOf(i + 1));
            aux.put(HMAux.TEXTO_01, String.valueOf(fotos[i]));
            aux.put(HMAux.TEXTO_02, nomes[i]);
            aux.put(HMAux.TEXTO_03, poderes[i]);
            //
            herois.add(aux);
        }
        //
        String[] De = {HMAux.TEXTO_01, HMAux.TEXTO_02};
        int[] Para = {R.id.celula_iv_foto, R.id.celula_tv_nome};
        lv_herois.setAdapter(
                new SimpleAdapter(
                        context,
                        herois,
                        R.layout.celula,
                        De,
                        Para
                )
        );

    }

    private void initActions() {
        lv_herois.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                HMAux item = (HMAux) parent.getItemAtPosition(position);

                Toast.makeText(context, item.get(HMAux.TEXTO_03), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
