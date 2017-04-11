/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Model.Connect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author phuoc
 */
public class SearchServlet extends HttpServlet {

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
            PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            Connect cn=new Connect();
            String action =request.getParameter("submit");
            
            if(action.equals("Search")){
                    String tenthuebao=request.getParameter("txtHoten");
                 if(tenthuebao!=null && tenthuebao.length() !=0){
                     //viết câu lệnh truy vấn theo dữ liệu từ form đưa vào
                       String sql="select * from DanhBa where TenTheubao like '%"+tenthuebao+"%'";
                     //kết nối dữ liệu
                       cn.connectCSDL();
                       //thực hiện câu lệnh truy vấn
                       cn.TruyVan(sql);
                       //Chuyển dữ liệu vừa load được từ CSDL sang showTraCuu.jsp
                       request.setAttribute("tenthuebao", cn.list);
                       //Load trang showTraCuu.jsp
                       RequestDispatcher Dispatcher=request.getRequestDispatcher("showTraCuu.jsp");
                       Dispatcher.forward(request, response);

                     }
                 else{
                  out.write("Dữ Liệu Tra Cứu Chưa Được Nhập");
                 
                 }
            }else if(action.equals("Insert")){
            
                String ten=request.getParameter("txtHoten");
                String sdt=request.getParameter("txtSdt");
                String diachi=request.getParameter("txtDiachi");
                if(ten.equals("") && sdt.equals("") && diachi.equals("")){
                
                out.write("Dữ Liệu Chưa Được Nhập");
                }else{
                    try {
                    cn.Insert(ten, sdt, diachi);
                    out.write("them thanh cong");
                    }
                
                catch (SQLException ex) {
                    out.write("Thêm Thất bại");
                    
                    }
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
