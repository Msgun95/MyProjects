package Bright.AuthenticationService.service;


import Bright.AuthenticationService.entity.AuthenticationResponse;
import Bright.AuthenticationService.entity.Login;
import Bright.AuthenticationService.dto.RegisterRequest;
import Bright.AuthenticationService.entity.User;
import Bright.AuthenticationService.repository.TokenRepository;
import Bright.AuthenticationService.repository.UserRepository;
import Bright.AuthenticationService.entity.Token;
import Bright.AuthenticationService.entity.TokenType;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final UserRepository repository;
private final TokenRepository tokenRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;
 //public AuthenticationResponse register(RegisterRequest request) {
public String register(RegisterRequest request) {
    var user = User.builder()
        .firstName(request.getFirstName())
        .lastName(request.getLastName())
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(request.getRole())
        .build();
    var savedUser = repository.save(user);
   return  "You resgistered Successfully! Thanks Alot! " + request.getFirstName();
//    var jwtToken = jwtService.generateToken(user);
//    var refreshToken = jwtService.generateRefreshToken(user);
//    saveUserToken(savedUser, jwtToken);
//    return AuthenticationResponse.builder()
//        .accessToken(jwtToken)use_table
//           // .refreshToken(refreshToken)
//        .build();
  }



  public AuthenticationResponse login (Login login) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            login.getEmail(),
            login.getPassword()
        )
    );
    var user = repository.findByEmail(login.getEmail())
        .orElseThrow();
    var jwtToken = jwtService.generateToken(user);
    var refreshToken = jwtService.generateRefreshToken(user);
//    revokeAllUserTokens(user);
    saveUserToken(user, jwtToken);
    return AuthenticationResponse.builder()
        .accessToken(jwtToken)
            .refreshToken(refreshToken)
        .build();
  }



  private void saveUserToken(User user, String jwtToken) {
    var token = Token.builder()
        .user(user)
        .token(jwtToken)
        .tokenType(TokenType.BEARER)
        .expired(false)
        .revoked(false)
        .build();
    tokenRepository.save(token);
   // tokenRepository.save(token);
  }

    public  void logout(String token){
        tokenRepository.deleteByToken(token);
    }




//  private void revokeAllUserTokens(User user) {
//    var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
//    if (validUserTokens.isEmpty())
//      return;
//    validUserTokens.forEach(token -> {
//      token.setExpired(true);
//      token.setRevoked(true);
//    });
//    tokenRepository.saveAll(validUserTokens);
//  }
//
//
//
//  public void refreshToken(
//          HttpServletRequest request,
//          HttpServletResponse response
//  ) throws IOException {
//    final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
//    final String refreshToken;
//    final String userEmail;
//    if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
//      return;
//    }
//    refreshToken = authHeader.substring(7);
//    userEmail = jwtService.extractUsername(refreshToken);
//    if (userEmail != null) {
//      var user = this.repository.findByEmail(userEmail)
//              .orElseThrow();
//      if (jwtService.isTokenValid(refreshToken, user)) {
//        var accessToken = jwtService.generateToken(user);
//        revokeAllUserTokens(user);
//        saveUserToken(user, accessToken);
//        var authResponse = AuthenticationResponse.builder()
//                .accessToken(accessToken)
//                .refreshToken(refreshToken)
//                .build();
//        new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
//      }
//    }
//  }
}
