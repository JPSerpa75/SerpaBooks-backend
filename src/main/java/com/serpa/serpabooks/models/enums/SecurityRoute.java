package com.serpa.serpabooks.models.enums;

import org.springframework.http.HttpMethod;

import lombok.Getter;

@Getter
public enum SecurityRoute {

	LIVROS_SAVE("/livros", HttpMethod.POST, "ADMIN"),
	LIVROS_UPDATE("/livros", HttpMethod.PUT, "ADMIN"),
	LIVROS_DELETE("/livros", HttpMethod.DELETE, "ADMIN"),
	LIVROS_AVALIAR("/livros/avaliar", HttpMethod.POST, "authenticated"),
	
	AUTOR_SAVE("/autor", HttpMethod.POST, "ADMIN"),
	AUTOR_UPDATE("/autor", HttpMethod.PUT, "ADMIN"),
	AUTOR_DELETE("/autor", HttpMethod.DELETE, "ADMIN"),
	AUTOR_GET("/autor", HttpMethod.GET, "ADMIN"),
	
	CAPA_SAVE("/capa", HttpMethod.POST, "ADMIN"),
	CAPA_UPDATE("/capa", HttpMethod.PUT, "ADMIN"),
	CAPA_DELETE("/capa", HttpMethod.DELETE, "ADMIN"),
	CAPA_GET("/capa", HttpMethod.GET, "ADMIN"),
	
	EDITORA_SAVE("/editora", HttpMethod.POST, "ADMIN"),
	EDITORA_UPDATE("/editora", HttpMethod.PUT, "ADMIN"),
	EDITORA_DELETE("/editora", HttpMethod.DELETE, "ADMIN"),
	EDITORA_GET("/editora", HttpMethod.GET, "ADMIN"),
	
	OUTRAS_ROTAS("/outras-rotas", HttpMethod.GET, "permitAll");

	private final String route;
	private final HttpMethod method;
	private final String role;

	SecurityRoute(String route, HttpMethod method, String role) {
		this.route = route;
		this.method = method;
		this.role = role;

	}

}
