
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
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
public class Conexao {
    public Connection ConectaBD(){
        Connection conn = null;
        try{
            String url = "jdbc:mysql://localhost:3306/CadastrarADM?user=root&password=";
            conn = (Connection) DriverManager.getConnection(url);
        }catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "ConexaotesteDAO" + erro.getMessage());
        }
        return conn;
    }
}
