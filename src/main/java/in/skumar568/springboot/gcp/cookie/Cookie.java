package in.skumar568.springboot.gcp.cookie;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;

import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@SQLDelete(sql = "UPDATE cookie SET is_deleted = true WHERE id=?")
public class Cookie extends AuditorEntity {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private UUID id;

    private String flavour;

    public static Cookie from (String flavour) {
        var cookie = new Cookie();
        cookie.flavour = flavour;
        return cookie;
    }

    public String getFlavour() {
        return flavour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cookie cookie = (Cookie) o;
        return flavour.equals(cookie.flavour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flavour);
    }

    @Override
    public String toString() {
        return "Cookie{" +
                "id=" + id +
                ", flavour='" + flavour + '\'' +
                '}';
    }
}
