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
 * @author Marko Milosevic
 */
public class SOGetOrganizacija extends AbstractSO {

    private Organizacija organizacija;
    
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Organizacija)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Organizacija!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        ArrayList<Organizacija> listaOrganizacija
                = (ArrayList<Organizacija>) (ArrayList<?>) DBBroker.getInstance().select(ado);
        Organizacija prosledjenaOrg = (Organizacija) ado;
        for (Organizacija org : listaOrganizacija) {
            if (org.equals(prosledjenaOrg)) {
                organizacija = org;
                break;
            }
        }
    }

    public Organizacija getOrganizacija() {
        return organizacija;
    }
    
    
}
