/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.harrybooksweb.beans;

import co.com.harrybooksweb.dao.LibroDao;
import co.com.harrybooksweb.dao.LibroDaoImpl;
import co.com.harrybooksweb.dao.VentaDao;
import co.com.harrybooksweb.dao.VentaDaoImpl;
import java.io.Serializable;
import java.util.*;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import co.com.harrybooksweb.model.Item;
import co.com.harrybooksweb.model.Libro;
import co.com.harrybooksweb.model.Usuario;
import co.com.harrybooksweb.model.Venta;
import org.primefaces.context.RequestContext;
import co.com.harrybooksweb.util.HibernateUtil;

/**
 *
 * @author cortiz
 */
@Named(value = "sp")
@SessionScoped
public class cartBean implements Serializable {

    private List<Item> cart = new ArrayList<Item>();
    private float total;
    private Item selectedItem = new Item();

    
/**
 *
 * crea una nueva instancia de el carrito
 */
    public cartBean() {
    }

 /**
 *
 * agrega una compra a un carrito
 */
    public List<Item> addtoCart(Libro p, Integer cantidad) {
        HttpSession session = HibernateUtil.getSession();

        if ((List<Item>) session.getAttribute("carrito") != null) {
            cart = (List<Item>) session.getAttribute("carrito");
        }

        for (Item item : cart) {
            if (item.getLibro().getIdLibro().equals(p.getIdLibro())) {
                item.setCantidad(cantidad + item.getCantidad());
                item.setId(p.getIdLibro());
                return cart;
            }

        }
        Item item1 = new Item();
        item1.setCantidad(cantidad);
        item1.setLibro(p);
        item1.setValorTotal(cantidad * p.getPrecioLibro());
        item1.setId(p.getIdLibro());
        cart.add(item1);
        session.setAttribute("carrito", this.cart);
        return cart;
    }

 /**
 *
 * elimina un libro del carrito
 */
    public void remove(Item i) {
        String msg;
        HttpSession session = HibernateUtil.getSession();
        List<Item> lista = (List<Item>) session.getAttribute("carrito");

        if (lista.remove(i)) {

            msg = "Se elimino correctamente el registro";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

        session.setAttribute("carrito", lista);

    }

    public String payment() {
        return "pago";
    }

/**
 *
 * muestra el dialogo de confirmar cancelar
 */
    public void MensajeConfirmarCancelar() {
        Map<String, Object> options = new HashMap<String, Object>();
        options.put("resizable", false);
        options.put("draggable", false);
        options.put("modal", true);
        RequestContext.getCurrentInstance().openDialog("cancelar", options, null);

    }

    public void closeDialog() {
        RequestContext.getCurrentInstance().closeDialog(this);
    }

/**
 *
 * cancela la compra
 */
    public void cancelarCompra() {
        String msg;
        HttpSession session = HibernateUtil.getSession();

        List<Item> lista = (List<Item>) session.getAttribute("carrito");

        lista.removeAll(lista);
        msg = "Se cancelo correctamente la compra";
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
        FacesContext.getCurrentInstance().addMessage(null, message);

        session.setAttribute("carrito", lista);

    }

/**
 *
 * confirmar la compra
 */
    public void confirmarCompra() {
        String msg;
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        Usuario user = (Usuario) session.getAttribute("usuario");

        List<Item> lista = (List<Item>) session.getAttribute("carrito");

        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        VentaDao ventaDao = new VentaDaoImpl();
        LibroDao libroDao = new LibroDaoImpl();
        Integer cantidad = ventaDao.findAll().size();
        for (Item item : lista) {
            Venta venta = new Venta(cantidad = cantidad + 1, user.getIdUsuario(), item.getLibro().getIdLibro(), date, item.getCantidad().toString(), item.getCantidad() * item.getLibro().getPrecioLibro());
            Libro libro = item.getLibro();
            Integer nuevaCantidad = new Integer(libro.getCantidadDisponible()) - new Integer(item.getCantidad());
            if (nuevaCantidad > 0) {
                libro.setCantidadDisponible(nuevaCantidad.toString());
                libroDao.update(libro);

            } else {
                msg = "no se puede realizar la compra. numero de libros no disponible";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
                FacesContext.getCurrentInstance().addMessage(null, message);
            }

            if (ventaDao.create(venta)) {
                msg = "Hemos recibido su solicitud y será procesada por nuestros agentes. Gracias por su compra";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
                FacesContext.getCurrentInstance().addMessage(null, message);

            } else {
                msg = "Eror al registrar la compra";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        }
        liberarCarrito();
    }
/**
 *
 * borra los items de el carrito
 */
    public void liberarCarrito() {
        String msg;
        HttpSession session = HibernateUtil.getSession();

        List<Item> lista = (List<Item>) session.getAttribute("carrito");

        lista.removeAll(lista);

        session.setAttribute("carrito", lista);

    }
    
    public Item getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(Item selectedItem) {
        this.selectedItem = selectedItem;
    }
    
    public List<Item> getCart() {
        return cart;
    }

    public void setCart(List<Item> cart) {
        this.cart = cart;
    }

    public float getTotal() {
        total = 0;
        for (Item item : cart) {
            total += item.getLibro().getPrecioLibro() * item.getCantidad();

        }
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

}
