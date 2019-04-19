package com.prasannjeet.serverlesscaller;

import com.amazonaws.services.lambda.runtime.Context;
import com.prasannjeet.hellolambda.model.HelloOutput;
import com.prasannjeet.hellolambda.model.HelloInput2;
import com.prasannjeet.hellolambdacaller.model.InvokeConfigurations;


public class HelloCallerLambda {
    public HelloOutput handleRequest(HelloInput2 helloInput2, Context context) {
        InvokeConfigurations invokeConfigurations = new InvokeConfigurations();
        invokeConfigurations.InvokeConfigurations2(helloInput2.getName(), helloInput2.getRegion(), helloInput2.getAwsLambdaAsyncClient(), helloInput2.getFunctionName());
        HelloOutput helloOutput = invokeConfigurations.getHelloOutput();
        context.getLogger().log(helloInput2.getName() + " said hello");
        return helloOutput;
    }
}
