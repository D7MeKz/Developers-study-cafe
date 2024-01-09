package org.toy.dsc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.toy.dsc.entity.UserEntity;

// Crud에서 인터페이스 구현체가 자동으로 만들어진다.
@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long> {

}
