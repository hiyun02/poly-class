package kopo.poly.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude
@Data
public class ChatDTO {
    private String roomkey="";
    private String userNm="";
    private String dateTime="";
    private String msg="";
}
