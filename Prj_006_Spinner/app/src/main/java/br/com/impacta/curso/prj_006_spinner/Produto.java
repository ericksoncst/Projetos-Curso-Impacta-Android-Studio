package br.com.impacta.curso.prj_006_spinner;

/**
 * Created by nalmir on 24/02/2018.
 */

public class Produto {

    private long idproduto;
    private String nome;
    private double preco;
    private int qtd;
    private String barcode;

    public Produto() {
        this.idproduto = -1;
        this.nome = "sem nome";
        this.preco = 0.0;
        this.qtd = -1;
        this.barcode = "sem barcode";
    }

    public long getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(long idproduto) {
        this.idproduto = idproduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    @Override
    public String toString() {
        return nome;
    }
}
