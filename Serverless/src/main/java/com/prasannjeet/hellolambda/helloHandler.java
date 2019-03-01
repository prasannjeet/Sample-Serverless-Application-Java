/*
 * Copyright (c) 2019. Prasannjeet Singh. Master's Student, Linnaeus University
 */

package com.prasannjeet.hellolambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class helloHandler implements RequestHandler<helloInput, helloOutput> {

    public helloOutput handleRequest(helloInput helloInput, Context context) {
        helloOutput o = new helloOutput();
        o.setMessage("Hello " + helloInput.getName());
        o.setFunctionName(context.getFunctionName());
        o.setMemoryLimit(context.getMemoryLimitInMB());
        o.setTheHashCode(helloInput.hashCode());
        context.getLogger().log(helloInput.getName() + " said hello");
        return o;
    }
}