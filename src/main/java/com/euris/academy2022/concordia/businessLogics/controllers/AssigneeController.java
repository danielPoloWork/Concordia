package com.euris.academy2022.concordia.businessLogics.controllers;

import com.euris.academy2022.concordia.businessLogics.services.AssigneeService;
import com.euris.academy2022.concordia.dataPersistences.dataTransferObjects.AssigneeDto;
import com.euris.academy2022.concordia.dataPersistences.dataTransferObjects.MemberDto;
import com.euris.academy2022.concordia.dataPersistences.dataTransferObjects.ResponseDto;
import com.euris.academy2022.concordia.dataPersistences.dataTransferObjects.requests.assignees.AssigneePostRequest;
import com.euris.academy2022.concordia.dataPersistences.dataTransferObjects.requests.members.MemberPostRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assignee")
public class AssigneeController {

    private final AssigneeService assigneeService;

    public AssigneeController(AssigneeService assigneeService) {
        this.assigneeService = assigneeService;
    }

    @PostMapping
    public ResponseDto<AssigneeDto> insert(@RequestBody AssigneePostRequest assigneeDto) {
        return assigneeService.insert(assigneeDto.toModel());
    }

    @DeleteMapping
    public ResponseDto<AssigneeDto> remove(@RequestBody AssigneePostRequest assigneeDto) {
        return assigneeService.removeByUuidMemberAndIdTask(assigneeDto.getUuidMember(), assigneeDto.getIdTask());
    }
}