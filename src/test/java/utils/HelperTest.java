package utils;

import static org.junit.Assert.*;

import org.junit.Test;

import core.settings.SettingsManager;
import core.utils.Helper;

public class HelperTest {

	@Test
	public void getRegionCoeffTest() {
		
		SettingsManager settings = new SettingsManager();
		settings.KalininskyCoeff.setValue(1.5);
		
		double value = Helper.getRegionCoeff(settings.KalininskyCoeff.getName(), settings);
		assertTrue(value == 1.5);
	}
	
}
