package view.actions;
import java.awt.event.*;
import java.nio.file.*;
import java.util.*;
import javax.swing.JOptionPane;
import view.IMainFrame;

public class SaveToFileAction implements ActionListener {

	private IMainFrame frame;
	
	// � �������� ������������ ��������� ��������� � ������������� ��� ��������
	public SaveToFileAction(IMainFrame frame) {
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			// ������, ������� ����� �������� � ����
			List<String> info = Arrays.asList(
					"����� ������: " + frame.getRegionName(),
					"���-�� �������������� ����: " + frame.getCount1Leaf(),
					"���-�� ������������� ����: " + frame.getCount2Leaf(),
					"���-�� ��������������� ����: " + frame.getCount3Leaf(),
					"���-�� �� � ����: " + frame.getCountM2Floor(),
					"������ ����� �������: " + (frame.isBathroomOn() ? "��������" : "�����������"),
					"�������������� ��������: " + (frame.getPromo().equals("") ? "�����������" : frame.getPromo()),
					"�����: " + frame.getResult() + " ���"
					);
			// ���� �� ����� (� ������ ������, � ��� �� ����������)
			Path file = Paths.get("VARIANT21.txt");
			// ���������� ������ ������ � ����
			Files.write(file, info);
		} catch (Exception exp) {
			JOptionPane.showMessageDialog(null, "��� ������� ���������� ������ ��������� ������ " + exp.getLocalizedMessage());
		}
	}
}
