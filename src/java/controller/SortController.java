/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nguye
 */
public class SortController extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            String url = "";
            switch (request.getParameter("pageManage")) {
                case "pageClient":
                    if (request.getParameter("sortChoose") == null) {
                        request.setAttribute("pageValue", null);
                    } else if (request.getParameter("sortChoose").equalsIgnoreCase("sortByName")) {
                        request.setAttribute("pageValue", "sortByName");
                    } else {
                        request.setAttribute("pageValue", "sortByStatus");
                    }
                    url = "view/employee/admin/manageClient.jsp";
                    break;
                case "pagePayment":
                    if (request.getParameter("sortChoose") == null) {
                        request.setAttribute("pageValue", null);
                    } else if (request.getParameter("sortChoose").equalsIgnoreCase("sortByForm")) {
                        request.setAttribute("pageValue", "sortByForm");
                    } else {
                        request.setAttribute("pageValue", "sortByStatus");
                    }
                    url = "view/employee/admin/managePayment.jsp";
                    break;
                case "pageTechnician":
                    if (request.getParameter("sortChoose") == null) {
                        request.setAttribute("pageValue", null);
                    } else if (request.getParameter("sortChoose").equalsIgnoreCase("sortByNameEmp")) {
                        request.setAttribute("pageValue", "sortByNameEmp");
                    } else {
                        request.setAttribute("pageValue", "sortByStatusEmp");
                    }
                    url = "view/employee/admin/manageTechnician.jsp";
                    break;
            }
            request.getRequestDispatcher(url).forward(request, response);
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
