package br.com.fiap.resources;

import br.com.fiap.beans.Scenario;
import br.com.fiap.bo.ScenarioBO;
import br.com.fiap.exceptions.ConnectionException;
import br.com.fiap.exceptions.ScenarioNotFoundException;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/scenarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ScenarioResource {

    private final ScenarioBO scenarioBO = new ScenarioBO();

    @GET
    public Response getScenarios() throws SQLException, ConnectionException {
        ArrayList<Scenario> scenarios = scenarioBO.getAll();
        return Response.ok(scenarios).build();
    }

    @GET
    @Path("/{id}")
    public Response getScenarioById(@PathParam("id") int id) throws
            ScenarioNotFoundException, SQLException, ConnectionException {

        Scenario scenario = scenarioBO.getById(id);
        if (scenario == null) throw new ScenarioNotFoundException();
        return Response.ok(scenario).build();
    }

}
