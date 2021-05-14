package settings;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import core.settings.SettingsManager;


public class SettingsManagerTest {

	static SettingsManager settings;
	
	@BeforeClass
	public static void beforeClass() {
		settings = new SettingsManager();
		settings.load();
	}
	
	@Test
	public void settingsTest() {
		settings.set("Kalininsky", 3.0);
		double expected = 3.0;
		assertTrue(settings.KalininskyCoeff.getValue() == expected);
	}
}
