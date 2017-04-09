package client.config;

import client.service.RentServiceClient;
import common.RentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;


/**
 * Created by Nicu on 4/1/17.
 */
@Configuration
public class RentServiceClientConfig {
    @Bean("rentService")
    public RmiProxyFactoryBean rmiProxyFactoryBean(){
        RmiProxyFactoryBean factoryBean = new RmiProxyFactoryBean();
        factoryBean.setServiceUrl("rmi://localhost:9009/RentService");
        factoryBean.setServiceInterface(RentService.class);
        return factoryBean;
    }

    @Bean
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    public RentServiceClient rentServiceClient(){
=======
    public RentServiceClient RentServiceClient(){
>>>>>>> 8e7da753f0004969eed9d95df6cfae6eaa2f91e6
=======
    public RentServiceClient RentServiceClient(){
>>>>>>> 8e7da753f0004969eed9d95df6cfae6eaa2f91e6
=======
    public RentServiceClient RentServiceClient(){
>>>>>>> 8e7da753f0004969eed9d95df6cfae6eaa2f91e6
        return new RentServiceClient();
    }

}
