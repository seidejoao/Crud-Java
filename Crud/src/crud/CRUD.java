package crud;

import connection.ConnectionDB;
import object.Object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CRUD {
    Connection conn;
    PreparedStatement preparedStatement;

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void create(Object object){
        String query = "INSERT INTO livros (titulo, autor, genero) VALUES (?, ?, ?)";
        //trabalharei com prepared statement para uma segurança melhor

        conn = new ConnectionDB().connectionDB();

        try {
            preparedStatement = conn.prepareStatement(query);

            preparedStatement.setString(1, object.getTitulo());
            preparedStatement.setString(2, object.getAutor());
            preparedStatement.setString(3, object.getGenero());

            preparedStatement.execute();

            preparedStatement.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Object> read(){
        String query = "SELECT * FROM livros LIMIT 10;";

        List<Object> objects = new ArrayList<>();


        conn = new ConnectionDB().connectionDB();

        try {
            preparedStatement = conn.prepareStatement(query);

            try(ResultSet rs = preparedStatement.executeQuery()){
                while(rs.next()){
                    Object object = new Object();
                    object.setId(rs.getInt("id"));
                    object.setTitulo(rs.getString("titulo"));
                    object.setAutor(rs.getString("autor"));
                    object.setGenero(rs.getString("genero"));
                    objects.add(object);
                }
            }

            preparedStatement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        setMsg("Livros listados com SUCESSO!!");

        return objects;
    }

    public void updateTitulo(String titulo, int id){
        conn = new ConnectionDB().connectionDB();

        String queryTitulo = "UPDATE livros SET titulo = ? WHERE (id = ?);";

        try {
            preparedStatement = conn.prepareStatement(queryTitulo);
            preparedStatement.setString(1, titulo);
            preparedStatement.setInt   (2, id);

            preparedStatement.execute();

            preparedStatement.close();

            setMsg("Titulo alterado com SUCESSO!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateAutor(String autor, int id){
        conn = new ConnectionDB().connectionDB();

        String queryAutor = "UPDATE livros SET autor = ? WHERE (id = ?);";

        try {
            preparedStatement = conn.prepareStatement(queryAutor);
            preparedStatement.setString(1, autor);
            preparedStatement.setInt   (2, id);

            preparedStatement.execute();

            preparedStatement.close();

            setMsg("Autor alterado com SUCESSO!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateGenero(String genero, int id){
        conn = new ConnectionDB().connectionDB();

        String queryGenero = "UPDATE livros SET genero = ?  WHERE (id = ?);";

        try {
            preparedStatement = conn.prepareStatement(queryGenero);
            preparedStatement.setString(1, genero);
            preparedStatement.setInt   (2, id);

            preparedStatement.execute();

            preparedStatement.close();

            setMsg("Objeto alterado com SUCESSO!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateTituloAutor(String titulo, String autor, int id){
        conn = new ConnectionDB().connectionDB();

        String queryTituloAutor = "UPDATE livros SET titulo = ?, autor = ? WHERE (id = ?);";

        try {
            preparedStatement = conn.prepareStatement(queryTituloAutor);
            preparedStatement.setString(1, titulo);
            preparedStatement.setString(2, autor);
            preparedStatement.setInt   (3, id);

            preparedStatement.execute();

            preparedStatement.close();

            setMsg("Objeto alterado com SUCESSO!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateTituloGenero(String titulo, String genero, int id){
        conn = new ConnectionDB().connectionDB();

        String queryTituloGenero = "UPDATE livros SET titulo = ?, genero = ? WHERE (id = ?);";

        try {
            preparedStatement = conn.prepareStatement(queryTituloGenero);
            preparedStatement.setString(1, titulo);
            preparedStatement.setString(2, genero);
            preparedStatement.setInt   (3, id);

            preparedStatement.execute();

            preparedStatement.close();

            setMsg("Objeto alterado com SUCESSO!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateAutorGenero(String autor, String genero, int id){
        conn = new ConnectionDB().connectionDB();

        String queryAutorGenero = "UPDATE livros SET autor = ?, genero = ? WHERE (id = ?);";

        try {
            preparedStatement = conn.prepareStatement(queryAutorGenero);
            preparedStatement.setString(1, autor);
            preparedStatement.setString(2, genero);
            preparedStatement.setInt   (3, id);

            preparedStatement.execute();

            preparedStatement.close();

            setMsg("Objeto alterado com SUCESSO!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateTituloAutorGenero(Object object){
        String queryTituloAutorGenero = "UPDATE livros SET titulo = ?, autor = ?, genero = ? WHERE (id = ?);";
        //trabalharei com prepared statement para uma segurança melhor

        conn = new ConnectionDB().connectionDB();

        try {
            preparedStatement = conn.prepareStatement(queryTituloAutorGenero);
            preparedStatement.setString(1, object.getTitulo());
            preparedStatement.setString(2, object.getAutor());
            preparedStatement.setString(3, object.getGenero());
            preparedStatement.setInt   (4, object.getId());

            preparedStatement.execute();

            preparedStatement.close();

            setMsg("Objeto alterado com SUCESSO!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int id){
        String query = "DELETE FROM livros WHERE id=?;";

        conn = new ConnectionDB().connectionDB();

        try {
            preparedStatement = conn.prepareStatement(query);

            preparedStatement.setInt(1, id);

            preparedStatement.execute();

            preparedStatement.close();

            setMsg("Objeto deletado com SUCESSO!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
