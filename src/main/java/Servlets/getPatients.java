/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import bloodbank.dao.Patients_DAO;
import bloodbank.entites.Patients;
import bloodbank.main_dao.HibernateSessionCon;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jsonFiles.patient_json;

/**
 *
 * @author Ahmed
 */
public class getPatients extends HttpServlet {

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

        try {
            Patients_DAO Patients_dao = new Patients_DAO();
            List<Patients> Patients_List = Patients_dao.GetAllPatients();
            //Patient_json[] array = new Patient_json[Patients_List.size()];
            List<patient_json> array = new ArrayList<>();
            for (Patients d : Patients_List) {
                patient_json record = new patient_json();
                record.setPatientId(d.getPatientId());
                record.setPatientFirstName(d.getFirstName());
                record.setPatientLastName(d.getLastName());
                record.setGender(d.getGender());
                record.setAddress(d.getAddress());
                record.setBloodType(d.getBloodType());
                record.setNatId(d.getNatId());
                record.setDateOfBirth(d.getDateOfBirth());
                record.setPrimaryNumber(d.getPrimaryNumber());
                record.setSecondaryNumber(d.getSecondaryNumber());
                record.setDoctorId("" + d.getStaff().getEmpId());

                array.add(record);
            }

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(array);
            // success
            response.getWriter().write(json);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error.....!");
            response.getWriter().write("Error");
        } finally {
            con.clearCon();
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
