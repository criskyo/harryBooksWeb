/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.harrybooksweb.beans;

import co.com.harrybooksweb.model.Usuario;
import java.awt.event.ActionEvent;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cortiz
 */
public class UsuarioBeanIT {
    
    public UsuarioBeanIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    /**
     * Test of setUsuarios method, of class UsuarioBean.
     */
    @Test
    public void testSetUsuarios() {
        System.out.println("setUsuarios");
        List<Usuario> usuarios = null;
        UsuarioBean instance = new UsuarioBean();
        instance.setUsuarios(usuarios);
        
    }

    /**
     * Test of getUsuario1 method, of class UsuarioBean.
     */
    @Test
    public void testGetUsuario1() {
        System.out.println("getUsuario1");
        UsuarioBean instance = new UsuarioBean();
        Usuario expResult = null;
        Usuario result = instance.getUsuario1();
        if(result!=null){
            assertTrue(true);
        }
        else{
            fail("no retorna usuario");
        }
        
        
    }

    /**
     * Test of setUsuario1 method, of class UsuarioBean.
     */
    @Test
    public void testSetUsuario1() {
        System.out.println("setUsuario1");
        Usuario usuario1 = null;
        UsuarioBean instance = new UsuarioBean();
        instance.setUsuario1(usuario1);
        
    }

    
}
