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
        String query = "INSERT INTO livros (nome, autor, genero) VALUES (?, ?, ?)";
        //trabalharei com prepared statement para uma segurança melhor

        conn = new ConnectionDB().connectionDB();

        try {
            preparedStatement = conn.prepareStatement(query);

            preparedStatement.setString(1, object.getNome());
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
                    object.setNome(rs.getString("nome"));
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

    public void update(Object object, int id){
        String queryTitulo            = "UPDATE livros SET nome = ? WHERE (id = ?);";
        String queryAutor             = "UPDATE livros SET autor = ? WHERE (id = ?);";
        String queryGenero            = "UPDATE livros SET genero = ?  WHERE (id = ?);";
        String queryTituloAutor       = "UPDATE livros SET nome = ?, autor = ? WHERE (id = ?);";
        String queryTituloGenero      = "UPDATE livros SET nome = ?, genero = ? WHERE (id = ?);";
        String queryAutorGenero       = "UPDATE livros SET autor = ?, genero = ? WHERE (id = ?);";
        String queryTituloAutorGenero = "UPDATE livros SET nome = ?, autor = ?, genero = ? WHERE (id = ?);";
        //trabalharei com prepared statement para uma segurança melhor

        conn = new ConnectionDB().connectionDB();

        try {
            switch (id){
                case 1:
                    preparedStatement = conn.prepareStatement(queryTitulo);
                    preparedStatement.setString(1, object.getNome());
                    preparedStatement.setInt(2, object.getId());
                case 2:
                    preparedStatement = conn.prepareStatement(queryAutor);
                    preparedStatement.setString(1, object.getAutor());
                    preparedStatement.setInt(2, object.getId());
                case 3:
                    preparedStatement = conn.prepareStatement(queryGenero);
                    preparedStatement.setString(1, object.getGenero());
                    preparedStatement.setInt(2, object.getId());
                case 4:
                    preparedStatement = conn.prepareStatement(queryTituloAutor);
                    preparedStatement.setString(1, object.getNome());
                    preparedStatement.setString(2, object.getAutor());
                    preparedStatement.setInt(3, object.getId());
                case 5:
                    preparedStatement = conn.prepareStatement(queryTituloGenero);
                    preparedStatement.setString(1, object.getNome());
                    preparedStatement.setString(2, object.getGenero());
                    preparedStatement.setInt(3, object.getId());
                case 6:
                    preparedStatement = conn.prepareStatement(queryAutorGenero);
                    preparedStatement.setString(1, object.getAutor());
                    preparedStatement.setString(2, object.getGenero());
                    preparedStatement.setInt(3, object.getId());
                case 7:
                    preparedStatement = conn.prepareStatement(queryTituloAutorGenero);
                    preparedStatement.setString(1, object.getNome());
                    preparedStatement.setString(2, object.getAutor());
                    preparedStatement.setString(3, object.getGenero());
                    preparedStatement.setInt(4, object.getId());
            }

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
