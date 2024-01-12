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
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author marek
 */
public class SOEditOrganizacija extends AbstractSO {
    
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Organizacija)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Organizacija!");
        }

        Organizacija o = (Organizacija) ado;

        ArrayList<Organizacija> listaOrg = (ArrayList<Organizacija>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        for (Organizacija org : listaOrg) {
            if (org.getOrganizacijaID() != o.getOrganizacijaID()) {
                if (org.equals(o)) {
                    throw new Exception("Organizacija vec postoji!");
                }
            }
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        DBBroker.getInstance().update(ado);
    }

}
