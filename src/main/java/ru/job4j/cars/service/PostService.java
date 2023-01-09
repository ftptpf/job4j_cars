package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.Post;
import ru.job4j.cars.repository.Store;

import java.util.List;

@Service
@AllArgsConstructor
public class PostService implements CrudService<Post> {
    private final Store<Post> store;

    public Post saveOrUpdate(Post post) {
        return store.saveOrUpdate(post);
    }

    public void delete(Post post) {
        store.delete(post);
    }

    public List<Post> findAll() {
        return store.findAll();
    }

    public Post findById(int id) {
        return store.findById(id);
    }

    public List<Post> findAllSale() {
        return store.findAllSale();
    }

    public List<Post> findAllSold() {
        return store.findAllSold();
    }

    public List<Post> findAllNew() {
        return store.findAllNew();
    }

    public List<Post> findAllSpecificBrand(String brand) {
        return store.findAllSpecificBrand(brand);
    }

    public List<Post> findAllPostsWithPhoto() {
        return store.findAllPostsWithPhoto();
    }

    public void changeStatusToSold(int id) {
        store.changeStatusToSold(id);
    }


}
