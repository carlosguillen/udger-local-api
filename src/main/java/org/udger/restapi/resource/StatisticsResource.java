/*
  UdgerParser - Java agent string parser based on Udger https://udger.com/products/local_parser

  author     The Udger.com Team (info@udger.com)
  copyright  Copyright (c) Udger s.r.o.
  license    GNU Lesser General Public License
  link       https://udger.com/products
*/
package org.udger.restapi.resource;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.udger.restapi.service.ParserStatistics;

/**
 * The Class StatisticsResource.
 */
@Path("statistic")
public class StatisticsResource {

    @Inject
    private ParserStatistics statistics;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStatistic() {
        JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();

        jsonBuilder.add("requests_ua", statistics.getRequestsUA())
            .add("requests_ip", statistics.getRequestsIP())
            .add("nanos_ua", statistics.getNanosRequestUA())
            .add("nanos_ip", statistics.getNanosRequestIP());

        return Response.ok(jsonBuilder.build().toString()).build();
    }
}
