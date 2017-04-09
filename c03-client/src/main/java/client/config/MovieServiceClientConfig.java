package client.config;

import client.service.MovieServiceClient;
import client.service.RentServiceClient;
import common.MovieService;
import common.RentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;


/**
 * Created by Nicu on 4/1/17.
 */
@Configuration
public class MovieServiceClientConfig {
    @Bean("movieService")
    public RmiProxyFactoryBean rmiProxyFactoryBean(){
        RmiProxyFactoryBean factoryBean = new RmiProxyFactoryBean();
        factoryBean.setServiceUrl("rmi://localhost:9009/MovieService");
        factoryBean.setServiceInterface(MovieService.class);
        return factoryBean;
    }

    @Bean
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    public MovieServiceClient movieServiceClient(){
=======
    public MovieServiceClient MovieServiceClient(){
>>>>>>> 8e7da753f0004969eed9d95df6cfae6eaa2f91e6
=======
    public MovieServiceClient MovieServiceClient(){
>>>>>>> 8e7da753f0004969eed9d95df6cfae6eaa2f91e6
=======
    public MovieServiceClient MovieServiceClient(){
>>>>>>> 8e7da753f0004969eed9d95df6cfae6eaa2f91e6
        return new MovieServiceClient();
    }
}
