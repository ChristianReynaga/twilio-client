package dev.chrislancer.twilioclient.services;

import dev.chrislancer.twilioclient.dto.requests.SendMessageRequest;
import dev.chrislancer.twilioclient.dto.responses.SendMessageResponse;
import dev.chrislancer.twilioclient.exceptions.TwilioServiceException;

import java.io.IOException;

public interface TwilioService {

    SendMessageResponse sendMessage(SendMessageRequest request) throws IOException, TwilioServiceException;

}
