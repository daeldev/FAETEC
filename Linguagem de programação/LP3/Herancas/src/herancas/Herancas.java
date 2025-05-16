/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package herancas;

/**
 *
 * @author Aluno.Tarde
 */
public class Herancas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Filha filha = new Filha("Mariazinha", "Niel");
        Pai pai = new Pai();
        
        filha.nome();
        pai.nome();
    }   
}
