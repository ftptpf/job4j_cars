package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.model.Post;
import ru.job4j.repository.PostDbStore;

import java.util.List;

@Service
public class PostService {

    private final PostDbStore store;

    public PostService(PostDbStore store) {
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

    public List<Post> findAllNew() {
        return store.findAllNew();
    }

    public List<Post> findAllSpecificBrand(String brand) {
        return store.findAllSpecificBrand(brand);
    }

    public List<Post> findAllPostsWithPhoto() {
        return store.findAllPostsWithPhoto();
    }


}
