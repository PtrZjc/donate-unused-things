package pl.zajacp.donateunusedthings.user.validation;

public class LoginExistsException extends Throwable {

    public LoginExistsException(final String message) {
        super(message);
    }

}
