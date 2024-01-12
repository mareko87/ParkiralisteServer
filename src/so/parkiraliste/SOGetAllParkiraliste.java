/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.parkiraliste;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Parkiraliste;
import java.sql.SQLException;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @Marko Milosevic
 */
public class SOGetAllParkiraliste extends AbstractSO {
    
    private ArrayList<Parkiraliste> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Parkiraliste)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Parkiraliste!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        ArrayList<AbstractDomainObject> listaParkiralista
                = (ArrayList<AbstractDomainObject>) DBBroker.getInstance().select(ado);
        lista = (ArrayList<Parkiraliste>) (ArrayList<?>) listaParkiralista;
    }
    
    public ArrayList<Parkiraliste> getLista() {
        return lista;
    }
    
}
