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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private String msg;

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

    public void update(Object object){
        String query = "UPDATE livros SET nome = ?, autor=?, genero=? WHERE (id = ?);";
        //trabalharei com prepared statement para uma segurança melhor

        conn = new ConnectionDB().connectionDB();

        try {
            preparedStatement = conn.prepareStatement(query);

            preparedStatement.setString(1, object.getNome());
            preparedStatement.setString(3, object.getGenero());
            preparedStatement.setInt(4, object.getId());

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
