package Tests;

import java.io.IOException;

import org.apache.pdfbox.examples.fdf.PrintFields;
import org.apache.pdfbox.examples.fdf.SetField;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.interactive.form.PDCheckbox;


public class TestPDF {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PDDocument document = PDDocument.load("stat.pdf");
			SetField s = new SetField();
			s.setField(document, "grad.null", "check()");
			PrintFields h = new PrintFields();

			h.printFields(document);
			document.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();


		}
	}

}
