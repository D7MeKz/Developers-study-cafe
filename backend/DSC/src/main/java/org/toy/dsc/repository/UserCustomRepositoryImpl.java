package org.toy.dsc.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.toy.dsc.entity.QUserEntity;
import org.springframework.stereotype.Repository;
import org.toy.dsc.entity.UserEntity;

import java.util.List;

@Repository
public class UserCustomRepositoryImpl implements UserCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;
    private final QUserEntity userEntity = QUserEntity.userEntity;
    public UserCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory){
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public String getIdByUserEmail(String email) {
         UserEntity targetUser = jpaQueryFactory.selectFrom(userEntity)
                .from(userEntity)
                .where(userEntity.email.eq(email))
                .fetchOne();

        if (targetUser != null){
            return String.valueOf(targetUser.getId());
        }else{
            return null;
        }
    }
}
