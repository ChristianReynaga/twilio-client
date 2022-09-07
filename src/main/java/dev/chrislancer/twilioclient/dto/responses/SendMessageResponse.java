package dev.chrislancer.twilioclient.dto.responses;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SendMessageResponse {

    private String sid;
    @SerializedName("date_created")
    private Timestamp dateCreated;
    @SerializedName("date_sent")
    private Timestamp dateSent;
    private String status;
    @SerializedName("error_code")
    private String errorCode;
    @SerializedName("error_message")
    private String errorMessage;
    private String uri;

}
