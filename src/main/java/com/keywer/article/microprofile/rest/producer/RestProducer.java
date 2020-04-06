package com.keywer.article.microprofile.rest.producer;

import com.kumuluz.ee.rest.utils.QueryStringDefaults;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

public class RestProducer {

    @Produces
    @ApplicationScoped
    public QueryStringDefaults getQueryStringDefaults() {
        return new QueryStringDefaults()
                .maxLimit(100)
                .defaultLimit(20)
                .defaultOffset(0);
    }
}