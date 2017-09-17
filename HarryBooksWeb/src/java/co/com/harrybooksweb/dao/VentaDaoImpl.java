/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.harrybooksweb.dao;

import java.util.List;
import co.com.harrybooksweb.model.Venta;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import co.com.harrybooksweb.util.HibernateUtil;

/**
 *
 * @author cortiz
 */
public class VentaDaoImpl implements VentaDao {

    @Override
    public List<Venta> findAll() {
        List<Venta> listado = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        String sql = "from model.Venta u ";

        try {
            session.beginTransaction();
            listado = session.createQuery(sql).list();

        } catch (Exception e) {
            throw e;
        }
        return listado;
    }

    @Override
    public List findAllventas() {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List result = null;

        try {
            session.beginTransaction();
            Query query = session.createSQLQuery(
                    "SELECT u.nombre_usuario,l.titulo_libro,l.precio_libro,v.cantidad_libro,v.total_libro,v.fecha_venta FROM harrybooksbd.libro l,harrybooksbd.venta v,harrybooksbd.usuario u where v.id_libro=l.id_libro and v.id_usuario=u.id_usuario");
            result = query.list();

        } catch (Exception e) {
            throw e;
        }
        return result;
    }

    @Override
    public boolean create(Venta venta) {
        boolean flag;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            Transaction tx = session.beginTransaction();
            session.persist(venta);
            session.save(venta);
            tx.commit();

            flag = true;
        } catch (Exception e) {
            flag = false;
            throw e;
        }
        return flag;
    }

}
