/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Isurilop
 */
public class ConsultaCandidatosGobierno {
    
        ResultSet  rs;
        ResultSetMetaData mtd;
        String[] columnas;
        String consulta,consulta2,error;
        
        public ConsultaCandidatosGobierno(String sql){
               Conexion conn = new Conexion();
                Connection con = conn.conectate();
                this.consulta=sql;
            try {
              
                Statement st = con.createStatement();
                rs= st.executeQuery(sql);
                mtd=rs.getMetaData();
                error=null;
            } catch (SQLException ex) {
              error= ex.getMessage();
            }
               
        }
            
         
        
   
        
        
     public String getError()
     {
         
         return error;
     }
     public ResultSet getResultado()
     {
         return this.rs;
     }
     public String[] getNombresColumnas() throws SQLException
     {
            int NumColumnas= mtd.getColumnCount();
            this.columnas = new String[NumColumnas];
            for(int a=0; a<NumColumnas;a++){
                
                columnas[a]=mtd.getColumnLabel(a+1);
            }
            return columnas;
     }
    
}
