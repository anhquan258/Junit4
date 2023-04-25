package net.javaguides.springboot;

import net.javaguides.springboot.model.BaseMoney;
import net.javaguides.springboot.model.Role;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.BaseMoneyRepository;
import net.javaguides.springboot.repository.HoKhauRepository;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.service.BaseMoneyServiceImpl;
import net.javaguides.springboot.service.UserServiceImpl;
import net.javaguides.springboot.web.dto.UserRegistrationDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class BaseMoneyServiceImplTest {

	@Test
	void contextLoads() {
	}
	   @Mock
	   private BaseMoneyRepository baseMoneyRepository;

	   @InjectMocks
	   private BaseMoneyServiceImpl baseMoneyService;

	   @Test
	   public void testGetBaseMoney() {
		   BaseMoney baseMoney = new BaseMoney();
		   baseMoney.setId(1L);
		   baseMoney.setBaseMoney(1432000F);
		   when(baseMoneyRepository.findById(1L)).thenReturn(Optional.of(baseMoney));

		   BaseMoney result = baseMoneyService.getBaseMoney();

		   assertEquals(result.getBaseMoney(),1432000);

	   }
}