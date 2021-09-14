package org.zerock.board.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.board.dto.ReplyDTO;

import java.util.List;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReplyServiceTests {
    @Autowired
    private ReplyService replyService;

    @Test
    void testGetList() {
        Long bno = 100L;
        List<ReplyDTO> replyDTOList = replyService.getList(bno);
        replyDTOList.forEach(new Consumer<ReplyDTO>() {
            @Override
            public void accept(ReplyDTO replyDTO) {
                System.out.println(replyDTO);
            }
        });
    }
}