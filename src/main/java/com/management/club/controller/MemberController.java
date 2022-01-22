package com.management.club.controller;

import com.management.club.model.MemberInfo;
import com.management.club.repository.MemberRepository;
import com.management.club.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;


@Controller
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberService memberService;


    @GetMapping("/member/list") //검색, 페이징 기능
    public String list(Model model, @PageableDefault(size = 4, direction = Sort.Direction.ASC) Pageable pageable,
                                 @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,
                                 @RequestParam(value ="searchType", required = false, defaultValue = "1") String searchType){

        if(Integer.parseInt(searchType)==1){
            Page<MemberInfo> members = memberRepository.findByMemberNameContaining(keyword, pageable);
            int startPage = 1;
            int endPage = members.getTotalPages();
            model.addAttribute("startPage", startPage);
            model.addAttribute("endPage", endPage);
            model.addAttribute("members", members);
            return "member/list";
        }
        else if(Integer.parseInt(searchType)==2){
            Page<MemberInfo> members = memberRepository.findByStudentIdContaining(keyword, pageable);
            int startPage = 1;
            int endPage = members.getTotalPages();
            model.addAttribute("startPage", startPage);
            model.addAttribute("endPage", endPage);
            model.addAttribute("members", members);
            return "member/list";
        }
        else{
            Page<MemberInfo> members = memberRepository.findByDepartmentContaining(keyword, pageable);
            int startPage = 1;
            int endPage = members.getTotalPages();
            model.addAttribute("startPage", startPage);
            model.addAttribute("endPage", endPage);
            model.addAttribute("members", members);
            return "member/list";
        }
    }

    @GetMapping("/member/add") //추가 페이지
    public String add(){
        return "member/add";
    }

    @GetMapping("/member/form") //수정 페이지 기존 데이터를 넘겨줌
    public String form(Model model,  @RequestParam(required = false) Long code){
        if(code == null){
            model.addAttribute("member", new MemberInfo());
        }
        else{
            MemberInfo memberInfo = memberRepository.findById(code).orElse(null);
            model.addAttribute("member", memberInfo);
        }
        return "member/form";
    }

    //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ//
    //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ API ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ//
    //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ//

    @PostMapping("/member/add")
    String newMember(@ModelAttribute MemberInfo memberInfo){
        memberRepository.save(memberInfo);
        return "redirect:/member/list";
    }

    @PostMapping("/member/update/{code}") //폼태그로 데이터를 받아서 POST매핑으로 받아줌.
    String replaceMember(@ModelAttribute MemberInfo newMember, @PathVariable Long code){
                 memberRepository.findById(code)
                .map(memberInfo -> {
                    memberInfo.setMemberName(newMember.getMemberName());
                    memberInfo.setPosition(newMember.getPosition());
                    memberInfo.setGrade(newMember.getGrade());
                    memberInfo.setContact(newMember.getContact());
                    memberInfo.setDepartment(newMember.getDepartment());
                    memberInfo.setStudentId(newMember.getStudentId());
                    return memberRepository.save(memberInfo);
                })
                .orElseGet(()->{
                    newMember.setCode(code);
                    return memberRepository.save(newMember);
                });
                 return "redirect:/member/list";
    }

    @PostMapping("/member/{code}") //폼태그로 데이터를 받아서 POST매핑으로 받아줌.
    public String delete(@PathVariable("code") Long code){
        memberRepository.deleteById(code);
        return "redirect:/member/list";
    }



}
