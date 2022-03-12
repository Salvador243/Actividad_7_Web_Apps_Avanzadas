/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package calculos;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author salva
 */
public class resultados extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if (request.getAttribute("flag") != null) {
                request.setAttribute("flag", 1);
                
                Cookie area = new Cookie("area", null);
                Cookie perimetro = new Cookie("perimetro", null);
                Cookie base1 = new Cookie("base", null);
                Cookie altura1 = new Cookie("altura", null);

                response.addCookie(area);
                response.addCookie(perimetro);
                response.addCookie(base1);
                response.addCookie(altura1);
                
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                String n1 = request.getParameter("b");
                String n2 = request.getParameter("h");

                Datos d = new Datos(n1, n2);
                d.darArea();
                d.darPerimetro();

                double area_ = d.getArea();
                double perimetro_ = d.getPerimetro();

                Cookie area = new Cookie("area", String.valueOf(area_));
                Cookie perimetro = new Cookie("perimetro", String.valueOf(perimetro_));
                Cookie base1 = new Cookie("base", n1);
                Cookie altura1 = new Cookie("altura", n2);

                response.addCookie(area);
                response.addCookie(perimetro);
                response.addCookie(base1);
                response.addCookie(altura1);

                response.sendRedirect(request.getContextPath() + "/index.jsp");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
