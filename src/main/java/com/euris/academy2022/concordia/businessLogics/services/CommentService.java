package com.euris.academy2022.concordia.businessLogics.services;

import com.euris.academy2022.concordia.dataPersistences.models.Comment;
import com.euris.academy2022.concordia.dataPersistences.DTOs.CommentDto;
import com.euris.academy2022.concordia.dataPersistences.DTOs.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    ResponseDto<CommentDto> insert(Comment comment);
    ResponseDto<CommentDto> insertFromTrello(Comment comment);
    ResponseDto<CommentDto> update(Comment comment);
    ResponseDto<CommentDto> updateFromTrello(Comment comment);
    ResponseDto<CommentDto> removeByUuid(String uuid);
    ResponseDto<List<CommentDto>> getAll();
    ResponseDto<CommentDto> getByUuid(String uuid);
    ResponseDto<CommentDto> getByIdTrelloComment(String idTrelloComment);
}