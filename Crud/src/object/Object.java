package object;

public class Object {

    private int id; // não mexer
    private String titulo;
    private String autor;
    private String genero;
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return  "Id: "+ id +
                ", Título: " + titulo +
                ", Autor: " + autor +
                ", Gênero: " + genero;
    }
}
