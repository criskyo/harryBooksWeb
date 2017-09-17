/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.harrybooksweb.dao;

import java.util.List;
import co.com.harrybooksweb.model.Venta;

/**
 *
 * @author cortiz
 */
public interface VentaDao {

    public List<Venta> findAll();

    public boolean create(Venta venta);

    public List findAllventas();

}
