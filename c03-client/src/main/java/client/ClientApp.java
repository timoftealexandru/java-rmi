package client;

import client.service.ClientServiceClient;
import client.service.MovieServiceClient;
import client.service.RentServiceClient;
import client.ui.Console;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Nicu on 3/5/2017.
 */
public class ClientApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("client.config");

        MovieServiceClient movieService = context.getBean(MovieServiceClient.class);
        ClientServiceClient clientService = context.getBean(ClientServiceClient.class);
        RentServiceClient rentService = context.getBean(RentServiceClient.class);

        Console console;

        console = new Console(movieService, clientService, rentService);
        console.runConsole();

    }

}
