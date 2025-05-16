/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herancas;

/**
 *
 * @author Aluno.Tarde
 */
public class Filha extends Pai{
    private String nomeFilha;
    public Filha(String nomeFilha, String nomePai){
        super(nomePai);
        this.nomeFilha = nomeFilha;
    }
    @Override
    public void nome(){
        System.out.println("O nome da filha é: " + this.nomeFilha + " e o nome do pai é: " + nomePai + ".");
    }
}
