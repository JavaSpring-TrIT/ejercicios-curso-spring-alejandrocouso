package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Formacion;
import com.curso.service.FormacionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
public class FormacionController {
	@Autowired
	FormacionService service;

	@Operation(summary = "Alta de formación", description = "Permite dar de alta una formación pasando por URL los parámetros necesarios")
	@PostMapping(value = "formacion/{curso}/{asignaturas}/{precio}")
	public List<Formacion> altaFormacion(
			@Parameter(description = "Nombre de la formación a dar de alta") @PathVariable("curso") String curso,
			@Parameter(description = "Numero de asignaturas de las que consta la formación") @PathVariable("asignaturas") int asignaturas,
			@Parameter(description = "Precio total de la formación") @PathVariable("precio") float precio) {
		Formacion formacion = new Formacion(curso, asignaturas, precio);
		return service.altaFormacion(formacion);
	}

	@Operation(summary = "Obtención de formaciones", description = "Obtiene la lista de formaciones sin necesidad de recibir ningún parametro")
	@GetMapping(value = "formaciones")
	public List<Formacion> obtenerFormaciones() {
		return service.obtenerFormaciones();
	}
}
