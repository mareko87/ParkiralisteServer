/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.vozilo;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Vozilo;
import java.sql.SQLException;
import so.AbstractSO;

/**
 *
 * @author marek
 */
public class SOAddVozilo extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Vozilo)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Vozilo!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        DBBroker.getInstance().insert(ado);
    }
    
}
