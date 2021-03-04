package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.PixTipo;

public class DAOPixTipo {
    public List<PixTipo> getTudo() {
        List<PixTipo> tipos = new ArrayList<>();
        
        try {
            String sql = "SELECT id_pix_tipo, descricao FROM pix_tipo;";
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet answer = pst.executeQuery();
            while (answer.next()) {
                int idPixTipo = answer.getInt(1);
                String descricao = answer.getString(2);
                
                PixTipo tipo = new PixTipo(idPixTipo, descricao);
                tipos.add(tipo);
            }
        } catch (SQLException e) {
            
        }
        
        return tipos;
    }
}
