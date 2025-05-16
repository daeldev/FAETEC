/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLNonTransientConnectionException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DisciplinaDAO {

    private Connection connection;

    public DisciplinaDAO() {
        connection = new ConnectionFactory().connection();
    }

    public DisciplinaDTO localizarProdutos(String nome) throws SQLException {
        String consulta = "SELECT * from Disciplina WHERE nome LIKE ?";
        DisciplinaDTO disciplinaDTO = null;
        try (PreparedStatement st = connection.prepareStatement(consulta)) {
            st.setString(1, nome);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    disciplinaDTO = new DisciplinaDTO();
                    disciplinaDTO.setIdDisciplina(rs.getInt("idDisciplina"));
                    disciplinaDTO.setNome(rs.getString("nome"));
                    disciplinaDTO.setCargaHoraria(rs.getInt("carga_horaria"));
                    disciplinaDTO.setEnsino(rs.getString("ensino"));
                }
            } catch (SQLNonTransientConnectionException err) {
                System.err.println("Erro na conexão com o banco: " + err.getMessage());
            } catch (SQLException err) {
                System.err.println("Erro ao executar uma consulta SQL: " + err.getMessage());
            }
            return disciplinaDTO;
        }
    }

    public int cadastrarDisciplina(DisciplinaDTO disciplinaDTO) throws SQLException {
        String inserir = "INSERT INTO Disciplina (nome, carga_horaria, ensino) VALUES (?,?,?)";
        try (PreparedStatement st = connection.prepareStatement(inserir)) {
            st.setString(1, disciplinaDTO.getNome());
            st.setInt(2, disciplinaDTO.getCargaHoraria());
            st.setString(3, disciplinaDTO.getEnsino());
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
    
    public int alterarDisciplina(DisciplinaDTO disciplinaDTO) throws SQLException{
       String alterar = "Update Disciplina set Nome = ?, carga_horaria =? , ensino=? where idDisciplina=?;";
       try (PreparedStatement st = connection.prepareStatement(alterar)) {
           st.setString(1, disciplinaDTO.getNome());
           st.setInt(2, disciplinaDTO.getCargaHoraria());
           st.setString(3, disciplinaDTO.getEnsino());
           st.setInt(4, disciplinaDTO.getIdDisciplina());
           int response = st.executeUpdate();
           return response;
       }
       catch (SQLNonTransientConnectionException err) {
           System.out.println("Erro na conexão com o banco "+ err.getMessage());
           return -1;
       }
       catch (SQLException err) {
           System.out.println("Erro ao executar o cadastro SQL:"+ err.getMessage());
           return -1;
       }
   }
    
    public int deletarDisciplina(int idDisciplina) throws SQLException{
       String deletar = "DELETE from Disciplina where idDisciplina=?";
       
       try (PreparedStatement st = connection.prepareStatement(deletar)) {
           st.setInt(1, idDisciplina);
           int response = st.executeUpdate();
           return response;
       }
       catch (SQLNonTransientConnectionException err) {
           System.out.println("Erro na conexão com o banco"+ err.getMessage());
           return -1;
       }
       catch (SQLException err) {
           System.out.println("Erro ao executar o cadastro SQL:"+ err.getMessage());
           return -1;
       }
   }
}
