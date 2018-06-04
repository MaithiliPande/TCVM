package com.yash.teacoffeemachine.util;

import org.junit.Before;
import org.junit.Test;

import com.yash.teacoffeemachine.exception.EmptyFileException;
import com.yash.teacoffeemachine.exception.FileDoesNotExistException;


public class MenuUtilTest {

	MenuUtil menuUtil;
	@Before
	public void setUp() {
		menuUtil = new MenuUtil();
	}
	@Test(expected=FileDoesNotExistException.class)
	public void shouldThrowFileDoesNotExistExceptionWhenFileDoesNotExist() {
		menuUtil.findFile("testing.txt");
	}
	
	@Test(expected=EmptyFileException.class)
	public void shouldThrowEmptyFileExceptionWhenFileIsEmpty() {
		menuUtil.readFile("test.txt");
	}
	
	@Test
	public void testReadFileIfFileIsNotEmpty() {
		menuUtil.readFile("menu.txt");
	}


}
