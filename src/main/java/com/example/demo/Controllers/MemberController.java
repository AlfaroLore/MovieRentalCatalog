package com.example.demo.Controllers;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.Models.Member;
import com.example.demo.Repositories.MemberRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
    private final MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping("/api/members")
    List<Member> all() {
        return memberRepository.findAll();
    }

    @PostMapping("/api/members")
    Member newMember(@Valid @RequestBody Member member) {
        return memberRepository.save(member);
    }

    @DeleteMapping("/api/members/{id}")
    void deleteMember(@PathVariable Long id) {
        memberRepository.deleteById(id);
    }

}
