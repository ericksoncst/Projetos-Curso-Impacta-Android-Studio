package br.com.impacta.curso.prj_007_listview_interface;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private ListView lv_posts;
    private PostAdapter adapter_posts;
    private ArrayList<HMAux> posts;

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
        lv_posts = (ListView)
                findViewById(R.id.telainicial_lv_posts);
        //
        gerarPosts(100);
        //
        adapter_posts = new PostAdapter(
                context,
                R.layout.celula,
                posts
        );
        adapter_posts.setOnInformarStatusPostListener(new PostAdapter.IPostAdapter() {
            @Override
            public void informarStatusPost(String id, String status) {
                atualizacao(id, status);
            }
        });
        //
        lv_posts.setAdapter(adapter_posts);
    }

    private void atualizacao(String id, String status) {
        for (HMAux aux : posts) {
            if (aux.get(HMAux.ID).equals(id)) {
                aux.put(HMAux.TEXTO_02, status);
                //
                break;
            }
        }
    }

    private void gerarPosts(int quantidade) {
        posts = new ArrayList<>();
        //
        for (int i = 1; i <= quantidade; i++) {
            HMAux item = new HMAux();
            item.put(HMAux.ID, String.valueOf(i));
            item.put(HMAux.TEXTO_01, "Post - " + String.valueOf(i));
            item.put(HMAux.TEXTO_02, String.valueOf(i % 2));
            //
            posts.add(item);
        }
    }

    private void initActions() {
        lv_posts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HMAux item = (HMAux) parent.getItemAtPosition(position);
                //
                Toast.makeText(context, item.get(HMAux.TEXTO_01), Toast.LENGTH_SHORT).show();
            }
        });
    }



}
