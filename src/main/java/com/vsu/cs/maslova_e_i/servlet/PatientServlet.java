//package com.vsu.cs.maslova_e_i.servlet;
//
//import com.vsu.cs.maslova_e_i.entity.Patient;
//import com.vsu.cs.maslova_e_i.service.PatientService;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//
//import java.io.IOException;
//
//@WebServlet("/patients")
//@RequiredArgsConstructor
//public class PatientServlet extends HttpServlet {
//    private final PatientService patientService;
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String action = req.getParameter("action");
//        if (action == null) {
//            listPatients(req, resp);
//        } else {
//            switch (action) {
//                case "new":
//                    showNewForm(req, resp);
//                    break;
//                case "edit":
//                    showEditForm(req, resp);
//                    break;
//                case "delete":
//                    deletePatient(req, resp);
//                    break;
//                default:
//                    listPatients(req, resp);
//                    break;
//            }
//        }
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        String action = req.getParameter("action");
//        if ("create".equals(action)) {
//            createPatient(req, resp);
//        } else if ("update".equals(action)) {
//            updatePatient(req, resp);
//        }
//    }
//
//    private void listPatients(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("patients", patientService.getAllPatients());
//        req.getRequestDispatcher("/patientList.jsp").forward(req, resp);
//    }
//
//    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("/patientForm.jsp").forward(req, resp);
//    }
//
//    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int id = Integer.parseInt(req.getParameter("id"));
//        Patient existingPatient = patientService.findById(id);
//        req.setAttribute("patient", existingPatient);
//        req.getRequestDispatcher("/patientForm.jsp").forward(req, resp);
//    }
//
//    private void createPatient(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        String fullName = req.getParameter("full_name");
//        int age = Integer.parseInt(req.getParameter("age"));
//        String gender = req.getParameter("gender");
//        int departmentId = Integer.parseInt(req.getParameter("department_id"));
//        Patient patient = Patient.builder()
//                .fullName(fullName)
//                .age(age)
//                .gender(gender)
//                .departmentId(departmentId)
//                .build();
//        patientService.create(patient);
//
//        resp.sendRedirect("patients");
//    }
//
//    private void updatePatient(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        int id = Integer.parseInt(req.getParameter("id"));
//        String fullName = req.getParameter("full_name");
//        int age = Integer.parseInt(req.getParameter("age"));
//        String gender = req.getParameter("gender");
//        int departmentId = Integer.parseInt(req.getParameter("department_id"));
//        Patient patient = Patient.builder()
//                .id(id)
//                .fullName(fullName)
//                .age(age)
//                .gender(gender)
//                .departmentId(departmentId)
//                .build();
//        patientService.update(patient);
//        resp.sendRedirect("patients");
//    }
//
//    private void deletePatient(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        int id = Integer.parseInt(req.getParameter("id"));
//        patientService.delete(id);
//        resp.sendRedirect("patients");
//    }
//}
