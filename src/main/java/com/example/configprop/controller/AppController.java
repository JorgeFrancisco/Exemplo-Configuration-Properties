package com.example.configprop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.configprop.config.AppProperties;
import com.example.configprop.services.AppService;

@RestController
@RequestMapping("/api")
public class AppController {

	private final AppService appService;

	public AppController(AppService appService) {
		this.appService = appService;
	}

	@GetMapping("/config")
	public ResponseEntity<AppProperties> exibirConfiguracao() {
		return ResponseEntity.ok(appService.getConfiguracoes());
	}
}