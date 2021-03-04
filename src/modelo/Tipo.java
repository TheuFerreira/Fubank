package modelo;

public class Tipo {
    private int idTipo;
    private String titulo;

    public Tipo(int idTipo) {
        this.idTipo = idTipo;
    }
    
    public Tipo(int idTipo, String titulo) {
        this.idTipo = idTipo;
        this.titulo = titulo;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public String getTitulo() {
        return titulo;
    }
    
    @Override
    public String toString() {
        return titulo;
    }
}
