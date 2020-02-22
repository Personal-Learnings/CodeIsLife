package com.learnings.practise.designpatterns;

public class Adapter {
    public static void main(String[] args) {
        ExternalServiceAdapter serviceAdapter = new ExternalServiceAdapter();
        serviceAdapter.invoke("Send this data");
    }
}

class ExternalService {
    public void invoke(Request request) {
        //Code to Invoke the External Service
    }
}

class ExternalServiceAdapter {
    private ExternalService externalService;

    ExternalServiceAdapter() {
        externalService = new ExternalService();
    }

    public void invoke(String data) {
        Request request = new Request();
        request.setHeader("header");
        request.setPayload(data);
        externalService.invoke(request);
    }
}

class Request {
    private String header;
    private String payload;

    public String getHeader() { return header; }
    public void setHeader(String header) { this.header = header; }
    public String getPayload() { return payload; }
    public void setPayload(String payload) { this.payload = payload; }
}
