/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import form.DBConnectionForm;

/**
 *
 * @author Marko Milosevic
 */
public class Start {
    
    public static void main(String[] args) {
        
        DBConnectionForm dBConnectionForm = new DBConnectionForm();
        dBConnectionForm.setLocationRelativeTo(null);
        dBConnectionForm.setVisible(true); 
    }
}
