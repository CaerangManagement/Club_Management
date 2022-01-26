package com.management.club.controller;

import com.management.club.model.Reply;
import com.management.club.model.UserInfo;
import com.management.club.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class ReplyController {

    @Autowired
    private final ReplyService replyService;

    @PostMapping("/reply/write")
    public String replyWrite(@ModelAttribute Reply reply, Long boardId, UserInfo user){

        replyService.replyWrite(reply, user, boardId);

        return "/board/board_list";

    }

    @PostMapping("/reply/delete")
    public String replyDelete(@ModelAttribute Reply reply,  Principal principal,
            UserInfo user){

        replyService.replyDelete(reply);
        return "/board/board_list";
    }

};
