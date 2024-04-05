package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Curso;
import com.curso.service.CursosService;

@RestController
public class CursosController {
	@Autowired
	CursosService service;

	@GetMapping(value = "cursos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> cursos() {
		return service.cursos();
	}

	@PostMapping(value = "curso", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> altaCurso(@RequestBody Curso curso) {
		return service.altaCurso(curso);
	}

	@DeleteMapping(value = "curso/{codigoCurso}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> eliminarCurso(@PathVariable("codigoCurso") String codigoCurso) {
		return service.eliminarCurso(codigoCurso);
	}

	@PutMapping(value = "curso/{codigoCurso}/{duracion}")
	public void actualizarDuracion(@PathVariable("codigoCurso") String codigoCurso,
			@PathVariable("duracion") int duracion) {
		service.actualizarDuracionCurso(codigoCurso, duracion);
	}

	@GetMapping(value = "curso/{codigoCurso}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Curso buscarcurso(@PathVariable("codigoCurso") String codigoCurso) {
		return service.buscarCurso(codigoCurso);
	}

	@GetMapping(value = "curso/{precioMaximo}/{precioMinimo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> obtenerCursosPorPrecio(@PathVariable("precioMaximo") int precioMaximo,
			@PathVariable("precioMinimo") int precioMinimo) {
		return service.obtenerCursosPorPrecio(precioMaximo, precioMinimo);
	}

}
