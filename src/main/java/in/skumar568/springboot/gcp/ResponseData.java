package in.skumar568.springboot.gcp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseData implements Serializable {
    private String chain;
    private String city;
    private String stmtDateEnd;
    private String sequenceKey;
    private String merchantName;
    private String statementStartMonth;
    private String acquirer;
    private String merchantNumber;
    private String associate;
    private String statementEndMonth;
    private String principal;
    private String stmtDateStart;
    private String stmtMonthYear;
    private String corporate;
    private String geographicalRegion;
    private String state;
    private String region;

}
