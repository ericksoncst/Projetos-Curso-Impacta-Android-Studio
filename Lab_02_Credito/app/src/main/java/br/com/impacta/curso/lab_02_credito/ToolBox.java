package br.com.impacta.curso.lab_02_credito;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by nalmir on 17/02/2018.
 */

public class ToolBox {

    public static int conversorInt(String texto) {
        try {
            return Integer.parseInt(texto);
        } catch (Exception e) {
            return -1;
        }
    }

    public static void mostrarMsg(Context context, String msg) {
        Toast.makeText(
                context,
                msg,
                Toast.LENGTH_SHORT
        ).show();
    }

    public static void mostrarErroLL(Context context, LinearLayout ll, boolean status) {
        if (status) {
            ll.setBackground(context.getDrawable(R.drawable.borda));
        } else {
            ll.setBackground(null);
        }
    }

}
