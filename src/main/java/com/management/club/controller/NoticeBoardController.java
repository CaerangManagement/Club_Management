package com.management.club.controller;

import com.management.club.model.NoticeBoard;
import com.management.club.repository.NoticeBoardRepository;
import com.management.club.service.NoticeBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RequiredArgsConstructor
@Controller
public class NoticeBoardController {


    private final NoticeBoardRepository noticeBoardRepository;


    private final NoticeBoardService noticeBoardService;

    /**
     * 게시글 리스트 조회
     */
    @GetMapping("/notice/board/list")
    public String notice_board_list(Model model , @PageableDefault(size = 10 , sort="createdDate", direction = Sort.Direction.DESC) Pageable pageable,
                             @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,
                             @RequestParam(value ="searchType", required = false, defaultValue = "1") String searchType){

        //제목으로 조회
        if(Integer.parseInt(searchType)==1){
            Page<NoticeBoard> noticeBoards = noticeBoardRepository.findByTitleContaining(keyword ,pageable);

            int current = noticeBoards.getNumber()+1;
            int begin = Math.max(1, current - 3);
            int end = Math.min(begin + 4, noticeBoards.getTotalPages());

            model.addAttribute("current", current);
            model.addAttribute("begin", begin);
            model.addAttribute("end", end);
            model.addAttribute("noticeBoards", noticeBoards);
            return "/notice_board/notice_board_list";
        }

        //작성자로 조회
        else{
            Page<NoticeBoard> noticeBoards = noticeBoardRepository.findByWriterContaining(keyword, pageable);

            int current = noticeBoards.getNumber()+1;
            int begin = Math.max(1, current - 3);
            int end = Math.min(begin + 4, noticeBoards.getTotalPages());

            model.addAttribute("current", current);
            model.addAttribute("begin", begin);
            model.addAttribute("end", end);
            model.addAttribute("noticeBoards", noticeBoards);
            return "/notice_board/notice_board_list";
        }

    }

    @GetMapping("/notice/board/add") //글 작성 페이지로 이동
    public String board_add(){
        return "/notice_board/notice_board_add";
    }

    @GetMapping("/notice/board/modify") //글 수정 페이지로 이동
    public String board_modify(Model model, @RequestParam(required = false) Long id){
        if(id == null){
            return "redirect:/notice/board/list";
        }
        else{
            NoticeBoard noticeBoard = noticeBoardRepository.findById(id).orElse(null);
            model.addAttribute("noticeBoard", noticeBoard);
        }

        return "/notice_board/notice_board_modify";
    }

    //상세정보 조회
    @GetMapping("/notice/board/{id}")
    public String findById(@PathVariable final Long id, Model model) {
        model.addAttribute("noticeBoard", noticeBoardService.findById(id));
        return "/notice_board/notice_board_view";
    }

}

