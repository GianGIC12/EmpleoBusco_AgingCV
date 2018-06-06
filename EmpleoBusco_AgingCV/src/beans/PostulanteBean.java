/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

/**
 *
 * @author user
 */
public class PostulanteBean {
    
    private int id_postulante,id_usuario,id_ubigeo;
    private String nombres,apellidos,estado_civil,sexo;
    private String ultima_actualizacion;
    private String mayor_nivel_estudio;
    private String mejor_carrera;
    private String institucion;
    private String email,rol;
    private String fh_edicion;
    

    public PostulanteBean() {
        
        
    }

    public int getId_postulante() {
        return id_postulante;
    }

    public void setId_postulante(int id_postulante) {
        this.id_postulante = id_postulante;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_ubigeo() {
        return id_ubigeo;
    }

    public void setId_ubigeo(int id_ubigeo) {
        this.id_ubigeo = id_ubigeo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getUltima_actualizacion() {
        return ultima_actualizacion;
    }

    public void setUltima_actualizacion(String ultima_actualizacion) {
        this.ultima_actualizacion = ultima_actualizacion;
    }

    public String getMayor_nivel_estudio() {
        return mayor_nivel_estudio;
    }

    public void setMayor_nivel_estudio(String mayor_nivel_estudio) {
        this.mayor_nivel_estudio = mayor_nivel_estudio;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getMejor_carrera() {
        return mejor_carrera;
    }

    public void setMejor_carrera(String mejor_carrera) {
        this.mejor_carrera = mejor_carrera;
    }

    public String getFh_edicion() {
        return fh_edicion;
    }

    public void setFh_edicion(String fh_edicion) {
        this.fh_edicion = fh_edicion;
    }
    
 
    
}
