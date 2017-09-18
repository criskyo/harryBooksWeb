/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.harrybooksweb.beans;

import co.com.harrybooksweb.model.Libro;
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
public class LibroBeanIT {
    
    public LibroBeanIT() {
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
    
    @Test
    public void testCantidadLibros2() {
        System.out.println("cantidadLibros2");
        Integer cantidad = 2;
        LibroBean instance = new LibroBean();
        String expResult = "2";
        String result = instance.cantidadLibros(cantidad);
        assertEquals(expResult, result);
    }

    @Test
    public void testCantidadLibros1() {
        System.out.println("cantidadLibros2");
        Integer cantidad = 1;
        LibroBean instance = new LibroBean();
        String expResult = "1";
        String result = instance.cantidadLibros(cantidad);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCantidadLibrosAgotado() {
        System.out.println("cantidadLibrosAgotado");
        Integer cantidad = 0;
        LibroBean instance = new LibroBean();
        String expResult = "Agotado";
        String result = instance.cantidadLibros(cantidad);
        assertEquals(expResult, result);
    }

    /**
     * Test of setLibros method, of class LibroBean.
     */
    @Test
    public void testSetLibros() {
        System.out.println("setLibros");
        List<Libro> libros = null;
        LibroBean instance = new LibroBean();
        instance.setLibros(libros);
        
    }

    /**
     * Test of cantidadLibros method, of class LibroBean.
     */
    @Test
    public void testCantidadLibros() {
        System.out.println("cantidadLibros");
        Integer cantidad = 3;
        LibroBean instance = new LibroBean();
        String expResult = "3";
        String result = instance.cantidadLibros(cantidad);
        assertEquals(expResult, result);
        
    }
    
}
