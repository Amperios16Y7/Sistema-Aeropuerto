package aerodb;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;
import java.io.File;

public class EnviarCorreo {

    public static void enviarConAdjunto(String destinatario, String asunto, String cuerpo, String rutaPDF) {
        final String remitente = "skywellairlines@gmail.com";
        final String contraseña = "vvvhdmtjfgwtaqxm";

        Properties propiedades = new Properties();
        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.smtp.starttls.enable", "true");
        propiedades.put("mail.smtp.host", "smtp.gmail.com");
        propiedades.put("mail.smtp.port", "587");

        Session sesion = Session.getInstance(propiedades, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remitente, contraseña);
            }
        });

        try {
            Message mensaje = new MimeMessage(sesion);
            mensaje.setFrom(new InternetAddress(remitente));
            mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            asunto = asunto + "(Esto es una practica Universitaria, no es un acuerdo real)";
            mensaje.setSubject(asunto);

            MimeBodyPart texto = new MimeBodyPart();
            cuerpo = cuerpo + " (Esto es una practica Universitaria, no es un acuerdo real, si te llego este correo y no esta relacionado "
                    + " con la practica sientase libre de borrar este mensaje, gracias por su paciencia!!)";
            texto.setText(cuerpo);

            MimeBodyPart adjunto = new MimeBodyPart();
            adjunto.attachFile(new File(rutaPDF));

            Multipart multiparte = new MimeMultipart();
            multiparte.addBodyPart(texto);
            multiparte.addBodyPart(adjunto);

            mensaje.setContent(multiparte);

            Transport.send(mensaje);
            System.out.println("✅ Correo enviado correctamente");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
