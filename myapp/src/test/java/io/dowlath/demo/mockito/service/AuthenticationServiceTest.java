package io.dowlath.demo.mockito.service;

import io.dowlath.demo.mockito.model.User;
import io.dowlath.demo.mockito.repository.UserRepository;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.mockito.Mockito.*;

/***
 * Author : Dowlath Basha G
 * Date   : 2/26/2022
 * Time   : 5:17 PM
 ***/
public class AuthenticationServiceTest {

    private AuthenticationService service; // SUT
    private UserRepository repository; // mock

    @Before
    public void setup(){
        this.repository = mock(UserRepository.class);
        this.service = new AuthenticationService(this.repository);
    }

    @Ignore
    @Test
    public void testAuthenticate(){
        // arrange
        when(repository.findByUserName(anyString())).thenThrow(new IllegalArgumentException());

        // act
        this.service.authenticate("Dowlath","Basha");

        // assert

    }
}
