package br.com.impacta.curso.prj_010_dbase.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by nalmir on 10/03/2018.
 */

public class SQLiteHelper extends SQLiteOpenHelper {

    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try{
            StringBuilder sb = new StringBuilder();
            //
            sb.append("CREATE TABLE IF NOT EXISTS [contatos] (\n" +
                    "  [idcontato] INT NOT NULL, \n" +
                    "  [nome] TEXT NOT NULL, \n" +
                    "  [telefone] TEXT NOT NULL, \n" +
                    "  [idade] INT NOT NULL, \n" +
                    "  CONSTRAINT [] PRIMARY KEY ([idcontato]));");

//            sb.append("CREATE TABLE IF NOT EXISTS [contatos_bk] (\n" +
//                    "  [idcontato] INT NOT NULL, \n" +
//                    "  [nome] TEXT NOT NULL, \n" +
//                    "  [telefone] TEXT NOT NULL, \n" +
//                    "  [idade] INT NOT NULL, \n" +
//                    "  CONSTRAINT [] PRIMARY KEY ([idcontato]));");

            String [] comandos = sb.toString().split(";");

            for (int i = 0; i < comandos.length; i++) {
                db.execSQL(comandos[i]);
            }

        } catch (Exception e){
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try{
            StringBuilder sb = new StringBuilder();
            //
            sb.append("DROP TABLE IF EXISTS [contatos];");

            String [] comandos = sb.toString().split(";");

            for (int i = 0; i < comandos.length; i++) {
                db.execSQL(comandos[i]);
            }

        } catch (Exception e){
        }

        onCreate(db);
    }
}
