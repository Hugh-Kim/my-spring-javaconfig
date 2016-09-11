package org.my.board.model;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by HughKim on 2016-09-11.
 */
@Entity
@Table(name = "USERS")
@Getter
public class User {
    @Id
    @Column(name = "id")
    private int id;
    private String name;
    private String email;
}
