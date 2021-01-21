package com.ecom.integration.client;

import com.nab.domain.Source;
import com.nab.domain.TikiProduct;
import com.ecom.integration.AppConfigProperties;
import com.ecom.integration.mapper.ClientMapper;
import com.ecom.integration.mapper.TikiProductMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class TikiClient extends BaseClient<TikiProduct> {

    private final TikiProductMapper mapper;

    public TikiClient(WebClient webClient,
        AppConfigProperties configProperties,
        TikiProductMapper mapper) {
        super(webClient, configProperties);
        this.mapper = mapper;
    }


    @Override
    public Source getSource() {
        return Source.TIKI;
    }

    @Override
    public Class<TikiProduct> getTarget() {
        return TikiProduct.class;
    }

    @Override
    public ClientMapper<TikiProduct> getMapper() {
        return mapper;
    }

}