/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.harrybooksweb.beans;

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
public class VentaBeanIT {
    
    public VentaBeanIT() {
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
     * Test of getList method, of class VentaBean.
     */
    @Test
    public void testGetList() {
        System.out.println("getList");
        VentaBean instance = new VentaBean();
        List expResult = null;
        List result = instance.getList();
        if(!result.isEmpty()){
            assertTrue(true);
        }else{
            fail("la lista esta vacia");
        }
        
        
    }

    /**
     * Test of setList method, of class VentaBean.
     */
    @Test
    public void testSetList() {
        System.out.println("setList");
        List list = null;
        VentaBean instance = new VentaBean();
        instance.setList(list);
       
    }
    
}
