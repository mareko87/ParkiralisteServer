/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.organizacija;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Administrator;
import domain.Organizacija;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author 38160
 */
public class SOGetAllOrganizacija extends AbstractSO {
    
    private ArrayList<Organizacija> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Organizacija)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Organizacija!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        ArrayList<AbstractDomainObject> listaOrganizacija 
                = (ArrayList<AbstractDomainObject>) DBBroker.getInstance().select(ado);
        lista = (ArrayList<Organizacija>) (ArrayList<?>) listaOrganizacija;
    }

    public ArrayList<Organizacija> getLista() {
        return lista;
    }
    

    
}
