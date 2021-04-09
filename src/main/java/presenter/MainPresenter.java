package presenter;

import observer.IEventListener;

import core.*;
import view.*;

// ����� ��������� ��������� IEventListener, �.�. �������� ����������� ������� ����� IMainFrame
public class MainPresenter implements IEventListener {

	private IMainFrame frame;
	private ICalculator calculator; 
	private Promo promo;
	
	public MainPresenter(IMainFrame frame, ICalculator calculator, Promo promo) {
		
		this.frame = frame;
		this.calculator = calculator;
		this.promo = promo;
		// ����������� ���� �� ������� ����� �������� ������������
		this.frame.subscribe("calculate", this);
	}
	
	@Override
	public void update(String eventType) {

		double price = calculator.calculate(
				Helper.getRegionCoeff(frame.getRegionName()), 
				promo.getCoeff(frame.getPromo()), 
				frame.getCount1Leaf(), 
				frame.getCount2Leaf(), 
				frame.getCount3Leaf(), frame.getCountM2Floor(), 
				frame.isBathroomOn());
		
		frame.setResult(price);
	}
}