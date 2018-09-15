package br.com.impacta.curso.prj_004_cb_rb_tb;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private CheckBox cb_ios;
    private CheckBox cb_android;

    private RadioGroup rg;
    private RadioButton rb_m;
    private RadioButton rb_f;

    private ToggleButton tb_tomada;

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
        cb_ios = (CheckBox) findViewById(R.id.cb_ios);
        cb_android = (CheckBox) findViewById(R.id.cb_android);
        //
        rg = (RadioGroup) findViewById(R.id.rg);
        rb_m = (RadioButton) findViewById(R.id.rb_m);
        rb_f = (RadioButton) findViewById(R.id.rb_f);
        //
        tb_tomada = (ToggleButton) findViewById(R.id.tb_tomada);
        //
        FromDB_ToScreen();
        //
        FromScreen_ToDB();
    }

    private void FromDB_ToScreen() {
        int ios = 1; // Sei iOS
        int android = 0; // Nao Sei Android

        String sexo = "m"; // M - masculino / F - Feminino

        boolean tomada = true; // true - ligado / false - desligado
        //
        if (ios == 1){
            cb_ios.setChecked(true);
        } else {
            cb_ios.setChecked(false);
        }
        //
        if (android == 1){
            cb_android.setChecked(true);
        } else {
            cb_android.setChecked(false);
        }
        //
        switch (sexo){
            case "m":
                rb_m.setChecked(true);
                break;
            case "f":
                rb_f.setChecked(true);
                break;
            default:

                break;
        }
        //
        tb_tomada.setChecked(tomada);



    }

    private void FromScreen_ToDB() {
        int ios = -1; // Sei iOS
        int android = -1; // Nao Sei Android

        String sexo = ""; // M - masculino / F - Feminino

        boolean tomada = false; // true - ligado / false - desligado

        if (cb_ios.isChecked()){
            ios = 1;
        } else {
            ios = 0;
        }
        //
        if (cb_android.isChecked()){
            android = 1;
        } else {
            android = 0;
        }
        //
        switch (rg.getCheckedRadioButtonId()){
            case R.id.rb_m:
                sexo = "m";
                break;
            case R.id.rb_f:
                sexo = "f";
                break;
            default:
                break;
        }
        //
        tomada = tb_tomada.isChecked();
        //
        cb_ios.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                String resultado = "";

                if (isChecked){
                    resultado = "Eu sei iOS";
                } else {
                    resultado = "Eu NAO sei iOS";
                }

                Toast.makeText(context, resultado, Toast.LENGTH_SHORT).show();
            }
        });
        //
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

                String resultado = "";

                switch (checkedId){
                    case R.id.rb_m:
                        resultado = "Masculino";
                        break;

                    case R.id.rb_f:
                        resultado = "Feminino";
                        break;
                    default:
                        resultado = "Nao Implementado";
                        break;
                }

                Toast.makeText(context, resultado, Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void initActions() {

    }

}
