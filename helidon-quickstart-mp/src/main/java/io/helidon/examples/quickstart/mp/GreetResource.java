package io.helidon.examples.quickstart.mp;

import io.helidon.examples.quickstart.fn.FnCaller;
import java.io.IOException;
import java.util.Collections;
import javax.enterprise.context.RequestScoped;
import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/greet")
@RequestScoped
public class GreetResource {

    private static final JsonBuilderFactory JSON = Json.createBuilderFactory(Collections.emptyMap());

    /*
     * input: [json] some long json that Google Home sends 
     * action: triggers the Flow
     * function output: [json] response that Google Home expects
     */
    @Path("/home_endpoint")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject homeEndpointGet(JsonObject j) throws IOException {
        FnCaller fn = new FnCaller();

        String input = "cats";

        System.out.println("Input from Google Home --> " + j);

        if ((j.getJsonObject("queryResult") != null)
                && (j.getJsonObject("queryResult").getJsonObject("parameters") != null)
                && (j.getJsonObject("queryResult").getJsonObject("parameters").getJsonString("searchPhrase") != null)) {
            input = j.getJsonObject("queryResult").getJsonObject("parameters").getJsonString("searchPhrase").toString();
        }

        System.out.println("Input is --> " + input);

        try {
            fn.callFn("giphyfn/flow", input);
        } catch (IOException exception) {
            throw exception;
        }

        return JSON.createObjectBuilder().add("fulfillmentText", "Flow function search for " + input + " was triggered by Helidawn.").build();
    }

}
