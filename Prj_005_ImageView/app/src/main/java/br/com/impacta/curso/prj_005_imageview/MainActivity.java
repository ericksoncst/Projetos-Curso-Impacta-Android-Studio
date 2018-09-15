package br.com.impacta.curso.prj_005_imageview;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView iv_foto_interna;
    private ImageView iv_foto_externa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        initVars();
        initActions();
    }

    private void initVars() {
        iv_foto_interna = (ImageView) findViewById(R.id.iv_foto_interna);
        iv_foto_externa = (ImageView) findViewById(R.id.iv_foto_externa);
    }

    private void initActions() {
        iv_foto_interna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_foto_interna.setImageResource(R.drawable.mamae);
            }
        });

        iv_foto_externa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String caminho = "/sdcard/DBase/mamae.jpg";
                //
                iv_foto_externa.setImageBitmap(
                        BitmapFactory.decodeFile(caminho)
                );
            }
        });
    }

}
