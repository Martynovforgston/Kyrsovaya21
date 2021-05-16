package core.calculator;

public class Promo21 extends Promo {
	// Массив промокодов
	private static String[] promos = { "PI223", "VAR21"  };
	
	public Promo21() {
		// Передаем массив промокодов в родительский класс
		super(promos);
	}
	
    @Override
	public double getCoeff(String promo) {
		// Если промокод существует, то возвращаем значение для скидки
		if (isValidPromo(promo))
			return 0.9;
		
		// Иначе возвращаем полный коэффициент без скидки
		return 1;
	}
}
