package WAA.spring.data.services;

import WAA.spring.data.entity.Address;
import WAA.spring.data.entity.Category;

import java.util.List;

public interface CategoryService {
    void save(Category category);
    Category getById(int id);
    void update(int id, Category categoryreq);
    void delete(int id);
    List<Category> findAll();
}
