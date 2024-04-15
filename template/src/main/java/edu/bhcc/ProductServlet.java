package edu.bhcc;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/****************************
 *  @Author : Matthew Dobler"
 *  @Date    : 4/12/24"
 *  @File   : ProductServlet"
 *  @Class   : CSC-"
 *****************************/
public class ProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        // Create the Model
        Map<String, Object> root = new HashMap<String, Object>();
        root.put("product1", new Product("Potato", 2.50, "It's a potato"));

        // Get the FreeMarker Template Engine
        FreeMarkerUtil setup = FreeMarkerUtil.getInstance();
        Configuration cfg = setup.getFreeMarkerConfiguration();
        Template template = cfg.getTemplate("hello.html");

        //  Merge the Model with the Template
        PrintWriter writer = response.getWriter();
        try {
            template.process(root, writer);
        } catch (TemplateException e) {
            writer.println("Could not process template:  " + e.getMessage());
        }
    }
}
