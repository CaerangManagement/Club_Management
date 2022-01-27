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

    private static final int BLOCK_PAGE_NUM_COUNT = 5; // 블럭에 존재하는 페이지 번호 수
    private static final int PAGE_POST_COUNT = 2; // 한 페이지에 존재하는 게시글 수

    private final MemberRepository memberRepository;

//    @Transactional
//    public List<MemberDto> getMemberList(Integer pageNum) {
//        Page<MemberInfo> page = memberRepository.findAll(PageRequest.of(pageNum - 1, PAGE_POST_COUNT, Sort.by(Sort.Direction.ASC, "code")));
//
//        List<MemberInfo> memberInfos = page.getContent();
//        List<MemberDto> memberDtoList = new ArrayList<>();
//
//        for (MemberInfo boardEntity : memberInfos) {
//            memberDtoList.add(this.convertEntityToDto(boardEntity));
//        }
//
//        return memberDtoList;
//    }

    public Long getMemberCount(){
        return memberRepository.count();
    }

    public Integer[] getPageList(Integer curPageNum){
        Integer[] pageList = new Integer[BLOCK_PAGE_NUM_COUNT];

        //총 게시글 갯수
        Double postsTotalCount = Double.valueOf(this.getMemberCount());

        //총 게시글 기준으로 계산한 마지막 번호 계산(올림으로 계산)
        Integer totalLastPageNum = (int)(Math.ceil((postsTotalCount/PAGE_POST_COUNT)));

        //현재 페이지를 기준으로 블럭의 마지막 페이지 번호 계산
        Integer blockLastpageNum = (totalLastPageNum > curPageNum + BLOCK_PAGE_NUM_COUNT)
                ? curPageNum + BLOCK_PAGE_NUM_COUNT
                : totalLastPageNum;

        //페이지 시작 번호 조정
        curPageNum = (curPageNum <= 3) ? 1 : curPageNum -2;

        //페이지 번호 할당
        for(int val=curPageNum , idx = 0; val <= blockLastpageNum; val++, idx++){
            pageList[idx] = val;
        }
        return pageList;
    }

//    private MemberDto convertEntityToDto(MemberInfo memberInfo) {
//        MemberDto memberDto = new MemberDto();
//        memberDto.setMemberName(memberInfo.getMemberName());
//        memberDto.setContact(memberInfo.getContact());
//        memberDto.setDepartment(memberInfo.getDepartment());
//        memberDto.setGrade(memberInfo.getGrade());
//        memberDto.setPosition(memberInfo.getPosition());
//        memberDto.setStudentId(memberInfo.getStudentId());
//        return memberDto;
//    }

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
