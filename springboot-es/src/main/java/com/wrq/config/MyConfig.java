package com.wrq.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;


/**
 * 构造es的TransportClient
 *
 * @author weiruiqi
 * @date 2020/6/25 18:01
 */
@Configuration
public class MyConfig {

    @Bean
    public TransportClient client() throws UnknownHostException {

        TransportAddress node = new TransportAddress(InetAddress.getByName("localhost"), 9300);
        Settings settings = Settings.builder()
                .put("cluster.name", "elasticsearch").build();
        TransportClient client = new PreBuiltTransportClient(settings);
        client.addTransportAddress(node);
        return client;
    }
}
