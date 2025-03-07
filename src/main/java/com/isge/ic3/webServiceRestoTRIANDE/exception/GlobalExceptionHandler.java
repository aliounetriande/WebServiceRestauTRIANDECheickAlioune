package com.isge.ic3.webServiceRestoTRIANDE.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice  // Cette classe intercepte toutes les exceptions globales de l'application
public class GlobalExceptionHandler {

    /**
     * Gestion des exceptions de type RuntimeException (ex : données non trouvées)
     */
    @ExceptionHandler(RuntimeException.class)  // Intercepte toutes les exceptions de type RuntimeException
    public ResponseEntity<Map<String, Object>> handleRuntimeException(RuntimeException ex) {
        // Création d'une structure JSON pour la réponse
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now()); // Ajoute la date et l'heure de l'erreur
        response.put("message", ex.getMessage()); // Message d'erreur précis
        response.put("status", HttpStatus.NOT_FOUND.value()); // Code HTTP 404 (Ressource non trouvée)

        // Retourne une réponse JSON avec un statut HTTP 404
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    /**
     * Gestion globale des autres types d'exceptions (ex: NullPointerException, IllegalArgumentException)
     */
    @ExceptionHandler(Exception.class)  // Intercepte toutes les autres exceptions générales
    public ResponseEntity<Map<String, Object>> handleGeneralException(Exception ex) {
        // Création d'une structure JSON pour la réponse
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now()); // Ajoute la date et l'heure de l'erreur
        response.put("message", "Une erreur inattendue est survenue : " + ex.getMessage()); // Message d'erreur générique
        response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value()); // Code HTTP 500 (Erreur serveur)

        // Retourne une réponse JSON avec un statut HTTP 500
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

