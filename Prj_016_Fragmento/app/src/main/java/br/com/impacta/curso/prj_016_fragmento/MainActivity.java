package br.com.impacta.curso.prj_016_fragmento;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private F01 mF01;
    private F02 mF02;

    private FragmentManager fm;

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
        fm = getSupportFragmentManager();
        //
        mF01 = (F01) fm.findFragmentById(R.id.telainicial_f1);
        mF01.setOnMudarOTextoListener(new F01.IF01() {
            @Override
            public void mudarOTexto(String texto) {
                mF02.modificarTexto(texto);
            }
        });
        mF02 = (F02) fm.findFragmentById(R.id.telainicial_f2);
    }

    private void initActions() {

    }

//    public void erradoMudar(String Texto){
//        mF02.modificarTexto(Texto);
//    }

}
