package com.vsu.cs.maslova_e_i.servlet;

import com.vsu.cs.maslova_e_i.service.DepartmentService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import lombok.RequiredArgsConstructor;

//TODO
@WebServlet("/department")
@RequiredArgsConstructor
public class DepartmentServlet extends HttpServlet {
    private final DepartmentService departmentService;

}
