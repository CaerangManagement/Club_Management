package com.management.club.dto;

import com.management.club.model.MemberInfo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberDto {

    private String department;
    private String grade;
    private String studentId;
    private String memberName;
    private String contact;
    private String position;

    public MemberInfo toEntity() {

        return MemberInfo.builder()
                .department(department)
                .grade(grade)
                .studentId(studentId)
                .memberName(memberName)
                .contact(contact)
                .position(position)
                .build();

    }
}
