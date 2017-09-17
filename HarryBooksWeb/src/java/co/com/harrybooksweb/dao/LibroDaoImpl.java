/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.harrybooksweb.dao;

import co.com.harrybooksweb.model.Libro;
import co.com.harrybooksweb.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author cortiz
 */
public class LibroDaoImpl implements LibroDao {

    @Override
    public List<Libro> findAll() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Libro> listado = null;
        String sql = "from Libro u";
        try {
            session.beginTransaction();
            listado = session.createQuery(sql).list();

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
        return listado;
    }

    @Override
    public boolean update(Libro libro) {
        boolean flag;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            Transaction tx = session.beginTransaction();

            Libro librodb = libro;

            session.update(librodb);
            tx.commit();

            flag = true;
        } catch (Exception e) {
            flag = false;
            throw e;
        }
        return flag;
    }

}
