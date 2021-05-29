package utils;

import static org.junit.Assert.*;

import org.junit.Test;

import core.utils.Helper;

public class HelperTest {

	@Test
	public void getRegionNameTest() {
		
		String regionName = Helper.getRegionName("Kalininsky");
		assertTrue(regionName == "Калининский");
	}
	
}
