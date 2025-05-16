/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Aluno.Tarde
 */
public class ConnectionFactory {
    public Connection connection(){
        try{
            return DriverManager.getConnection("jdbc:mysql://"+"localhost/ProjetoTardeExemplo","root","");
        }catch(SQLException ex){
            System.out.println(ex);
            throw new RuntimeException();
        }
    }
}
