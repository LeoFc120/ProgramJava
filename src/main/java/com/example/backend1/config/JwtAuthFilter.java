package com.example.backend1.config;

import com.example.backend1.services.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // 1. Busca el token en la cabecera de la petición
        final String authHeader = request.getHeader("Authorization");

        // 2. Si no hay token, lo deja pasar (SecurityConfig lo bloqueará después si es ruta privada)
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        // 3. Extrae el texto del token (quitando la palabra "Bearer ")
        final String jwt = authHeader.substring(7);

        try {
            String correo = jwtService.extractUsername(jwt);

            // 4. Si el token es válido, le dice a Spring Security: "Déjalo pasar, está autenticado"
            if (correo != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                if (jwtService.isTokenValid(jwt)) {
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            correo, null, new ArrayList<>()
                    );
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }
        } catch (Exception e) {
            // Token inválido, se ignora
        }

        filterChain.doFilter(request, response);
    }
}