package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Saldo;
import modelo.Tipo;

public class DAOSaldo {
    public List<Saldo> getTudo(Long cpf) {
        List<Saldo> saldos = new ArrayList<>();
        
        try {
            String sql = "SELECT s.id_saldo, s.descricao, s.valor, s.data, t.id_tipo, t.titulo FROM saldo AS s INNER JOIN tipo AS t ON t.id_tipo = s.id_tipo WHERE cpf = ? ORDER BY data DESC;";
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
                Saldo saldo = new Saldo(idSaldo, descricao, valor, data, cpf, tipo);
                saldos.add(saldo);
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }
        
        return saldos;
    }
    
    public void inserir(Saldo saldo) {
        try {
            String sql = "INSERT INTO saldo(id_tipo, descricao, valor, data, cpf) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, saldo.getTipo().getIdTipo());
            pst.setString(2, saldo.getDescricao());
            pst.setDouble(3, saldo.getValor());
            pst.setTimestamp(4, saldo.getData());
            pst.setLong(5, saldo.getCPF());
            pst.executeUpdate();
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }
    }
}
