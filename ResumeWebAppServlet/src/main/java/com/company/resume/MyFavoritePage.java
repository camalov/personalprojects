/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.company.resume;

import com.company.dao.inter.UserDaoInter;
import com.company.entity.Country;
import com.company.entity.User;
import com.company.main.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "MyFavoritePage", urlPatterns = {"/MyFavoritePage"})
public class MyFavoritePage extends HttpServlet {
    
    UserDaoInter userDao = Context.instanceUserDao();
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        List<User> userList = userDao.getAll();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello World!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 style=\"color:red\">Servlet Page!</h1>");
        out.println("</body>");
        
        for (User u : userList) {
            out.println(u + "<br>");
        }
        
        out.println("</html>");
    }
    
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
    
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String name = req.getParameter("name");
            String surname = req.getParameter("surname");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            String profileDesc = req.getParameter("profile_description");
            String adress = req.getParameter("adress");
            long time = sdf.parse(req.getParameter("birthdate")).getTime();
            Date birthdate = new Date(time);
            int birthplaceId = new Integer(req.getParameter("birthplace_id"));
            int nationalityId = new Integer(req.getParameter("nationality_id"));
            Country nationality = new Country(nationalityId, null, null);
            Country birthplace = new Country(birthplaceId, null, null);
            
            User u = new User(0, name, surname, email, phone, profileDesc, adress, birthdate, nationality, birthplace);;
            
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Successful</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 style=\"color:green\">I got post request</h1>");
            
            out.println(userDao.addUser(u) + "\n" + u);
            
            out.println("</body>");
            
            
            
            out.println("</html>");
        } catch (ParseException ex) {
            Logger.getLogger(MyFavoritePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
