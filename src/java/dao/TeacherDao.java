/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Teacher;
import static dao.Dao.session;
import java.util.List;

/**
 *
 * @author ElBastamy
 */
public class TeacherDao  extends Dao<Teacher>{

    @Override
    public boolean save(Teacher obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Teacher obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Teacher obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Teacher getByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Teacher> getAll() {

        try {
        
        initSession();
  
        return session.getNamedQuery("Teacher.findAll").list();
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
