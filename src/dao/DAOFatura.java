package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Fatura;
import modelo.Tipo;

public class DAOFatura {
    public List<Fatura> getTudo(Long cpf) {
        List<Fatura> faturas = new ArrayList<>();
        
        try {
            String sql = "SELECT s.id_fatura, s.descricao, s.valor, s.data, t.id_tipo, t.titulo FROM fatura AS s INNER JOIN tipo AS t ON t.id_tipo = s.id_tipo WHERE cpf = ? ORDER BY data DESC;";
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setLong(1, cpf);
            
            ResultSet answer = pst.executeQuery();
            while (answer.next()) {
                
                Long idSaldo = answer.getLong(1);
                String descricao = answer.getString(2);
                double valor = answer.getDouble(3);
                Timestamp data = answer.getTimestamp(4);
                int idTipo = answer.getInt(5);
                String titulo = answer.getString(6);
                
                Tipo tipo = new Tipo(idTipo, titulo);
                Fatura fatura = new Fatura(idSaldo, descricao, valor, data, cpf, tipo);
                faturas.add(fatura);
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }
        
        return faturas;
    }
    
    public void inserir(Fatura fatura) {
        try {
            String sql = "INSERT INTO fatura(id_tipo, descricao, valor, data, cpf) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, fatura.getTipo().getIdTipo());
            pst.setString(2, fatura.getDescricao());
            pst.setDouble(3, fatura.getValor());
            pst.setTimestamp(4, fatura.getData());
            pst.setLong(5, fatura.getCPF());
            pst.executeUpdate();
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }
    }
    
    public List<Fatura> getResumo(Long cpf) {
        List<Fatura> faturas = new ArrayList<>();
        
        try {
            String sql = "SELECT SUM(valor), data FROM fatura WHERE cpf = ? AND id_tipo != 5 GROUP BY MONTH(data), YEAR(data) ORDER BY data DESC;";
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setLong(1, cpf);
            
            ResultSet answer = pst.executeQuery();
            while (answer.next()) {
                double valor = answer.getDouble(1);
                Timestamp data = answer.getTimestamp(2);
                
                Fatura fatura = new Fatura(valor, data);
                faturas.add(fatura);
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }
        
        return faturas;
    }
}
