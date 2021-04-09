package observer;

import java.util.*;

// ������� ��������
public class EventManager {
	// ���-������� "�������� �������" = "������ �����������" 
    Map<String, List<IEventListener>> listeners = new HashMap<>();

    // ����������� ������, ��������� ������ �������
    public EventManager(String... operations) {
        for (String operation : operations) {
        	// ��������� � ������� �������� ������� � ������ ��� �����������
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    // ����� �������� �� �������
    public void subscribe(String eventType, IEventListener listener) {
        List<IEventListener> users = listeners.get(eventType);				// �������� ������ ����������� �� ������� �������
        users.add(listener);												// ��������� ������ ���������� �� �������
    }

    // ����� ������� �� �������
    public void unsubscribe(String eventType, IEventListener listener) {
        List<IEventListener> users = listeners.get(eventType);				// �������� ������ ����������� �� ������� �������
        users.remove(listener);												// ���������� ���������� �� �������
    }	
    
    // ����� ���������� ����������� � �����-���� �������
    public void notify(String eventType) {
        List<IEventListener> users = listeners.get(eventType);				// �������� ������ ����������� �� ������� �������
        for (IEventListener listener : users) {								// �������� �� ������ update ��� ��������� ������� �������
            listener.update(eventType);
        }
    }
}
