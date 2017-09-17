/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.harrybooksweb.dao;

import co.com.harrybooksweb.model.Libro;
import java.util.List;

/**
 *
 * @author cortiz
 */
public interface LibroDao {

    public List<Libro> findAll();

    public boolean update(Libro libro);
}
