package com.management.club.controller;

import com.management.club.model.Board;
import com.management.club.model.MemberInfo;
import com.management.club.model.NoticeBoard;
import com.management.club.repository.BoardRepository;
import com.management.club.repository.MemberRepository;
import com.management.club.repository.NoticeBoardRepository;
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

    @Autowired
    private final NoticeBoardRepository noticeBoardRepository;



    @GetMapping("index") //메인페이지
    public String index(Model model){
        List<Board> board = boardRepository.findTop7ByOrderByIdDesc(); //상위 7개의 게시물을 보여주는 쿼리
        List<NoticeBoard> noticeBoard = noticeBoardRepository.findTop7ByOrderByIdDesc(); //상위 7개의 공지사항 게시물을 보여주는 쿼리
        List<MemberInfo> member = memberRepository.findTop7ByOrderByCodeDesc(); //최근 등록된 7명의 정보를 보여주는 쿼리

        model.addAttribute("board", board);
        model.addAttribute("noticeBoard", noticeBoard);
        model.addAttribute("member", member);
        return "/index";
    }

    @GetMapping("login") //로그인 페이지
    public String login(){
        return "login";
    }
    
    @GetMapping("signup") //회원가입 페이지
    public String signup(){
        return "signup";
    }

    @GetMapping("intro") //회원가입 페이지
    public String intro(){
        return "intro";
    }

    @GetMapping("test")
    public String test(){
        return "test";
    }

}
