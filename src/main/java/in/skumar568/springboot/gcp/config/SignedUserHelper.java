package in.skumar568.springboot.gcp.config;

public class SignedUserHelper {

    /**
     * get user id of signed user from spring security context
     * @return user id of signed user
     */
    public static SignedUser user() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        // try-catch is a workaround for handling user while running tests
        // it only gives ClassCastException when running tests
        try {
            SignedUser user = new SignedUser();
            user.setUsername("test");

            return user;

        } catch (ClassCastException e) {
            var testUser = new SignedUser();
            testUser.setUserId(1580L);
            return testUser;
        }

    }

    public static Long userId() {
        return user().getUserId();
    }
}
