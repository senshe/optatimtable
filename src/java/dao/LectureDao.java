/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Lecture;
import static dao.Dao.session;
import java.util.List;

/**
 *
 * @author ElBastamy
 */
public class LectureDao extends Dao<Lecture>{

    @Override
    public boolean save(Lecture obj) {
     try {
        
        initSession();
  session.save(obj);
        return true;
        } catch (Exception e) {
            e.printStackTrace();
           // log.fatal(e.getMessage());
            return false;
        } finally {
            session.close();
           // log.debug("********** Fin getPersonne PersonneDAO **********");
        }  
              
    }

    @Override
    public boolean update(Lecture obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Lecture obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Lecture getByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Lecture> getAll() {

        try {
        
        initSession();
  
        return session.getNamedQuery("Lecture.findAll").list();
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
