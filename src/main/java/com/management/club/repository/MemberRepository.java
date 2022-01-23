package com.management.club.repository;


import com.management.club.model.MemberInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<MemberInfo, Long> {

    Page<MemberInfo> findByMemberNameContaining(String memberName, Pageable pageable);
    Page<MemberInfo> findByStudentIdContaining(String studentId, Pageable pageable);
    Page<MemberInfo> findByDepartmentContaining(String studentId, Pageable pageable);



}
