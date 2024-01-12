/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.organizacija;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Organizacija;
import domain.Vozilo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Marko Milosevic
 */
public class SOAddOrganizacija extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Organizacija)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Organizacija!");
        }

        Organizacija o = (Organizacija) ado;

        ArrayList<Organizacija> listaOrg = (ArrayList<Organizacija>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        for (Organizacija org : listaOrg) {
            if (org.equals(o)) {
                throw new Exception("Organizacija vec postoji!");
            }
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        PreparedStatement ps = DBBroker.getInstance().insert(ado);
        Long organizacijaID = getKey(ps);

        Organizacija o = (Organizacija) ado;
        o.setOrganizacijaID(organizacijaID);

        for (Vozilo vozilo : o.getVozila()) {
            vozilo.setOrganizacija(o);
            DBBroker.getInstance().insert(vozilo);
        }
    }

    private Long getKey(PreparedStatement ps) throws SQLException {
        ResultSet tableKeys = ps.getGeneratedKeys();
        tableKeys.next();
        return tableKeys.getLong(1);
    }

}
