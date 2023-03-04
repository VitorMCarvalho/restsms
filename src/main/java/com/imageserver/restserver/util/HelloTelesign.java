import com.telesign.MessagingClient;
import com.telesign.RestClient;

public final class HelloTelesign {

    private String customerId = "E4F61A1A-6809-42B2-89FB-90E722F2D15C";
    private String apiKey = "yCila2ZEpFXY0IjuFyb5TgjMuXBJD9nBvu5XjigYB0386Y7UvjF+7pxdioUHwuQj9sonrL1+Vbbvzz8qVyTY2w==";
    private String phoneNumber = "5581997188747";
    private String message = "You're scheduled for a dentist appointment at 2:30PM.";
    private String messageType = "ARN";

    public void EnviarSms(String numero, string posicao){
        this.phoneNumber = numero;
        this.message = "Sua posicao é " + posicao;
        try {
            MessagingClient messagingClient = new MessagingClient(this.customerId, this.apiKey);
            RestClient.TelesignResponse telesignResponse = messagingClient.message(this.phoneNumber, this.message, this.messageType, null);
            System.out.println("Your reference id is: "+telesignResponse.json.get("reference_id"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}