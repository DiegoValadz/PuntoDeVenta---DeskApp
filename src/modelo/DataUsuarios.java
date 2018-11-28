/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class DataUsuarios{

    @JsonProperty("ok")
    public boolean ok;

    @JsonProperty("usuarios")
    public ArrayList<Usuario> usuarios;

    @JsonProperty("total_usuarios")
    public int totalUsuarios;

    @Override
    public String toString() {
        return "Data{" + "ok=" + ok + ", usuarios=" + usuarios + ", totalUsuarios=" + totalUsuarios + '}';
    }

}
