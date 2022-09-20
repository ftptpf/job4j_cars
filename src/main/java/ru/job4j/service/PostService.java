package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.model.Post;
import ru.job4j.model.User;
import ru.job4j.persistence.PostDbStore;

import java.util.List;

@Service
public class PostService {

    private final PostDbStore store;

    public PostService(PostDbStore store) {
        this.store = store;
    }

    public User saveOrUpdate(User user) {
        return store.saveOrUpdate(user);
    }

    public void delete(User user) {
        store.delete(user);
    }

    public List<Post> findAll() {
        return store.findAll();
    }

    public Post findById(int id) {
        return store.findById(id);
    }

    public List<Post> findAllSold() {
        return store.findAllSold();
    }

    public List<Post> findAllNew() {
        return store.findAllNew();
    }


}