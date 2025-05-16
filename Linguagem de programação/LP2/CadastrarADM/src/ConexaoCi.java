import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ConexaoCi {
    Connection conn;
    
    public int autenticarUsuario(UsuarioDTO objusdto){
        conn = new Conexao().ConectaBD();
        try{
            String sql = "Insert into Cliente (IdCliente, Login, Senha, Nome, Endereco, Telefone) Values (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objusdto.getIdCliente());
            pstm.setString(2, objusdto.getLogin());
            pstm.setString(3, objusdto.getSenha());
            pstm.setString(4, objusdto.getNome());
            pstm.setString(5, objusdto.getEndereco());
            pstm.setString(6, objusdto.getTelefone());
            
            int rs = pstm.executeUpdate();
            return rs;
        }catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "UsuarioConexaoci : " + erro);
            return -1;
        }
    }
}
