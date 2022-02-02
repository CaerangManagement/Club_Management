package com.management.club.controller;

import com.management.club.model.Board;
import com.management.club.model.MemberInfo;
import com.management.club.repository.BoardRepository;
import com.management.club.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {

    @Autowired
    private final BoardRepository boardRepository;

    @Autowired
    private final MemberRepository memberRepository;



    @GetMapping("/index") //메인페이지
    public String index(Model model){
        List<Board> board = boardRepository.findTop4ByOrderByIdDesc(); //상위 4개의 게시물을 보여주는 쿼리
        List<MemberInfo> member = memberRepository.findTop4ByOrderByCodeDesc(); //최근 등록된 4명의 정보를 보여주는 쿼리
        model.addAttribute("board", board);
        model.addAttribute("member", member);
        return "/index";
    }

    @GetMapping("/login") //로그인 페이지
    public String login(){
        return "/login";
    }
    
    @GetMapping("/signup") //회원가입 페이지
    public String signup(){
        return "/signup";
    }

}
