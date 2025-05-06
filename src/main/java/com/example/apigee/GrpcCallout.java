package com.example.apigee;

import com.apigee.flow.execution.ExecutionContext;
import com.apigee.flow.execution.ExecutionResult;
import com.apigee.flow.message.MessageContext;
import com.apigee.flow.execution.spi.Execution;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import pubsub.PubSubServiceGrpc;
import pubsub.PubSubServiceGrpc.PubSubServiceBlockingStub;
import pubsub.GetTopicRequest;
import pubsub.GetTopicResponse;

public class GrpcCallout implements Execution {

    @Override
    public ExecutionResult execute(MessageContext messageContext, ExecutionContext executionContext) {
        //String topicId = messageContext.getVariable("topic.id").toString();
        String topic_name = "/event/Account_Updated__e";

        ManagedChannel channel = null;
        try {
            channel = ManagedChannelBuilder
                    .forAddress("api.pubsub.salesforce.com", 7443)
                    .useTransportSecurity()
                    .build();

            PubSubServiceBlockingStub stub = PubSubServiceGrpc.newBlockingStub(channel);

            GetTopicRequest request = GetTopicRequest.newBuilder()
                    .setTopicName(topic_name)
                    .build();

            GetTopicResponse response = stub.getTopic(request);

            // Set response variables to Apigee context
            messageContext.setVariable("grpc.topic.name", response.getSchemaId());
            messageContext.setVariable("grpc.topic.description", response.getTopicName());

            return ExecutionResult.SUCCESS;
        } catch (Exception e) {
            messageContext.setVariable("grpc.error", e.getMessage());
            return ExecutionResult.ABORT;
        } finally {
            if (channel != null) {
                channel.shutdown();
            }
        }
    }
}
