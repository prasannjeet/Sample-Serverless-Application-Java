package com.prasannjeet.hellolambdacaller;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambdaAsyncClient;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.google.gson.Gson;
import com.prasannjeet.hellolambda.model.HelloOutput;
import com.prasannjeet.hellolambda.model.HelloInput2;
import com.prasannjeet.hellolambdacaller.logic.Processes;
import com.prasannjeet.hellolambdacaller.model.InvokeConfigurations;

import java.nio.charset.StandardCharsets;

public class CallerClass {

    public static void main (String[] args) {
//        InvokeConfigurations invokeConfigurations = new InvokeConfigurations("Prasannjeet", "us-east-2", "helloLambda", "hellolambda");
//        System.out.println(Processes.prettyPringJSON(invokeConfigurations.getResponse()));

        AWSCredentialsProvider awsCredentialsProvider = new ProfileCredentialsProvider("helloLambda");
        AWSLambdaAsyncClient awsLambdaAsyncClient = new AWSLambdaAsyncClient(awsCredentialsProvider).withRegion(Regions.US_EAST_2);
        System.out.println("Okay "+awsLambdaAsyncClient);
        System.out.println("Okay2 "+new Gson().toJson(awsLambdaAsyncClient));
        HelloInput2 helloInput2 = new HelloInput2("Monika", "us-east-2", awsLambdaAsyncClient, "hellolambda");

        AWSCredentialsProvider awsCredentialsProvider1 = new ProfileCredentialsProvider("helloLambda2");
        AWSLambdaAsyncClient awsLambdaAsyncClient1 = new AWSLambdaAsyncClient(awsCredentialsProvider1).withRegion(Regions.US_EAST_2);
        InvokeRequest invokeRequest = new InvokeRequest().withFunctionName("serverless-caller").withPayload(new Gson().toJson(helloInput2));
        InvokeResult invokeResult = awsLambdaAsyncClient1.invoke(invokeRequest);
        String stringResult = StandardCharsets.UTF_8.decode(invokeResult.getPayload()).toString();
        HelloOutput helloOutput = new Gson().fromJson(stringResult, HelloOutput.class);
        System.out.println("Answer: "+Processes.prettyPringJSON(new Gson().toJson(helloOutput)));
    }
}
