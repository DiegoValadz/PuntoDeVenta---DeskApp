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
public class ServiceException extends Exception {
    private Integer httpStatusCode;
 
    private static final long serialVersionUID = -1873750263916403862L;
 
    public ServiceException(String message, Integer httpStatusCode) {
        super(message);
        this.httpStatusCode = httpStatusCode;
    }
 
    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }
 
    public void setHttpStatusCode(Integer httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }
}