package client.config;

import client.service.ClientServiceClient;
import common.ClientService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;


/**
 * Created by Nicu on 4/1/17.
 */
@Configuration
public class ClientServiceClientConfig {
    @Bean
    RmiProxyFactoryBean rmiProxyFactoryBean(){
        RmiProxyFactoryBean factoryBean = new RmiProxyFactoryBean();
        factoryBean.setServiceUrl("rmi://localhost:1099/ClientService");
        factoryBean.setServiceInterface(ClientService.class);
        return factoryBean;
    }

    @Bean
    ClientServiceClient ClientServiceClient(){
        return new ClientServiceClient();
    }
}
