package pl.zajacp.donateunusedthings.user.validation;

public class EmailExistsException extends Exception {

    public EmailExistsException(final String message) {
        super(message);
    }

}
