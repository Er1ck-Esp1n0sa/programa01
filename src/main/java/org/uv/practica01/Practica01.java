/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package org.uv.practica01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erikc
 */
public class Practica01 {

    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        try {
            String sql = "insert into empleados(clave, nombre, direccion, telefono) values"
                    +"('01', 'Erick','av 1','555')";
            String url = "jdbc:postgresql://localhost:5433/ejemplo";
            String pwd = "1234";
            String user = "postgres";
            con = DriverManager.getConnection(url,user,pwd);
            Logger.getLogger(Practica01.class.getName()).log(Level.INFO, "Se conecto");
            st = con.createStatement();
            st.execute(sql);
            Logger.getLogger(Practica01.class.getName()).log(Level.INFO, "Se guardo");
            
        } catch (SQLException ex) {
            Logger.getLogger(Practica01.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try{
            if(st != null)
                    st.close();
            } catch (SQLException ex) {
                Logger.getLogger(Practica01.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
            if(con != null)
                    con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Practica01.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            }
        }
    }

