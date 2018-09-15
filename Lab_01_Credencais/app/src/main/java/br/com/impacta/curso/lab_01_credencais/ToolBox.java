package br.com.impacta.curso.lab_01_credencais;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by nalmir on 03/02/2018.
 */

public class ToolBox {

    public static void exibirMensagem(Context context, String mensagem) {
        Toast.makeText(
                context,
                mensagem,
                Toast.LENGTH_SHORT
        ).show();
    }
}
