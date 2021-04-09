package view;

import observer.EventManager;
import observer.IEventListener;
import view.actions.*;

import javax.swing.*; 
import java.awt.*; 

public class MainFrame extends JFrame implements IMainFrame {

	public EventManager events;
	
	// ���������� �����
    private Container container; 
    
    private JMenuBar 	menuBar;
    private JMenu 		menuFile, menuRef;
    private JMenuItem	saveToFileItem, exitItem, aboutItem;
    
    private JLabel regionNameLbl;
    private JLabel count1LeafLbl;
    private JLabel count2LeafLbl;
    private JLabel count3LeafLbl;
    private JLabel countM2FloorLbl;
    private JLabel promoLbl;
    private JLabel resultLbl;
    
    private JTextField promoTxt;
    private JTextField resultTxt;
    
    private JComboBox<String> regionNameCB;
    
    private JSpinner count1LeafSpinner;
    private JSpinner count2LeafSpinner;
    private JSpinner count3LeafSpinner;
    private JSpinner countM2FloorSpinner;
    
    private JCheckBox isBathroomOnCheck;
    
    private JButton calculateBtn;
    
    private String regionNames[] = { "�����������", "�������", "���������", "���������", "�����������", "�����������������", "���������" }; 
  
    public MainFrame() 
    {
    	events = new EventManager("calculate");
    	
        setTitle("����������� ����������� ����� ��� �������");	// ������ �������� ����� 
        setBounds(300, 90, 525, 390); 							// ������ ������� �����
        setDefaultCloseOperation(EXIT_ON_CLOSE); 				// ����� �� ��������� ��� �������� �����
        setResizable(false); 									// ������ ����� ����������
        setLocationRelativeTo(null); 							// �������������� ����� �� ������
  
        // ���������, � ������� ����� �������� ��� ���������� �����
        container = getContentPane(); 
        container.setLayout(null); 
  
        // �������� ����
        // �����-��������� ��� ����
        menuBar = new JMenuBar();  
        // ������ ����
        menuFile = new JMenu("����");  
        menuRef  = new JMenu("�������");
        // ��������� ������� ����
        saveToFileItem = new JMenuItem("��������� � ����");
        saveToFileItem.addActionListener(new SaveToFileAction(this));
        exitItem  = new JMenuItem("�����");  
        exitItem.addActionListener(new ExitAction());
        aboutItem = new JMenuItem("� ���������");
        aboutItem.addActionListener(new ShowAboutFrameAction());

        menuFile.add(saveToFileItem); 
        menuFile.add(exitItem); 
        menuRef.add(aboutItem);
        
        menuBar.add(menuFile); 
        menuBar.add(menuRef);
        
        // ������ ���� �����
        this.setJMenuBar(menuBar); 
        
        regionNameLbl = new JLabel("����� ������"); 
        regionNameLbl.setBounds(20, 20, 100, 20);
        container.add(regionNameLbl); 
  
        // �������� ������ � ���������� ��������
        regionNameCB = new JComboBox<String>(regionNames); 
        regionNameCB.setBounds(110, 19, 190, 25);
        container.add(regionNameCB);  
  
        count1LeafLbl = new JLabel("�������������� ����");
        count1LeafLbl.setBounds(20, 60, 150, 20);
        container.add(count1LeafLbl); 
  
        // �������� �������� ��� �������� ���-�� �������������� ����
        count1LeafSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 15, 1));
        count1LeafSpinner.setBounds(20, 80, 150, 25);
        container.add(count1LeafSpinner);
        
        count2LeafLbl = new JLabel("������������� ����");
        count2LeafLbl.setBounds(180, 60, 150, 20);
        container.add(count2LeafLbl); 
        
        // �������� �������� ��� �������� ���-�� ������������� ����
        count2LeafSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 15, 1));
        count2LeafSpinner.setBounds(180, 80, 150, 25);
        container.add(count2LeafSpinner);
        
        count3LeafLbl = new JLabel("�������������� ����");
        count3LeafLbl.setBounds(340, 60, 150, 20);
        container.add(count3LeafLbl); 
        
        // �������� �������� ��� �������� ���-�� �������������� ����
        count3LeafSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 15, 1));
        count3LeafSpinner.setBounds(340, 80, 150, 25);
        container.add(count3LeafSpinner);
        
        countM2FloorLbl = new JLabel("���������� �� � ����");
        countM2FloorLbl.setBounds(20, 121, 170, 20);
        container.add(countM2FloorLbl); 
        
        // �������� �������� ��� �������� ���-�� �� � ����
        countM2FloorSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 3000, 1));
        countM2FloorSpinner.setBounds(155, 120, 335, 25);
        container.add(countM2FloorSpinner);
  
        // �������� ������� ��� ������ �� ����� �������
        isBathroomOnCheck = new JCheckBox("�������� ������ ����� �������");
        isBathroomOnCheck.setBounds(20, 160, 250, 20);
        container.add(isBathroomOnCheck); 
        
        promoLbl = new JLabel("��������");
        promoLbl.setBounds(20, 200, 75, 20);
        container.add(promoLbl); 
        
        // �������� ���������� ���� ��� ����� ���������
        promoTxt = new JTextField();
        promoTxt.setBounds(90, 200, 150, 25);
        container.add(promoTxt);
        
        resultLbl = new JLabel("���������");
        resultLbl.setBounds(20, 240, 75, 20);
        container.add(resultLbl); 
        
        // �������� ���������� ����, ���� ����� ������� ��������� ��������
        resultTxt = new JTextField("");
        resultTxt.setBounds(90, 240, 150, 25);
        resultTxt.setEditable(false);				// ������ �� �������������� ���� �������������
        container.add(resultTxt);
        
        // �������� ������ ��� ������� ���������
        calculateBtn = new JButton("���������"); 
        calculateBtn.setBounds(20, 280, 470, 30);
        calculateBtn.addActionListener(new CalculateAction(this.events)); 	// ������ ���������� �������
        container.add(calculateBtn); 
        
        setVisible(true); 
    }
  
    // ���������� ����������
    
    // ��������� �������� �������
	@Override
	public String getRegionName() {		
		return this.regionNameCB.getSelectedItem().toString();
	}
	
	// ��������� ���������
	@Override
	public String getPromo() {		
		return this.promoTxt.getText();
	}
	
	// ��������� �������� ���������� �������������� ����
	@Override
	public int getCount1Leaf() { 		
		return (int)this.count1LeafSpinner.getValue();
	}

	// ��������� �������� ���������� �������������� ����
	@Override
	public int getCount2Leaf() {		
		return (int)this.count2LeafSpinner.getValue();
	}

	// ��������� �������� ���������� �������������� ����
	@Override
	public int getCount3Leaf() {		
		return (int)this.count3LeafSpinner.getValue();
	}
	
	// ��������� �������� ���������� ��.� ����
	@Override
	public int getCountM2Floor() {		
		return (int)this.countM2FloorSpinner.getValue();
	}

	// �������� �� ������ ����� �������
	@Override
	public boolean isBathroomOn() { 	
		return this.isBathroomOnCheck.isSelected();
	}

	// �������� �� �������
	@Override
	public void subscribe(String eventType, IEventListener listener) { 
		this.events.subscribe(eventType, listener);
	}
	
	// ������� �� �������
	@Override
	public void unsubscribe(String eventType, IEventListener listener) { 
		this.events.unsubscribe(eventType, listener);
	}

	@Override
	public void setResult(double price) {		
		// ���������� ��������
		price = Math.round(price * 100);
		price = price / 100;
		// ������ �������� � ���� ���������
		this.resultTxt.setText(Double.toString(price));
	}

	// ��������� ��������� �� ���� ���������
	@Override
	public double getResult() { 	
		try { return Double.parseDouble(this.resultTxt.getText()); }
		catch (Exception e) { return 0.0; }
	}
	
}
