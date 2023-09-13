/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import bloodbank.dao.BloodStock_DAO;
import bloodbank.entites.BloodStock;
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
import jsonFiles.bag_json;

/**
 *
 * @author Ahmed
 */
public class getAvaliableBags extends HttpServlet {

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
            BloodStock_DAO BloodStock_dao = new BloodStock_DAO();
            List<BloodStock> BloodStock_List = BloodStock_dao.GetAvaliableBags();
            //donor_json[] array = new donor_json[Donors_List.size()];
            List<bag_json> array = new ArrayList<>();
            for (BloodStock bs : BloodStock_List) {
                bag_json record = new bag_json();
                record.setBagId("" + bs.getBagId());
                record.setBloodType(bs.getBloodType());
                record.setDonationDate(bs.getDonationDate());
                record.setDoctorId("" + bs.getStaff().getEmpId());
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
