package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class HelperTest {

	@Test
	public void getRegionCoeffTest() {
		double value = Helper.getRegionCoeff("�����������������");
		assertTrue(value == 1.2);
	}
	
}
