import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno.Tarde
 */
public class UsuarioConexaoci {
    Connection conn;
    
    public ResultSet autenticarUsuario(UsuarioDTO objusdto){
        conn = new conexao().ConectaBD();
        try{
            String sql = "Select * from Cadastro where Login =? and Senha =?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objusdto.getLogin());
            pstm.setString(2, objusdto.getSenha());
            
            
            ResultSet rs = pstm.executeQuery();
            return rs;
        }catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "UsuarioConexaoci : " + erro);
            return null;
        }
    }
    
    public ResultSet autenticarUsuario1(UsuarioDTO objusdto1){
        conn = new conexao().ConectaBD();
        try{
            String sql = "Select * from Cadastro where Nome =? and CPF =?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objusdto1.getNome());
            pstm.setString(2, objusdto1.getCPF());
            
            
            ResultSet rs = pstm.executeQuery();
            return rs;
        }catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "UsuarioConexaoci : " + erro);
            return null;
        }
    }
}
