package core.settings;

import java.util.ArrayList;
import java.util.List;

public abstract class SettingsBase<T extends Property> {
	
	List<T> properties;
	
	SettingsBase() {
		this.properties = new ArrayList<T>();
	}
	
	public void add(T property) {
		this.properties.add(property);
	}
	
	public void set(String name, Object value) {
		// Ищем св-во с данным именем
		T property = this.find(name);
		// Если существует, задаем зачение
		if (property != null) {
			property.setValue(value);
		}
	}
	
	public T find(String name) {
		// Проходимся циклом по всем св-вам
		for (T property: this.properties) {
			// Ищем нужное св-во по имени
			if (property.getName().equals(name)) {
				return property;
			}
		}
		
		return null;
	}
	
	public List<T> getAll() {
		return this.properties;
	}
	
	public abstract boolean load();
	public abstract boolean save();
}
