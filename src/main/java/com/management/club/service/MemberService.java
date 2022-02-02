package com.management.club.service;

import com.management.club.dto.MemberDto;
import com.management.club.exception.CustomException;
import com.management.club.exception.ErrorCode;
import com.management.club.model.MemberInfo;
import com.management.club.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor //final로 선언된 모든 멤버변수에 대한 생성자를 만들어줌
public class MemberService {



    private final MemberRepository memberRepository;


    @Transactional
    public Long save(final MemberDto params) {
        MemberInfo entity = memberRepository.save(params.toEntity());
        return entity.getCode();
    }

    @Transactional
    public Long update(final Long code, final MemberDto params) {
        //영속성 컨텍스트에 있는 (id)값으로 조회 후 값을 변경시키면 Transaction이 종료(commit)되는 시점에 update쿼리를 자동으로 실행함. (더티체킹)

        MemberInfo entity = memberRepository.findById(code).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
        entity.update(params.getDepartment(), params.getMemberName(), params.getContact(), params.getPosition(), params.getGrade(), params.getStudentId());

        return code;
    }
}
