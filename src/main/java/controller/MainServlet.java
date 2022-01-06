package controller;

import model.Category;
import model.SanPham;
import service.CategoryService;
import service.SPService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MainServlet", urlPatterns = "/home")
public class MainServlet extends HttpServlet {
    private static final SPService spService = new SPService();
    private static final CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action==null) action="";
        switch (action){
            case "create":
                showCreateForm(req,resp);
                break;
            case "edit":
                showEditForm(req,resp);
                break;
            case "delete":
                showDeleteForm(req,resp);
                break;
            default:
                showProduct(req,resp);
        }
    }
    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String find = req.getParameter("find");
        SanPham sp = spService.findByName(find);
        List<Category> list = categoryService.finnAll();
        for (Category c:list) {
            if(c.getId_category()==sp.getId_category())
                sp.setName_category(c.getName_category());
        }
        req.setAttribute("sp",sp);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/detail.jsp");
        requestDispatcher.forward(req,resp);
    }

    private void showDeleteForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        SanPham sp = spService.findByID(id);
        List<Category> listC = categoryService.finnAll();
        for (Category c:listC) {
            if(c.getId_category()==sp.getId_category())
                sp.setName_category(c.getName_category());
        }
        req.setAttribute("sp",sp);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/delete.jsp");
        requestDispatcher.forward(req,resp);
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        SanPham sp = spService.findByID(id);
        req.setAttribute("sp",sp);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/edit.jsp");
        requestDispatcher.forward(req,resp);
    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/create.jsp");
        requestDispatcher.forward(req,resp);
    }

    private void showProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<SanPham> listSp = spService.findAll();
        List<Category> listC = categoryService.finnAll();
        for (SanPham sp:listSp) {
            for (Category c:listC) {
                if(sp.getId_category()==c.getId_category()){
                    sp.setName_category(c.getName_category());
                }
            }
        }
        req.setAttribute("list",listSp);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/home.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action==null) action="";
        switch (action){
            case "create":
                create(req,resp);
                break;
            case "edit":
                edit(req,resp);
                break;
            case "delete":
                delete(req,resp);
                break;
            case "search":
                search(req,resp);
                break;
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        spService.delete(id);
        showProduct(req, resp);
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id =Integer.parseInt(req.getParameter("id"));
        String name_sp = req.getParameter("name");
        int price = Integer.parseInt(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String color = req.getParameter("color");
        int id_category = Integer.parseInt(req.getParameter("category"));
        String description = req.getParameter("description");
        SanPham sp = new SanPham(id,name_sp,price,quantity,color,description,id_category);
        spService.edit(sp);
        showProduct(req, resp);
    }

    private void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name_sp = req.getParameter("name");
        int price = Integer.parseInt(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String color = req.getParameter("color");
        int id_category = Integer.parseInt(req.getParameter("category"));
        String description = req.getParameter("description");
        SanPham sp = new SanPham(name_sp,price,quantity,color,description,id_category);
        spService.save(sp);
        showProduct(req, resp);
    }

}
