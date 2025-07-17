package com.example.configprop.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

@Validated
@ConfigurationProperties(prefix = "app")
public record AppProperties(

		@NotEmpty(message = "O nome da aplicação não pode ser vazio") String name,

		@Min(value = 1, message = "O número mínimo de usuários deve ser maior que zero") int maxUsers,

		@NotEmpty(message = "A lista de funcionalidades não pode estar vazia") List<String> features) {
}