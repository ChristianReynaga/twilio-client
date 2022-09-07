package dev.chrislancer.twilioclient.client;

import dev.chrislancer.twilioclient.dto.requests.SendMessageRequest;
import dev.chrislancer.twilioclient.dto.responses.SendMessageResponse;
import dev.chrislancer.twilioclient.exceptions.TwilioServiceException;
import dev.chrislancer.twilioclient.services.TwilioService;
import dev.chrislancer.twilioclient.services.impl.TwilioServiceImpl;

import java.io.IOException;

public class TwilioClientImpl implements TwilioClient {

    private final TwilioService twilioService;

    public TwilioClientImpl(String baseUrl, String accountSid, String authToken) {
        twilioService = new TwilioServiceImpl(baseUrl, accountSid, authToken);
    }

    @Override
    public SendMessageResponse sendMessage(SendMessageRequest request) throws IOException, TwilioServiceException {
        return twilioService.sendMessage(request);
    }

}
