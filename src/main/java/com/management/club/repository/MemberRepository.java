package com.management.club.repository;


import com.management.club.model.MemberInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<MemberInfo, Long> {

    //회원 이름으로 검색
    Page<MemberInfo> findByMemberNameContaining(String memberName, Pageable pageable);
    //회원 학번으로 검색
    Page<MemberInfo> findByStudentIdContaining(String studentId, Pageable pageable);
    //회원 학과로 검색
    Page<MemberInfo> findByDepartmentContaining(String department, Pageable pageable);

    //상위 4개 회원목록 index페이지에서 보여줄꺼
    List<MemberInfo> findTop4ByOrderByCodeDesc();


}
