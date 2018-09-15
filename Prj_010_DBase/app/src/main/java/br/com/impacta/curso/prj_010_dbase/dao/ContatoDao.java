package br.com.impacta.curso.prj_010_dbase.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

import br.com.impacta.curso.prj_010_dbase.banco.Dao;
import br.com.impacta.curso.prj_010_dbase.banco.HMAux;
import br.com.impacta.curso.prj_010_dbase.model.Contato;

/**
 * Created by nalmir on 10/03/2018.
 */

public class ContatoDao extends Dao {
    public static final String TABELA = "contatos";
    public static final String IDCONTATO = "idcontato";
    public static final String NOME = "nome";
    public static final String TELEFONE = "telefone";
    public static final String IDADE = "idade";

    public String [] column = {
            IDCONTATO, NOME, TELEFONE, IDADE
    };

    public ContatoDao(Context context) {
        super(context);
    }

    // Segunda Tela
    public void inserirContato(Contato contato) {
        abrirBanco();
        //
        ContentValues cv = new ContentValues();
        cv.put(IDCONTATO, contato.getIdcontato());
        cv.put(NOME, contato.getNome());
        cv.put(TELEFONE, contato.getTelefone());
        cv.put(IDADE, contato.getIdade());
        //
        db.insert(TABELA, null, cv);
        //
        fecharBanco();
    }

    public void alterarContato(Contato contato) {
        abrirBanco();
        //
        String filtro = IDCONTATO + " = ? ";
        String [] parametros_filtro = { String.valueOf(contato.getIdcontato()) };
        //
        ContentValues cv = new ContentValues();
        //cv.put(IDCONTATO, contato.getIdcontato());
        cv.put(NOME, contato.getNome());
        cv.put(TELEFONE, contato.getTelefone());
        cv.put(IDADE, contato.getIdade());
        //
        db.update(TABELA, cv, filtro, parametros_filtro);
        //
        fecharBanco();
    }

    public void apagarContato(long idcontato) {
        abrirBanco();
        //
        String filtro = IDCONTATO + " = ? ";
        String [] parametros_filtro = { String.valueOf(idcontato) };
        //
        db.delete(TABELA, filtro, parametros_filtro);
        //
        fecharBanco();
    }

    public Contato obterContatoByID(long idcontato) {
        Contato cAux = null;
        //
        abrirBanco();
        //
        Cursor cursor = null;
        //
        try{

            StringBuilder comando = new StringBuilder();
            String [] parametros_filtro = { String.valueOf(idcontato) };

            comando
                    .append(" select * from ")
                    .append(TABELA)
                    .append(" where ")
                    .append(IDCONTATO)
                    .append(" = ? ");

            cursor = db.rawQuery(comando.toString(), parametros_filtro);

            while(cursor.moveToNext()){
                cAux = new Contato();
                //
                cAux.setIdcontato(cursor.getLong(cursor.getColumnIndex(IDCONTATO)));
                cAux.setNome(cursor.getString(cursor.getColumnIndex(NOME)));
                cAux.setTelefone(cursor.getString(cursor.getColumnIndex(TELEFONE)));
                cAux.setIdade(cursor.getInt(cursor.getColumnIndex(IDADE)));
            }

            cursor.close();

        } catch (Exception e){
        }
        //
        fecharBanco();
        //
        return cAux;
    }

    // Primeira Tela
    public ArrayList<HMAux> obterListaContatos() {
        ArrayList<HMAux> contatos = new ArrayList<>();
        //
        abrirBanco();
        //
        Cursor cursor = null;
        //
        try{

            StringBuilder comando = new StringBuilder();

            comando
                    .append(" select idcontato, nome from ")
                    .append(TABELA)
                    .append(" order by ")
                    .append(NOME);

            cursor = db.rawQuery(comando.toString(), null);

            while(cursor.moveToNext()){
                HMAux aux = new HMAux();
                //
                aux.put(
                        HMAux.ID,
                        cursor.getString(cursor.getColumnIndex(IDCONTATO))
                );
                //
                aux.put(
                        HMAux.TEXTO_01,
                        cursor.getString(cursor.getColumnIndex(NOME))
                );
                //
                contatos.add(aux);
            }

            cursor.close();

        } catch (Exception e){
        }
        //
        fecharBanco();
        //
        return contatos;
    }

    public long proximoID() {
        long proID = 1;
        //
        abrirBanco();
        //
        Cursor cursor = null;
        //
        try{

            StringBuilder comando = new StringBuilder();

            comando
                    .append(" select max(idcontato) + 1 as id from ")
                    .append(TABELA);

            cursor = db.rawQuery(comando.toString(), null);

            while(cursor.moveToNext()){
                proID = cursor.getLong(cursor.getColumnIndex("id"));
            }

            if (proID == 0){
                proID = 1;
            }

            cursor.close();

        } catch (Exception e){
        }
        //
        fecharBanco();
        //
        return proID;
    }


}
