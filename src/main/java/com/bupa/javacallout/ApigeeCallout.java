package com.bupa.javacallout;

import com.apigee.flow.execution.ExecutionContext;
import com.apigee.flow.execution.ExecutionResult;
import com.apigee.flow.execution.spi.Execution;
import com.apigee.flow.message.MessageContext;

public class ApigeeCallout implements Execution {

    public ExecutionResult execute(MessageContext messageContext, ExecutionContext executionContext) {

        try {

            messageContext.setVariable("foo", "Hello World!");

            return ExecutionResult.SUCCESS;

        } catch (Exception e) {
            return ExecutionResult.ABORT;
        }
    }

}
