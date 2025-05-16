/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Aluno.Tarde
 */
public class ProdutoModel {
    
    private String descricao;
    private double preco;
    private String lucro;
 

    public ProdutoModel(){
    }
    
     public ProdutoModel(String descricao, double preco, String lucro) {
        this.descricao = descricao;
        this.preco = preco;
        this.lucro = lucro;
    }
    
    
    
    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the preco
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * @return the lucro
     */
    public String getLucro() {
        return lucro;
    }

    /**
     * @param lucro the lucro to set
     */
    public void setLucro(String lucro) {
        this.lucro = lucro;
    }

   

}
