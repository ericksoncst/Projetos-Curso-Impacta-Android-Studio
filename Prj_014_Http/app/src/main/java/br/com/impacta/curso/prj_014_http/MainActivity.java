package br.com.impacta.curso.prj_014_http;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private ListView lv_contatos;

    private ProgressDialog progressDialog;

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
                findViewById(R.id.lv_contatos);
        //
        new Sincronismo().execute(gerarContatos(10));

    }

    private void initActions() {

    }

    private class Sincronismo extends AsyncTask<ArrayList<Contato>, Void, ArrayList<Contato>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("Sincronismo");
            progressDialog.setMessage("Aguarde. Sincronismo sendo realizado...");
            progressDialog.setCancelable(false);
            //
            progressDialog.show();
        }

        @Override
        protected ArrayList<Contato> doInBackground(ArrayList<Contato>... params) {
            Transmissao_Rec rec;

            try {
                Gson gson = new Gson();
                Transmissao_Env env = new Transmissao_Env();
                env.setContatos(params[0]);


                String resultado = ToolBox.cominicacao(
                        "http://www.nmsystems.com.br/testecarga.php",
                        gson.toJson(env)
                );

                rec = gson.fromJson(
                        resultado,
                        Transmissao_Rec.class
                );

            } catch (Exception e) {
                return null;
            }

            return rec.getContatos();
        }

        @Override
        protected void onPostExecute(ArrayList<Contato> contatos) {
            super.onPostExecute(contatos);
            //
            if (contatos != null) {
                lv_contatos.setAdapter(
                        new ArrayAdapter<Contato>(
                                context,
                                android.R.layout.simple_list_item_1,
                                contatos
                        )
                );
            }
            //
            progressDialog.dismiss();
        }
    }


    private ArrayList<Contato> gerarContatos(int quantidade) {
        ArrayList<Contato> contatos = new ArrayList<>();
        //
        for (int i = 1; i <= quantidade; i++) {
            contatos.add(new Contato(
                    i,
                    "Nome - " + String.valueOf(i)
            ));
        }
        //
        return contatos;
    }

}
