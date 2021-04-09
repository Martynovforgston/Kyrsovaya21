package core;

import javax.swing.JOptionPane;

public class Promo21 extends Promo {
	// ������ ����������
	private static String[] promos = { "PI223", "VAR21"  };
	
	public Promo21() {
		// �������� ������ ���������� � ������������ �����
		super(promos);
	}
	
    @Override
	public double getCoeff(String promo) {
		// ���� �������� ����������, �� ���������� �������� ��� ������
		if (isValidPromo(promo))
			return 0.9;
		
		else if (!promo.isEmpty())
			JOptionPane.showMessageDialog(null, "��������� �������� �� �������� ��������������");
		
		// ����� ���������� ������ ����������� ��� ������
		return 1;
	}
}
