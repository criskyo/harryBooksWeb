/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.harrybooksweb.beans;

import co.com.harrybooksweb.model.Item;
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
public class cartBeanIT {

    public cartBeanIT() {
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
     * Test of payment method, of class cartBean.
     */
    @Test
    public void testPayment() {
        System.out.println("payment");
        cartBean instance = new cartBean();
        String expResult = "pago";
        String result = instance.payment();
        assertEquals(expResult, result);

    }

    /**
     * Test of getSelectedItem method, of class cartBean.
     */
    @Test
    public void testGetSelectedItem() {
        System.out.println("getSelectedItem");
        cartBean instance = new cartBean();
        Item expResult = null;
        Item result = instance.getSelectedItem();
        if (result != null) {
            assertTrue(true);
        } else {
            fail("no retorna item");
        }

    }

    /**
     * Test of setSelectedItem method, of class cartBean.
     */
    @Test
    public void testSetSelectedItem() {
        System.out.println("setSelectedItem");
        Item selectedItem = null;
        cartBean instance = new cartBean();
        instance.setSelectedItem(selectedItem);

    }

    /**
     * Test of getCart method, of class cartBean.
     */
    @Test
    public void testGetCart() {
        System.out.println("getCart");
        cartBean instance = new cartBean();
        List<Item> expResult = null;
        List<Item> result = instance.getCart();
        if (result != null) {
            assertTrue(true);
        } else {
            fail("no retorna usuario");
        }

    }

    /**
     * Test of setCart method, of class cartBean.
     */
    @Test
    public void testSetCart() {
        System.out.println("setCart");
        List<Item> cart = null;
        cartBean instance = new cartBean();
        instance.setCart(cart);

    }

    /**
     * Test of getTotal method, of class cartBean.
     */
    @Test
    public void testGetTotal() {
        System.out.println("getTotal");
        cartBean instance = new cartBean();
        float expResult = 0.0F;
        float result = instance.getTotal();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of setTotal method, of class cartBean.
     */
    @Test
    public void testSetTotal() {
        System.out.println("setTotal");
        float total = 0.0F;
        cartBean instance = new cartBean();
        instance.setTotal(total);

    }

}
