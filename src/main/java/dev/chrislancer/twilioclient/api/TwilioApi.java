package dev.chrislancer.twilioclient.api;

import dev.chrislancer.twilioclient.dto.responses.SendMessageResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TwilioApi {

    @FormUrlEncoded
    @POST("2010-04-01/Accounts/{accountSid}/Messages.json")
    Call<SendMessageResponse> sendMessage(
            @Path("accountSid") String accountSid,
            @Field("Body") String body,
            @Field("From") String from,
            @Field("To") String to
    );
}
