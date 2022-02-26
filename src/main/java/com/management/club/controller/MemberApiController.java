package com.management.club.controller;

import com.management.club.dto.MemberDto;
import com.management.club.repository.MemberRepository;
import com.management.club.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api")
public class MemberApiController {

    private final MemberService memberService;

    private final MemberRepository memberRepository;

    //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ//
    //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ API ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ//
    //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ//

    //회원 추가
    @RequestMapping(value="/member/add", method=RequestMethod.POST)
    ResponseEntity<?> save(@RequestBody final MemberDto memberDto){
        Long member_code = memberService.save(memberDto);
        return new ResponseEntity<>(member_code, HttpStatus.CREATED);
    }

    //회원 수정
    @RequestMapping(value="/member/update/{code}", method=RequestMethod.PUT)
    ResponseEntity<?> update(@PathVariable("code") final Long code, @RequestBody final MemberDto memberDto){
        Long member_code = memberService.update(code, memberDto);
        return new ResponseEntity<>(member_code, HttpStatus.OK);
    }

    //게시글 삭제
    @RequestMapping(value="/member/delete/{code}", method=RequestMethod.DELETE)
    ResponseEntity<?> delete(@PathVariable("code") final Long code){
        memberRepository.deleteById(code);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
