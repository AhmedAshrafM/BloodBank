/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import bloodbank.dao.BloodStock_DAO;
import bloodbank.entites.BloodStock;
import bloodbank.entites.Staff;
import bloodbank.main_dao.HibernateSessionCon;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;  
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ahmed
 */
public class addBag extends HttpServlet {

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
        HibernateSessionCon con = new HibernateSessionCon();

        try{
            //Integer bag_id = Integer.valueOf(request.getParameter("bag_id"));
            String Blood_Type = request.getParameter("blood_type");
            String Donation_Date = request.getParameter("donation_date");
            Date donationDate = new SimpleDateFormat("yyyy/MM/dd").parse(Donation_Date);                      
            Integer doctor_id = Integer.valueOf(request.getParameter("doctor_id")) ;
            BloodStock bs = new BloodStock();
            Staff staff = con.getSession().get(Staff.class,doctor_id);
            //bs.setBagId(bag_id);
            bs.setBloodType(Blood_Type);
            bs.setDonationDate(donationDate);
            bs.setStaff(staff);
            
            BloodStock_DAO bsDao = new BloodStock_DAO();

            con.openCon();
            con.beginTrans();
            bsDao.insert(bs);
            con.commitTrans();
            
            response.getWriter().write("Done");
            
        }catch(Exception e){
            e.printStackTrace();
            con.rollBack();
            response.getWriter().write("NotDone");
            System.out.println("Error ....................");
        }
        con.clearCon();
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
