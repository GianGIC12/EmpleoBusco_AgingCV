/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas;

import archivos.ExportarCSV;
import gestion.Query_Postulante;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;

/**
 *
 * @author user
 */
public class PostulanteCV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, IOException {
        // TODO code application logic here
        
        
           Calendar calendar = Calendar.getInstance();

        int num_dia = calendar.get(Calendar.DAY_OF_YEAR);
System.out.println("" + num_dia);

        System.out.println("estamos en el día: " + num_dia);
        
        
        Query_Postulante q = new Query_Postulante();
        
        
        
        q.llenarFechas1();
        q.listarfechas1();
        
      
        
        
        q.conseguirPostulante(num_dia);
        
        q.mostrarPostulantes();
        
        
        ExportarCSV e= new ExportarCSV();
        
        e.exportarResultados(q.getPostulantes());
        System.out.println("Exportacion Completa");
    }
    
}
