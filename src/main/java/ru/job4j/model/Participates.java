package ru.job4j.model;

import javax.persistence.*;

@Entity
@Table(name = "participates")
public class Participates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idUser;
    private int idPost;

}
