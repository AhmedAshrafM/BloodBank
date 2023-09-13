/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import bloodbank.dao.Staff_DAO;
import bloodbank.entites.Staff;
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
import jsonFiles.staff_json;

/**
 *
 * @author Ahmed
 */
public class getStaff extends HttpServlet {

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
            Staff_DAO Staff_DAO = new Staff_DAO();
            List<Staff> Staff_List = Staff_DAO.GetAllStaff();
            //Staff_json[] array = new Staff_json[Staff_List.size()];
            List<staff_json> array = new ArrayList<>();
            for (Staff s : Staff_List) {
                staff_json record = new staff_json();
                record.setEmpId(s.getEmpId());
                record.setStaffFirstName(s.getFirstName());
                record.setStaffLastName(s.getLastName());
                record.setGender(s.getGender());
                record.setAddress(s.getAddress());
                record.setBloodType(s.getBloodType());
                record.setNatId(s.getNatId());
                record.setDateOfBirth(s.getDateOfBirth());
                record.setPrimaryNumber(s.getPrimaryNumber());
                record.setSecondaryNumber(s.getSecondaryNumber());
                record.setSalary(s.getSalary());
                record.setJobId("" + s.getEmpJobs().getJobId());

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
