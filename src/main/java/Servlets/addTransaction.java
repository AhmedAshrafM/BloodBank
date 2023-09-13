/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import bloodbank.dao.BloodTransactions_DAO;
import bloodbank.entites.BloodStock;
import bloodbank.entites.BloodTransactions;
import bloodbank.entites.Donors;
import bloodbank.entites.Patients;
import bloodbank.entites.Staff;
import bloodbank.main_dao.HibernateSessionCon;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ahmed
 */
public class addTransaction extends HttpServlet {

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
             if(request.getParameter("donor_id") == null){
            Integer patient_id = Integer.valueOf(request.getParameter("patient_id")) ;
            Integer doctor_id = Integer.valueOf(request.getParameter("doctor_id")) ;                 
            Integer bag_id = Integer.valueOf(request.getParameter("bag_id")) ;
            Date transaction_date = new Date(System.currentTimeMillis());
            BloodTransactions bt = new BloodTransactions();
            Staff staff = con.getSession().get(Staff.class,doctor_id);           
            Patients patients = con.getSession().get(Patients.class, patient_id);
            BloodStock bloodStock = con.getSession().get(BloodStock.class, bag_id);
            bt.setPatients(patients);
            bt.setStaff(staff);
            bt.setTransactionDate(transaction_date);
            bt.setBloodStock(bloodStock);
            
            BloodTransactions_DAO btDao = new BloodTransactions_DAO();
            
            con.openCon();
            con.beginTrans();
            btDao.insert(bt);
            con.commitTrans();
            
            response.getWriter().write("Done");
            }else{
            Integer donor_id = Integer.valueOf(request.getParameter("donor_id")) ;
            Integer doctor_id = Integer.valueOf(request.getParameter("doctor_id")) ;                 
            Integer bag_id = Integer.valueOf(request.getParameter("bag_id")) ;
            //String transactiondate = request.getParameter("transaction_date");

            Date transaction_date = new Date(System.currentTimeMillis());
            BloodTransactions bt = new BloodTransactions();
            Staff staff = con.getSession().get(Staff.class,doctor_id);    
            BloodStock bloodStock = con.getSession().get(BloodStock.class, bag_id);
           Donors donors = con.getSession().get(Donors.class, donor_id);
            bt.setDonors(donors);
            //bt.setTransactionId(transaction_id);
            bt.setStaff(staff);
            bt.setTransactionDate(transaction_date);
            bt.setBloodStock(bloodStock);
            
            BloodTransactions_DAO btDao = new BloodTransactions_DAO();

            con.openCon();
            con.beginTrans();
            btDao.insert(bt);
            con.commitTrans();
            
            response.getWriter().write("Done");
            }
            
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
