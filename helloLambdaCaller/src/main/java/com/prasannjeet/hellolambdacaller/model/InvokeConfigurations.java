package com.prasannjeet.hellolambdacaller.model;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambdaAsyncClient;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.google.gson.Gson;
import com.prasannjeet.hellolambda.model.HelloInput;
import com.prasannjeet.hellolambda.model.HelloOutput;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.nio.charset.StandardCharsets;

@Data
@NoArgsConstructor
public class InvokeConfigurations {
    String name;
    String region;
    Regions theRegion;
    String profileName;
    HelloInput helloInput;
    HelloOutput helloOutput;
    String stringResult;
    String functionName;
    Gson gson;
    AWSCredentialsProvider awsCredentialsProvider;
    AWSLambdaAsyncClient awsLambdaAsyncClient;
    InvokeRequest invokeRequest;
    InvokeResult invokeResult;

    public InvokeConfigurations(String name, String region, String profileName, String functionName) {
        this.setName(name);
        this.setRegion(region);
        this.setProfileName(profileName);
        this.setFunctionName(functionName);
        Gson gson = new Gson();

        theRegion = Regions.fromName(region);
        awsCredentialsProvider = new ProfileCredentialsProvider(profileName);
        awsLambdaAsyncClient = new AWSLambdaAsyncClient(awsCredentialsProvider).withRegion(theRegion);
        helloInput = new HelloInput(name);
        invokeRequest = new InvokeRequest().withFunctionName(functionName).withPayload(gson.toJson(helloInput));
        invokeResult = awsLambdaAsyncClient.invoke(invokeRequest);
        stringResult = StandardCharsets.UTF_8.decode(this.getInvokeResult().getPayload()).toString();
        helloOutput = new HelloOutput();
        helloOutput = gson.fromJson(stringResult, HelloOutput.class);
    }

    public void InvokeConfigurations2 (String name, String region, AWSLambdaAsyncClient awsLambdaAsyncClient, String functionName) {
        this.setName(name);
        this.setRegion(region);
        this.setFunctionName(functionName);
        Gson gson = new Gson();

        theRegion = Regions.fromName(region);
        this.awsLambdaAsyncClient = awsLambdaAsyncClient;
        helloInput = new HelloInput(name);
        invokeRequest = new InvokeRequest().withFunctionName(functionName).withPayload(gson.toJson(helloInput));
        invokeResult = awsLambdaAsyncClient.invoke(invokeRequest);
        stringResult = StandardCharsets.UTF_8.decode(this.getInvokeResult().getPayload()).toString();
        helloOutput = new HelloOutput();
        helloOutput = gson.fromJson(stringResult, HelloOutput.class);
    }


    public String getResponse() {
        return new Gson().toJson(helloOutput);
    }
}
