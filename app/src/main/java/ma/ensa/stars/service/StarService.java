package ma.ensa.stars.service;

import java.util.ArrayList;
import java.util.List;

import ma.ensa.stars.beans.Star;
import ma.ensa.stars.dao.IDao;

public class StarService implements IDao<Star> {
    private List<Star> stars;
    private static StarService instance;
    private StarService() {
        this.stars = new ArrayList<>();
    }
    public static StarService getInstance() {
        if(instance == null)
            instance = new StarService();
        return instance;
    }

    public boolean create(Star o) {
        return stars.add(o);
    }

     public boolean update(Star o) {
        for(Star s : stars){
            if(s.getStar() == o.getId()){
                s.setImg(o.getImg());
                s.setName(o.getName());
                s.setStar(o.getStar());
            }
        }
        return true;
    }
    @Override
    public boolean delete(Star o) {
        return stars.remove(o);
    }
    @Override
    public Star findById(int id) {
        for(Star s : stars){
            if(s.getId() == id)
                return s;
        }
        return null;
    }
    @Override
    public List<Star> findAll() {
        return stars;
    }
}
