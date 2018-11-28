package modelo;
import com.fasterxml.jackson.annotation.JsonProperty;
//import org.jongo.marshall.jackson.id.Id;
import org.codehaus.jackson.annotate.JsonSetter;
 
/**
 *
 * @author diego
 */

public class Usuario{
    private String ID;    
    
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

    public Usuario() {
    }

    public Usuario(String ID, String tipo, boolean userState, boolean google, String nombre, String usuario, String contraseña) {
        this.ID = ID;
        this.tipo = tipo;
        this.userState = userState;
        this.google = google;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }
 
  

    public String getId() {
        return ID;
    }
    @JsonSetter("ID")
    public void setId(String ID) {
        this.ID = ID;
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
        return "Usuario{" + "id=" + ID + ", tipo=" + tipo + ", userState=" + userState + ", google=" + google + ", nombre=" + nombre + ", usuario=" + usuario + ", contraseña=" + contraseña + '}';
    }
 
 
}

