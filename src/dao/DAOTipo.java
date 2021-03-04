package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Tipo;

public class DAOTipo {
    public List<Tipo> getTudo() {
        List<Tipo> tipos = new ArrayList<>();
        
        try {
            String sql = "SELECT id_tipo, titulo FROM tipo WHERE id_tipo >= 6;";
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            
            ResultSet answer = pst.executeQuery();
            while (answer.next()) {
                
                int idTipo = answer.getInt(1);
                String titulo = answer.getString(2);
                
                Tipo tipo = new Tipo(idTipo, titulo);
                tipos.add(tipo);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }
        
        return tipos;
    }
}
