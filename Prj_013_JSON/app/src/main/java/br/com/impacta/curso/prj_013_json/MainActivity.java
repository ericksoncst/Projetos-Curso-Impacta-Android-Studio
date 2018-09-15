package br.com.impacta.curso.prj_013_json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btn_gerar_Json;
    private Button btn_ler_Json;
    //
    private Button btn_gerar_gson;
    private Button btn_ler_gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        initVars();
        initActions();
    }

    private void initVars() {
        btn_gerar_Json = (Button) findViewById(R.id.btn_gerar_json);
        btn_ler_Json = (Button) findViewById(R.id.btn_ler_json);
        //
        btn_gerar_gson = (Button) findViewById(R.id.btn_gerar_gson);
        btn_ler_gson = (Button) findViewById(R.id.btn_ler_gson);
    }

    private void initActions() {

        btn_gerar_Json.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    JSONArray ja = new JSONArray(gerarContatosJSON(20));
                    JSONObject transmissao = new JSONObject();
                    transmissao.put("contatos", ja);

                    Log.d("JSON", ja.toString());
                    Log.d("JSON", transmissao.toString());

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        btn_ler_Json.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder server = new StringBuilder();
                server.append("{\n" +
                        "\t\"contatos\": [{\n" +
                        "\t\t\"idcontato\": 1,\n" +
                        "\t\t\"nome\": \"Nome - 1\"\n" +
                        "\t}, {\n" +
                        "\t\t\"idcontato\": 2,\n" +
                        "\t\t\"nome\": \"Nome - 2\"\n" +
                        "\t}, {\n" +
                        "\t\t\"idcontato\": 3,\n" +
                        "\t\t\"nome\": \"Nome - 3\"\n" +
                        "\t}, {\n" +
                        "\t\t\"idcontato\": 4,\n" +
                        "\t\t\"nome\": \"Nome - 4\"\n" +
                        "\t}, {\n" +
                        "\t\t\"idcontato\": 5,\n" +
                        "\t\t\"nome\": \"Nome - 5\"\n" +
                        "\t}, {\n" +
                        "\t\t\"idcontato\": 6,\n" +
                        "\t\t\"nome\": \"Nome - 6\"\n" +
                        "\t}, {\n" +
                        "\t\t\"idcontato\": 7,\n" +
                        "\t\t\"nome\": \"Nome - 7\"\n" +
                        "\t}, {\n" +
                        "\t\t\"idcontato\": 8,\n" +
                        "\t\t\"nome\": \"Nome - 8\"\n" +
                        "\t}, {\n" +
                        "\t\t\"idcontato\": 9,\n" +
                        "\t\t\"nome\": \"Nome - 9\"\n" +
                        "\t}, {\n" +
                        "\t\t\"idcontato\": 10,\n" +
                        "\t\t\"nome\": \"Nome - 10\"\n" +
                        "\t}, {\n" +
                        "\t\t\"idcontato\": 11,\n" +
                        "\t\t\"nome\": \"Nome - 11\"\n" +
                        "\t}, {\n" +
                        "\t\t\"idcontato\": 12,\n" +
                        "\t\t\"nome\": \"Nome - 12\"\n" +
                        "\t}, {\n" +
                        "\t\t\"idcontato\": 13,\n" +
                        "\t\t\"nome\": \"Nome - 13\"\n" +
                        "\t}, {\n" +
                        "\t\t\"idcontato\": 14,\n" +
                        "\t\t\"nome\": \"Nome - 14\"\n" +
                        "\t}, {\n" +
                        "\t\t\"idcontato\": 15,\n" +
                        "\t\t\"nome\": \"Nome - 15\"\n" +
                        "\t}, {\n" +
                        "\t\t\"idcontato\": 16,\n" +
                        "\t\t\"nome\": \"Nome - 16\"\n" +
                        "\t}, {\n" +
                        "\t\t\"idcontato\": 17,\n" +
                        "\t\t\"nome\": \"Nome - 17\"\n" +
                        "\t}, {\n" +
                        "\t\t\"idcontato\": 18,\n" +
                        "\t\t\"nome\": \"Nome - 18\"\n" +
                        "\t}, {\n" +
                        "\t\t\"idcontato\": 19,\n" +
                        "\t\t\"nome\": \"Nome - 19\"\n" +
                        "\t}, {\n" +
                        "\t\t\"idcontato\": 20,\n" +
                        "\t\t\"nome\": \"Nome - 20\"\n" +
                        "\t}]\n" +
                        "}");

                try {
                    JSONObject recebimento = new JSONObject(server.toString());
                    JSONArray ja = recebimento.getJSONArray("contatos");
                    //
                    ArrayList<Contato> contatos = new ArrayList<Contato>();

                    for (int i = 0; i < ja.length(); i++) {
                        contatos.add(new Contato(ja.getJSONObject(i)));
                    }

                    Log.d("ST", "Hugo");

                    int a = 10;



                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        btn_gerar_gson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gson gson = new Gson();

                Transmissao env = new Transmissao();
                env.setContatos(gerarContatos(20));

                String resultado = gson.toJson(env);

                Log.d("GSON", resultado);
            }
        });

        btn_ler_gson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder server = new StringBuilder();
                server.append("{\n" +
                        "\t\"contatos\": [{\n" +
                        "\t\t\"idcontato\": 1,\n" +
                        "\t\t\"nome\": \"Nome - 1\"\n" +
                        "\t}, {\n" +
                        "\t\t\"idcontato\": 2,\n" +
                        "\t\t\"nome\": \"Nome - 2\"\n" +
                        "\t}, {\n" +
                        "\t\t\"idcontato\": 3,\n" +
                        "\t\t\"nome\": \"Nome - 3\"\n" +
                        "\t}, {\n" +
                        "\t\t\"idcontato\": 4,\n" +
                        "\t\t\"nome\": \"Nome - 4\"\n" +
                        "\t}, {\n" +
                        "\t\t\"idcontato\": 5,\n" +
                        "\t\t\"nome\": \"Nome - 5\"\n" +
                        "\t}, {\n" +
                        "\t\t\"idcontato\": 6,\n" +
                        "\t\t\"nome\": \"Nome - 6\"\n" +
                        "\t}, {\n" +
                        "\t\t\"idcontato\": 7,\n" +
                        "\t\t\"nome\": \"Nome - 7\"\n" +
                        "\t}, {\n" +
                        "\t\t\"idcontato\": 8,\n" +
                        "\t\t\"nome\": \"Nome - 8\"\n" +
                        "\t}, {\n" +
                        "\t\t\"idcontato\": 9,\n" +
                        "\t\t\"nome\": \"Nome - 9\"\n" +
                        "\t}, {\n" +
                        "\t\t\"idcontato\": 10,\n" +
                        "\t\t\"nome\": \"Nome - 10\"\n" +
                        "\t}, {\n" +
                        "\t\t\"idcontato\": 11,\n" +
                        "\t\t\"nome\": \"Nome - 11\"\n" +
                        "\t}, {\n" +
                        "\t\t\"idcontato\": 12,\n" +
                        "\t\t\"nome\": \"Nome - 12\"\n" +
                        "\t}, {\n" +
                        "\t\t\"idcontato\": 13,\n" +
                        "\t\t\"nome\": \"Nome - 13\"\n" +
                        "\t}, {\n" +
                        "\t\t\"idcontato\": 14,\n" +
                        "\t\t\"nome\": \"Nome - 14\"\n" +
                        "\t}, {\n" +
                        "\t\t\"idcontato\": 15,\n" +
                        "\t\t\"nome\": \"Nome - 15\"\n" +
                        "\t}, {\n" +
                        "\t\t\"idcontato\": 16,\n" +
                        "\t\t\"nome\": \"Nome - 16\"\n" +
                        "\t}, {\n" +
                        "\t\t\"idcontato\": 17,\n" +
                        "\t\t\"nome\": \"Nome - 17\"\n" +
                        "\t}, {\n" +
                        "\t\t\"idcontato\": 18,\n" +
                        "\t\t\"nome\": \"Nome - 18\"\n" +
                        "\t}, {\n" +
                        "\t\t\"idcontato\": 19,\n" +
                        "\t\t\"nome\": \"Nome - 19\"\n" +
                        "\t}, {\n" +
                        "\t\t\"idcontato\": 20,\n" +
                        "\t\t\"nome\": \"Nome - 20\"\n" +
                        "\t}]\n" +
                        "}");
                Gson gson = new Gson();

                Transmissao rec = gson.fromJson(
                        server.toString(),
                        Transmissao.class
                );

                int ii = 100;
            }
        });

    }

    private ArrayList<Contato> gerarContatos(int quantidade){
        ArrayList<Contato> contatos = new ArrayList<>();
        //
        for (int i = 1; i <= quantidade; i++) {
            Contato cAux = new Contato();
            cAux.setIdcontato(i);
            cAux.setNome("Nome - " + String.valueOf(i));
            //
            contatos.add(cAux);
        }
        //
        return contatos;
    }

    private ArrayList<JSONObject> gerarContatosJSON(int quantidade){
        ArrayList<JSONObject> contatos = new ArrayList<>();
        //
        for (int i = 1; i <= quantidade; i++) {
            Contato cAux = new Contato();
            cAux.setIdcontato(i);
            cAux.setNome("Nome - " + String.valueOf(i));
            //
            contatos.add(cAux.toJSONObject());
        }
        //
        return contatos;
    }

}
