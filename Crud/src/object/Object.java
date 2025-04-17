package object;

public class Object {

    private int id; // não mexer
    private String nome;
    private String autor;
    private String genero;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
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
                ", Título: " + nome +
                ", Autor: " + autor +
                ", Gênero: " + genero;
    }
}
