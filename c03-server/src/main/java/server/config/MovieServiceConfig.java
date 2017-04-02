package server.config;

import common.MovieService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;
import server.service.MovieServiceImpl;


/**
 * Created by Nicu on 4/1/17.
 */
@Configuration
public class MovieServiceConfig {
    @Bean
    public MovieService movieService(){
        return new MovieServiceImpl();
    }

    @Bean
    public RmiServiceExporter rmiServiceExporter(){
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setServiceName("MovieService");
        exporter.setServiceInterface(MovieService.class);
        exporter.setService(movieService());
        return exporter;
    }
}

