package com.RFY.RentForYou;

import com.RFY.RentForYou.models.CityModel;
import com.RFY.RentForYou.repository.CityRepository;
import com.RFY.RentForYou.service.CityServerImpl;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
class RentForYouApplicationTests {
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private CityServerImpl cityServer;

	@Test
	@Transactional
	public void testAddCity() {
		CityModel city = new CityModel(2L, "Санкт-Петербург");
		cityServer.addCity(city);
		CityModel foundCity = cityServer.findCity(2L);
		assertNotNull(foundCity);
		assertEquals("Санкт-Петербург", foundCity.getNameCity());
	}


}
