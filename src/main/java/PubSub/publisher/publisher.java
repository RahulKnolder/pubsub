package PubSub.publisher;

import com.azure.messaging.webpubsub.WebPubSubServiceClient;
import com.azure.messaging.webpubsub.WebPubSubServiceClientBuilder;
import com.azure.messaging.webpubsub.models.WebPubSubContentType;

public class publisher {
    public static void main( String[] args )
    {


            WebPubSubServiceClient service = new WebPubSubServiceClientBuilder()
                                                     .connectionString("Endpoint=https://mypubsubaccount.webpubsub.azure.com;AccessKey=v64PgbdIsD0njbBHZ0HTn4gpjv9PalQyOOUjvpgmBTM=;Version=1.0;")
                                                     .hub("Hub")
                                                     .buildClient();
        service.sendToAll("I am rahul kumar sinha", WebPubSubContentType.TEXT_PLAIN);
    }
}
