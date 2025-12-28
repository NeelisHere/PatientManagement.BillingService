package com.billingService.demo.grpc;

import billing.BillingResponse;
import billing.BillingServiceGrpc;
import billing.BillingServiceGrpc.BillingServiceImplBase;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class BillingGrpcService extends BillingServiceImplBase {
    private static final Logger log = LoggerFactory.getLogger(BillingServiceGrpc.class);
    @Override
    public void createBillingAccount(billing.BillingRequest request, StreamObserver<billing.BillingResponse> responseObserver) {
        log.info("createBillingAccount request received {}", request.toString());
        BillingResponse response = BillingResponse.newBuilder()
                .setAccountId("70f9g8h70d9f8g7j")
                .setStatus("ACTIVE")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
