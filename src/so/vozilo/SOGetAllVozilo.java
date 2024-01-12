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
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Marko Milosevic
 */
public class SOGetAllVozilo extends AbstractSO {
    
    private ArrayList<Vozilo> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Vozilo)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Vozilo!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        ArrayList<AbstractDomainObject> listaVozila
                = (ArrayList<AbstractDomainObject>) DBBroker.getInstance().select(ado);
        lista = (ArrayList<Vozilo>) (ArrayList<?>) listaVozila;
    }
    
    public ArrayList<Vozilo> getLista() {
        return lista;
    }
    
}
