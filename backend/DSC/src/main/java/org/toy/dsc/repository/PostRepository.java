package org.toy.dsc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.toy.dsc.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity,Long> {
}
