package io.pivotal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class DataToPass {
    private String dataId;
    private String dataValue;
}