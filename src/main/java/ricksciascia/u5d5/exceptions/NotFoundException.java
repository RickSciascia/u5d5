package ricksciascia.u5d5.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("La risorsa con ID: " + id + " non è stata trovata!!!!");
    }
}
