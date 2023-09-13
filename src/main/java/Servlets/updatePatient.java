/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import bloodbank.dao.Patients_DAO;
import bloodbank.entites.Patients;
import bloodbank.entites.Staff;
import bloodbank.main_dao.HibernateSessionCon;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ahmed
 */
public class updatePatient extends HttpServlet {

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
            String patient_first_name = request.getParameter("patient_first_name");
            String patient_last_name = request.getParameter("patient_last_name");
            String Gender = request.getParameter("gender");
            String Address = request.getParameter("address");
            String Blood_Type = request.getParameter("blood_type");
            String Nat_id = request.getParameter("nat_id");
            String Date_of_birth = request.getParameter("date_of_birth");
            Date dateOfBirth = new SimpleDateFormat("yyyy/MM/dd").parse(Date_of_birth);
            String Primary_Number = request.getParameter("Primary_Number");
            String Secondary_Number = request.getParameter("secondary_number");
            Integer doctor_id = Integer.valueOf(request.getParameter("doctor_id")) ;
            Patients_DAO pDao = new Patients_DAO();

            List<Patients> Patients_List = pDao.GetPatientByNatId(Nat_id);
            
            if(Patients_List.isEmpty()){
                throw new Exception();
            }
            Patients p = Patients_List.get(0); 

            Staff staff = con.getSession().get(Staff.class,doctor_id);
            p.setFirstName(patient_first_name);
            p.setGender(Gender);
            p.setAddress(Address);
            p.setBloodType(Blood_Type);
            p.setDateOfBirth(dateOfBirth);
            p.setPrimaryNumber(Primary_Number);
            p.setSecondaryNumber(Secondary_Number);
            p.setLastName(patient_last_name);
            p.setStaff(staff);
            

            con.openCon();
            con.beginTrans();
            pDao.update(p);
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
