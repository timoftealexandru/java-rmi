package client.config;
import client.service.RentServiceClient;
import common.RentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;


/**
 * Created by Nicu on 4/1/17.
 */
@Configuration
public class RentServiceClientConfig {
    @Bean
    RmiProxyFactoryBean rmiProxyFactoryBean(){
        RmiProxyFactoryBean factoryBean = new RmiProxyFactoryBean();
        factoryBean.setServiceUrl("rmi://localhost:1099/RentService");
        factoryBean.setServiceInterface(RentService.class);
        return factoryBean;
    }

    @Bean
    public RentServiceClient RentServiceClient(){
        return new RentServiceClient();
    }
}
