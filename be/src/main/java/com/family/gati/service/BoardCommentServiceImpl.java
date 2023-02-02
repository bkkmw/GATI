package com.family.gati.service;

import com.family.gati.dto.BoardCommentDto;
import com.family.gati.dto.BoardDto;
import com.family.gati.entity.BoardComment;
import com.family.gati.repository.BoardCommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class BoardCommentServiceImpl implements BoardCommentService{
    private final BoardCommentRepository boardCommentRepository;

    @Override
    public List<BoardCommentDto> findByBoardId(Integer boardId) {
        List<BoardComment> boardComments = boardCommentRepository.findByBoardId(boardId);
        int size = boardComments.size();
        List<BoardCommentDto> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            BoardCommentDto boardCommentDto = new BoardCommentDto(boardComments.get(i));
            result.add(boardCommentDto);
        }
        return result;
    }
}
