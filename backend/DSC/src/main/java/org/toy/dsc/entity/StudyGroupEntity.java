package org.toy.dsc.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Study_Groups")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudyGroupEntity extends BaseTimeEntity{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성 전략
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Builder
    public StudyGroupEntity(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
