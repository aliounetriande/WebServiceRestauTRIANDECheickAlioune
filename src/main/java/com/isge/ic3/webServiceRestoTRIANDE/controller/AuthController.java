//package com.isge.ic3.webServiceRestoTRIANDE.controller;
//
//import com.isge.ic3.webServiceRestoTRIANDE.model.User;
//import com.isge.ic3.webServiceRestoTRIANDE.security.JwtUtil;
//import com.isge.ic3.webServiceRestoTRIANDE.service.UserService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;
//
//@RestController
//@RequestMapping("/auth")
//public class AuthController {
//
//    private final AuthenticationManager authenticationManager;
//    private final UserService userService;
//    private final JwtUtil jwtUtil;
//
//    public AuthController(AuthenticationManager authenticationManager, UserService userService, JwtUtil jwtUtil) {
//        this.authenticationManager = authenticationManager;
//        this.userService = userService;
//        this.jwtUtil = jwtUtil;
//    }
//
//    /**
//     * Endpoint pour l'inscription d'un utilisateur (ADMIN ou CLIENT)
//     */
//    @PostMapping("/register")
//    public ResponseEntity<User> register(@RequestBody Map<String, String> request) {
//        User user = userService.registerUser(
//                request.get("username"),
//                request.get("password"),
//                request.get("role"),
//                request.get("nom"),
//                request.get("email"),
//                request.get("adresse")
//        );
//        return ResponseEntity.ok(user);
//    }
//
//    /**
//     * Endpoint pour la connexion et la génération du JWT
//     */
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody Map<String, String> request) {
//        try {
//            // Tentative d'authentification de l'utilisateur
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(request.get("username"), request.get("password"))
//            );
//        } catch (BadCredentialsException e) {
//            return ResponseEntity.status(401).body("Invalid credentials"); // Mauvaises informations d'authentification
//        }
//
//        // Récupération des détails de l'utilisateur
//        UserDetails userDetails = userService.loadUserByUsername(request.get("username"));
//        String role = userDetails.getAuthorities().toArray()[0].toString();  // Récupérer le rôle de l'utilisateur
//        String jwt = jwtUtil.generateToken(userDetails.getUsername(), role);  // Ajouter le rôle dans le JWT
//
//        return ResponseEntity.ok(jwt);
//    }
//}
