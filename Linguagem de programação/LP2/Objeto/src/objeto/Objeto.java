/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package objeto;

import java.util.Scanner;

/**
 *
 * @author Aluno
 */
public class Objeto {
    
    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        double n1, n2;
        Scanner entrada = new Scanner (System.in);
        System.out.print("Valor de n1 = ");
        n1 = entrada.nextDouble();
        System.out.print("Valor de n2 = ");
        n2 = entrada.nextDouble();
        Resultado s = new Resultado();
        System.out.print(s.soma(n1,n2));
    }
}
