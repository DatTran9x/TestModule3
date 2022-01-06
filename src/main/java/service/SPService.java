package service;

import dao.SPdao;
import model.SanPham;

import java.util.List;

public class SPService {
    private static final SPdao spdao = new SPdao();

    public List<SanPham> findAll(){
        return spdao.findAll();
    }

    public void save(SanPham sp) {
        spdao.save(sp);
    }

    public SanPham findByID(int id) {
        return spdao.findByID(id);
    }

    public void edit(SanPham sp) {
        spdao.edit(sp);
    }

    public void delete(int id) {
        spdao.delete(id);
    }

    public SanPham findByName(String find) {
        return spdao.findByName(find);
    }
}
