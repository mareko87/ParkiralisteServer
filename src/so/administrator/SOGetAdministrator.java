/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.administrator;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Administrator;
import domain.Organizacija;
import java.sql.SQLException;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author marek
 */
public class SOGetAdministrator extends AbstractSO{
    
    private Administrator administrator;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Administrator)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Administrator!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        ArrayList<Administrator> listaAdministratora
                = (ArrayList<Administrator>) (ArrayList<?>) DBBroker.getInstance().select(ado);
        Administrator prosledjenAdmin = (Administrator) ado;
        for (Administrator admin : listaAdministratora) {
            if (admin.equals(prosledjenAdmin)) {
                administrator = admin;
                break;
            }
        }
    }

    public Administrator getAdministrator() {
        return administrator;
    }
}
