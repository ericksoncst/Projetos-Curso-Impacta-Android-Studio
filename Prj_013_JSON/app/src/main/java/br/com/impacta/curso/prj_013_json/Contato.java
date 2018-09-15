package br.com.impacta.curso.prj_013_json;

import org.json.JSONObject;

/**
 * Created by nalmir on 17/03/2018.
 */

public class Contato {

    public static final String IDCONTATO = "idcontato";
    public static final String NOME = "nome";


    private long idcontato;
    private String nome;

    public Contato() {
        this.idcontato = -1;
        this.nome = "sem nome";
    }

    public Contato(long idcontato, String nome) {
        this.idcontato = idcontato;
        this.nome = nome;
    }

    public Contato(JSONObject jsonObject) {
        try {
            this.idcontato = jsonObject.getLong(IDCONTATO);
            this.nome = jsonObject.getString(NOME);
        } catch (Exception e) {
            this.idcontato = -1;
            this.nome = "sem nome";
        }
    }

    public long getIdcontato() {
        return idcontato;
    }

    public void setIdcontato(long idcontato) {
        this.idcontato = idcontato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public JSONObject toJSONObject() {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put(IDCONTATO, idcontato);
            jsonObject.put(NOME, nome);
            //
            return jsonObject;

        } catch (Exception e) {
            return null;
        }
    }
}
