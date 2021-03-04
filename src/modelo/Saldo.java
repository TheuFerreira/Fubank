package modelo;

import java.sql.Timestamp;

public class Saldo {
    private Long idSaldo;
    private Tipo tipo;
    private String descricao;
    private double valor;
    private Timestamp data;
    private Long cpf;

    public Saldo(Long idSaldo, String descricao, double valor, Timestamp data, Long cpf, Tipo tipo) {
        this.idSaldo = idSaldo;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.cpf = cpf;
        this.tipo = tipo;
    }
    
    public Saldo(double valor, Timestamp data, Long cpf) {
        this.descricao = "Fatura paga";
        this.valor = valor;
        this.data = data;
        this.cpf = cpf;
        tipo = new Tipo(5);
    }
    
    public Saldo(String descricao, double valor, Timestamp data, Long cpf, Tipo tipo) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.cpf = cpf;
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public Timestamp getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    public Long getCPF() {
        return cpf;
    }
    
    public Tipo getTipo() {
        return tipo;
    }
}
