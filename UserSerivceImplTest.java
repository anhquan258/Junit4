package net.javaguides.springboot;
import net.javaguides.springboot.model.Role;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.HoKhauRepository;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.service.UserServiceImpl;
import net.javaguides.springboot.web.dto.UserRegistrationDto;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserSerivceImplTest {

	@Test
	void contextLoads() {
	}

	@Mock
	private UserRepository userRepository;
	@InjectMocks
	private UserServiceImpl userService;


	@Mock
	private HoKhauRepository hoKhauRepository;

	@Mock
	private BCryptPasswordEncoder passwordEncoder;

	@InjectMocks
	private UserServiceImpl userServiceImpl;

	User user = new User("John", "Doe", "johndoe@example.com", "password", "123456", "01/01/2001", "123456789", "123 Main St", "1234567890", "coquanBHYT", Arrays.asList(new Role("ROLE_USER")), "1");
	UserRegistrationDto userRegistrationDto = new UserRegistrationDto("Jane", "Doe", "joh.ndoe@example.com", "password", "123456", "01/01/2001", "123456789", "123 Main St", "1234567890", "coquanBHYT");
	@Test
	public void testGetUser() {
		// given
		String maBHYT = "123456";

		when(userRepository.findByMaBHYT(maBHYT)).thenReturn(user);

		// when
		UserRegistrationDto result = userServiceImpl.getUser(maBHYT);

		// then
		assertEquals("John", result.getFirstName());
		assertEquals("Doe", result.getLastName());
		assertEquals("johndoe@example.com", result.getEmail());
		assertEquals("password", result.getPassword());
		assertEquals("123456", result.getMaBHYT());
		assertEquals("01/01/2001", result.getBirthDay());
		assertEquals("123456789", result.getCmnd());
		assertEquals("123 Main St", result.getAddress());
		assertEquals("1234567890", result.getPhoneNumber());
		assertEquals("coquanBHYT", result.getCoquanBHYT());
	}

	@Test
	public void shouldReturnUpdatedUser_whenUpdateUser() {
		when(userRepository.findByMaBHYT(userRegistrationDto.getMaBHYT())).thenReturn(user);

		User result = userServiceImpl.update(userRegistrationDto);

		assertEquals("Jane", result.getFirstName());
		assertEquals("Doe", result.getLastName());
		assertEquals("joh.ndoe@example.com", result.getEmail());
		assertEquals("123456", result.getMaBHYT());
		assertEquals("01/01/2001", result.getBirthDay());
		assertEquals("123456789", result.getCmnd());
		assertEquals("123 Main St", result.getAddress());
		assertEquals("1234567890", result.getPhoneNumber());
		assertEquals("coquanBHYT", result.getCoquanBHYT());
	}
    @Test
	public void saveTest(){
		User result = userServiceImpl.save(userRegistrationDto);
		assertEquals("Jane", result.getFirstName());
		assertEquals("Doe", result.getLastName());
		assertEquals("joh.ndoe@example.com", result.getEmail());
		assertEquals("123456", result.getMaBHYT());
		assertEquals("01/01/2001", result.getBirthDay());
		assertEquals("123456789", result.getCmnd());
		assertEquals("123 Main St", result.getAddress());
		assertEquals("1234567890", result.getPhoneNumber());
		assertEquals("coquanBHYT", result.getCoquanBHYT());

	}

	@Test
	public void checkHoKhauTest(){
		String userName="Jonh";
		boolean check=false;
		when(userRepository.findByMaBHYT(userName)).thenReturn(user);
		boolean result =userServiceImpl.checkHoKhau(user.getCmnd(),userName);
		assertEquals(check, result);
	}
}