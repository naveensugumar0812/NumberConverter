package com.bank.application.service.impl.test;

import static org.junit.Assert.assertEquals;

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
	
	@Test(expected=NumberFormatException.class)
	public void testMinimumValue() {
		converterService.convertNumToWord("0");
	}
	
	@Test(expected=NumberFormatException.class)
	public void testExceedMaxValue() {
		converterService.convertNumToWord("1000000");
	}
	
	@Test(expected=NumberFormatException.class)
	public void testForAlphabet() {
		converterService.convertNumToWord("asdasd");
	}
	
	@Test(expected=NumberFormatException.class)
	public void testForWithSpace() {
		converterService.convertNumToWord("1 3 4");
	}
	
	@Test(expected=NumberFormatException.class)
	public void testForFloat() {
		converterService.convertNumToWord("1.5");
	}
	
	@Test
	public void testForValueBelowHundred() {
		assertEquals("NINETY NINE", converterService.convertNumToWord("99").trim());
		assertEquals("ONE", converterService.convertNumToWord("1").trim());
		assertEquals("TWELVE", converterService.convertNumToWord("12").trim());
		assertEquals("THIRTY", converterService.convertNumToWord("30").trim());
		assertEquals("TEN", converterService.convertNumToWord("10").trim());
	}
	
	
}
