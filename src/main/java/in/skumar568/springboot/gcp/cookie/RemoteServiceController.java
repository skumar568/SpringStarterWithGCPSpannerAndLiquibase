package in.skumar568.springboot.gcp.cookie;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class RemoteServiceController {

    @Autowired
    private RestTemplate restTemplate;

    private String serviceUrl = "https://dummy.restapiexample.com/api/v1/employees";

    @GetMapping("/employees")
    public ResponseEntity getEmployees() {
        String response = restTemplate.getForObject(serviceUrl, String.class);
        log.info("Got response from {} => {} ",serviceUrl, response);
        return ResponseEntity.ok("response from " + serviceUrl+" =>" + response);

    }
}
