package in.skumar568.springboot.gcp.cookie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.google.api.client.util.Lists;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "api/cookies", produces = "application/json")
@Slf4j
public class CookieController {
//
//    @Autowired
//    PubSubUtility pubSubUtility;

    private final CookieRepository cookieRepository;

    public CookieController(CookieRepository cookieRepository) {
        this.cookieRepository = cookieRepository;
    }

    @PostMapping
    public ResponseEntity<Cookie> save( @RequestBody Cookie cookie) throws Exception {
        return ResponseEntity.ok().body(cookieRepository.save(cookie));
    }

    @GetMapping
    public ResponseEntity<List<Cookie>> getall() {
        List<Cookie> cookieList = Lists.newArrayList(cookieRepository.findAll());
        return ResponseEntity.ok().body(cookieList);
    }

    @DeleteMapping("/{cookieId}")
    public  String delete (@PathVariable String cookieId){
        Cookie cookie = cookieRepository.findById(cookieId);

        log.info("deleting ", cookie.getId());

//        cookieRepository.s
        cookieRepository.delete(cookie);

        return "deleted";
    }

}
