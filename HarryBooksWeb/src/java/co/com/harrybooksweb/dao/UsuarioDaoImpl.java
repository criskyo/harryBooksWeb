/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.harrybooksweb.dao;

import java.util.List;
import co.com.harrybooksweb.model.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;
import co.com.harrybooksweb.util.HibernateUtil;

/**
 *
 * @author cortiz
 */
public class UsuarioDaoImpl implements UsuarioDao {

    @Override
    public Usuario findByUsuario(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Usuario model = null;

        String sql = "from Usuario where nombreUsuario = '" + usuario.getNombreUsuario() + "'";

        try {
            session.beginTransaction();
            model = (Usuario) session.createQuery(sql).uniqueResult();

            return model;

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public Usuario findById(Long id) {
        Usuario model = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        String sql = "from Usuario where idUsuario =" + id;

        try {
            session.beginTransaction();
            model = (Usuario) session.createQuery(sql).uniqueResult();

            return model;
        } catch (Exception e) {
            // session.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public Usuario login(Usuario usuario) {
        Usuario model = findByUsuario(usuario);
        if (model != null) {
            if (!usuario.getContrasenaUsuario().equals(model.getContrasenaUsuario())) {
                model = null;
            }
        }
        return model;
    }

    @Override
    public List<Usuario> findAll() {
        List<Usuario> listado = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        String sql = "from model.Usuario u ";

        try {
            session.beginTransaction();
            listado = session.createQuery(sql).list();

        } catch (Exception e) {
            // session.getTransaction().rollback();
            throw e;
        }
        return listado;
    }

    @Override
    public boolean create(Usuario usuario) {
        boolean flag;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            Transaction tx = session.beginTransaction();
            session.persist(usuario);
            session.save(usuario);
            tx.commit();

            flag = true;
        } catch (Exception e) {
            flag = false;
            throw e;
        }
        return flag;

    }

    @Override
    public boolean update(Usuario usuario) {
        boolean flag;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            session.beginTransaction();
            Usuario usuariodb = usuario;

            session.update(usuariodb);

            flag = true;
        } catch (Exception e) {
            flag = false;
            throw e;
        }
        return flag;
    }

    @Override
    public boolean delete(Integer id) {
        boolean flag;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            session.beginTransaction();
            Usuario usuario = (Usuario) session.load(Usuario.class, id);
            session.delete(usuario);

            flag = true;
        } catch (Exception e) {
            flag = false;
            throw e;
        }
        return flag;
    }
}
