package core.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class PDF21 {
	
	public static byte[] create(String district, int count1Leaf, int count2Leaf, int count3Leaf, int countM2Floor, boolean isBathOn, String promo, double result) {
		// Пытаемся создать ПДФ файл
	try {
            Document document = new Document();
            // Поток байтов, куда будет передан документ
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            PdfWriter.getInstance(document, stream);
            document.open();
            addMetaData(document);
            addContent(document, district, count1Leaf, count2Leaf, count3Leaf, countM2Floor, isBathOn, promo, result);
            document.close();
            return stream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return new byte[0];
        }
	}
	
	private static void addMetaData(Document document) {
        document.addTitle("Итоговый расчет");
        document.addAuthor("Вариант21");
        document.addCreator("Вариант21");
    }
	
    private static void addContent(Document document, String district, int count1Leaf, int count2Leaf, int count3Leaf, int countM2Floor, boolean isBathOn, String promo, double result) throws DocumentException, IOException {
        // Начинаем новую страницу
    	document.newPage();
    	
    	// Всякая инфа
    	addField(document, "Наименование организации", "ООО \"Вариант21\"", 0);
    	
    	// Добавляем, масштабируем и размещаем лого
    	Image logo = createImage(document, "logo.jpg");
    	logo.scaleAbsolute(50f, 50f);
    	logo.setAbsolutePosition(document.right() - (logo.getScaledWidth()), document.top() - logo.getScaledHeight());
    	document.add(logo);
    	
	addEmptyLine(p, indents);
    	Paragraph calcPar = new Paragraph("Итоговый расчет от " + new SimpleDateFormat("dd.MM.yyyy").format(new Date()), getFont(16, Font.BOLD));
    	calcPar.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(calcPar);
        
        // Добавляем таблицу с данными
        PdfPTable table = createTable(document);
        
        table.addCell(new Phrase("Наименование", getFont(14, Font.BOLD)));
        table.addCell(new Phrase("Значение", getFont(14, Font.BOLD)));
        
        table.addCell(new Phrase("Регион", getFont(14, Font.NORMAL)));
        table.addCell(new Phrase(Helper.getRegionName(district), getFont(14, Font.NORMAL)));
        
        table.addCell(new Phrase("Кол-во одностворчатых окон", getFont(14, Font.NORMAL)));
        table.addCell(Integer.toString(count1Leaf));
        
        table.addCell(new Phrase("Кол-во двухстворчатых окон", getFont(14, Font.NORMAL)));
        table.addCell(Integer.toString(count2Leaf));
        
        table.addCell(new Phrase("Кол-во трехстворченных окон", getFont(14, Font.NORMAL)));
        table.addCell(Integer.toString(count3Leaf));
        
        table.addCell(new Phrase("Кол-во км м пола", getFont(14, Font.NORMAL)));
        table.addCell(Integer.toString(countM2Floor));
        
        table.addCell(new Phrase("Услуга мытья санузла", getFont(14, Font.NORMAL)));
        String status = isBathOn ? "включена" : "отсутствует";
        table.addCell(new Phrase(status, getFont(14, Font.NORMAL)));
        
        table.addCell(new Phrase("Использованный промокод", getFont(14, Font.NORMAL)));
        table.addCell(new Phrase(promo.equals("") ? "отсутствует" : promo, getFont(14, Font.NORMAL)));
        
        table.addCell(new Phrase("ИТОГО", getFont(14, Font.BOLD)));
        table.addCell(Double.toString(result));
        
        // Создаем параграф для таблицы
        Paragraph tableParagraph = new Paragraph("", getFont(14, Font.NORMAL));
        addEmptyLine(tableParagraph, 2);
        tableParagraph.add(table);
        document.add(tableParagraph);
    }

    private static void addField(Document document, String name, String value, int indents) throws DocumentException, IOException {
    	Paragraph p = new Paragraph(name + ": ", getFont(14, Font.BOLD));
    	p.add(new Chunk(value, getFont(14, Font.UNDERLINE)));
    	addEmptyLine(p, indents);
    	document.add(p);
    }
    
    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
    
    private static PdfPTable createTable(Document document) throws DocumentException, IOException {
    	// Создаем таблицу
        PdfPTable table = new PdfPTable(2);
        table.setHeaderRows(1);
        return table;
    }
    
    private static Image createImage(Document document, String name) throws DocumentException, MalformedURLException, IOException {
    	Image img = Image.getInstance(PDF21.class.getClassLoader().getResource(name));
    	return img;
    }
    
    private static Font getFont(float size, int style) throws DocumentException, IOException {
    	BaseFont bf = BaseFont.createFont("font.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
    	return new Font(bf, size, style);
    }
}
