package br.com.impacta.curso.prj_012_thread;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by nalmir on 17/03/2018.
 */

public class DS2 extends IntentService {

    public static boolean status = false;

    public DS2() {
        super("DS2");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        // Tudo que voce rodar aqui sera executado em outro processo

        status = true;

        try {
            int indice = 0;
            while (indice < 25) {
                Thread.sleep(1000);
                indice++;
                //
                Log.d("DS2", String.valueOf(indice));
            }
        } catch (InterruptedException e) {
        } finally {
            status = false;
        }

    }
}
