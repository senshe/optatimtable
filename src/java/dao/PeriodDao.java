/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Period;
import static dao.Dao.session;
import java.util.List;

/**
 *
 * @author ElBastamy
 */
public class PeriodDao extends Dao<Period>{

    @Override
    public boolean save(Period obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Period obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Period obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Period getByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Period> getAll() {

        try {
        
        initSession();
  
        return session.getNamedQuery("Period.findAll").list();
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
