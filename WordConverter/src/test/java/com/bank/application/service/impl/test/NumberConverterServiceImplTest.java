package com.bank.application.service.impl.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.bank.application.service.impl.NumberConverterServiceImpl;

@SpringBootTest
public class NumberConverterServiceImplTest {

	public NumberConverterServiceImplTest(){
	}

	@InjectMocks
	NumberConverterServiceImpl converterService;
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}


	@Test(expected=NumberFormatException.class)
	public void testNegativeValue() {
		converterService.convertNumToWord("-21312");
	} 
}
