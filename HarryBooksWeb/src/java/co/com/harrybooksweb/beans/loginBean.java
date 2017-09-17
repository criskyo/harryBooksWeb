/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.harrybooksweb.beans;

import co.com.harrybooksweb.dao.UsuarioDaoImpl;
import co.com.harrybooksweb.dao.UsuarioDao;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import co.com.harrybooksweb.model.Usuario;
import org.primefaces.context.RequestContext;
import co.com.harrybooksweb.util.HibernateUtil;

/**
 *
 * @author cortiz
 */
@Named(value = "loginBean")
@SessionScoped
public class loginBean implements Serializable {

    private Usuario usuario;
    private UsuarioDao usuarioDao;
    private Integer rol;

    public loginBean() {

        this.usuarioDao = new UsuarioDaoImpl();
        if (this.usuario == null) {
            this.usuario = new Usuario();
        }
    }

    public Integer getRol() {
        return rol;
    }

    public void setRol(Integer rol) {
        this.rol = rol;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
/**
 *
 * loguea el usuario
 */
    public void login() {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = new FacesMessage();
        boolean loggedIn;
        this.usuario = this.usuarioDao.login(this.usuario);
        if (this.usuario != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.usuario.getNombreUsuario());
            loggedIn = true;
            HttpSession hs = HibernateUtil.getSession();
            hs.setAttribute("usuario", this.usuario);
            if (this.usuario.getPerfilUsuario().equals(1)) {
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuario.getNombreUsuario());
                ExternalContext context1 = FacesContext.getCurrentInstance().getExternalContext();
                try {
                    context1.redirect(context1.getRequestContextPath() + "/faces/admin.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(loginBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (this.usuario.getPerfilUsuario().equals(2)) {
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuario.getNombreUsuario());
                ExternalContext context1 = FacesContext.getCurrentInstance().getExternalContext();
                try {
                    context1.redirect(context1.getRequestContextPath() + "/faces/tienda.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(loginBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else {
            loggedIn = false;
            this.usuario = new Usuario();
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Usuario y/o contraseña incorrecta.");

        }
        FacesContext.getCurrentInstance().addMessage(null, message);

    }

    public void logout() {
        String ruta = "/faces/index.xhtml";
        RequestContext context = RequestContext.getCurrentInstance();

        HttpSession session = HibernateUtil.getSession();
        session.invalidate();

        context.addCallbackParam("loggetOut", true);
        context.addCallbackParam("ruta", ruta);
        System.out.println(org.hibernate.Version.getVersionString());
    }

}
