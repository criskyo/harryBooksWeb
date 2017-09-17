/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.harrybooksweb.beans;

import co.com.harrybooksweb.dao.UsuarioDao;
import co.com.harrybooksweb.dao.UsuarioDaoImpl;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import co.com.harrybooksweb.model.Usuario;

/**
 *
 * @author cortiz
 */
@Named(value = "usuarioBean")
@RequestScoped
public class UsuarioBean {

    private List<Usuario> usuarios;

    private Usuario usuario1 = new Usuario();

    /**
     * crea una nueva instancia de UsuarioBean
     */
    public UsuarioBean() {
        this.usuarios = new ArrayList<Usuario>();
    }

    /**
     * obtiene la lista de usuarios
     */
    public List<Usuario> getUsuarios() {
        UsuarioDao clienteDao = new UsuarioDaoImpl();
        this.usuarios = clienteDao.findAll();
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    /**
     * crea el usuario
     */
    public void btnCreateCliente(ActionEvent event) {
        String msg;

        UsuarioDao usuarioDao = new UsuarioDaoImpl();

        if (usuarioDao.create(this.usuario1)) {
            msg = "usuario registrado corectamente";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "Eror al registrar usuario";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

}
