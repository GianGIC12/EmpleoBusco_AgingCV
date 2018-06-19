/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package archivos;

import beans.PostulanteBean;
import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author user
 */
public class ExportarCSV {

    public ExportarCSV() {
    }
    
    public void exportarResultados(List<PostulanteBean> postulantes) throws IOException{
        
         String outputFile ="C:/Users/user/Google Drive/bd_AgingCV.CSV";
        
          boolean alreadyExists = new File(outputFile).exists();
          
          if (alreadyExists) {
            File bd_AgingCV= new File(outputFile);
            bd_AgingCV.delete();
        }
          
          CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ';');
          
          csvOutput.write("id_postulante");
          csvOutput.write("id_usuario");
          csvOutput.write("pais");
          csvOutput.write("nombres");
          csvOutput.write("apellidos");
          csvOutput.write("estado_civil");
          csvOutput.write("sexo");
          csvOutput.write("ultima_actualizacion");
          csvOutput.write("nivel_estudio");
          csvOutput.write("carrera");
          csvOutput.write("institucion");
          csvOutput.write("email");
          csvOutput.write("rol");
          csvOutput.write("fh_registro");
          csvOutput.write("fh_extraccion");
          
          csvOutput.endRecord();
          
          for (PostulanteBean postulante: postulantes) {
            
          csvOutput.write(postulante.getId_postulante()+"");    
          csvOutput.write(postulante.getId_usuario()+"");    
          csvOutput.write(postulante.getPais()); 
          csvOutput.write(postulante.getNombres());
          csvOutput.write(postulante.getApellidos());
          csvOutput.write(postulante.getEstado_civil());
          csvOutput.write(postulante.getSexo());
          csvOutput.write(postulante.getUltima_actualizacion());
          csvOutput.write(postulante.getMayor_nivel_estudio());
          csvOutput.write(postulante.getMejor_carrera());
          csvOutput.write(postulante.getInstitucion());
          csvOutput.write(postulante.getEmail());
          csvOutput.write(postulante.getRol());
          csvOutput.write(postulante.getFh_registro());
          csvOutput.write(postulante.getFh_extraccion());
          
          csvOutput.endRecord();
        }
          
         csvOutput.close();  
        
        
    }
    
    
    
}
