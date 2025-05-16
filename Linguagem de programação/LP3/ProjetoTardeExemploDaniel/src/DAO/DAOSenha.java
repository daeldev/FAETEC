package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import ConnectionFactory.ConnectionFactory;
import Model.CSenha;

public class DAOSenha {
    private Connection connection;
    public DAOSenha(){
        connection = new ConnectionFactory().connection();
    }
public CSenha LocalizarCsenha (String Email) throws SQLException {
    String consulta = "Select Cliente_Email, Senha from Login where Cliente_Email = ?";
    CSenha csenha = null;
    try (PreparedStatement st = connection.prepareStatement(consulta)) {
        st.setString(1, Email);
    try (ResultSet rs = st.executeQuery()) {
        if(rs.next()) {
            csenha = new CSenha();
            csenha.setSenha(rs.getString("Senha"));
            csenha.setUsuario(rs.getString("Cliente_Email"));
        }
    }catch (SQLNonTransientConnectionException err) {
        System.err.println("erro na conexao com o banco"+ err.getMessage());
    }catch (SQLException err) {
        System.err.println("erro ao executar a consulta SQL"+ err.getMessage());
    }
    return csenha;
    } 
}
   public void cadastrarCsenha(String Email, String Senha)
           throws SQLException{
       String Inserir = "Insert into Login (Cliente_Email,Senha) values (?,?)";
       
       try(PreparedStatement st = connection.prepareStatement(Inserir)) {
           st.setString(1, Email);
           st.setString(2, Senha);
           st.executeUpdate();
       }
       catch (SQLNonTransientConnectionException err) {
           System.out.println("Erro na conexão com o banco" + err.getMessage());
       }
       catch (SQLException err) {
           System.out.println("Erro ao executar o cadastro SQL:" + err.getMessage());
       }
   }
   public void AlterarCsenha(String Email, String Senha, String Nivel) throws SQLException{
       String alterar = "Update Login set Senha = ?, Nivel=? where Cliente_Email=?;";
       try (PreparedStatement st = connection.prepareStatement(alterar)) {
           st.setString(1, Senha);
           st.setString(2, Nivel);
           st.setString(3, Email);
           st.executeUpdate();
       }
       catch (SQLNonTransientConnectionException err) {
           System.out.println("Erro na conexão com o banco "+ err.getMessage());
       }
       catch (SQLException err) {
           System.out.println("Erro ao executar o cadastro SQL:"+ err.getMessage());
       }
   }
   public void DeletarCsenha(String Email) throws SQLException{
       String deletar = "Deletar from Login where Cliente_Email=?";
       
       try (PreparedStatement st = connection.prepareStatement(deletar)) {
           st.setString(1, Email);
           st.executeUpdate();
       }
       catch (SQLNonTransientConnectionException err) {
           System.out.println("Erro na conexão com o banco"+ err.getMessage());
       }
       catch (SQLException err) {
           System.out.println("Erro ao executar o cadastro SQL:"+ err.getMessage());
       }
   }
}