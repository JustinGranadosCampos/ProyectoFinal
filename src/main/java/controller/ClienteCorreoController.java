package controller;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.mail.MessagingException;
import model.Correo;

@Named(value = "clienteCorreoController")
@RequestScoped
public class ClienteCorreoController {
    
    private static final String recipient = "justingranados34@gmail.com";
    private String subject;
    private String message;
    private String statusMessage = "";
    
    public ClienteCorreoController() {
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

//    public String getRecipient() {
//        return recipient;
//    }
//
//    public void setRecipient(String recipient) {
//        this.recipient = recipient;
//    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getStatusMessage() {
        return statusMessage;
    }
    
    public String send() {
        statusMessage = "Message Sent";
        try {
            Correo.sendMessage(recipient, subject, message);
        }
        catch(MessagingException ex) {
            statusMessage = ex.getMessage();
        }
        return "contacto?faces-redirect=true";  // redisplay page with status message
    }
}