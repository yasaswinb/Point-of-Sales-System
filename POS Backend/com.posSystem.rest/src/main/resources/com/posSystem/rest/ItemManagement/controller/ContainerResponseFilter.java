package com.posSystem.rest.ItemManagement.controller;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;

public interface ContainerResponseFilter {
	public void filter(ContainerRequestContext request, ContainerResponseContext response) throws IOException;
	public void filter(ContainerRequestContext request) throws IOException;
}
