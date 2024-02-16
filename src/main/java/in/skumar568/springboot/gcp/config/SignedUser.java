package in.skumar568.springboot.gcp.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SignedUser {

     private String password;

    private String username = "unkown";

    private Long userId;

    private String tenantId;

    private Boolean enabled;

    private Boolean accountNonExpired;

    private Boolean accountNonLocked;

    private boolean credentialsNonExpired;

}
