package org.toy.dsc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.toy.dsc.domain.User;
import org.toy.dsc.entity.UserEntity;

// Crud에서 인터페이스 구현체가 자동으로 만들어진다.
@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long> {

}

