package view;

import java.awt.Container;
import java.awt.Font;

import javax.swing.*;

public class AboutFrame extends JFrame {
	
	private Container container; 
    private JLabel aboutLbl;
	
	public AboutFrame() {
		
		setTitle("� ���������"); 
        setBounds(40, 20, 300, 340); 
        setResizable(false); 
  
        container = getContentPane(); 
        container.setLayout(null); 
        
        String textAbout = 
        		"<html>����������� ����������� ����� ��� ������� � "
        		+ "��� ���������, ������� ����� ���� "
        		+ "������������ ���������������� ����� ��� ������� "
        		+ "��������� ������� ������ ��������.<br><br>"
        		+ "(C) ��� \"������� 21\", 2020. ��� ����� ��������.</html>";
        String textAbout1 = 
        		"<html>���������� � ������� ����������: <br>"
        		+ "�������� ��������� ���������� 0162 <br>"
        		+ "������������ ����� ��������� 0641  <br> "
        		+ "�������� ����� ���������� 0343  <br>"
        		+ "�������� ����� ���������� 0170</html>";
        
        aboutLbl = new JLabel(textAbout);
        aboutLbl.setFont(new Font("Arial", Font.PLAIN, 14)); 
        aboutLbl.setSize(250, 200); 
        aboutLbl.setLocation(15, -10); 
        container.add(aboutLbl); 
        
        aboutLbl = new JLabel(textAbout1);
        aboutLbl.setFont(new Font("Arial", Font.PLAIN, 14)); 
        aboutLbl.setSize(300, 250); 
        aboutLbl.setLocation(15, +100); 
        container.add(aboutLbl); 
        
        setVisible(true);
	}
	
}