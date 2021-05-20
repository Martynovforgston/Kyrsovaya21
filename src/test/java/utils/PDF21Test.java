package utils;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import core.utils.PDF21;

public class PDF21Test {
	
	@Test
	public void assertPDFValid() {
		// Создаем документ
		byte[] document = PDF21.create("", 0, 0, 0, 0, false, "", 0.0);
		// Проверяем, что он создался корректно
		assertTrue(document.length > 0);
	}
}
