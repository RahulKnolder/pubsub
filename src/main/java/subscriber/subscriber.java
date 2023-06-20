package subscriber;

import com.azure.messaging.webpubsub.WebPubSubServiceClient;
import com.azure.messaging.webpubsub.WebPubSubServiceClientBuilder;
import com.azure.messaging.webpubsub.models.GetClientAccessTokenOptions;
import com.azure.messaging.webpubsub.models.WebPubSubClientAccessToken;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class subscriber {

    public static void main( String[] args ) throws IOException, URISyntaxException
    {



        WebPubSubServiceClient service = new WebPubSubServiceClientBuilder()
                                                 .connectionString("Endpoint=https://mypubsubaccount.webpubsub.azure.com;AccessKey=v64PgbdIsD0njbBHZ0HTn4gpjv9PalQyOOUjvpgmBTM=;Version=1.0;")
                                                 .hub("Hub")
                                                 .buildClient();

        WebPubSubClientAccessToken token = service.getClientAccessToken(new GetClientAccessTokenOptions());

        WebSocketClient webSocketClient = new WebSocketClient(new URI(token.getUrl())) {

            @Override
            public void onMessage(String message) {
                System.out.println("rahul");
                System.out.println(String.format("Message received: %s", message));
            }

            @Override
            public void onClose(int arg0, String arg1, boolean arg2) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onError(Exception arg0) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onOpen(ServerHandshake arg0) {
                // TODO Auto-generated method stub
            }

        };

        webSocketClient.connect();
    }




}
