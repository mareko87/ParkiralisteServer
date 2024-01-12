/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.administrator.login;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Administrator;
import java.sql.SQLException;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Marko Milosevic
 */
public class SOLogin extends AbstractSO{
    
    private Administrator administrator;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Administrator)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Administrator!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        if (DBBroker.getInstance() != null) {
            System.out.println("SOLogin.execute: Uspesna konekcija sa bazom!");
        }
        ArrayList<Administrator> listaAdministratora 
                = (ArrayList<Administrator>) (ArrayList<?>) DBBroker.getInstance().select(ado);
        
        Administrator prosledjenAdmin = (Administrator) ado;
        if (prosledjenAdmin == null) {
            System.out.println("prosledjenAdmin == null");
        }
        
        for (Administrator admin : listaAdministratora) {
            if(admin.getKorisnickoIme().equals(prosledjenAdmin.getKorisnickoIme()) &&
                    admin.getLozinka().equals(prosledjenAdmin.getLozinka())){
                administrator = admin;
                break;
            }
        }
    }

    public Administrator getAdministrator() {
        return administrator;
    }
    
    
}
