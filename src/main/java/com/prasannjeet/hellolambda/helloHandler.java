package com.prasannjeet.hellolambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class helloHandler implements RequestHandler<helloInput, helloOutput> {

    public helloOutput handleRequest(helloInput helloInput, Context context) {
        helloOutput o = new helloOutput();
        o.setMessage("Hello " + helloInput.getName());
        o.setFunctionName(context.getFunctionName());
        o.setMemoryLimit(context.getMemoryLimitInMB());
        context.getLogger().log(helloInput.getName() + " said hello");
        return o;
    }
}