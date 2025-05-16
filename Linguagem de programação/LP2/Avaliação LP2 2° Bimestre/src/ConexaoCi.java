

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno.Tarde
 */
public class ConexaoCi {
    Connection conn;
    
    public int CadastrarAluno(DTO.Aluno aluno){     
            conn = new ConexaoBD().ConectaBD();
            try {
                String sql = "INSERT INTO Aluno (Nome, Idade, Nomeresponsavel, Email) VALUES (?, ?, ?, ?)";
                PreparedStatement pstm = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                pstm.setString(1, aluno.getNome());

//                if (aluno.getIdade() > 0){
                    pstm.setInt(2, aluno.getIdade());
//                }else{
//                    return -1;
//                }
                pstm.setString(3, aluno.getNomeresponsavel());    
                pstm.setString(4, aluno.getEmail()); 

                int rs = pstm.executeUpdate();
                ResultSet rsa = pstm.getGeneratedKeys();
                if (rsa.next()) {
                    JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso.");
                }  
                return rs;
            }catch (SQLException erro){
                JOptionPane.showMessageDialog(null, "Falha no cadastro" + erro.getMessage());
                return -1;
            } 
        
        
    }
    public boolean ConsultarAluno(DTO.Aluno aluno){
        conn = (Connection) new ConexaoBD().ConectaBD();      
        int generatedKey = -1;
        try{
            String sql = "SELECT * FROM Aluno Where Matricula = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, aluno.getMatricula());
            
            ResultSet rs = pstm.executeQuery(); 
                if (rs.next()){
                    aluno.setNome(rs.getString("Nome"));
                    aluno.setIdade(rs.getInt("Idade"));
                    aluno.setNomeresponsavel(rs.getString("Nomeresponsavel"));  
                    aluno.setEmail(rs.getString("Email"));      
                    return true;
                }else{
                    JOptionPane.showMessageDialog(null, "ERRO: Aluno inexistente."); 
                    return false;
                }   
        }catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
            return false;
        }
    }
}
