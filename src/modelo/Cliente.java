package modelo;

public class Cliente {
    private Long cpf;
    private String senha;
    private String nome;
    private String sobrenome;
    private double saldo;
    private double limite;
    private double fatura;
    
    public Cliente(Long cpf, String nome, String sobrenome, double saldo, double limite, double fatura) {
        this.cpf = cpf;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.saldo = saldo;
        this.limite = limite;
        this.fatura = fatura;
    }
    
    public Cliente(Long cpf, String nome, String sobrenome, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.senha = senha;
    }

    public Long getCPF() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }
    
    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public double getSaldo() {
        return saldo;
    }
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public double getFatura() {
        return fatura;
    }

    public void setFatura(double fatura) {
        this.fatura = fatura;
    }
}
