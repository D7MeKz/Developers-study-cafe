package org.toy.dsc.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.toy.dsc.entity.QUserEntity;
import org.springframework.stereotype.Repository;
import org.toy.dsc.entity.UserEntity;

import java.util.List;

@Repository
public class UserCustomRepositoryImpl implements UserCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;
    private QUserEntity userEntity = QUserEntity.userEntity;
    public UserCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory){
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public Boolean isValidUserByEmail(String email) {
         List<UserEntity> targetUser = jpaQueryFactory.selectFrom(userEntity)
                .from(userEntity)
                .where(userEntity.email.eq(email))
                .fetch();

         if (!targetUser.isEmpty()){
             return true;
         }else{
             return false; // Invalid User
         }
    }
}
