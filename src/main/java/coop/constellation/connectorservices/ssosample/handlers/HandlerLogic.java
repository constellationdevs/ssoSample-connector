package coop.constellation.connectorservices.ssosample.handlers;

import java.io.IOException;
import java.text.ParseException;
import java.util.Map;

import com.xtensifi.dspco.ConnectorMessage;
import com.xtensifi.dspco.UserData;

/**
 * Interface for the custom logic to generate a response
 */

public interface HandlerLogic {
    String generateResponse(final UserData userData, ConnectorMessage connectorMessage)
            throws IOException, ParseException;

    void generateResponse(final Map<String, String> parms, UserData userData, ConnectorMessage cm) throws Exception;
}