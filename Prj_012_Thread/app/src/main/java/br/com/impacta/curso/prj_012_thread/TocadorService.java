package br.com.impacta.curso.prj_012_thread;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;

/**
 * Created by nalmir on 17/03/2018.
 */

public class TocadorService extends Service {

    private MediaPlayer mPlayer;

    @Override
    public void onCreate() {
        super.onCreate();
        //
        mPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ci);
        mPlayer.setLooping(true);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        mPlayer.start();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        mPlayer.stop();
        mPlayer.release();

        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
