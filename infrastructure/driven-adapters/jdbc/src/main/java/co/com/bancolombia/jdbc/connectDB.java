package co.com.bancolombia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class connectDB {

    public void queryDB() {
        try {
            // Creo una conexion a la base de datos con la Url, User y Password
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cursowebspring", "root", null);

            // Creo un objeto Statement para enviar consultas a la base de datos
            Statement statement = connection.createStatement();

            // Envio la consulta y guardo la respuesta en un objeto ResultSet
            ResultSet resultSet = statement.executeQuery("SELECT * FROM usuarios");

            //Imprimo la respuesta
            System.out.println("Esta es la respuesta:");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("id")+" "+ resultSet.getString("nombre") + " " + resultSet.getString("apellido"));
            }
        } catch (Exception e) {
            System.out.println("No connect :(");
            e.printStackTrace();
        }
    }
}