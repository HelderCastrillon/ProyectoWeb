/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.dao.connect.pgConnect;
import com.mycompany.models.Paises;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Helder Castrillon
 */
public class PaisesDao {
    public static List<Paises> getPaises(){
        
         List<Paises> listaPAises = new ArrayList();   
            // TODO code application logic here

              try {
                  pgConnect connectPG = new pgConnect();
                  Connection conex=connectPG.settingConnect();
                  java.sql.Statement st = conex.createStatement();  
  
                  String sql ="SELECT countryid, countryname,regionid FROM countries";
                  ResultSet result = st.executeQuery(sql);
                  while(result.next()) {
                      String countryid = result.getString("countryid");
                      String countryname = result.getString("countryname");
                      int regionid = result.getInt("regionid");                      
                      
                       Paises pais = new Paises(countryid,countryname,regionid);
                       listaPAises.add(pais);
                       System.out.println(pais);
                  }
                  result.close();
                  st.close();
                  conex.close();
              } catch(ClassNotFoundException | SQLException exc) {
                  System.out.println("Error: "+exc.getMessage());
                  Paises pais = new Paises("Error","Error no se pudo hacer la consulta SQL",0);
                  listaPAises.add(pais);
              }

        return listaPAises;
        
    }
    
        public static List<Paises> findPaises(String nombre){
        
         List<Paises> listaPAises = new ArrayList();   
            // TODO code application logic here

              try {
                  pgConnect connectPG = new pgConnect();
                  Connection conex=connectPG.settingConnect();
                  java.sql.Statement st = conex.createStatement();  
  
                  String sql ="SELECT countryid, countryname,regionid FROM countries where countryname='"+nombre+"'";
                  ResultSet result = st.executeQuery(sql);
                  while(result.next()) {
                      String countryid = result.getString("countryid");
                      String countryname = result.getString("countryname");
                      int regionid = result.getInt("regionid");                      
                      
                       Paises pais = new Paises(countryid,countryname,regionid);
                       listaPAises.add(pais);
                       System.out.println(pais);
                  }
                  result.close();
                  st.close();
                  conex.close();
              } catch(ClassNotFoundException | SQLException exc) {
                  System.out.println("Error: "+exc.getMessage());
                  Paises pais = new Paises("Error","Error no se pudo hacer la consulta SQL",0);
                  listaPAises.add(pais);
              }

        return listaPAises;
        
    }
        public static boolean setPaises(Paises pais){
        
              try {
                  pgConnect connectPG = new pgConnect();
                  Connection conex=connectPG.settingConnect();
                  java.sql.Statement st = conex.createStatement();  
  
                  String sql ="INSERT INTO countries(countryid, countryname, regionid) VALUES ('"+pais.getCountryid()+"','"+pais.getCountryname()+"',"+pais.getRegionid()+")";
                  System.out.println(sql);
                st.executeQuery(sql);
                  st.close();
                  conex.close();
                  return true;
              } catch(ClassNotFoundException | SQLException exc) {
                  return false;
              }


    }
}
