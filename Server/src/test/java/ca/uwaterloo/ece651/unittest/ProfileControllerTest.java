package ca.uwaterloo.ece651.unittest;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import ca.uwaterloo.ece651.controllers.ProfileController;
import ca.uwaterloo.ece651.models.Profile;
import ca.uwaterloo.ece651.repositories.ProfileRepository;

@RunWith(MockitoJUnitRunner.class)

public class ProfileControllerTest {

	private static ProfileRepository profileRepository = mock(ProfileRepository.class);

	@InjectMocks
	private ProfileController profileController;

	@BeforeClass
	    public static void initResifteration() {
		
		Profile userRegisteration1 = new Profile();
		userRegisteration1.setId(1L);
		userRegisteration1.setUsername("testUsername1");
		userRegisteration1.setEmail("testUsername1@gmail.com");
		userRegisteration1.setPassword("111111");
		

		Profile userRegisteration2 = new Profile();
		userRegisteration2.setId(2L);
		userRegisteration2.setUsername("testUsername2");
		userRegisteration2.setEmail("testUsername2@gmail.com");
		userRegisteration2.setPassword("222222");
		

		Profile userRegisteration3 = new Profile();
		userRegisteration3.setId(3L);
		userRegisteration3.setUsername("testUsername3");
		userRegisteration3.setEmail("testUsername3@gmail.com");
		userRegisteration3.setPassword("333333");
		
		Profile userRegisteration4 = new Profile();
		userRegisteration4.setId(4L);
		userRegisteration4.setUsername("testUsername4");
		userRegisteration4.setEmail("testUsername4@gmail.com");
		userRegisteration4.setPassword("444444");	
		
		
		
		when(profileRepository.findByEmail("testUsername1@gmail.com")).thenReturn(userRegisteration1);
		
		when(profileRepository.findByEmailAndPassword("testUsername2@gmail.com", "222222")).thenReturn(userRegisteration2);
	
	}
	
	 @Test
	    public void testGetUserRegistrationOne() {
	
		 int result= profileController.registration("testUsername1@gmail.com", "111111", "testUsername1");
			 assertEquals(0, result);	
	 }
	 
	 @Test
	    public void testGetUserRegistrationTwo() {
		 
		 int result= profileController.registration("testUsername5@gmail.com", "555555", "testUsername5");
			 assertEquals(1, result);
	 }
	 
	 @Test
		public void testGetUserLoginOne() {
			 
		Profile result= profileController.login("testUsername2@gmail.com","222222");
		assertEquals("testUsername2",result.getUsername());
	 }
	 
	 @Test
		public void testGetUserLoginTwo() {
			 
		Profile result= profileController.login("testUsername6@gmail.com","666666");
		assertNotEquals("testUsername6",result.getUsername());
	 }
	  
}
