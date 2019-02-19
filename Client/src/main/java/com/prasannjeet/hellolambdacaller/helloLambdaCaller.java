/*
 * Copyright (c) 2019. Prasannjeet Singh. Master's Student, Linnaeus University
 */

package com.prasannjeet.hellolambdacaller;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambdaAsyncClient;

import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.google.gson.Gson;
import com.prasannjeet.hellolambda.helloInput;
import com.prasannjeet.hellolambda.helloOutput;

import java.nio.charset.StandardCharsets;


public class helloLambdaCaller {
    public static void main (String[] args) {
        String name = "Student";
        String region = "us-east-2";
        if(args.length > 0) name = args[0];
        if(args.length > 1) region = args[1];
        Regions theRegion = Regions.fromName(region);
        Gson gson = new Gson();
        AWSLambdaAsyncClient client = new AWSLambdaAsyncClient(new ProfileCredentialsProvider("default")).withRegion(theRegion);
        AwsClientBuilder clientBuilder = null;
        helloInput in = new helloInput();
        in.setName(name);
        InvokeRequest invokeRequest = new InvokeRequest().withFunctionName("hellolambda").withPayload(gson.toJson(in));
        InvokeResult invokeResult = client.invoke(invokeRequest);
        String s = StandardCharsets.UTF_8.decode(invokeResult.getPayload()).toString();
        helloOutput out = gson.fromJson(s, helloOutput.class);
        System.out.println("Message: " + out.getMessage() + "\n" +
                "FunctionName: " + out.getFunctionName() + "\n" +
                "Memory: " + out.getMemoryLimit());
    }
}
