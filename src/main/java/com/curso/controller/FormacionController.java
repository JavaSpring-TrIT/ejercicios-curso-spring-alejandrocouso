package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Formacion;
import com.curso.service.FormacionService;

@RestController
public class FormacionController {
	@Autowired
	FormacionService service;

	@PostMapping(value = "formacion/{curso}/{asignaturas}/{precio}")
	public List<Formacion> altaCurso(@PathVariable("curso") String curso,
			@PathVariable("asignaturas") int asignaturas,
			@PathVariable("precio") float precio) {
		Formacion formacion = new Formacion(curso, asignaturas, precio);
		return service.altaFormacion(formacion);
	}

	@GetMapping(value = "formaciones")
	public List<Formacion> obtenerFormaciones() {
		return service.obtenerFormaciones();
	}
}
