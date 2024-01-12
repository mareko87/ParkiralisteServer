/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.organizacija;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Organizacija;
import java.sql.SQLException;
import so.AbstractSO;

/**
 *
 * @author Marko Milosevic
 */
public class SODeleteOrganizacija extends AbstractSO{

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Organizacija)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Organizacija!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        DBBroker.getInstance().delete(ado);
    }
    
}
