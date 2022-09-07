package dev.chrislancer.twilioclient.utils;

import dev.chrislancer.twilioclient.client.RetrofitClient;
import dev.chrislancer.twilioclient.dto.responses.ErrorResponse;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

import java.io.IOException;
import java.lang.annotation.Annotation;

public class ErrorUtils {

    private ErrorUtils() {
    }

    public static ErrorResponse parseError(Response<?> response) {
        Converter<ResponseBody, ErrorResponse> converter =
                RetrofitClient.getInstance()
                        .responseBodyConverter(ErrorResponse.class, new Annotation[0]);
        ErrorResponse error;
        try {
            if (response.errorBody() == null) {
                throw new IllegalArgumentException("ErrorBody no debe ser nulo");
            }
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            return new ErrorResponse();
        }
        return error;
    }

}
