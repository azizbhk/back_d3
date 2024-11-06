package com.aziz.voyages.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomvoy", types = { voyage.class })
public interface voyageprojection {
	public String getNomProduit();
}