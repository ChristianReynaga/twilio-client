package dev.chrislancer.twilioclient.client;

import dev.chrislancer.twilioclient.dto.requests.SendMessageRequest;
import dev.chrislancer.twilioclient.dto.responses.SendMessageResponse;
import dev.chrislancer.twilioclient.exceptions.TwilioServiceException;

import java.io.IOException;

public interface TwilioClient {

    SendMessageResponse sendMessage(SendMessageRequest request) throws IOException, TwilioServiceException;

}
