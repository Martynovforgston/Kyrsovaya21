package core;

import java.util.HashMap;

public class Helper {

	// ����� ��� ��������� ������������ ������
	public static double getRegionCoeff(String name) {
		
		HashMap<String, Double> coeffs  = new HashMap<String, Double>() {{
		    put("�����������", 			1.1);
		    put("�������", 				1.2);
		    put("���������", 			1.1);
		    put("���������", 			1.1);
		    put("�����������", 			1.0);
		    put("�����������������", 	1.2);
		    put("���������", 			1.1);
		}};
		
		try {
			return coeffs.get(name); //������������� ���� �����-�� �� �������
		}
		catch(Exception e) {  //��� ������
			System.out.println("��� ��������� ������������ ������ ��������� ������: " + e.getMessage());
		}
		
		return 1.0;
	}
}
