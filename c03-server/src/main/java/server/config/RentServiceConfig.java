package server.config;

import common.RentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;
import server.service.RentServiceImpl;

/**
 * Created by Nicu on 4/1/17.
 */
@Configuration
public class RentServiceConfig {
    @Bean
    public RentService clientService(){
        return new RentServiceImpl();
    }

    @Bean
    public RmiServiceExporter rmiServiceExporter(){
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setServiceName("RentService");
        exporter.setServiceInterface(RentService.class);
        exporter.setService(clientService());
        return exporter;
    }
}
