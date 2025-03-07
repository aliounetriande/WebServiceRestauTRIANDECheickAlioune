//package com.isge.ic3.webServiceRestoTRIANDE.service;
//
//import com.isge.ic3.webServiceRestoTRIANDE.model.Client;
//import com.isge.ic3.webServiceRestoTRIANDE.model.Role;
//import com.isge.ic3.webServiceRestoTRIANDE.model.User;
//import com.isge.ic3.webServiceRestoTRIANDE.repository.UserRepository;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserService implements UserDetailsService {
//
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return userRepository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé"));
//    }
//
//    public User registerUser(String username, String password, String role, String nom, String email, String adresse) {
//        if (userRepository.findByUsername(username).isPresent()) {
//            throw new RuntimeException("Nom d'utilisateur déjà utilisé");
//        }
//
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(passwordEncoder.encode(password));
//        user.setRole(role.equalsIgnoreCase("ADMIN") ? Role.ADMIN : Role.CLIENT);
//
//        if (user.getRole() == Role.CLIENT) {
//            Client client = new Client();
//            client.setNom(nom);
//            client.setEmail(email);
//            client.setAdresse(adresse);
//            user.setClient(client);
//        }
//
//        return userRepository.save(user);
//    }
//}
