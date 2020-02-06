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
	
	@Test
	public void testForValueAboveHundred() {
		assertEquals("ONE HUNDRED", converterService.convertNumToWord("100").trim());
		assertEquals("ONE HUNDRED AND ONE", converterService.convertNumToWord("101").trim());
		assertEquals("NINE HUNDRED AND NINETY NINE", converterService.convertNumToWord("999").trim());
		assertEquals("SEVEN HUNDRED AND EIGHTY NINE", converterService.convertNumToWord("789").trim());
		
	}
	
	@Test
	public void testForValueAboveThousand() {
		assertEquals("ONE THOUSAND", converterService.convertNumToWord("1000").trim());
		assertEquals("ONE THOUSAND NINE HUNDRED AND NINETY EIGHT", converterService.convertNumToWord("1998").trim());
		assertEquals("NINE THOUSAND NINE HUNDRED AND NINETY NINE", converterService.convertNumToWord("9999").trim());
		
	}
	
	
	
}
