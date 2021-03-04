package modelo;

public class PixTipo {
    private int idPixTipo;
    private String descricao;

    public PixTipo(int idPixTipo, String descricao) {
        this.idPixTipo = idPixTipo;
        this.descricao = descricao;
    }
    
    public int getIdPixTipo() {
        return idPixTipo;
    }
    
    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
