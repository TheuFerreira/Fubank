package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Cliente;

public class DAOCliente {
    
    public double getSaldo(Long cpf) {
        double valor = 0;
        
        try {
            String sql = "SELECT saldo FROM cliente WHERE cpf = ?;";
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setLong(1, cpf);
            ResultSet answer = pst.executeQuery();
            
            while (answer.next()) {
                valor = answer.getDouble(1);
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }
        
        return valor;
    }
    
    public void inserir(Cliente cliente) {
        try {
            String sql = "INSERT INTO cliente VALUES (?, ?, ?, ?, 0, 500, 0);";
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setLong(1, cliente.getCPF());
            pst.setString(2, cliente.getSenha());
            pst.setString(3, cliente.getNome());
            pst.setString(4, cliente.getSobrenome());
            pst.executeUpdate();
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }
    }
    
    public double getFatura(Long cpf) {
        double valor = 0;
        
        try {
            String sql = "SELECT fatura FROM cliente WHERE cpf = ?;";
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setLong(1, cpf);
            ResultSet answer = pst.executeQuery();
            
            while (answer.next()) {
                valor = answer.getDouble(1);
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }
        
        return valor;
    }
    
    public double getLimite(Long cpf) {
        double valor = 0;
        
        try {
            String sql = "SELECT limite FROM cliente WHERE cpf = ?;";
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setLong(1, cpf);
            ResultSet answer = pst.executeQuery();
            
            while (answer.next()) {
                valor = answer.getDouble(1);
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }
        
        return valor;
    }
    
    public Cliente checkCliente(Long cpf, String senha) {
        
        try {
            String sql = "SELECT nome, sobrenome, saldo, limite, fatura FROM cliente WHERE cpf = ? AND senha = ?;";
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setLong(1, cpf);
            pst.setString(2, senha);
            ResultSet answer = pst.executeQuery();
            
            Cliente client = null;
            
            while (answer.next()) {
                String nome = answer.getString(1);
                String sobrenome = answer.getString(2);
                double saldo = answer.getDouble(3);
                double limite = answer.getDouble(4);
                double fatura = answer.getDouble(5);
                
                client = new Cliente(cpf, nome, sobrenome, saldo, limite, fatura);
            }
            
            return client;
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }
        
        return null;
    }
    
    public boolean existe(Long cpf) {
        
        try {
            String sql = "SELECT COUNT(cpf) FROM cliente WHERE cpf = ?;";
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setLong(1, cpf);
            ResultSet answer = pst.executeQuery();
            
            int valor = 0;
            while (answer.next()) {
                valor = answer.getInt(1);
            }
            
            return valor == 1;
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }
        
        return false;
    }
    
    public void atualizarLimite(Long cpf, double valor) {
        
        try {
            String sql = "UPDATE cliente SET limite = ? WHERE cpf = ?;";
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setDouble(1, valor);
            pst.setLong(2, cpf);
            pst.executeUpdate();
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }
    }
}
