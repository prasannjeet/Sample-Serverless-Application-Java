/*
 * Copyright (c) 2019. Prasannjeet Singh. Master's Student, Linnaeus University
 */

package com.prasannjeet.hellolambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.prasannjeet.hellolambda.logics.FirstLogic;
import com.prasannjeet.hellolambda.model.HelloInput;
import com.prasannjeet.hellolambda.model.HelloOutput;

public class helloHandler implements RequestHandler<HelloInput, HelloOutput> {

    public HelloOutput handleRequest(HelloInput helloInput, Context context) {
        HelloOutput o = new HelloOutput();
        o.setMessage(new FirstLogic().addHello(helloInput.getName()));
        o.setFunctionName(context.getFunctionName());
        o.setMemoryLimit(context.getMemoryLimitInMB());
        o.setTheHashCode(helloInput.hashCode());
//        o.setCognitoIdentity(context.getIdentity());
        context.getLogger().log(helloInput.getName() + " said hello");
        return o;
    }
}