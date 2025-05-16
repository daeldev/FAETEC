
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno.Tarde
 */
public class DTO {
    public class Aluno{
        private int Matricula;
        private String Nome;
        private int Idade;
        private String Nomeresponsavel;
        private String Email;

        public int getMatricula() {
            return Matricula;
        }

        public void setMatricula(int Matricula) {
            this.Matricula = Matricula;
        }

        public String getNome() {
            return Nome;
        }

        public void setNome(String Nome) {
            if (!Nome.isEmpty()) {
                this.Nome = Nome;
            } else {
                JOptionPane.showMessageDialog(null, "ERRO: Verifique o nome do aluno.");
            }
        }

        public int getIdade() {
            return Idade;
        }

        public void setIdade(int Idade) {
            if (Idade > 0) {
                this.Idade = Idade;
            } else {
                JOptionPane.showMessageDialog(null, "ERRO: A idade deve ser maior do que zero.");
            }
        }

        public String getNomeresponsavel() {
            return Nomeresponsavel;
        }

        public void setNomeresponsavel(String Nomeresponsavel) {
            if (!Nomeresponsavel.isEmpty()) {
                this.Nomeresponsavel = Nomeresponsavel;
            } else {
                JOptionPane.showMessageDialog(null, "ERRO: Verifique o nome do responsável do aluno.");
            }
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String Email) {
            if (!Email.isEmpty()) {
                this.Email = Email;
            } else {
                JOptionPane.showMessageDialog(null, "ERRO: Verifique o E-mail do aluno.");
            }
        }
    }
}
