package org.zerock.mapper;

import org.zerock.domain.ReplyVO;

public interface ReplyMapper {
	public int insert(ReplyVO vo); // 외래키를 사용하여 등록
	public ReplyVO read(Long rno); // 특정 댓글 읽기
	public int delete(Long targetRno); // 댓글의 bno(번호)로 삭제
}
