package com.management.club.controller;

import com.management.club.dto.UserInfoDto;
import com.management.club.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;

    @PostMapping("/user")
    public String signup(UserInfoDto infoDto) { // 회원 추가
        userService.save(infoDto);
        return "redirect:/login";
    }

    @GetMapping("/auth/login") //로그인 에러 컨트롤러
    public String login(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "exception", required = false) String exception, Model model) {
        model.addAttribute("error", error);
        model.addAttribute("exception", exception);
        return "/login";
    }


    //security config에서 로그아웃 설정을 해줬지만 post로 csrf를 보내야 하기때문에 직접 패스를 치면 404에러가뜸,
    //이것을 막아주기위해 Get으로 요청해도 가능하게끔 따로 만들어줌.

    @GetMapping(value = "/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/index";
    }


    @ResponseBody
    @GetMapping("/user/idCheck{userId}")
    public boolean idCheck(@RequestParam("userId") String user_id) {

        return userService.userIdCheck(user_id);
    }
}

