/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import ConnectionFactory.ConnectionFactory;
import Model.PacienteModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;

/**
 *
 * @author Aluno.Tarde
 */
public class PacienteDAO {
    private Connection connection;

    public PacienteDAO() {
        connection = new ConnectionFactory().connection();
    }
    
    public int cadastrarPaciente(PacienteModel pacienteModel) throws SQLException {
        String inserir = "INSERT INTO Paciente (nome, plano, genero) VALUES (?,?,?)";
        try (PreparedStatement st = connection.prepareStatement(inserir)) {
            st.setString(1, pacienteModel.getNome());
            st.setString(2, pacienteModel.getPlano());
            st.setString(3, pacienteModel.getGenero());
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
    
    public PacienteModel pesquisarPaciente(String nome) throws SQLException {
        String consulta = "SELECT * from Paciente WHERE nome LIKE ?";
        PacienteModel pacienteModel = null;
        try (PreparedStatement st = connection.prepareStatement(consulta)) {
            st.setString(1, nome);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    pacienteModel = new PacienteModel();
                    pacienteModel.setNome(rs.getString("nome"));
                    pacienteModel.setPlano(rs.getString("plano"));
                    pacienteModel.setGenero(rs.getString("genero")); 
                }
            } catch (SQLNonTransientConnectionException err) {
                System.err.println("Erro na conexão com o banco: " + err.getMessage());
            } catch (SQLException err) {
                System.err.println("Erro ao executar uma consulta SQL: " + err.getMessage());
            }
            return pacienteModel;
        }
    }
}
