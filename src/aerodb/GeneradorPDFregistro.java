package aerodb;

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

public class GeneradorPDFregistro{

    public static void generaRegistro(String nombre, String apellido, String correo){
        Document documento = new Document(PageSize.A4, 50, 50, 50, 50);
        
        try {
            String path = System.getProperty("user.dir") + "/" + nombre + apellido + "Registro.pdf";
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
            
            String txtTitulo = "Bienvenido a Skywell Airlines !" + nombre + " " + apellido + "!";
            Paragraph titulo = new Paragraph(txtTitulo , fuentePersonal);
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(30);
            documento.add(titulo);
            documento.add(new Paragraph("\n"));
            
            String txtParrafo = "Usted ha sido registrado como invitado "
                    + "Usted puede comprar boletos para vuelos y consultar aeropuertos, para hacer ajustes a su cuenta hable con el administrador de las bases de datos";
            
            
            Paragraph parrafo = new Paragraph(txtParrafo , fuentePersonal4);
            parrafo.setAlignment(Element.ALIGN_CENTER);
            parrafo.setSpacingAfter(40);
            documento.add(parrafo);
            documento.add(new Paragraph("\n\n"));
            
            documento.add(new Paragraph("Nombre: " + nombre, fuentePersonal4));
            documento.add(new Paragraph("Apellido: " + apellido, fuentePersonal4));
            documento.add(new Paragraph("Correo: " + correo, fuentePersonal4));
            documento.add(new Paragraph("Rol: Invitado", fuentePersonal4));
            
            documento.add(new Paragraph("\n\n\n"));
            
            String agradecimientosTxt = "\nGracias por registrarte. ¡Buen viaje!";
            Paragraph agradecimientos = new Paragraph(agradecimientosTxt , fuentePersonal);
            agradecimientos.setAlignment(Element.ALIGN_CENTER);
            agradecimientos.setSpacingAfter(20);
            documento.add(agradecimientos);
            
            String txtCita = "“Una vez que hayas probado el vuelo, siempre caminarás por la tierra con los ojos vueltos hacia el cielo, porque allí has ​​estado y allí siempre anhelarás "
                    + "regresar”.\n" + "";
            Paragraph cita = new Paragraph(txtCita , fuentePersonal3);
            cita.setAlignment(Element.ALIGN_CENTER);
            documento.add(cita);
            
            documento.add(new Paragraph("–Leonardo DaVinci", fuentePersonal3));
            
            documento.add(new Paragraph("\n\n\n\n\n\n\n"));
            documento.add(new Paragraph("Correo: skywellairlines@gmail.com", fuentePersonal4));
            documento.close();

            System.out.println("PDF generado exitosamente en: " + path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

