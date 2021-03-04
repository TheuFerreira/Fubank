package modelo;

import java.sql.Timestamp;

public class Fatura {
    private Long idFatura;
    private Tipo tipo;
    private String descricao;
    private double valor;
    private Timestamp data;
    private Long cpf;

    public Fatura(double valor, Timestamp data) {
        this.valor = valor;
        this.data = data;
    }
    
    public Fatura(double valor, Timestamp data, Long cpf) {
        descricao = "Fatura Paga";
        this.valor = valor;
        this.data = data;
        this.cpf = cpf;
        tipo = new Tipo(5);
    }
    
    public Fatura(Long idFatura, String descricao, double valor, Timestamp data, Long cpf, Tipo tipo) {
        this.idFatura = idFatura;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.cpf = cpf;
        this.tipo = tipo;
    }
    
    public Fatura(String descricao, double valor, Timestamp data, Long cpf, Tipo tipo) {
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
