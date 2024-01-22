package org.toy.dsc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.toy.dsc.entity.StudyGroupEntity;

public interface StudyGroupRepository extends JpaRepository<StudyGroupEntity, Long> {
}
