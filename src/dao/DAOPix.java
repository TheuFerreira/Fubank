package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Pix;
import modelo.PixTipo;

public class DAOPix {
    public List<Pix> getTudo(Long cpf) {
        List<Pix> pixs = new ArrayList<>();
        
        try {
            String sql = "SELECT p.chave, pt.id_pix_tipo, pt.descricao FROM pix AS p INNER JOIN pix_tipo AS pt ON pt.id_pix_tipo = p.id_pix_tipo WHERE cpf = ?;";
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setLong(1, cpf);
            
            ResultSet answer = pst.executeQuery();
            while (answer.next()) {
                String chave = answer.getString(1);
                int idPixTipo = answer.getInt(2);
                String descricao = answer.getString(3);
                
                PixTipo pixTipo = new PixTipo(idPixTipo, descricao);
                Pix pix = new Pix(chave, cpf, pixTipo);
                pixs.add(pix);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }
        
        return pixs;
    }

    public Boolean existe(String chave) {
        Boolean res = false;
        
        try {
            String sql = "SELECT chave FROM pix WHERE chave = ? LIMIT 1;";
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, chave);
            
            ResultSet answer = pst.executeQuery();
            if (answer.next()) {
                res = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }
        
        return res;
    }
    
    public void inserir(Pix pix) {
        try {
            String sql = "INSERT INTO pix (chave, cpf, id_pix_tipo) VALUES (?, ?, ?);";
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, pix.getChave());
            pst.setLong(2, pix.getCPF());
            pst.setInt(3, pix.getPixTipo().getIdPixTipo());
            pst.executeUpdate();
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }
    }
    
    public void remover(Pix pix) {
        try {
            String sql = "DELETE FROM pix WHERE chave = ?;";
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, pix.getChave());
            pst.executeUpdate();
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }
    }
}
