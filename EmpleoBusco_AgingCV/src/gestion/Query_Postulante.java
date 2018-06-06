/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestion;

import beans.PostulanteBean;
import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author user
 */
public class Query_Postulante {
    
    private String sql;
    String[] fechas1;
    
    private List<PostulanteBean> postulante;
    
    

    public Query_Postulante() {
        
        postulante= new ArrayList<>();
        
        fechas1= new String[366];
        
    }
    
    
    public void llenarFechas1() {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();

        String fecha = dateFormat.format(date);
        String annio = fecha.substring(0, 4);
        int aux = Integer.parseInt(annio) - 1;

        fechas1[0] = aux + "-12-31";

        int contador = 0;

        for (int i = 1; i <= 12; i++) {

            String mes = "-0";

            if (i >= 10) {
                mes = "-";
            }

            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {

                for (int j = 1; j <= 31; j++) {
                    contador++;

                    if (j < 10) {

                        fechas1[contador] = annio + mes + i + "-0" + j;

                    } else {

                        fechas1[contador] = annio + mes + i + "-" + j;

                    }

                }

            } else if (i == 2) {

                for (int j = 1; j <= 28; j++) {
                    contador++;

                    if (j < 10) {

                        fechas1[contador] = annio + mes + i + "-0" + j;

                    } else {

                        fechas1[contador] = annio + mes + i + "-" + j;

                    }

                }

            } else {

                for (int j = 1; j <= 30; j++) {
                    contador++;

                    if (j < 10) {

                        fechas1[contador] = annio + mes + i + "-0" + j;

                    } else {

                        fechas1[contador] = annio + mes + i + "-" + j;

                    }

                }

            }

        }

    }
    
    public void listarfechas1() {

        for (int i = 0; i < fechas1.length; i++) {

            System.out.println(fechas1[i]);
        }

    }

    public void conseguirPostulante() throws SQLException{
        
         Conexion objCon = new Conexion();
          objCon.conectar();
        
       sql="";
        
       PreparedStatement stm = objCon.getCon().prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        
        int contador=0;
       
        while (rs.next()) {
            
            
            
        }
        
        objCon.desconectar(); 
       
        
        
    }
    
    
    
    
    
    
}
