/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.harrybooksweb.beans;

import co.com.harrybooksweb.dao.VentaDao;
import co.com.harrybooksweb.dao.VentaDaoImpl;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author cortiz
 */
@Named(value = "VentaBean")
@RequestScoped
public class VentaBean {

    List list;

    /**
     * obtiene la lista de ventas
     */
    public List getList() {
        VentaDao venta = new VentaDaoImpl();
        list = venta.findAllventas();
        return list;
    }

    /**
     * guarda la lista de ventas
     */
    public void setList(List list) {
        this.list = list;
    }

}
