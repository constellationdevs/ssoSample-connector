package coop.constellation.connectorservices.ssosample.service;


public interface IBasicTemplateHandler {
    public void init();

    public String requestExternalData(String url);
}