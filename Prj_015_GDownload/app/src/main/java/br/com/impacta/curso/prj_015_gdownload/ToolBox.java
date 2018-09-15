package br.com.impacta.curso.prj_015_gdownload;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by nalmir on 24/03/2018.
 */

public class ToolBox {

    public static void GDownload(String urlServer, String local) throws Exception {

        URL url;
        //
        url = new URL(urlServer);
        //
        URLConnection connection = url.openConnection();
        //
        //
        File arquivo = new File(local);
        if (arquivo.exists()) {
            arquivo.delete();
        }

        // Arquivo local no aparelho
        FileOutputStream outputStream = new FileOutputStream(local, true);

        // Arquivo na Web
        InputStream inputStream = new
                BufferedInputStream(connection.getInputStream());

        byte[] buffer = new byte[1024];
        int n;

        while ((n = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, n);
        }

        outputStream.flush();
        outputStream.close();
    }


}
