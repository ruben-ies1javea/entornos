package entornos.documentacion.actividad.enunciado;

import java.io.Serializable;


public class Persona implements Serializable {

    private String nombre;
    private String apellidos;
    private String telefono;
    private int edad;

    
  
    public String getNombre() {
        return nombre;
    }

   
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   
    public String getApellidos() {
        return apellidos;
    }

   
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

  
    public String getTelefono() {
        return telefono;
    }

   
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

  
    public int getEdad() {
        return edad;
    }

    
    public void setEdad(int edad) {
        this.edad = edad;
    }
}
