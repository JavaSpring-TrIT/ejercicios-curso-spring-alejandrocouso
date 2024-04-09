package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Curso;
import com.curso.service.CursosService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@CrossOrigin("*")
@RestController
public class CursosController {
	@Autowired
	CursosService service;

	@Operation(summary = "Obtención de cursos", description = "Obtiene una lista de cursos sin necesidad de recibir ningún parametro")
	@GetMapping(value = "cursos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> cursos() {
		return service.cursos();
	}

	@Operation(summary = "Alta de un curso", description = "Da de alta un curso recibiendo en el body un JSON de 'curso'")
	@PostMapping(value = "curso", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> altaCurso(
			@Parameter(description = "Curso en formato JSON con su correspondiente código, nombre, duración y precio") @RequestBody Curso curso) {
		return service.altaCurso(curso);
	}

	@Operation(summary = "Eliminación de un curso", description = "Elimina un curso recibiendo como parámetro el codigo de curso")
	@DeleteMapping(value = "curso/{codigoCurso}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> eliminarCurso(
			@Parameter(description = "Código del curso que se quiere eliminar") @PathVariable("codigoCurso") String codigoCurso) {
		return service.eliminarCurso(codigoCurso);
	}

	@Operation(summary = "Actualización duración curso", description = "Actualiza la duración de un curso recibiendo como parámetro el codigo del curso y la nueva duración")
	@PutMapping(value = "curso/{codigoCurso}/{duracion}")
	public void actualizarDuracion(
			@Parameter(description = "Código del curso que se quiere actualizar") @PathVariable("codigoCurso") String codigoCurso,
			@Parameter(description = "Nueva duración del curso") @PathVariable("duracion") int duracion) {
		service.actualizarDuracionCurso(codigoCurso, duracion);
	}

	@Operation(summary = "Búsqueda de curso por su código", description = "Busca un curso por su código de curso")
	@GetMapping(value = "curso/{codigoCurso}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Curso buscarcurso(
			@Parameter(description = "Código del curso a buscar") @PathVariable("codigoCurso") String codigoCurso) {
		return service.buscarCurso(codigoCurso);
	}

	@Operation(summary = "Búsqueda de cursos por rango de precio", description = "Busca un curso cuyo precio se encuentre en el rango de precios indicado ")
	@GetMapping(value = "curso/{precioMaximo}/{precioMinimo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> obtenerCursosPorPrecio(
			@Parameter(description = "Precio máximo admitido") @PathVariable("precioMaximo") float precioMaximo,
			@Parameter(description = "Precio mínimo admitido") @PathVariable("precioMinimo") float precioMinimo) {
		return service.obtenerCursosPorPrecio(precioMaximo, precioMinimo);
	}

}
