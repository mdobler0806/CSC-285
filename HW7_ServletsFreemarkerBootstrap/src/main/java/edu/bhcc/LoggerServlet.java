package edu.bhcc;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.*;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * A Servlet that handles logging requests. Mixes GET and POST requests,
 * where GET requests load the empty page with no logs and POST requests add new log entries.
 */
public class LoggerServlet extends HttpServlet {
    private ArrayList<String> logs;
    private ArrayList<String> times;
    private Map<String, Object> dataModel;
    private Template template;

    /**
     * Handles get requests by loading the default page with no logs added.
     *
     * @param request  the HttpServletRequest object representing the request
     * @param response the HttpServletResponse object representing the response
     * @throws IOException if an I/O error occurs while processing the request
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException
    {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        // Create the Data Model
        dataModel = new HashMap<String, Object>();

        //Set up objects to put in the data model root.
        logs = new ArrayList<String>();
        times = new ArrayList<String>();
        String imagePath = "/images/giphy.gif";
        dataModel.put("logs", logs);
        dataModel.put("times", times);
        dataModel.put("imagePath",imagePath);


        // Get the FreeMarker Template Engine
        FreeMarkerUtil setup = FreeMarkerUtil.getInstance();
        Configuration cfg = setup.getFreeMarkerConfiguration();
        template = cfg.getTemplate("logger.ftl");

        //  Merge the Model with the Template
        PrintWriter writer = response.getWriter();
        try
        {
            template.process(dataModel, writer);
        } catch (TemplateException e)
        {
            writer.println("Could not process template:  " + e.getMessage());
        }
    }

    /**
     * Handles a POST request by adding a new log entry and merging the model with the template.
     *
     * @param request  the HttpServletRequest object representing the request
     * @param response the HttpServletResponse object representing the response
     * @throws IOException if an I/O error occurs while processing the request
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        String logToBeAdded = request.getParameter("log");
        logs.add(logToBeAdded);

        String timeToBeAdded = LocalTime.now().toString().substring(0, 8);
        times.add(timeToBeAdded);


        //  Merge the Model with the Template
        PrintWriter writer = response.getWriter();
        try
        {
            template.process(dataModel, writer);
        } catch (TemplateException e)
        {
            writer.println("Could not process template:  " + e.getMessage());
        }

    }
}
