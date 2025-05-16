/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectionFactory.ConnectionFactory;
import Model.CAcesso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;

/**
 *
 * @author Aluno.Tarde
 */
public class DAOAcesso {
        private Connection connection;
    public DAOAcesso(){
        connection = new ConnectionFactory().connection();
    }
public CAcesso LocalizarCacesso (String Email) throws SQLException {
    String consulta = "Select * from Cliente";
    CAcesso cacesso = null;
    
    try (PreparedStatement st = connection.prepareStatement(consulta)) {
        st.setString(1, Email);
        
    try (ResultSet rs = st.executeQuery()) {
        if(rs.next()) {
            cacesso = new CAcesso();
            cacesso.setNome(rs.getString("Nome"));
            cacesso.setEndereco(rs.getString("Endereco"));
            cacesso.setBairro(rs.getString("Bairro"));
            cacesso.setMunicipio(rs.getString("Municipio"));
            cacesso.setNumero(rs.getInt("Numero"));
            cacesso.setProfissao(rs.getString("Profissao"));
            cacesso.setGenero(rs.getString("Genero"));
            cacesso.setEmail(rs.getString("Email"));
            cacesso.setSenha(rs.getString("Senha"));
            
        }
    }catch (SQLNonTransientConnectionException err) {
        System.err.println("erro na conexao com o banco"+ err.getMessage());
    }catch (SQLException err) {
        System.err.println("erro ao executar a consulta SQL"+ err.getMessage());
    }
    return cacesso;
    } 
   
}


   public void cadastrarCacesso(String Nome,String Endereco,String Bairro,String Municipio,int Numero,String Email, String Senha)
           throws SQLException{
       String Inserir = "Insert into Cliente (Nome, Endereco, Bairro, Municipio,Numero,Email)"
       + " values (?,?,?,?,?,?);";
       
       try(PreparedStatement st = connection.prepareStatement(Inserir)) {
           st.setString(1, Nome);
           st.setString(2, Endereco);
           st.setString(3, Bairro);
           st.setString(4, Municipio);
           st.setInt(5, Numero);
           st.setString(6, Email);
           st.executeUpdate();
       }
       catch (SQLNonTransientConnectionException err) {
           System.out.println("Erro na conexão com o banco" + err.getMessage());
       }
       catch (SQLException err) {
           System.out.println("Erro ao executar o cadastro SQL:" + err.getMessage());
       }
       
       
       String Inserirsenha = "insert into Login (Senha,Cliente_Email) values (?,?)";
       
       try(PreparedStatement st = connection.prepareStatement(Inserirsenha)) {
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
   
   
   
   
 public void AlterarCacesso(String Nome,String Endereco,String Bairro,String Municipio,int Numero,String Email, String Senha , String Profissao,String Genero) throws SQLException{
       String alterar = "Update Cliente set Nome = ?, Endereco=? , Bairro=?, Municipio=?, Numero=?, Profissao=?, Genero=? where Email=?;";
       try (PreparedStatement st = connection.prepareStatement(alterar)) {
           st.setString(1, Nome);
           st.setString(2, Endereco);
           st.setString(3, Bairro);
           st.setString(4, Municipio);
           st.setInt(5, Numero);
           st.setString(6, Email);
           st.setString(7, Profissao);
           st.setString(8, Genero);
           st.executeUpdate();
       }
       catch (SQLNonTransientConnectionException err) {
           System.out.println("Erro na conexão com o banco "+ err.getMessage());
       }
       catch (SQLException err) {
           System.out.println("Erro ao executar o cadastro SQL:"+ err.getMessage());
       }
   }
   public void DeletarCacesso(String Email) throws SQLException{
       String deletar = "Deletar from Cliente where Email=?";
       
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