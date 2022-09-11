package WAA.spring.data.services.imple;

import WAA.spring.data.entity.Address;
import WAA.spring.data.entity.Category;
import WAA.spring.data.repository.CatagoryRepo;
import WAA.spring.data.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImple implements CategoryService {

    @Autowired
    private CatagoryRepo catagoryRepo;

    @Override
    public void save(Category category) {
        catagoryRepo.save(category);

    }

    @Override
    public Category getById(int id) {
        return catagoryRepo.findById(id).orElse(null);
    }

    @Override
    public void update(int id, Category categoryreq) {
        Category category =catagoryRepo.findById(id).orElse(null);
        if(category==null)
            throw new NullPointerException("the Id is not exist in DB");
       category.setName(categoryreq.getName());

    }

    @Override
    public void delete(int id) {
        Category category =catagoryRepo.findById(id).orElse(null);
        catagoryRepo.delete(category);
    }

    @Override
    public List<Category> findAll() {
        return (List<Category>) catagoryRepo.findAll();
    }
}
