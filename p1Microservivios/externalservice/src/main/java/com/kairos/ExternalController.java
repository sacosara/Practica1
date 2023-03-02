package com.kairos;

@GrpcService
public class ExternalController extends Externa ServiceGrpc.ServiceImplBase{

    @Override
    public void toUpperCase(Request r,StreamObserver<Response> resObserver){
        System.out.println("Request recived\n" + request);
        resObserver.onNext(res);
        resObserver.onCompleted();
        
    }

    Response res = Response.newBuilder().setResult(r.getText().toUpperCase()).build();
    
    
}
