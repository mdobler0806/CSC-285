package edu.bhcc;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author MatthewDobler
 * Servlet that displays an HTML form for inputting two numbers and selecting a specific
 * arithmetic operation. The form then posts the data to another servlet which performs
 * the actual operation.
 */
public class CalculatorServlet extends HttpServlet {

    /**
     * Responds to GET request by showing an HTML form where users
     * can input two numbers and choose an arithmetic operation. The form submit sends a POST
     * request to CalculatorResultServlet.
     * @param request Object that contains the request the client made to the servlet.
     * @param response Object that contains the response from the servlet to the client.
     * @throws IOException If an input or output exception occurs.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        PrintWriter serverWriter = response.getWriter();
        serverWriter.println("<html>");
        serverWriter.println("<body>");
        serverWriter.println("<h1>Welcome to the Calculator</h1>");
        serverWriter.println("<form ACTION='CalculatorResult' method='POST'>");
        serverWriter.println("<h2>Number #1</h2>");
        serverWriter.println("<input type='text' name='number1'>");
        serverWriter.println("<h2>Number #2</h2>");
        serverWriter.println("<input type='text' name='number2'>");
        serverWriter.println("<h2>Operation</h2>");
        serverWriter.println("<select name='operation'>");
        serverWriter.println("<option value='add'>Add</option>");
        serverWriter.println("<option value='subtract'>Subtract</option>");
        serverWriter.println("<option value='multiply'>Multiply</option>");
        serverWriter.println("<option value='divide'>Divide</option>");
        serverWriter.println("</select>");
        serverWriter.println("<input type='submit' value='Calculate'>");
        serverWriter.println("</body>");
        serverWriter.println("</html>");

    }
}
