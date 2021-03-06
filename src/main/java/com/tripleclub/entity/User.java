package com.tripleclub.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "user_id")
    @Type(type="uuid-char")
    private UUID userId;

    @Column(name = "user_name")
    private String userName;

//    @OneToMany(mappedBy = "user")
//    private List<Mileage> mileageId;
//
//    @OneToMany(mappedBy = "user")
//    private List<Review> reviewId;
}
