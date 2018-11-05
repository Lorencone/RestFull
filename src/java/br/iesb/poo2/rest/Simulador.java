package br.iesb.poo2.rest;

import java.text.*;
import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("financeiro")
public class Simulador {

    @Context
    private UriInfo context;

    public Simulador() {
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
    // TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    public String calculaEmprestimo(@FormParam("parcelas") int parcelas, @FormParam("valor") double valor) {
        double total = ((valor * 0.10) * parcelas) + valor;
        double vlrParcelas = total / parcelas;
        double juros = total - valor;
        Locale localeBR = new Locale("pt","BR");
        NumberFormat dinheiro = NumberFormat.getCurrencyInstance(localeBR);
        String texto = "Seu empréstimo de <strong> " + dinheiro.format(valor) +"</strong>,<br>parcelado em <strong>" + parcelas + " parcelas de " + dinheiro.format(vlrParcelas) + "</strong>,<br>custará <strong> " + dinheiro.format(total) + "</strong>.<br><br>(valor total de juros: <strong>" + dinheiro.format(juros) + "</strong>).";
        return texto;
    }
    
}
