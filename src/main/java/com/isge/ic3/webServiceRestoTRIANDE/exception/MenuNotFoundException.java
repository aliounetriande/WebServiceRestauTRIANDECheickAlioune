package com.isge.ic3.webServiceRestoTRIANDE.exception;

public class MenuNotFoundException extends RuntimeException {
    public MenuNotFoundException(Long id) {
        super("Menu non trouvé avec l'ID: " + id);
    }
}
