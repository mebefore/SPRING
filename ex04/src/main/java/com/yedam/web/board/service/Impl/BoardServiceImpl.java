package com.yedam.web.board.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.web.board.mapper.BoardMapper;
import com.yedam.web.board.service.BoardService;
import com.yedam.web.board.service.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	//mapper호출
	@Autowired
	BoardMapper boardMapper; //mapper의 명칭 붙이기 
	
	
	@Override
	public List<BoardVO> getBoardList() {
		// TODO Auto-generated method stub
		return boardMapper.selectBoardAllList();
	}

	@Override
	public BoardVO getBoardInfo(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return boardMapper.selectBoardInfo(boardVO);
	}

	@Override
	//등록 - 등록된 글 번호 반환 / 실패 : -1
	public int insertBoardInfo(BoardVO boardVO) {
		int result = boardMapper.insertBoardInfo(boardVO);
		if(result == 1) {
			return boardVO.getBno();
		}else {
			return -1;
		}
	}

	@Override
	//수정 - 수정된 글 번호 반환 / 실패 : -1
	public int updateBoardInfo(BoardVO boardVO) {
		int result = boardMapper.updateBoardInfo(boardVO);
		if(result == 1) {
			return boardVO.getBno();
		}else {
			return -1;
		}
	}

	@Override
	//삭제 - 삭제된 글 번호 반환 / 실패 : -1
	public int deleteBoardInfo(int bno) {
		int result = boardMapper.deleteBoardInfo(bno);
		if(result == 1) {
			return bno;
		}else {
			return -1;
		}
	}

}
