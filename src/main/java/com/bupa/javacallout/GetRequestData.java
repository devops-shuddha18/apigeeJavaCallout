package com.bupa.javacallout;

import com.apigee.flow.execution.ExecutionContext;
import com.apigee.flow.execution.ExecutionResult;
import com.apigee.flow.execution.spi.Execution;
import com.apigee.flow.message.MessageContext;

import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;

public class GetRequestData implements Execution {

    @Override
    public ExecutionResult execute(MessageContext messageContext, ExecutionContext executionContext) {
        try {
            // Get request headers
            Map<String, String> headers = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
            for (String headerName : messageContext.getMessage().getHeaderNames()) {
                headers.put(headerName, messageContext.getMessage().getHeader(headerName));
            }

            // Get query parameters
            Map<String, String> queryParams = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
            for (String param : messageContext.getMessage().getQueryParamNames()) {
                queryParams.put(param, messageContext.getMessage().getQueryParam(param));
            }

            // Get request body as string
            InputStream inStream = messageContext.getMessage().getContentAsStream();
            String body = (inStream != null) ? new Scanner(inStream, "UTF-8").useDelimiter("\\A").next() : "";

            // Log all the data (or set it as variables if you prefer)
            messageContext.setVariable("javaCallout.headers", headers.toString());
            messageContext.setVariable("javaCallout.queryParams", queryParams.toString());
            messageContext.setVariable("javaCallout.body", body);

            return ExecutionResult.SUCCESS;

        } catch (Exception e) {
            messageContext.setVariable("javaCallout.error", e.getMessage());
            return ExecutionResult.ABORT;
        }
    }
}