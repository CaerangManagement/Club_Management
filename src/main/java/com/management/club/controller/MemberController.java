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


@Controller
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberService memberService;


    @GetMapping("/member/list") //검색, 페이징 기능
    public String list(Model model, @PageableDefault(size = 10, direction = Sort.Direction.DESC) Pageable pageable,
                                 @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,
                                 @RequestParam(value ="searchType", required = false, defaultValue = "1") String searchType){

        if(Integer.parseInt(searchType)==1){
            Page<MemberInfo> members = memberRepository.findByMemberNameContaining(keyword, pageable);
            int current = members.getNumber()+1;
            int begin = Math.max(1, current - 3);
            int end = Math.min(begin + 4, members.getTotalPages());

            model.addAttribute("current", current);
            model.addAttribute("begin", begin);
            model.addAttribute("end", end);
            model.addAttribute("members", members);
            return "member/list";
        }
        else if(Integer.parseInt(searchType)==2){
            Page<MemberInfo> members = memberRepository.findByStudentIdContaining(keyword, pageable);
            int current = members.getNumber()+1;
            int begin = Math.max(1, current - 3);
            int end = Math.min(begin + 4, members.getTotalPages());

            model.addAttribute("current", current);
            model.addAttribute("begin", begin);
            model.addAttribute("end", end);
            model.addAttribute("members", members);
            return "member/list";
        }
        else{
            Page<MemberInfo> members = memberRepository.findByDepartmentContaining(keyword, pageable);
            int current = members.getNumber()+1;
            int begin = Math.max(1, current - 3);
            int end = Math.min(begin + 4, members.getTotalPages());

            model.addAttribute("current", current);
            model.addAttribute("begin", begin);
            model.addAttribute("end", end);
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





}
