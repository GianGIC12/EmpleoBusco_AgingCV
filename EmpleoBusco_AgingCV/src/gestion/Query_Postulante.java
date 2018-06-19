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
   
    
    private List<PostulanteBean> postulantes;
    
    

    public Query_Postulante() {
        
        postulantes= new ArrayList<>();
        
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

    public void conseguirPostulante(int num_dia) throws SQLException{
        
         Conexion objCon = new Conexion();
          objCon.conectar();
        
          String fecha_extraccion= fechas1[num_dia];
          
       sql="select p.id as id_postulante, p.id_usuario as id_usuario, p.pais_residencia as pais, "
            +" p.nombres as nombre, p.apellidos as apellido,p.estado_civil as estado_civil, "
            + " p.sexo as sexo, p.ultima_actualizacion as ultima_actualizacion, "
            + " p.mejor_nivel_estudio as nivel_estudio,  p.mejor_carrera as mejor_carrera, "
            + " p.institucion as institucion, u.email as email, u.rol as rol, u.fh_registro as fecha_registro "
            + " from db_empleobusco_prod.postulante as p " 
            + " join db_empleobusco_prod.usuario as u "
            + " on p.id_usuario=u.id "  
            + " where p.id >134 " + " and  u.email not like "+"'"+"%@yopmail.com" +"'" 
            + " and u.email not like "+"'"+"%@mail.com" +"'"   ;
        
       PreparedStatement stm = objCon.getCon().prepareStatement(sql);
        ResultSet rs = stm.executeQuery();       
        int contador=0; 
        
        int id_postulante=0;
        int id_usuario=0;
        String pais= "No definido ";
        String nombre= " ";
        String apellido= " ";
        String estado_civil= " ";
        String sexo= " ";
        String ultima_actualizacion= " ";
        String nivel_estudio= " ";
        String mejor_carrera= " ";
        String institucion= " ";
        String email= " ";
        String rol = " ";
        String fh_registro= " ";
        
        while (rs.next()) {
            contador++;
            
            PostulanteBean postulante= new PostulanteBean();
            
            id_postulante= rs.getInt(1);
            id_usuario= rs.getInt(2);
            
            if (rs.getString(3)!=null) {
            
                switch(rs.getInt(3)){
                
                case 2533: pais="Peru";break;
                case 4632: pais="Costa Rica";break;
                case 4610: pais="Bolivia"; break;
                case 4658: pais="Guatemala";break;
                case 4629: pais="Dominicana";break;    
                case 4711: pais="Nicaragua";break;    
                case 4720: pais="Panama";break;
                default:   pais="Unknown";break;
                    
                    
            }
                
            }
  
            
            if (rs.getString(4)!=null) {
            nombre= rs.getString(4); 
            
            nombre= nombre.replaceAll("ó", "o");
            nombre= nombre.replaceAll("é", "e");
            nombre= nombre.replaceAll("í", "i");
            nombre= nombre.replaceAll("ñ", "n");
            nombre=nombre.replaceAll("á", "a");
            nombre=nombre.replaceAll("ú","u");
            nombre=nombre.replaceAll("Á","A");
            nombre= nombre.replaceAll("–", "/");
            nombre=nombre.replaceAll("ü", "u");
            nombre=nombre.replaceAll("Ó", "O");
            nombre=nombre.replaceAll("É", "E");
            
            
            }
            
            if (rs.getString(5)!=null) {
            apellido= rs.getString(5);   
            
            apellido= apellido.replaceAll("ó", "o");
            apellido= apellido.replaceAll("é", "e");
            apellido= apellido.replaceAll("í", "i");
            apellido= apellido.replaceAll("ñ", "n");
            apellido=apellido.replaceAll("á", "a");
            apellido=apellido.replaceAll("ú","u");
            apellido=apellido.replaceAll("Á","A");
            apellido= apellido.replaceAll("–", "/");
            apellido=apellido.replaceAll("ü", "u");
            apellido=apellido.replaceAll("Ó", "O");
            apellido=apellido.replaceAll("É", "E");
            
            }
            if (rs.getString(6)!=null) {
            estado_civil= rs.getString(6);
                
            }
            if (rs.getString(7)!=null) {
            sexo= rs.getString(7);    
            }
            if (rs.getString(8)!=null) {
               
            ultima_actualizacion= rs.getString(8);
            ultima_actualizacion= ultima_actualizacion.substring(0, 10);
             
            }
            if (rs.getString(9)!=null) {
            nivel_estudio= rs.getString(9);
                
            nivel_estudio= nivel_estudio.replaceAll("ó", "o");
            nivel_estudio= nivel_estudio.replaceAll("é", "e");
            nivel_estudio= nivel_estudio.replaceAll("í", "i");
            nivel_estudio= nivel_estudio.replaceAll("ñ", "n");
            nivel_estudio=nivel_estudio.replaceAll("á", "a");
            nivel_estudio=nivel_estudio.replaceAll("ú","u");
            nivel_estudio=nivel_estudio.replaceAll("Á","A");
            nivel_estudio= nivel_estudio.replaceAll("–", "/");
            nivel_estudio=nivel_estudio.replaceAll("ü", "u");
            nivel_estudio=nivel_estudio.replaceAll("Ó", "O");
            nivel_estudio=nivel_estudio.replaceAll("É", "E");
            
            
            }
            if (rs.getString(10)!=null) {
            mejor_carrera= rs.getString(10);
                
            
            mejor_carrera= mejor_carrera.replaceAll("ó", "o");
            mejor_carrera= mejor_carrera.replaceAll("é", "e");
            mejor_carrera= mejor_carrera.replaceAll("í", "i");
            mejor_carrera= mejor_carrera.replaceAll("ñ", "n");
            mejor_carrera=mejor_carrera.replaceAll("á", "a");
            mejor_carrera=mejor_carrera.replaceAll("ú","u");
            mejor_carrera=mejor_carrera.replaceAll("Á","A");
            mejor_carrera= mejor_carrera.replaceAll("–", "/");
            mejor_carrera=mejor_carrera.replaceAll("ü", "u");
            mejor_carrera=mejor_carrera.replaceAll("Ó", "O");
            mejor_carrera=mejor_carrera.replaceAll("É", "E");
            
            
            
            
            }
            if (rs.getString(11)!=null) {
            institucion= rs.getString(11);
                
            institucion=institucion.replaceAll("ó", "o");
            institucion= institucion.replaceAll("é", "e");
            institucion= institucion.replaceAll("í", "i");
            institucion= institucion.replaceAll("ñ", "n");
            institucion=institucion.replaceAll("á", "a");
            institucion=institucion.replaceAll("ú","u");
            institucion=institucion.replaceAll("Á","A");
            institucion= institucion.replaceAll("–", "/");
            institucion=institucion.replaceAll("ü", "u");
            institucion=institucion.replaceAll("Ó", "O");
            institucion=institucion.replaceAll("É", "E");
            
            
            
            }
            if (rs.getString(12)!=null) {
            email= rs.getString(12);
                
            }
            if (rs.getString(13)!=null) {
            rol= rs.getString(13);
                
            }
            if (rs.getString(14)!=null) {
            fh_registro= rs.getString(14);
            fh_registro= fh_registro.substring(0,10);
                
            }
            
            
            
            postulante.setId_postulante(id_postulante);
            postulante.setId_usuario(id_usuario);
            postulante.setPais(pais);
            postulante.setNombres(nombre);
            postulante.setApellidos(apellido);
            postulante.setEstado_civil(estado_civil);
            postulante.setSexo(sexo);
            postulante.setUltima_actualizacion(ultima_actualizacion);
            postulante.setMayor_nivel_estudio(nivel_estudio);
            postulante.setMejor_carrera(mejor_carrera);
            postulante.setInstitucion(institucion);
            postulante.setEmail(email);
            postulante.setRol(rol);
            postulante.setFh_registro(fh_registro);
            postulante.setFh_extraccion(fecha_extraccion);
            
            postulantes.add(postulante);
            
            System.out.println(contador+ " : "+"extracción"+rs.getInt(1));
            
            
        }
        
        objCon.desconectar(); 
       
        
        
    }
    
    public void mostrarPostulantes(){
        
        int contador=0;
        for (PostulanteBean postulante: postulantes) {
            contador++;
            
            System.out.println(contador+ " : " + " id_postulante: "+postulante.getId_postulante()
            +" id_usuario: "+postulante.getId_usuario()
            + " pais: " + postulante.getPais()
            + " nombres: "+ postulante.getNombres()
            +  " apellidos: "+ postulante.getApellidos()
            + " estado_civil: "+ postulante.getEstado_civil()
            + " sexo: "+postulante.getSexo()
            + " ultima_actualizaci: "+postulante.getUltima_actualizacion() 
            +" nivel_estudio: " + postulante.getMayor_nivel_estudio()
            + " carrera: "+ postulante.getMejor_carrera()
            + " institucion: "+postulante.getInstitucion()
            +" email: "+ postulante.getEmail()
            +" rol: "+postulante.getRol()
            + " fh_registro: "+postulante.getFh_registro()
            + " fh_extraccion: "+postulante.getFh_extraccion());
            
            
            
        }
        
        
        
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String[] getFechas1() {
        return fechas1;
    }

    public void setFechas1(String[] fechas1) {
        this.fechas1 = fechas1;
    }

    public List<PostulanteBean> getPostulantes() {
        return postulantes;
    }

    public void setPostulantes(List<PostulanteBean> postulantes) {
        this.postulantes = postulantes;
    }
    
    
    
    
}
