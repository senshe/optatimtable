/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Timeslot;
import static dao.Dao.session;
import java.util.List;

/**
 *
 * @author ElBastamy
 */
public class TimeslotDao extends Dao<Timeslot>{

    @Override
    public boolean save(Timeslot obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Timeslot obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Timeslot obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Timeslot getByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Timeslot> getAll() {

        try {
        
        initSession();
  
        return session.getNamedQuery("Timeslot.findAll").list();
        } catch (Exception e) {
            e.printStackTrace();
           // log.fatal(e.getMessage());
            return null;
        } finally {
            session.close();
           // log.debug("********** Fin getPersonne PersonneDAO **********");
        }  
                
                }
    
}
