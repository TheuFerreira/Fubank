package modelo;

public class Pix {
    private String chave;
    private Long cpf;
    private PixTipo pixTipo;
    
    public Pix(String chave, Long cpf, PixTipo pixTipo) {
        this.chave = chave;
        this.cpf = cpf;
        this.pixTipo = pixTipo;
    }
    
    public PixTipo getPixTipo() {
        return pixTipo;
    }

    public Long getCPF() {
        return cpf;
    }
    
    public String getChave() {
        return chave;
    }
        
}
