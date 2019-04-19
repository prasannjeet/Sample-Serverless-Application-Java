/*
 * Copyright (c) 2019. Prasannjeet Singh. Master's Student, Linnaeus University
 */

package com.prasannjeet.hellolambda.model;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.services.lambda.AWSLambdaAsyncClient;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HelloInput2 {
    String name;
    String region;
    AWSLambdaAsyncClient awsLambdaAsyncClient;
    String functionName;

    public HelloInput2(String name, String region, AWSLambdaAsyncClient awsLambdaAsyncClient, String functionName) {
        this.name = name;
        this.region = region;
        this.awsLambdaAsyncClient = awsLambdaAsyncClient;
        this.functionName = functionName;
    }
}
