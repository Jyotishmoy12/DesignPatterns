
// DIP stands for Dependency Inversion Principle

// Bad example of the Dependency Inversion Principle
// At first glance, the EmailService class looks like it has a dependency on the GmailClient class.
// Then one day a product manager decides to use a different email service provider, 
// like Outlook or Yahoo, and the EmailService class needs to be modified to work with it.
// class GmailClient {
//     public void sendGmail(String toAddress, String subjectLine, String emailBody) {
//         System.out.println("Connecting to Gmail SMTP server...");
//         System.out.println("Sending email via Gmail to: " + toAddress);
//         System.out.println("Subject: " + subjectLine);
//         System.out.println("Body: " + emailBody);
//         // ... actual Gmail API interaction logic ...
//         System.out.println("Gmail email sent successfully!");
//     }
// }

// class EmailService {
//     private GmailClient gmailClient;

//     public EmailService() {
//         this.gmailClient = new GmailClient();
//     }

//     public void sendWelcomeEmail(String userEmail, String userName) {
//         String subject = "Welcome, " + userName + "!";
//         String body = "Thanks for signing up to our awesome platform. We're glad to have you!";
//         this.gmailClient.sendGmail(userEmail, subject, body);
//     }

//     public void sendPasswordResetEmail(String userEmail) {
//         String subject = "Reset Your Password";
//         String body = "Please click the link below to reset your password...";
//         this.gmailClient.sendGmail(userEmail, subject, body);
//     }
// }

// Good example of the Dependency Inversion Principle

interface EmailClient {
    void sendEmail(String toAddress, String subjectLine, String emailBody);
}

class GmailClientImpl implements EmailClient {
    public void sendEmail(String toAddress, String subjectLine, String emailBody) {
        System.out.println("Connecting to Gmail SMTP server...");
        System.out.println("Sending email via Gmail to: " + toAddress);
        System.out.println("Subject: " + subjectLine);
        System.out.println("Body: " + emailBody);
        // ... actual Gmail API interaction logic ...
        System.out.println("Gmail email sent successfully!");
    }
}

class OutlookClientImpl implements EmailClient {
    public void sendEmail(String toAddress, String subjectLine, String emailBody) {
        System.out.println("Connecting to Outlook SMTP server...");
        System.out.println("Sending email via Outlook to: " + toAddress);
        System.out.println("Subject: " + subjectLine);
        System.out.println("Body: " + emailBody);
        // ... actual Outlook API interaction logic ...
        System.out.println("Outlook email sent successfully!");
    }
}

// Our EmailService will no longer know about GmailClientImpl or
// OutlookClientImpl.
// It will only know about the EmailClient interface.

class EmailService {
    private final EmailClient emailClient; // Dependency on the EmailClient interface

    public EmailService(EmailClient emailClient) {
        this.emailClient = emailClient;
    }

    public void sendWelcomeEmail(String userEmail, String userName) {
        String subject = "Welcome, " + userName + "!";
        String body = "Thanks for signing up to our awesome platform. We're glad to have you!";
        this.emailClient.sendEmail(userEmail, subject, body);
    }

    public void sendEmail(String toAddress, String subjectLine) {
        this.emailClient.sendEmail(toAddress, subjectLine, "");
    }
}

public class DIP {
    public static void main(String[] args) {
        EmailService gmailService = new EmailService(new GmailClientImpl());
        gmailService.sendEmail("test@example.com", "Welcome to SOLID principles!");

        System.out.println("--- Using Outlook ---");
        EmailService outlookService = new EmailService(new OutlookClientImpl());
        outlookService.sendEmail("test@example.com", "Welcome to SOLID principles!");
    }
}
