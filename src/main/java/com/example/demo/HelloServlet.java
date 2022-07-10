package com.example.demo;

import com.example.beans.NhanVien;
import com.example.models.NhanVienModel;
import com.example.utils.ServletUtils;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "Nhanvien", value = "/Nhanvien/*")
public class HelloServlet extends HttpServlet {
    private String message;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = request.getPathInfo();
        switch (path) {
            case "/list":
                List<NhanVien> list = NhanVienModel.HienThiDsachNhanVien();
                request.setAttribute("listNV", list);
                ServletUtils.forward("/index.jsp", request, response);
                break;
            case "/deleteNV":
                int id = Integer.parseInt(request.getParameter("id"));
                NhanVienModel.deleteNhanVien(id);
                String  url1 = "/Nhanvien/list";
                ServletUtils.redirect(url1, request, response);
                break;
            case "/addNV":
                ServletUtils.forward("/addNV.jsp", request, response);
                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        switch (path) {
            case "/list":
                updateNV(request,response);
                break;
            case "/addNV":
                String name = request.getParameter("name");
                Integer age = Integer.parseInt(request.getParameter("age"));
                Integer salary = Integer.parseInt(request.getParameter("salary"));
                NhanVien c = new NhanVien(name,age,salary,1);
                NhanVienModel.addNhanVien(c);
                String  urlproduct = "/Nhanvien/list";
                ServletUtils.redirect(urlproduct, request, response);
                break;

        }
    }
    private void updateNV(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{

        int id = Integer.parseInt(request.getParameter("id")) ;
        String name = request.getParameter("name");
        Integer age = Integer.parseInt(request.getParameter("age"));
        Integer salary = Integer.parseInt(request.getParameter("salary"));
        NhanVien c = new NhanVien(id,name,age,salary,1);
        NhanVienModel.updateNhanVien(c);
        String  urlproduct = "/Nhanvien/list";
        ServletUtils.redirect(urlproduct, request, response);
    }
}
