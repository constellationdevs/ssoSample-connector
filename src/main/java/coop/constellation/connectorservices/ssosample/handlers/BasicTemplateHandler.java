package coop.constellation.connectorservices.ssosample.handlers;

public interface BasicTemplateHandler {
    public void init();

    public String requestExternalData(String url);
}