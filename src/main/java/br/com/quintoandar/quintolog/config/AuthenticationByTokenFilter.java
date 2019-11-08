package br.com.quintoandar.quintolog.config;

import br.com.quintoandar.quintolog.entity.LogUser;
import br.com.quintoandar.quintolog.repository.LogUserRepository;
import br.com.quintoandar.quintolog.services.TokenService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationByTokenFilter extends OncePerRequestFilter {

    private TokenService tokenService;
    private LogUserRepository repository;

    public AuthenticationByTokenFilter(TokenService tokenService, LogUserRepository repository) {
        this.tokenService = tokenService;
        this.repository = repository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain)
            throws ServletException, IOException {

        String token = toRecover(httpServletRequest);
        boolean valid = tokenService.isTokenValid(token);

        if (valid) {
            authenticateClient(token);
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private void authenticateClient(String token) {

        Long idUser = tokenService.getIdUser(token);
        LogUser logUser = repository.findById(idUser).get();

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(logUser, null, ((LogUser) logUser).getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String toRecover(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
            return null;
        }

        return token.substring(7, token.length());
    }
}
