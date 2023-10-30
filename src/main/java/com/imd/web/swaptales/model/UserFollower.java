package com.imd.web.swaptales.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_follower")
public class UserFollower {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "follower_id")
    private User follower;

}