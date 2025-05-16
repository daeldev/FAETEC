/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
  public class ClasseMétodo {
    public String metodo(double a, double b, double c, double d){
        double soma = a+b+c+d;
        
        if (soma / 4 < 5){
            return ("Reprovado");
        }
        if (soma / 4 >= 5 && (a + b + c + d) / 4d < 7){
            return ("Recuperação");
        }
        if (soma / 4 >= 7 && (a + b + c + d) / 4 < 10){
            return ("Aprovado");
        }
    }
}
