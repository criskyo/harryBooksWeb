/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.harrybooksweb.beans;

import co.com.harrybooksweb.model.Usuario;
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
public class loginBeanIT {
    
    public loginBeanIT() {
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
     * Test of getRol method, of class loginBean.
     */
    @Test
    public void testGetRol() {
        System.out.println("getRol");
        loginBean instance = new loginBean();
        Integer expResult = null;
        Integer result = instance.getRol();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setRol method, of class loginBean.
     */
    @Test
    public void testSetRol() {
        System.out.println("setRol");
        Integer rol = null;
        loginBean instance = new loginBean();
        instance.setRol(rol);
        
    }

    /**
     * Test of getUsuario method, of class loginBean.
     */
    @Test
    public void testGetUsuario() {
        System.out.println("getUsuario");
        loginBean instance = new loginBean();
        Usuario expResult = null;
        Usuario result = instance.getUsuario();
        if(result!=expResult)
        {
            assertTrue(true);
        }else{
            fail("no trae el usuario");
        }
        
        
    }

    /**
     * Test of setUsuario method, of class loginBean.
     */
    @Test
    public void testSetUsuario() {
        System.out.println("setUsuario");
        Usuario usuario = null;
        loginBean instance = new loginBean();
        instance.setUsuario(usuario);
        
    }

    

    
    
}
