package dev.chrislancer.twilioclient.services.impl;

import dev.chrislancer.twilioclient.api.TwilioApi;
import dev.chrislancer.twilioclient.client.RetrofitClient;
import dev.chrislancer.twilioclient.dto.requests.SendMessageRequest;
import dev.chrislancer.twilioclient.dto.responses.ErrorResponse;
import dev.chrislancer.twilioclient.dto.responses.SendMessageResponse;
import dev.chrislancer.twilioclient.exceptions.TwilioServiceException;
import dev.chrislancer.twilioclient.services.TwilioService;
import dev.chrislancer.twilioclient.utils.ErrorUtils;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class TwilioServiceImpl implements TwilioService {

    private final TwilioApi api;
    private final String accountSid;

    public TwilioServiceImpl(String baseUrl, String accountSid, String authToken) {
        this.accountSid = accountSid;
        api = RetrofitClient.initializeClient(baseUrl, accountSid, authToken).create(TwilioApi.class);
    }

    @Override
    public SendMessageResponse sendMessage(SendMessageRequest request) throws IOException,
            TwilioServiceException {
        Call<SendMessageResponse> call = api.sendMessage(
                accountSid, request.getBody(), request.getFrom(), request.getTo()
        );
        Response<SendMessageResponse> response = call.execute();
        if (response.isSuccessful()) {
            return response.body();
        }
        ErrorResponse errorResponse = ErrorUtils.parseError(response);
        throw new TwilioServiceException("Error en el servicio Twilio", errorResponse);
    }

}
