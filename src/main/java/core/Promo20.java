package core;

public class Promo20 extends Promo{
	private static String[] promos = { "SKIDKA20", "skiiidka" };
	
	public Promo20() { 
	super(promos);      //����� ������������ �� Promo
	}

	@Override
	public double getCoeff(String promo) {
		// ���� �������� ����������, �� ���������� �������� ��� ������
		if (isValidPromo(promo))
			return 0.8;
		
		return 1;
	}
	
}
