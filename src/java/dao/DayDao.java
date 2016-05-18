/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Day;
import static dao.Dao.session;
import java.util.List;

/**
 *
 * @author ElBastamy
 */
public class DayDao  extends Dao<Day>{

    @Override
    public boolean save(Day obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Day obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Day obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Day getByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Day> getAll() {

        try {
        
        initSession();
  
        return session.getNamedQuery("Day.findAll").list();
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
