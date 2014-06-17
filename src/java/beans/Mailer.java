package beans;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import model.TaxiService;
import model.User;

public class Mailer {

    private Session session;
    private Properties properties;

    public Mailer() {
        this.properties = new Properties();
        this.properties.put("mail.smtp.host", "smtp.gmail.com");
        this.properties.put("mail.smtp.socketFactory.port", "465");
        this.properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        this.properties.put("mail.smtp.auth", "true");
        this.properties.put("mail.smtp.port", "465");
        this.session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("noreply.setare@gmail.com", "Setare123");
            }
        });
    }
    
    public void sendTaxiServiceMail(TaxiService ts){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - hh:mm");
        try {
            Message message = createMessage(ts.getUser());
            message.setSubject("[Setare]: Taxi Reservation nº " + ts.getId());
            StringBuilder messageBody = new StringBuilder();
            
            messageBody.append("<h1><b>Taxi Reservation Confirmation</b></h1>\n\n");
            messageBody.append("Hello, <b>").append(ts.getUser().getName()).append("</b>\n\n");
            messageBody.append("<p>The reservation of the taxi is scheduled for <b>");
            messageBody.append(sdf.format(ts.getServiceBegin()));
            messageBody.append("</b> at the place of departure <b>");
            messageBody.append(ts.getPickUpLocation());
            messageBody.append("</b>, <b>");
            messageBody.append(ts.getCity());
            messageBody.append("</b> and the final destination is <b>");
            messageBody.append(ts.getDropOffLocation());
            messageBody.append("</b>.</p>\n");
            if(ts.isRoundTrip()){
                messageBody.append("<p>The return is scheduled for the <b>")
                           .append(sdf.format(ts.getServiceEnd()))
                           .append("</b> at the final destination mentioned above.</p>\n\n");
            }
            messageBody.append("<p>The price to be paid to the driver will be <b>");
            messageBody.append(NumberFormat.getCurrencyInstance().format(ts.getFinalPrice()));
            messageBody.append("</b>, which include luggage according to the taxi selected.\n");
            
            if(!ts.getSpecialRequest().isEmpty()){
                messageBody.append("\nYour special request is : <b>").append(ts.getSpecialRequest())
                           .append("</b>");
            }            
            messageBody.append("</p>\n\n<p> For further questions contact the Setare team through the provided contact.")
                       .append("</p>\n <p>Thank you for choosing,</p>\n <p>The Setare team</p>");
            
            message.setContent(messageBody.toString(),"text/html; charset=utf-8");
            Transport.send(message);
        } catch (Exception ex) {
            Logger.getLogger(Mailer.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    public void sendCarServiceMail(){
        
    }
    
    private Message createMessage(User u) throws Exception{
        Message message = new MimeMessage(this.session);
        message.setFrom(new InternetAddress("noreply.setare@gmail.com","Setare Team"));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("andre.nogueira26@gmail.com", u.getName()));
        message.setSentDate(new Date());
        return message;        
    }

}
