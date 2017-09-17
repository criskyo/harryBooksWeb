/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.harrybooksweb.beans;

import co.com.harrybooksweb.dao.LibroDao;
import co.com.harrybooksweb.dao.LibroDaoImpl;
import co.com.harrybooksweb.model.Libro;
import co.com.harrybooksweb.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cortiz
 */
@Named(value = "libroBean")
@RequestScoped
public class LibroBean {

    private List<Libro> libros;

    /**
     * crea una nueva instancia de libro
     */
    public LibroBean() {
    }

    /**
     * obtiene la lista de libros
     */
    public List<Libro> getLibros() {
        this.libros = new ArrayList<Libro>();
        List<Libro> temporal = new ArrayList<Libro>();
        HttpSession session = HibernateUtil.getSession();
        LibroDao productoDao = new LibroDaoImpl();
        if ((List<Libro>) session.getAttribute("libros") != null) {
            temporal = (List<Libro>) session.getAttribute("libros");
        } else {
            temporal = productoDao.findAll();
            session.setAttribute("libros", temporal);
        }
        for (Libro prod : temporal) {

            libros.add(prod);
        }
        return libros;
    }

    /**
     * asigna los libros
     */
    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    /**
     * retorna Agotado si la cantidad disponible es 0
     */
    public String cantidadLibros(Integer cantidad) {
        return cantidad.equals(0) ? "Agotado" : cantidad.toString();
    }

}
