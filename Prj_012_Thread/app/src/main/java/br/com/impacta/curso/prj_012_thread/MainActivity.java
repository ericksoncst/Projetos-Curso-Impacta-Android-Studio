package br.com.impacta.curso.prj_012_thread;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private TextView tv_c;
    private Button btn_pd;

    private Button btn_play;
    private Button btn_stop;

    private Button btn_ds2;

    private int indice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        initVars();
        initActions();
    }

    private void initVars() {
        context = getBaseContext();

        tv_c = (TextView) findViewById(R.id.tv_c);
        btn_pd = (Button) findViewById(R.id.btn_pd);
        btn_play = (Button) findViewById(R.id.btn_play);
        btn_stop = (Button) findViewById(R.id.btn_stop);
        btn_ds2 = (Button) findViewById(R.id.btn_ds2);
    }

    private void initActions() {
        btn_pd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //processoDemodorado();
                processoDemoradoComAT();
            }
        });

        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(context, TocadorService.class);
                startService(mIntent);
            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(context, TocadorService.class);
                stopService(mIntent);
            }
        });

        btn_ds2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!DS2.status) {
                    Intent mIntent = new Intent(context, DS2.class);
                    startService(mIntent);
                }
            }
        });
    }

    private void processoDemodorado() {
        btn_pd.setEnabled(false);
        //
        try {
            indice = 0;
            while (indice < 25) {
                Thread.sleep(1000);
                indice++;
                //
                tv_c.setText(String.valueOf(indice));
            }
        } catch (InterruptedException e) {
        }
        //
        btn_pd.setEnabled(true);

    }

    private void processoDemoradoComAT() {
        new Sincronismo().execute();
    }


    private class Sincronismo extends AsyncTask<Void, Integer, Void> {

        // UI Thread - Tem Acesso a Tela
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //
            btn_pd.setEnabled(false);
            tv_c.setText("0");
        }

        // Nao Acessa a Tela
        @Override
        protected Void doInBackground(Void... params) {

            try {
                indice = 0;
                while (indice < 25) {
                    Thread.sleep(1000);
                    indice++;
                    //
                    publishProgress(indice);
                }
            } catch (InterruptedException e) {
            }


            return null;
        }

        // UI Thread - Tem Acesso a Tela
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            //
            tv_c.setText(String.valueOf(values[0]));
        }

        // UI Thread - Tem Acesso a Tela
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            //
            btn_pd.setEnabled(true);
        }
    }

}
