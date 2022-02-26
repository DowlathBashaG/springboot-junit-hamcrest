package io.dowlath.demo.mockito.controller;

import io.dowlath.demo.mockito.service.AuthenticationService;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

/***
 * Author : Dowlath Basha G
 * Date   : 2/26/2022
 * Time   : 4:16 PM
 ***/
public class LoginControllerTest {

    private LoginController controller; // SUT
    private AuthenticationService service; //mock

    @Before
    public void setup() throws Exception{
       this.service = mock(AuthenticationService.class);
       this.controller = new LoginController(this.service);
    }

    @Test
    public void testService(){
        //arrange
        when(service.authenticate(anyString(),anyString())).thenReturn(true);
        // act
        String viewPath = controller.service("Dowlath","Basha");
        //assert
        assertNotNull(viewPath);
        assertEquals("/home",viewPath);
    }

    @Test
    public void testService_validUsernameAndPassword_logsInUser(){
        //arrange
        when(service.authenticate(anyString(),anyString())).thenReturn(true);
        // act
        String viewPath = controller.service("Dowlath","Basha");
        //assert
        assertNotNull(viewPath);
        assertEquals("/home",viewPath);
    }

}
