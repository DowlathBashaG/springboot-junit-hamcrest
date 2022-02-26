package io.dowlath.demo.mockito.service;

import io.dowlath.demo.mockito.model.User;
import io.dowlath.demo.mockito.repository.UserRepository;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;

/***
 * Author : Dowlath Basha G
 * Date   : 2/26/2022
 * Time   : 6:09 PM
 ***/
@RunWith(MockitoJUnitRunner.class)
public class UserLookupServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserLookupService userLookupService;

    @Test
    public void getRegularUsers_junit(){

        //arrange
        List<User> userList = new LinkedList();
        userList.add(User.createRegularUser("anne","abc123"));
        userList.add(User.createRegularUser("donald","dcc123"));
        userList.add(User.createAdminUser("beebop","pwd321"));
        when(userRepository.findAll()).thenReturn(userList);

        //act
        Set<User> actualUsers = userLookupService.getRegularUsers();

        //assert - Gerneral Collection
        assertNotNull(actualUsers);
        assertEquals(actualUsers.size(),1);

        /*
            Junit : assertEquals(expected, actual) BUT Hamcrest : assertEquals(actual,expected);
         */
        // Check user1
        User actualUser1 = userList.get(0);
        assertNotNull(actualUser1);
        assertEquals(actualUser1.getUserType(),User.UserType.REGULAR_USER);
        assertEquals(actualUser1.getUserName(),"anne");
        assertEquals(actualUser1.getPassword(),"abc123");

        // Check user2
        User actualUser2 = userList.get(1);
        assertNotNull(actualUser2);
        assertEquals(actualUser2.getUserType(),User.UserType.REGULAR_USER);
        assertEquals(actualUser2.getUserName(),"donald");
        assertEquals(actualUser2.getPassword(),"dcc123");

        // Check user3
        User actualUser3 = userList.get(2 );
        assertNotNull(actualUser3);
        assertEquals(actualUser3.getUserType(),User.UserType.ADMIN_USER);
        assertEquals(actualUser3.getUserName(),"beebop");
        assertEquals(actualUser3.getPassword(),"pwd321");

        /*for(User actualUser : actualUsers){
            assertNotNull(actualUser);
            assertEquals(actualUser.getUserType(),User.UserType.ADMIN_USER);
        }*/


    }

    @Ignore
    @Test
    public void getRegularUsers_hamcrest(){

        //arrange
        List<User> userList = new LinkedList();
        userList.add(User.createRegularUser("anne","abc123"));
        userList.add(User.createRegularUser("donald","dcc123"));
        userList.add(User.createAdminUser("beebop","pwd321"));
        when(userRepository.findAll()).thenReturn(userList);

        //act
        Set<User> actualUsers = userLookupService.getRegularUsers();

        //assert - Gerneral Collection
        assertThat(actualUsers,is(notNullValue()));
        assertThat(actualUsers.size(),equalTo(1));
        assertThat(actualUsers,containsInAnyOrder(equalTo(User.createRegularUser("anne","abc123")),
                                     equalTo(User.createRegularUser("donald","dcc123"))
                 ));

        /*
            Junit : assertEquals(expected, actual) BUT Hamcrest : assertEquals(actual,expected);
         */
        // Check user1
       /* User actualUser1 = userList.get(0);
        assertNotNull(actualUser1);
        assertEquals(actualUser1.getUserType(),User.UserType.REGULAR_USER);
        assertEquals(actualUser1.getUserName(),"anne");
        assertEquals(actualUser1.getPassword(),"abc123");*/

        // Check user2
        /*User actualUser2 = userList.get(1);
        assertNotNull(actualUser2);
        assertEquals(actualUser2.getUserType(),User.UserType.REGULAR_USER);
        assertEquals(actualUser2.getUserName(),"donald");
        assertEquals(actualUser2.getPassword(),"dcc123");*/

        // Check user3
        /*User actualUser3 = userList.get(2 );
        assertNotNull(actualUser3);
        assertEquals(actualUser3.getUserType(),User.UserType.ADMIN_USER);
        assertEquals(actualUser3.getUserName(),"beebop");
        assertEquals(actualUser3.getPassword(),"pwd321");*/

        /*for(User actualUser : actualUsers){
            assertNotNull(actualUser);
            assertEquals(actualUser.getUserType(),User.UserType.ADMIN_USER);
        }*/


    }
    @Test
    public void getAdminUsers(){

    }

}
