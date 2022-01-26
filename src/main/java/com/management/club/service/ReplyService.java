package com.management.club.service;

import com.management.club.model.Board;
import com.management.club.model.Reply;
import com.management.club.model.UserInfo;
import com.management.club.repository.BoardRepository;
import com.management.club.repository.ReplyRepository;
import com.management.club.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReplyService {

    @Autowired
    private final ReplyRepository replyRepository;

    @Autowired
    private final BoardRepository boardRepository;

    @Autowired
    private final UserRepository userRepository;

    public void replyWrite(Reply reply, UserInfo user, Long boardId){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UserInfo findUser = userRepository.findByCode(user.getCode());
        Optional<Board> findBoard = boardRepository.findById(boardId);


        reply.setWriter(authentication.getName()); //작성자 기본생성
        reply.setBoard(findBoard.get());
        reply.setUserInfo(findUser);
        

        replyRepository.save(reply);


    }

    public void replyDelete(Reply reply){

        replyRepository.delete(reply);

    }

};
