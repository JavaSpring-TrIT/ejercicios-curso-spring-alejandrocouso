package com.curso.service;

import java.util.List;

import com.curso.model.Curso;

public interface CursosService {
	List<Curso> cursos();

	List<Curso> altaCurso(Curso curso);

	List<Curso> eliminarCurso(String codigoCurso);

	void actualizarDuracionCurso(String codigoCurso, int duracion);

	Curso buscarCurso(String codigoCurso);

	List<Curso> obtenerCursosPorPrecio(int precioMaximo, int precioMinimo);

}
