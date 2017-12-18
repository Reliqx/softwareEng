package sheridan.banking.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author reliq
 */
public class BankServlet extends HttpServlet {

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
            throws ServletException, IOException, InstantiationException, SQLException, ClassNotFoundException {
        String action = request.getServletPath();
        String jspPath = "/WEB-INF/jsp/";
        String showNext = null;

        switch (action) {
            case "/login.do": {
                showNext = CustomerController.login(request);
                CustomerController.loadAccount(request);
                break;

            }
            case "/customize.do":{
                showNext = CustomerController.accountSettings(request);
                break;
            }
            case "/edit.do": {
                showNext = CustomerController.edit(request);

                break;

            }
            case "/home.do": {
                showNext = CustomerController.mainMenu(request);
                break;
            }
            case "/adminHome.do": {
                showNext = CustomerController.adminMenu(request);
                break;
            }
            case "/createAccount.do": {
                showNext = CustomerController.createAccount(request);
                break;
            }
            case "/viewAccounts.do": {
                showNext = CustomerController.viewAccounts(request);
                break;
            }
            case "/deleteAccount.do": {
                showNext = CustomerController.remove(request);
                break;
            }
            case "/viewSummary.do": {
                showNext = CustomerController.viewSummary(request);
                break;
            }

            case "/viewBalance.do": {

                showNext = CustomerController.viewBalance(request);
                break;
            }
            case "/viewTransac.do": {
                showNext = CustomerController.viewTransactions(request);
                break;
            }
            case "/viewTransfer.do": {
                showNext = CustomerController.viewTransfer(request);
                break;
            }
            case "/confirmTransfer.do": {
                showNext = CustomerController.confirmTransfer(request);
                break;
            }
            case "/makeTransfer.do": {
                showNext = CustomerController.makeTransfer(request);
                break;
            }
            case "/viewBills.do": {
                showNext = CustomerController.viewBills(request);
                break;
            }
            case "/payBill.do": {
                showNext = CustomerController.confirmPayBill(request);
                break;
            }
            case "/billPaid.do": {
                showNext = CustomerController.billPaid(request);
                break;
            }
        }

        //String greeting = getInitParameter("greeting");
        //request.setAttribute("greeting", greeting);
        if (showNext.startsWith("redirect:")) {
            response.sendRedirect(response.encodeRedirectURL(showNext.substring(9)));
        } else {
            request.getRequestDispatcher(jspPath + showNext + ".jsp")
                    .forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (InstantiationException ex) {
            Logger.getLogger(BankServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BankServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BankServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (InstantiationException ex) {
            Logger.getLogger(BankServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BankServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BankServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
