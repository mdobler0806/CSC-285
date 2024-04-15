package edu.bhcc;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author MatthewDobler
 * This servlet handles arithmetic operations.
 * It receives two numbers and an operation type (add, subtract, multiply, divide) from a POST
 * request and computes the result. It then displays the result as well as a link back to the
 * original CalculatorServlet page.
 */
public class CalculatorResultServlet extends HttpServlet {

    /**
     * Handles the POST request by extracting the parameters and performing the specified
     * operation, then displays it in HTML format.
     * @param request Object that contains the request the client made to the servlet.
     * @param response Object that contains the response from the servlet to the client.
     * @throws IOException If an input or output exception occurs.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        double number1 = Double.parseDouble(request.getParameter("number1"));
        double number2 = Double.parseDouble(request.getParameter("number2"));
        String operation = request.getParameter("operation");

        double result = 0;

        switch (operation) {
            case "add":
                result = number1 + number2;
                break;
            case "subtract":
                result = number1 - number2;
                break;
            case "multiply":
                result = number1 * number2;
                break;
            case "divide":
                if (number2 == 0) {
                    response.getWriter().println("Cannot divide by zero.");
                    return;
                }
                result = number1 / number2;
                break;
        }
        PrintWriter serverWriter = response.getWriter();
        serverWriter.println("<html>");
        serverWriter.println("<body>");
        serverWriter.println("<h1>Result:" + result);
        serverWriter.println("<p>");
        serverWriter.println("<a href='http://localhost:8080/calculator'> Return to Calculator </a>");
        serverWriter.println("</body>");
        serverWriter.println("</html>");
    }
}
