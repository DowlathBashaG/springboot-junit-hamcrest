package io.dowlath.junit;

import org.junit.Assert;
import org.junit.Test;

/***
 * Author : Dowlath Basha G
 * Date   : 2/26/2022
 * Time   : 11:06 AM
 ***/
public class HelloWorldJunitTest {
       @Test
       public void test_greet(){
           String greeting = HelloWorldJunit.greet("Dowlath");
           Assert.assertNotNull(greeting);
           Assert.assertTrue("Hello Dowlath".equals(greeting));
       }
}
