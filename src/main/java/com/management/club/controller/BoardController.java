package com.management.club.controller;

import com.management.club.model.Board;
import com.management.club.repository.BoardRepository;
import com.management.club.service.BoardService;
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
public class BoardController {


    private final BoardRepository boardRepository;


    private final BoardService boardService;

    /**
     * 게시글 리스트 조회
     */
    @GetMapping("/board/list")
    public String board_list(Model model , @PageableDefault(size = 10 , sort="createdDate", direction = Sort.Direction.DESC) Pageable pageable,
                             @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,
                             @RequestParam(value ="searchType", required = false, defaultValue = "1") String searchType){

        //전체 게시글 조회
        if(Integer.parseInt(searchType)==1){
            Page<Board> boards = boardRepository.findAll(pageable);
            int startPage = 1;
            int endPage = boards.getTotalPages();
            model.addAttribute("startPage", startPage);
            model.addAttribute("endPage", endPage);
            model.addAttribute("boards", boards);
            return "/board/board_list";
        }

        //제목으로 조회
        else if(Integer.parseInt(searchType)==2){
            Page<Board> boards = boardRepository.findByTitleContaining(keyword ,pageable);
            int startPage = 1;
            int endPage = boards.getTotalPages();
            model.addAttribute("startPage", startPage);
            model.addAttribute("endPage", endPage);
            model.addAttribute("boards", boards);
            return "/board/board_list";
        }

        //작성자로 조회
        else{
            Page<Board> boards = boardRepository.findByWriterContaining(keyword, pageable);
            int startPage = 1;
            int endPage = boards.getTotalPages();
            model.addAttribute("startPage", startPage);
            model.addAttribute("endPage", endPage);
            model.addAttribute("boards", boards);
            return "/board/board_list";
        }

    }

    @GetMapping("/board/add") //글 작성 페이지로 이동
    public String board_add(){
        return "/board/board_add";
    }
    
    @GetMapping("/board/modify") //글 수정 페이지로 이동
    public String board_modify(Model model, @RequestParam(required = false) Long id){
        if(id == null){
            return "redirect:/board/list";
        }
        else{
            Board board = boardRepository.findById(id).orElse(null);
            model.addAttribute("board", board);
        }

        return "/board/board_modify";
    }

    //상세정보 조회
    @GetMapping("/board/{id}")
    String findById(@PathVariable final Long id, Model model) {
        model.addAttribute("board", boardService.findById(id));
        return "/board/board_view";
    }

}
