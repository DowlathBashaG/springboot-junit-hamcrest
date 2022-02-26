package io.dowlath.demo.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/***
 * Author : Dowlath Basha G
 * Date   : 2/26/2022
 * Time   : 1:06 PM
 ***/
public class CalculatorTest {
     Calculator calc;
    /*@Test(expected = RuntimeException.class)
    public void testAdd(){
        throw new RuntimeException("Oops");
    }*/

   /* @Test()
    public void testAdd(){
        /int result = Calculator.add(3,4);
        Assert.assertEquals(7,7);
    }*/

    @Before()
    public void setup(){
         calc = new Calculator();
    }

    @Test()
    public void testAdd(){

        // arrange
        int a = 10;
        int b = 20;

        // act
        int result = Calculator.add(a,b);

        // assert
        assertEquals(30,result);

        /*
        // For Example
        assertNotNull(new Object());
        assertTrue(10==10);
        assertNotEquals(1L,2l); */
    }

    @Test
    public void test_add_not_static(){
        // arrange
        int a=10;
        int b=20;
        // act
        int result = calc.add_not_static(a,b);
        // assert
        assertEquals(30,result);
    }

    @Test
    public void test_zeroPostiveNumber(){
        // arrange
        int a = 10;
        int b = 0;
        // act
        int result = calc.add_not_static(a,b);
        // assert
        assertEquals(10,result);
    }
}
