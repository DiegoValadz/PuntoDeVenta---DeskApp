package modelo;
import com.fasterxml.jackson.annotation.JsonProperty;
//import org.jongo.marshall.jackson.id.Id;

 
/**
 *
 * @author diego
 */

public class Usuario{
    @JsonProperty("_id")
    public String _id;
    
    @JsonProperty("ID_USER")
    private String ID_USER;    
    
    @JsonProperty("tipo")
    private String tipo;
 
    @JsonProperty("userState")
    private boolean userState; 
    
    @JsonProperty("google")
    private boolean google;
 
    @JsonProperty("nombre")
    private String nombre;
 
    @JsonProperty("usuario")
    private String usuario;
 
    @JsonProperty("contraseña")
    private String contraseña;
    
    @JsonProperty("direccion")
    private String direccion;
 
    @JsonProperty("email")
    private String email;
 
    @JsonProperty("ciudad")
    private String ciudad;
    
    @JsonProperty("estado")
    private String estado;
 
    @JsonProperty("cp")
    private String cp;
 
    @JsonProperty("telefono")
    private String telefono;
       
 
    public Usuario() {
        userState=true;
        contraseña=" ";
    }

   
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
  
    public String getID_USER() {
        return ID_USER;
    }

    public void setID_USER(String ID_USER) {
        this.ID_USER = ID_USER;
    }
 

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isUserState() {
        return userState;
    }

    public void setUserState(boolean userState) {
        this.userState = userState;
    }

    public boolean isGoogle() {
        return google;
    }

    public void setGoogle(boolean google) {
        this.google = google;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Usuario{" + "ID_USER=" + ID_USER + ", tipo=" + tipo + ", userState=" + userState + ", google=" + google + ", nombre=" + nombre + ", usuario=" + usuario + ", contrase\u00f1a=" + contraseña + ", direccion=" + direccion + ", email=" + email + ", ciudad=" + ciudad + ", estado=" + estado + ", cp=" + cp + ", telefono=" + telefono + '}';
    }

   
 
 
}

