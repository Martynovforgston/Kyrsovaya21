package core.settings;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import core.utils.Helper;

public class SettingsManager extends SettingsBase<Property> {
	
	private String filePath = "settings.txt";
	
	public PropertyGeneric<Double> KalininskyCoeff = new PropertyGeneric<Double>("Kalininsky", 1.1);
	public PropertyGeneric<Double> DemskyCoeff = new PropertyGeneric<Double>("Demsky", 1.2);
	public PropertyGeneric<Double> KirovskyCoeff = new PropertyGeneric<Double>("Kirovsky", 1.1);
	public PropertyGeneric<Double> LeninskyCoeff = new PropertyGeneric<Double>("Leninsky", 1.1);
	public PropertyGeneric<Double> OctoberskyCoeff = new PropertyGeneric<Double>("Octobersky", 1.0);
	public PropertyGeneric<Double> OrdzhonikidzevskiyCoeff = new PropertyGeneric<Double>("Ordzhonikidzevskiy", 1.2);
	public PropertyGeneric<Double> SovetskiyCoeff = new PropertyGeneric<Double>("Sovetsky", 1.1);

	public SettingsManager() {
		// Инициализируем настройки
		super.properties.add(KalininskyCoeff);
		super.properties.add(DemskyCoeff);
		super.properties.add(KirovskyCoeff);
		super.properties.add(LeninskyCoeff);
		super.properties.add(OctoberskyCoeff);
		super.properties.add(OrdzhonikidzevskiyCoeff);
		super.properties.add(SovetskiyCoeff);
	}

	@Override
	public boolean load() {
		// Не удалось создать файл для настроек
		if (!Helper.TryCreateFile(filePath))
			return false;
		
		try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.UTF_8)) {

			String line;

			while ((line = reader.readLine()) != null) {
				String[] data = line.split("=");

				if (data.length != 2)
					continue;
				
				Property property = super.find(data[0]);

				// Пытаемся преобразовать переменную в нужный тип
                if (property != null)
                {
                    if (property.getValue() instanceof Boolean)
                    {
                    	property.setValue(Boolean.parseBoolean(data[1]));
                    }
                    else if (property.getValue() instanceof Integer)
                    {
                    	property.setValue(Integer.parseInt(data[1]));
                    }
                    else if (property.getValue() instanceof Double)
                    {
                    	property.setValue(Double.parseDouble(data[1]));
                    }
                    else if (property.getValue() instanceof Float)
                    {
                    	property.setValue(Float.parseFloat(data[1]));
                    }
                    else if (property.getValue() instanceof String)
                    {
                    	property.setValue(data[1].toString());
                    }
                }
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	public boolean save() {
		// Не удалось создать фалй для настроек
		if (Helper.TryCreateFile(filePath)) {
			
			try (PrintWriter writer = new PrintWriter(filePath, "UTF-8")) {	
				
				for (Property property: super.properties) {
					writer.println(property.getName() + "=" + property.getValue());
				}
				
				writer.close();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		
		return false;
	}
}
