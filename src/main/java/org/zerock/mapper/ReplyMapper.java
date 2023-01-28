package org.zerock.mapper;

import org.zerock.domain.ReplyVO;

public interface ReplyMapper {
	public int insert(ReplyVO vo); // 외래키를 사용하여 등록
	public ReplyVO read(Long rno); // 특정 댓글 읽기
	public int delete(Long targetRno); // 댓글의 bno(번호)로 삭제
	public int update(ReplyVO reply); // tbl_reply 테이블 댓글의 내용 및 최종 수정 시간 변경
}
