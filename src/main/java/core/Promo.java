package core;

public abstract class Promo {
	// ������ ����������
	private String[] promos;
	
	public Promo(String[] promos) //�����������
	{
		this.promos = promos;
	}
	
	// ����������� ����� ��� ��������� ������������ ��� ������
	public abstract double getCoeff(String promo);
	
	// ��������������� ����� ��� �������� ������������ ���������, � ���������� ������ ���� �� ��������
	protected boolean isValidPromo(String value) {
		// �������� �� ������� ����������
		for (String promo: promos)
			if (promo.equals(value))
				return true;
		
		return false;
	}
}
