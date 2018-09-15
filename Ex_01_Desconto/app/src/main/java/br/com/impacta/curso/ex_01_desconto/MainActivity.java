package br.com.impacta.curso.ex_01_desconto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private EditText et_desconto;
    private EditText et_preco;

    private double preco_cheio = 2000.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        initVars();
        initActions();
    }

    private void initVars() {
        et_desconto = (EditText) findViewById(R.id.et_desconto);
        et_preco = (EditText) findViewById(R.id.et_preco);
        //
        et_desconto.setText("");
        et_preco.setText(String.valueOf(preco_cheio));
    }

    private void initActions() {
        et_desconto.addTextChangedListener(tw_desconto);
        et_preco.addTextChangedListener(tw_preco);
    }

    private TextWatcher tw_desconto = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            et_preco.removeTextChangedListener(tw_preco);
            //
            try {

                double desconto_digitado = Double.parseDouble(
                        et_desconto.getText().toString());

                double preco_com_desconto = (1 - desconto_digitado / 100) * preco_cheio;

                et_preco.setText(String.valueOf(preco_com_desconto));

            } catch (Exception e) {
                et_preco.setText(String.valueOf(preco_cheio));
            }
            //
            et_preco.addTextChangedListener(tw_preco);

        }
    };

    private TextWatcher tw_preco = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            et_desconto.removeTextChangedListener(tw_desconto);
            //
            try {

                double preco_digitado = Double.parseDouble(
                        et_preco.getText().toString());

                double desconto_pratico = ( 1 - preco_digitado/preco_cheio) * 100;

                et_desconto.setText(String.valueOf(desconto_pratico));

            } catch (Exception e) {
                et_desconto.setText("");
            }
            //
            et_desconto.addTextChangedListener(tw_desconto);
        }
    };

}
