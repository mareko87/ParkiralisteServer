/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.administrator;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Administrator;
import java.sql.SQLException;
import so.AbstractSO;

/**
 *
 * @author Marko Milosevic
 */
public class SODeleteAdministrator extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Administrator)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Administrator!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        DBBroker.getInstance().delete(ado);
    }

}
