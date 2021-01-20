/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionetudiant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author aba
 */
public class DbUtils {

    private static  String dbURL = "jdbc:derby://localhost:1527/GestionEtudiant;create=true;user=root;password=admin";
    // jdbc Connection
    private static Connection conn;

    public static Connection createConnection() {
        if (conn == null){
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
                //Get a connection
                conn = DriverManager.getConnection(dbURL);
                return(conn);

            } catch (Exception except) {
                except.printStackTrace();
                System.out.println("Connexion non reussi");
            }
        }return conn;
    }
}
