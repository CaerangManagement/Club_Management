package com.management.club.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class MemberInfo {

    @Id
    @Column(name = "code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    @Column(name = "department")
    private String department; //소속

    @Column(name = "grade")
    private String grade; //학년

    @Column(name = "studentId", unique = true)
    private String studentId; //학번

    @Column(name = "memberName")
    private String memberName; //이름

    @Column(name = "contact")
    private String contact; //연락처

    @Column(name = "position")
    private String position; //직책

    @Builder
    public MemberInfo(String department, String memberName,String contact,
                      String position, String grade, String studentId){
        this.department = department;
        this.memberName = memberName;
        this.contact = contact;
        this.position = position;
        this.grade = grade;
        this.studentId = studentId;
    }
    
    //수정된 회원정보 담을 곳
    public void update(String department, String memberName,String contact,
                       String position, String grade, String studentId){
        this.department = department;
        this.memberName = memberName;
        this.contact = contact;
        this.position = position;
        this.grade = grade;
        this.studentId = studentId;
    }





}

