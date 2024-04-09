package com.curso.service;

import java.util.List;

import com.curso.model.Formacion;

public interface FormacionService {
	List<Formacion> obtenerFormaciones();

	List<Formacion> altaFormacion(Formacion formacion);
}
