package dev.chrislancer.twilioclient.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SendMessageRequest {

     private String body;
     private String from;
     private String to;

}
