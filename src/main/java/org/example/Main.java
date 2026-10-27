package org.example;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        String url = "jdbc:mysql://localhost:3306/Acceso";
        String user = "root";
        String password = "romanick";
        String sqlInsert = "INSERT INTO Equipo(id, nombre, categoria, disponible)" +
                " VALUES (?, ?, ?)";

        try
            (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(sqlInsert))
        {

           ResultSet rs = pst.executeQuery();

           while (rs.next()){
               System.out.println(
                       rs.getInt("id") +
                       " | "  + rs.getString("Nombre")+
                       " | "  + rs.getString("categoria")+ " | "+
                        (rs.getBoolean("disponible")?"disponible":"no disponible")
               );

           }

        }catch(SQLException e){
            throw new  RuntimeException(e);
        }
        }
    }

