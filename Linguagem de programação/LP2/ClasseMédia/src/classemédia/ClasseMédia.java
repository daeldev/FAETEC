/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package classemédia;

import java.util.Scanner;

/**
 *
 * @author Aluno
 */
public class ClasseMédia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double n1, n2, n3, n4;
        Scanner entrada = new Scanner (System.in);
        
        System.out.print("Valor de n1 = ");
        n1 = entrada.nextDouble();
        
        System.out.print("Valor de n2 = ");
        n2 = entrada.nextDouble();
        
        System.out.print("Valor de n3 = ");
        n3 = entrada.nextDouble();
        
        System.out.print("Valor de n4 = ");
        n4 = entrada.nextDouble();
        ClassMétodo media = new ClassMétodo();
        
        if (media.metodo(n1, n2, n3, n4) < 5){
            System.out.print("Reprovado");
        }
        
        if (media.metodo(n1, n2, n3, n4) / 4 >= 5 && media.metodo(n1, n2, n3, n4) < 7){
            System.out.print ("Recuperação");
        }
        
        if (media.metodo(n1, n2, n3, n4) / 4 >= 7 && media.metodo(n1, n2, n3, n4) <= 10){
            System.out.print ("Aprovado");
        }
        System.out.print("Resultado da média das notas ="+ media.metodo(n1, n2, n3, n4));
    }
}
