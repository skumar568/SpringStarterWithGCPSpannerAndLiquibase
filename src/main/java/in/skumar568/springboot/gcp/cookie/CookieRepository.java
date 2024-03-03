package in.skumar568.springboot.gcp.cookie;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CookieRepository extends CrudRepository<Cookie, Long> {

    public Cookie findById(String cookieId);
}
