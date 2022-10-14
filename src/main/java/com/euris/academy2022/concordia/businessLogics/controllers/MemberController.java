package com.euris.academy2022.concordia.businessLogics.controllers;


import com.euris.academy2022.concordia.businessLogics.services.MemberService;
import com.euris.academy2022.concordia.businessLogics.services.trelloServices.UserDetailsManagerService;
import com.euris.academy2022.concordia.dataPersistences.DTOs.MemberDto;
import com.euris.academy2022.concordia.dataPersistences.DTOs.requests.members.MemberPostRequest;
import com.euris.academy2022.concordia.dataPersistences.DTOs.requests.members.MemberPutRequest;
import com.euris.academy2022.concordia.dataPersistences.DTOs.ResponseDto;
import com.euris.academy2022.concordia.utils.enums.MemberRole;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    private final UserDetailsManagerService userDetailsManagerService;

    public MemberController(MemberService memberService, UserDetailsManagerService userDetailsManagerService) {
        this.memberService = memberService;
        this.userDetailsManagerService = userDetailsManagerService;
    }

    @PostMapping
    public ResponseDto<MemberDto> insert(@RequestBody MemberPostRequest memberDto) {
        ResponseDto<MemberDto> response = memberService.insert(memberDto.toModel());
        if (response.getBody() != null) {
            userDetailsManagerService.responsePostByModel(response.getBody().toModel());
        }
        return response;
    }

    @PutMapping
    public ResponseDto<MemberDto> update(@RequestBody MemberPutRequest memberDto) {
        ResponseDto<MemberDto> response = memberService.update(memberDto.toModel());
        if (response.getBody() != null) {
            userDetailsManagerService.responsePutByModel(response.getBody().toModel());
        }
        return response;
    }

    @DeleteMapping("/{uuid}")
    public ResponseDto<MemberDto> removeByUuid(@PathVariable String uuid) {
        ResponseDto<MemberDto> response = memberService.removeByUuid(uuid);
        if (response.getBody() != null) {
            userDetailsManagerService.responseDeleteByUsername(response.getBody().getUsername());
        }
        return response;
    }

    @GetMapping
    public ResponseDto<List<MemberDto>> getAll() {
        return memberService.getAll();
    }

    @GetMapping("/{uuid}")
    public ResponseDto<MemberDto> getByUuid(@PathVariable String uuid) {
        return memberService.getMemberDtoByUuid(uuid);
    }

    @GetMapping("/idTrelloMember={idTrelloMember}")
    public ResponseDto<MemberDto> getByIdTrelloMember(@PathVariable String idTrelloMember) {
        return memberService.getByIdTrelloMember(idTrelloMember);
    }

    @GetMapping("/username={username}")
    public ResponseDto<MemberDto> getByUsername(@PathVariable String username) {
        return memberService.getByUsername(username);
    }

    @GetMapping("/role={role}")
    public ResponseDto<List<MemberDto>> getByRole(@PathVariable MemberRole role) {
        return memberService.getByRole(role);
    }

    @GetMapping("/name={name}")
    public ResponseDto<List<MemberDto>> getByName(@PathVariable String name) {
        return memberService.getByFirstName(name);
    }

    @GetMapping("/surname={surname}")
    public ResponseDto<List<MemberDto>> getBySurname(@PathVariable String surname) {
        return memberService.getByLastName(surname);
    }
}
