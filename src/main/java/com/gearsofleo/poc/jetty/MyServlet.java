package com.gearsofleo.poc.jetty;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(asyncSupported = false, name = "MyServlet", urlPatterns = {"/hello"}, loadOnStartup = 1,
initParams = {
		@WebInitParam(name="webInitParam1", value="Hello"), 
		@WebInitParam(name="webInitParam2", value="World")
		}
		)
public class MyServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	String jvmArgs = String.join(",", JVMArguments.getJVMArguments());
    	
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html><head><title>MyServlet</title></head><body>");
            out.write(jvmArgs);
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
 
    @Override
    public String getServletInfo() {
        return "Servlet info";
    }
}