package com.management.club.service;

import com.management.club.dto.MemberDto;
import com.management.club.model.MemberInfo;
import com.management.club.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    private static final int BLOCK_PAGE_NUM_COUNT = 5; // 블럭에 존재하는 페이지 번호 수
    private static final int PAGE_POST_COUNT = 2; // 한 페이지에 존재하는 게시글 수

    @Autowired
    private MemberRepository memberRepository;


    @Transactional
    public List<MemberDto> getMemberList(Integer pageNum) {
        Page<MemberInfo> page = memberRepository.findAll(PageRequest.of(pageNum - 1, PAGE_POST_COUNT, Sort.by(Sort.Direction.ASC, "code")));

        List<MemberInfo> memberInfos = page.getContent();
        List<MemberDto> memberDtoList = new ArrayList<>();

        for (MemberInfo boardEntity : memberInfos) {
            memberDtoList.add(this.convertEntityToDto(boardEntity));
        }

        return memberDtoList;
    }

//    public List<MemberDto> searchMembers(String keyword){
//        List<MemberInfo> memberInfos = memberRepository.findByMemberNameContaining(keyword);
//        List<MemberDto> memberDtoList = new ArrayList<>();
//
//        if(memberInfos.isEmpty()) return memberDtoList; //결과가 없으면 바로 빈 Dto 넘기기
//
//        for(MemberInfo memberInfo : memberInfos){ //Dto로 변환후 리턴
//            memberDtoList.add(this.convertEntityToDto(memberInfo));
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


    private MemberDto convertEntityToDto(MemberInfo memberInfo) {
        MemberDto memberDto = new MemberDto();
        memberDto.setMemberName(memberInfo.getMemberName());
        memberDto.setContact(memberInfo.getContact());
        memberDto.setDepartment(memberInfo.getDepartment());
        memberDto.setGrade(memberInfo.getGrade());
        memberDto.setPosition(memberInfo.getPosition());
        memberDto.setStudentId(memberInfo.getStudentId());
        return memberDto;
    }

    public Long save(MemberDto memberDto) {
        return memberRepository.save(MemberInfo.builder()
                .department(memberDto.getDepartment())
                .memberName(memberDto.getMemberName())
                .contact(memberDto.getContact())
                .position(memberDto.getPosition())
                .grade(memberDto.getGrade())
                .studentId(memberDto.getStudentId()).build()).getCode();
    }
}
