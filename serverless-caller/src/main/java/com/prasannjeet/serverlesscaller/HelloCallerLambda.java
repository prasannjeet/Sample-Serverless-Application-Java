package com.prasannjeet.serverlesscaller;

import com.amazonaws.services.lambda.runtime.Context;
import com.prasannjeet.serverlesscaller.model.HelloInput;
import com.prasannjeet.serverlesscaller.model.HelloOutput;

public class HelloCallerLambda {
    public HelloOutput handleRequest(HelloInput helloInput, Context context) {
        HelloOutput o = new HelloOutput();
        o.setMessage("Hello "+helloInput.getName());
        o.setFunctionName(context.getFunctionName());
        o.setMemoryLimit(context.getMemoryLimitInMB());
        o.setTheHashCode(helloInput.hashCode());
//        o.setCognitoIdentity(context.getIdentity());
        context.getLogger().log(helloInput.getName() + " said hello");
        return o;
    }
}
