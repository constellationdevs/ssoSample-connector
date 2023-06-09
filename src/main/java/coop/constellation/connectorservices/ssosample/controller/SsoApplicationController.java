package coop.constellation.connectorservices.ssosample.controller;

import com.xtensifi.dspco.ConnectorMessage;

import com.xtensifi.connectorservices.common.logging.ConnectorLogging;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import coop.constellation.connectorservices.ssosample.handlers.GetTokenHandler;
import lombok.AllArgsConstructor;

// NOTE: Format for "@RequestMapping"
// RequestMapping("/externalConnector/[Connector Name]/[Connector Version Number]")

@RestController
@Controller
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/externalConnector/SsoConnector/1.0")
public class SsoApplicationController extends ConnectorControllerBase {

    // Following method is required in order for your controller to pass health
    // checks.
    @GetMapping("/awsping")
    public String getAWSPing() {
        return "{ping: 'pong'}";
    }

    // Logger for this object
    private ConnectorLogging logger = new ConnectorLogging();

    @PostMapping(path = "/GetToken", consumes = "application/json", produces = "application/json")
    public ConnectorMessage ExternalCallMethod(@RequestBody String connectorJson) {
        final String logPrefix = "SSOConnector.ExternalCallMethod: ";

        GetTokenHandler handler = new GetTokenHandler();

        final ConnectorMessage connectorMessage = handleConnectorMessage(logPrefix, connectorJson, handler);
        logger.info(connectorMessage, "Final: " + connectorMessage.getResponse());
        return connectorMessage;

    }
}
