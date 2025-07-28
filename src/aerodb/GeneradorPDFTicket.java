/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aerodb;

/**
 *
 * @author jarqu
 */


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;
import com.itextpdf.text.BaseColor;
import java.io.FileOutputStream;


public class GeneradorPDFTicket {
    public static void generarTicket(String destinatario, String[] vuelo, String[] pasajero){
        Document documento = new Document(PageSize.A4, 50, 50, 50, 50);
        
        try {
            String path = System.getProperty("user.dir") + "/" + pasajero[1] + pasajero[2] + "Ticket.pdf";
            PdfWriter.getInstance(documento, new FileOutputStream(path));
            
            
            BaseFont bf = BaseFont.createFont(System.getProperty("user.dir") + "/fonts/Pacifico/Pacifico-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            BaseFont bf2 = BaseFont.createFont(System.getProperty("user.dir") + "/fonts/Yellowtail/Yellowtail-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            BaseFont bf3 = BaseFont.createFont(System.getProperty("user.dir") + "/fonts/Tinos/Tinos-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            
            BaseColor azul = new BaseColor(0,153,255);
            Font fuentePersonal = new Font(bf, 18, Font.NORMAL, azul);
            Font fuentePersonal2 = new Font(bf, 14, Font.NORMAL, BaseColor.BLACK);
            
            Font fuentePersonal3 = new Font(bf2, 14, Font.NORMAL, BaseColor.BLUE);
            
            Font fuentePersonal4 = new Font(bf3, 14, Font.NORMAL, BaseColor.BLACK);
            documento.open();
            
            
            String rutaImagen = System.getProperty("user.dir") + "/Icons/Skywell Airlines logoBlue (1).png";
            Image imagen = Image.getInstance(rutaImagen);
            imagen.scaleToFit(100, 100);
            imagen.setAlignment(Image.ALIGN_CENTER);
            documento.add(imagen);
            
            String txtTitulo = "Gracias por su compra !" + pasajero[0] + " " + pasajero[1] + "!";
            Paragraph titulo = new Paragraph(txtTitulo , fuentePersonal);
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(30);
            documento.add(titulo);
            documento.add(new Paragraph("\n"));
            
            String txtParrafo = "Gracias por elegir Skywell Airlines para su viaje. "
                    + "Valoramos su confianza y nos comprometemos a brindarle un servicio seguro, cómodo y puntual. "
                    + "Esperamos que disfrute su vuelo y esperamos verlo nuevamente pronto a bordo. ¡Buen viaje!";
            
            
            Paragraph parrafo = new Paragraph(txtParrafo , fuentePersonal4);
            parrafo.setAlignment(Element.ALIGN_CENTER);
            parrafo.setSpacingAfter(40);
            documento.add(parrafo);
            
            documento.add(new Paragraph("Aerolinea: " + vuelo[2], fuentePersonal4));
            documento.add(new Paragraph("Vuelo: " + vuelo[1], fuentePersonal4));
            documento.add(new Paragraph("Destino: " + vuelo[10], fuentePersonal4));
            documento.add(new Paragraph("Precio: " + vuelo[8] + " MXN", fuentePersonal4));
            documento.add(new Paragraph("Nombre: " + pasajero[0], fuentePersonal4));
            documento.add(new Paragraph("Apellido: " + pasajero[1], fuentePersonal4));
            documento.add(new Paragraph("Correo: " + pasajero[5], fuentePersonal4));
            
            
            documento.add(new Paragraph("\n\n\n"));
            
            String agradecimientosTxt = "\nGracias por viajar con SkywellAirlines. ¡Buen viaje!";
            Paragraph agradecimientos = new Paragraph(agradecimientosTxt , fuentePersonal);
            agradecimientos.setAlignment(Element.ALIGN_CENTER);
            agradecimientos.setSpacingAfter(20);
            documento.add(agradecimientos);
            
            String txtCita = "“El hombre debe elevarse por encima de la Tierra, hasta la cima de la atmósfera y más allá, porque sólo así comprenderá plenamente el mundo en el que vive”.\n" + "";
            Paragraph cita = new Paragraph(txtCita , fuentePersonal3);
            cita.setAlignment(Element.ALIGN_CENTER);
            documento.add(cita);
            
            documento.add(new Paragraph("– Sócrates", fuentePersonal3));
            
            documento.add(new Paragraph("\n\n\n\n"));
            documento.add(new Paragraph("Correo: skywellairlines@gmail.com", fuentePersonal4));
            documento.close();

            System.out.println("PDF generado exitosamente en: " + path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
