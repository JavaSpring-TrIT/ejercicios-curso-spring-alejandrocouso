package com.curso.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.curso.model.Curso;
import com.curso.model.Formacion;

@Service
public class FormacionServiceImpl implements FormacionService {
	@Autowired
	RestClient restClient;

	private String url = "http://localhost:8080/";

	@Override
	public List<Formacion> obtenerFormaciones() {
		List<Formacion> formaciones = new ArrayList<>();
		
		//Obtenemos los cursos
		Curso[] cursos = getCursos(url + "cursos");

		//Convertimos los cursos a nuestra clase formacion con las transformaciones adecuadas
		for (Curso curso : cursos) {
			Formacion formacion = new Formacion();
			formacion.setCurso(curso.getNombre());
			if (curso.getDuracion() >= 50) {
				formacion.setAsignaturas(10);
			} else {
				formacion.setAsignaturas(5);
			}
			formacion.setPrecio(curso.getPrecio());
			formaciones.add(formacion);
		}
		return formaciones;
	}

	private Curso[] getCursos(String url) {
		return restClient.get().uri(url).retrieve().body(Curso[].class);
	}

	@Override
	public List<Formacion> altaFormacion(Formacion formacion) {
		//Creamos la clase intermedia de intercambio de informacion
		Curso curso = new Curso();
		curso.setNombre(formacion.getCurso());
		curso.setDuracion(formacion.getAsignaturas() * 10);
		String codCurso= formacion.getCurso().substring(0, 3) + curso.getDuracion();
		curso.setCodCurso(codCurso);
		curso.setPrecio(formacion.getPrecio());
		
		
		// Comprobamos si la formacion existe
		Curso cursoBuscado = getCurso(url + "curso/"+ codCurso );
		
		// Si no existe, creamos la formacion/curso		
		if (cursoBuscado == null) {
			postFormacion(url + "curso", curso);	
		}
		
		//Devolvemos todas las formaciones
		return obtenerFormaciones();
	}

	private Curso getCurso(String url) {
		return restClient.get().uri(url).retrieve().body(Curso.class);
	}

	private void postFormacion(String url, Curso curso) {
		restClient.post().uri(url).accept(MediaType.APPLICATION_JSON).body(curso).retrieve().toBodilessEntity();
	}

}
