package com.curso.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.curso.model.Curso;

@Service
public class CursosServiceImpl implements CursosService {
	List<Curso> cursos;

	public CursosServiceImpl() {
		cursos = new ArrayList<Curso>();
		cursos.add(new Curso("A111", "Java", 10, 5));
		cursos.add(new Curso("B222", "CSS", 20, 6));
		cursos.add(new Curso("C333", "Python", 30, 7));
		cursos.add(new Curso("D444", "Windows", 40, 8));
		cursos.add(new Curso("E555", "Linux", 50, 9));
	}

	@Override
	public List<Curso> cursos() {
		return cursos;
	}

	@Override
	public List<Curso> altaCurso(Curso curso) {
		cursos.add(curso);
		return cursos;
	}

	@Override
	public List<Curso> eliminarCurso(String codigoCurso) {
		cursos.removeIf(curso -> curso.getCodCurso().equals(codigoCurso));
		return cursos;
	}

	@Override
	public void actualizarDuracionCurso(String codigoCurso, int duracion) {
		Curso curso = buscarCurso(codigoCurso);
		if (curso != null) {
			curso.setDuracion(duracion);
		}
	}

	@Override
	public Curso buscarCurso(String codigoCurso) {
		System.out.print(codigoCurso);
		return cursos.stream().filter(curso -> curso.getCodCurso().equals(codigoCurso)).findFirst().orElse(null);
	}

	@Override
	public List<Curso> obtenerCursosPorPrecio(int precioMaximo, int precioMinimo) {
		return cursos.stream().filter(curso -> curso.getPrecio() > precioMinimo && curso.getPrecio() < precioMaximo)
				.toList();
	}

}
