package com.example.apigee;

import com.apigee.flow.execution.spi.Execution;
import com.apigee.flow.execution.ExecutionContext;
import com.apigee.flow.execution.ExecutionResult;
import com.apigee.flow.message.MessageContext;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import pubsub.PubSubServiceGrpc;
import pubsub.GetTopicRequest;
import pubsub.GetTopicResponse;

public class GrpcCallout implements Execution {

    @Override
    public ExecutionResult execute(MessageContext messageContext, ExecutionContext executionContext) {
        //String topicName = messageContext.getVariable("request.queryparam.topic_name");
        String topicName = "/data/AccountChangeEvent";

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("api.pubsub.salesforce.com", 7443)
                .useTransportSecurity()
                .build();

        PubSubServiceGrpc.PubSubServiceBlockingStub stub = PubSubServiceGrpc.newBlockingStub(channel);

        GetTopicRequest request = GetTopicRequest.newBuilder()
                .setTopicName(topicName)
                .build();

        try {
            GetTopicResponse response = stub.getTopic(request);
            messageContext.setVariable("grpc.schema_id", response.getSchemaId());
            messageContext.setVariable("grpc.topic_name", response.getTopicName());
            messageContext.setVariable("grpc.can_publish", response.getCanPublish());
            messageContext.setVariable("grpc.rpc_id", response.getRpcId());
        } catch (Exception e) {
            messageContext.setVariable("grpc.error", e.getMessage());
            return ExecutionResult.ABORT;
        } finally {
            channel.shutdown();
        }

        return ExecutionResult.SUCCESS;
    }
}
