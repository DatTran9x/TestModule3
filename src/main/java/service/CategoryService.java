package service;

import dao.Categorydao;
import model.Category;

import java.util.List;

public class CategoryService {
    private static final Categorydao categorydao = new Categorydao();

    public List<Category> finnAll(){
        return categorydao.getAll();
    }
}
