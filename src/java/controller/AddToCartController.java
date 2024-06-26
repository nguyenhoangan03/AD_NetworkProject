/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ServiceDAO;
import dto.Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nguye
 */
public class AddToCartController extends HttpServlet {

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
            ServiceDAO serDao = new ServiceDAO();
            Service service = serDao.getService(Integer.parseInt(request.getParameter("service")));
            Map<String, Integer> cart = new HashMap<>();
            if (request.getSession(false).getAttribute("cart") == null) {
                cart.put(service.getServiceName(), 1);
                request.getSession(false).setAttribute("cart", cart);
            } else {
                cart = (Map<String, Integer>) request.getSession(false).getAttribute("cart");
                if (cart.containsKey(service.getServiceName())) {
                    if (cart.get(service.getServiceName()) <= 3) {
                        cart.put(service.getServiceName(), cart.get(service.getServiceName()) + 1);
                    }
                } else {
                    cart.put(service.getServiceName(), 1);
                }
            }
            request.getSession(false).setAttribute("cart", cart);
            switch (request.getParameter("pageAction")) {
                case "internet":
                    response.sendRedirect("/AD_Network/MainController?view=viewInternetService");
                    break;
                case "cloud":
                    response.sendRedirect("/AD_Network/MainController?view=viewCloudService");
                    break;
                case "television":
                    response.sendRedirect("/AD_Network/MainController?view=viewTelevisionService");
                    break;
                case "camera":
                    response.sendRedirect("/AD_Network/MainController?view=viewCameraService");
                    break;
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
