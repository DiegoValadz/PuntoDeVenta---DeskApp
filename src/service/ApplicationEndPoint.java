/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author diego
 */
public class ApplicationEndPoint {
    private static String USUARIOS = "";
 
    public static String getUser(int desde) {
        return USUARIOS.concat(String.format("/?desde=", desde));
    }
}