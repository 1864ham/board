package org.zerock.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.zerock.board.dto.ReplyDTO;
import org.zerock.board.entity.Board;
import org.zerock.board.entity.Reply;
import org.zerock.board.repository.ReplyRepository;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService{

    private final ReplyRepository replyRepository;

    @Override
    public Long register(ReplyDTO replyDTO) {
        Reply reply = dtoToEntity(replyDTO);
        replyRepository.save(reply);
        return reply.getRno();
    }

    @Override
    public List<ReplyDTO> getList(Long bno) {
        List<Reply> result= replyRepository.getRepliesByBoardOrderByRno(
                        Board.builder().bno(bno).build());
        return result.stream().map(
                new Function<Reply, ReplyDTO>() {
                    @Override
                    public ReplyDTO apply(Reply reply) {
                        return entityToDTO(reply);
                    }
                }
        ).collect(Collectors.toList());
    }

    @Override
    public void modify(ReplyDTO replyDTO) {

    }

    @Override
    public void remove(Long rno) {

    }

    @Override
    public Reply dtoToEntity(ReplyDTO replyDTO) {
        return ReplyService.super.dtoToEntity(replyDTO);
    }

    @Override
    public ReplyDTO entityToDTO(Reply reply) {
        return ReplyService.super.entityToDTO(reply);
    }
}
