package ru.job4j.cars.service;

import org.springframework.stereotype.Service;
import ru.job4j.cars.model.Post;
import ru.job4j.cars.repository.PostRepository;

import java.util.List;

@Service
public class PostService {

    private final PostRepository store;

    public PostService(PostRepository store) {
        this.store = store;
    }

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
