package br.com.impacta.curso.prj_016_fragmento;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

/**
 * Created by nalmir on 24/03/2018.
 */

public class F01 extends Fragment {

    private Context context;

    private CheckBox cb_android;
    private Button btn_acionar;

    public interface  IF01{
        void mudarOTexto(String texto);
    }

    private IF01 delegate;

    public void setOnMudarOTextoListener(IF01 delegate) {
        this.delegate = delegate;
    }

    //private MainActivity host;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f01, container, false);

        initVars(view);
        initActions();

        return view;
    }

    private void initVars(View view) {
        context = getActivity();
        //
        //host = (MainActivity) getActivity();
        //
        cb_android = (CheckBox)
                view.findViewById(R.id.f01_cb_android);
        btn_acionar = (Button)
                view.findViewById(R.id.f01_btn_acionar);
    }

    private void initActions() {
        btn_acionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!cb_android.isChecked()){
                    Toast.makeText(context, "Acionado", Toast.LENGTH_SHORT).show();
                } else {
                    if (delegate != null){
                        delegate.mudarOTexto("Hugo Android!!!");
                    }
                    //host.erradoMudar("Hugo Android!!!");
                }
            }
        });
    }
}
