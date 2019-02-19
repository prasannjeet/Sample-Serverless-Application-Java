/*
 * Copyright (c) 2019. Prasannjeet Singh. Master's Student, Linnaeus University
 */

package com.prasannjeet.hellolambdacaller;

import com.amazonaws.ClientConfigurationFactory;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.AwsRegionProvider;

public class AwsClientBuilderFull extends AwsClientBuilder {
    protected AwsClientBuilderFull(ClientConfigurationFactory clientConfigFactory) {
        super(clientConfigFactory);
    }

    protected AwsClientBuilderFull(ClientConfigurationFactory clientConfigFactory, AwsRegionProvider regionProvider) {
        super(clientConfigFactory, regionProvider);
    }

    public Object build() {
        return null;
    }
}
