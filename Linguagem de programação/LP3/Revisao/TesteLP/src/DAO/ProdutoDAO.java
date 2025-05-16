/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectionFactory.ConnectionFactory;
import Model.ProdutoModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;

/**
 *
 * @author Aluno.Tarde
 */
public class ProdutoDAO {
    private Connection connection;

    public ProdutoDAO() {
        connection = new ConnectionFactory().connection();
    }
    
    public int cadastrarProduto(ProdutoModel ProdutoModel) throws SQLException {
        String inserir = "INSERT INTO Produto (descricao, preco, lucro) VALUES (?,?,?)";
        try (PreparedStatement st = connection.prepareStatement(inserir)) {
            st.setString(1, ProdutoModel.getDescricao());
            st.setDouble(2, ProdutoModel.getPreco());
            st.setString(3, ProdutoModel.getLucro());
            int response = st.executeUpdate();
            return response;
        } catch (SQLNonTransientConnectionException err) {
            System.out.println("Erro na conexão com o banco:" + err.getMessage());
            return -1;
        } catch (SQLException err) {
            System.out.println("Erro ao Executar o cadastro SQL:" + err.getMessage());
            return -1;
        }
    }
    
    public ProdutoModel pesquisarProduto(String descricao) throws SQLException {
        String consulta = "SELECT * from Produto WHERE descricao LIKE ?";
        ProdutoModel ProdutoModel = null;
        try (PreparedStatement st = connection.prepareStatement(consulta)) {
            st.setString(1, descricao);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    ProdutoModel = new ProdutoModel();
                    ProdutoModel.setDescricao(rs.getString("descricao"));
                    ProdutoModel.setPreco(Double.valueOf(rs.getString("preco")));
                    ProdutoModel.setLucro(rs.getString("lucro")); 
                }
            } catch (SQLNonTransientConnectionException err) {
                System.err.println("Erro na conexão com o banco: " + err.getMessage());
            } catch (SQLException err) {
                System.err.println("Erro ao executar uma consulta SQL: " + err.getMessage());
            }
            return ProdutoModel;
        }
    }
}
