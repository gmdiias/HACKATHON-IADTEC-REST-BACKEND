package com.gmdiias.controle.clientes;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.gmdiias.controle.compra.Estado;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneratePdfReport {

	private GeneratePdfReport() {
		
	}
	
    public static ByteArrayInputStream pdfClientes(List<Cliente> clientes) {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {


            PdfPTable table = new PdfPTable(6);
           
            table.setWidthPercentage(80);
            table.setWidths(new int[]{1, 3, 5, 3, 3, 3});

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            
            addHeaderColumn(table, headFont, "Id");
			addHeaderColumn(table, headFont, "Name");
			addHeaderColumn(table, headFont, "Cpf");
			addHeaderColumn(table, headFont, "Situacao");
			addHeaderColumn(table, headFont, "Estado");
			addHeaderColumn(table, headFont, "Pais");
			

            for (Cliente client : clientes) {


                addOnCenter(table, Long.toString(client.getId()));
                addOnLeft(table, client.getNome());
                addOnCenter(table, client.getCpf());
                addOnLeft(table, client.getSituacao().toString());
                Estado estado = client.getEstado();
				addOnLeft(table, estado.getNome());
                addOnLeft(table, estado.getPais().getNome());
                
            }

            PdfWriter.getInstance(document, out);
            document.open();

            document.add(table);
            
            document.close();
            
        } catch (DocumentException ex) {
        
            Logger.getLogger(GeneratePdfReport.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

	private static void addOnLeft(PdfPTable table, String content) {
		PdfPCell cell;
        cell = new PdfPCell(new Phrase(content));
        cell.setPaddingLeft(5);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(cell);
	}

	private static void addOnCenter(PdfPTable table, String content) {
		PdfPCell cell;
		cell = new PdfPCell(new Phrase(content));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);
	}

	private static void addHeaderColumn(PdfPTable table, Font headFont, String name) {
		PdfPCell hcell;
		hcell = new PdfPCell(new Phrase(name, headFont));
		hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(hcell);
	}
}