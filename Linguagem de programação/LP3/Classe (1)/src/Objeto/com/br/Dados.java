/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objeto.com.br;

/**
 *
 * @author Aluno.Tarde
 */
public class Dados {
    private int matricula;
    public int numero;
    public String nome, endereco, bairro, municipio, uf;

    //Faz um set em massa.
    public Dados(int matricula, String nome, String endereco, String bairro, String municipio, String uf) {
        this.matricula = matricula;
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.municipio = municipio;
        this.uf = uf;
    }
    public Dados(){
        
    }
    //Faz um set específico
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
