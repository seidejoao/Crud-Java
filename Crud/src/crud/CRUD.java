package crud;

import connection.ConnectionDB;
import object.Object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class CRUD {
    Connection conn;
    PreparedStatement preparedStatement;

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

}
