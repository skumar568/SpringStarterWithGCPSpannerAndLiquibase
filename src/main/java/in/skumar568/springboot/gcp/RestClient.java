package in.skumar568.springboot.gcp;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestClient {

    static RestTemplate restTemplate = new RestTemplate();
    public static String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6IjAwMDAwMDAwLTAwMDAtMDAwMC0wMDAwLTAwMDAwMDAwMCJ9.eyJhdWQiOiIwMDAwMDAwMC0wMDAwLTAwMDAtMDAwMC0wMDAwMDAwMDAiLCJzdWJtb2R1bGVzIjoibWVyY2hhbnQucG9ydGFsIiwiaXNzIjoiaHR0cHM6Ly9zZWN1cmUtYXBpLWRldi5ucC1yZXBvcnRpbmcuZ2xvYmFscGF5LmNvbS9uZXh0Z2VuL2FwcGxpY2F0aW9ucyIsImxhbmd1YWdlIjoiZW4tVVMiLCJleHAiOjE3MDcxMzMxNDYsImFwcF9pZCI6IjMiLCJpYXQiOjE3MDcxMzIyNDYsImVtYWlsIjoibWRldl90c3lzX3RlY2hfYWRtaW5AcHV0c2JveC5jb20iLCJjbGllbnRfaWQiOiIwMDAwMDAwMC0wMDAwLTAwMDAtMDAwMC0wMDAwMDAwMDAifQ.A8crgBkFPLrP6e036FYlkxO3SZO8aLbLpEsur3AiC_W6M7_Icd4GGvaqmjsHcN-_spSK_M3o3ltNq4W22Dr5gAmKyJyFjU0v5_jSkyFl1kDfh0xCPkz-YEZa6hovHbk5F4D4Zrk683y0UWWiKPitayWomb_u-x5NsYp23SCGIgo";

    public static String apiUri = "https://api-dev.np-reporting.globalpay.com/nextgen/reports/api/v2/reports/17/data?filters=%5B%7B%22v1%22%3A%22100100000001%22%2C%22id%22%3A65043%2C%22type%22%3A%22EXACT%22%7D%2C%7B%22v1%22%3A%222023-05-01%22%2C%22v2%22%3A%222023-05-31%22%2C%22id%22%3A188%2C%22type%22%3A%22BETWEEN%22%7D%2C%7B%22v1%22%3A%2205-2023%22%2C%22type%22%3A%22EXACT%22%2C%22id%22%3A184%7D%2C%7B%22v1%22%3A%2205-2023%22%2C%22type%22%3A%22EXACT%22%2C%22id%22%3A185%7D%5D";
    public static void main(String args[]) throws Exception {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION,token);
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        ResponseEntity<ResponseData[]> response = restTemplate.exchange(apiUri, HttpMethod.GET, httpEntity, ResponseData[].class);

    }

}
