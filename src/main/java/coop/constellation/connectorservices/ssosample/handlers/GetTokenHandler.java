package coop.constellation.connectorservices.ssosample.handlers;

import java.io.IOException;
import java.text.ParseException;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.xtensifi.dspco.ConnectorMessage;
import com.xtensifi.dspco.UserData;

import coop.constellation.connectorservices.ssosample.service.BasicTemplateImp;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetTokenHandler extends HandlerBase {

    private BasicTemplateImp BasicTemplateSvc;
    private String extResponse;

    @Override
    public void generateResponse(Map<String, String> parms, UserData userData, ConnectorMessage connectorMessage)
            throws Exception {
        if (parms.get("url") != null) {
            // REQUIRED FORMAT - Is handled by httpRequest;
            BasicTemplateSvc = new BasicTemplateImp();
            BasicTemplateSvc.init();
            String response = BasicTemplateSvc.requestExternalData(parms.get("url"));

            connectorMessage.setResponse(response);
        } else {
            // REQUIRED FORMAT - "{\"response\": {YOUR OBJECT HERE}}" as JSON string;
            extResponse = "{\"response\": {\"data\": {}, \"success\": false}}";
        }
        // ==========================================================================================================
        // END - FUNCTION TO CALL EXTERNAL WEB SERVER
        // BEGIN - SET RESPONSE - Your Code here.
        // ==========================================================================================================
        connectorMessage.setResponse(extResponse);
    }

    @Override
    public String generateResponse(UserData userData, ConnectorMessage connectorMessage)
            throws IOException, ParseException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generateResponse'");
    }

}
