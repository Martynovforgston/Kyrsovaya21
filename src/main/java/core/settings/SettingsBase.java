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
		// ���� �������� � ������ ������
		T property = this.find(name);
		// ���� ��� ����������, ������ ��������
		if (property != null) {
			property.setValue(value);
		}
	}
	
	public T find(String name) {
		// ���� � ������ ���� �������� � ������ ������
		for (T property: this.properties) {
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