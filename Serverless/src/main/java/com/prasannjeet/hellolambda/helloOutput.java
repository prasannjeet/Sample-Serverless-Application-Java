/*
 * Copyright (c) 2019. Prasannjeet Singh. Master's Student, Linnaeus University
 */

package com.prasannjeet.hellolambda;

public class helloOutput {
    private String message;
    private String functionName;
    private int theHashCode;
    private int memoryLimit;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public int getMemoryLimit() {
        return memoryLimit;
    }

    public void setMemoryLimit(int memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    public int getTheHashCode() {
        return theHashCode;
    }

    public void setTheHashCode(int theHashCode) {
        this.theHashCode = theHashCode;
    }
}
