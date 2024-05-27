package com.vsu.cs.maslova_e_i.servlet;

import com.vsu.cs.maslova_e_i.entity.Department;
import com.vsu.cs.maslova_e_i.service.DepartmentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.IOException;

@WebServlet("/departments")
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentServlet extends HttpServlet {
    private DepartmentService departmentService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            listDepartments(req, resp);
        } else {
            switch (action) {
                case "new":
                    showNewForm(req, resp);
                    break;
                case "edit":
                    showEditForm(req, resp);
                    break;
                case "delete":
                    deleteDepartment(req, resp);
                    break;
                case "viewPatients":
                    viewPatients(req, resp);
                    break;
                default:
                    listDepartments(req, resp);
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String action = req.getParameter("action");
        if ("create".equals(action)) {
            createDepartment(req, resp);
        } else if ("update".equals(action)) {
            updateDepartment(req, resp);
        }
    }

    private void listDepartments(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("departments", departmentService.getAllDepartments());
        req.getRequestDispatcher("/departmentList.jsp").forward(req, resp);
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/departmentForm.jsp").forward(req, resp);
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Department existingDepartment = departmentService.findById(id);
        req.setAttribute("department", existingDepartment);
        req.getRequestDispatcher("/departmentForm.jsp").forward(req, resp);
    }

    private void createDepartment(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Department department = Department.builder()
                .name(req.getParameter("name"))
                .build();
        departmentService.create(department);

        resp.sendRedirect("departments");
    }

    private void updateDepartment(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        Department department = Department.builder()
                .id(id)
                .name(name)
                .build();
        departmentService.update(department);
        resp.sendRedirect("departments");
    }

    private void deleteDepartment(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        departmentService.delete(id);
        resp.sendRedirect("departments");
    }

    private void viewPatients(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int departmentId = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("patients", departmentService.getPatientsByDepartmentId(departmentId));
        req.getRequestDispatcher("/patientList.jsp").forward(req, resp);
    }
}
