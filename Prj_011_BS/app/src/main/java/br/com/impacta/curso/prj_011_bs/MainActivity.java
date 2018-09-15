package br.com.impacta.curso.prj_011_bs;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private Button btn_abacaxi;

    private int indice = 0;

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
        btn_abacaxi = (Button)
                findViewById(R.id.btn_abacaxi);
    }

    private void initActions() {
        btn_abacaxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent();
                mIntent.setAction("ABACAXI");
                mIntent.addCategory(Intent.CATEGORY_DEFAULT);
                mIntent.putExtra("indice", ++indice);
                //
                context.sendBroadcast(mIntent);
            }
        });
    }

}
