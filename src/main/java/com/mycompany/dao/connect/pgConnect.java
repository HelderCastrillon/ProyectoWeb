/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Helder Castrillon
 */
public class pgConnect {

    public pgConnect() {
    }
    

    
    public  Connection settingConnect() throws ClassNotFoundException, SQLException{
        String cadena = "jdbc:postgresql://localhost:5432/ventas";
        String user ="postgres";
        String pass = "desa4361";
        Class.forName("org.postgresql.Driver");
        Connection conex = DriverManager.getConnection(cadena,user,pass);
        return conex;
    }
    
    
}
