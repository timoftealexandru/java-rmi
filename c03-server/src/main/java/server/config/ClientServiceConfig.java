package server.config;
import common.ClientService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;
import server.service.ClientServiceImpl;

/**
 * Created by Nicu on 4/1/17.
 */
@Configuration
public class ClientServiceConfig {
    @Bean
    public ClientService clientService(){
        return new ClientServiceImpl();
    }

    @Bean
    public RmiServiceExporter rmiServiceExporter(){
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setServiceName("ClientService");
        exporter.setServiceInterface(ClientService.class);
        exporter.setService(clientService());
        return exporter;
    }
}
