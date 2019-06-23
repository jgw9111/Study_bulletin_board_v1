package ino.web.freeBoard.service;

import ino.web.freeBoard.dto.FreeBoardDto;
import ino.web.freeBoard.dto.PaginationDto;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FreeBoardService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List freeBoardList(){
		return sqlSessionTemplate.selectList("freeBoardGetList");
	}
	
	public List<FreeBoardDto> freeBoardListWithPaging(PaginationDto pdto){
		return sqlSessionTemplate.selectList("freeBoardListWithPaging",pdto);
	}
	
	public List freeBoardList2(){
		return sqlSessionTemplate.selectList("freeBoardGetList2");
	}
	
	public void freeBoardInsertPro(FreeBoardDto dto){
		sqlSessionTemplate.insert("freeBoardInsertPro",dto);
	}
	
	public FreeBoardDto getDetailByNum(int num){
		return sqlSessionTemplate.selectOne("freeBoardDetailByNum", num);
	}

	public int freeBoardCount(){
		return sqlSessionTemplate.selectOne("freeBoardCount");
	}
	
	public void freeBoardUpdate(FreeBoardDto dto){
		sqlSessionTemplate.update("freeBoardUpdate",dto);
		
	}
	
	public void freeBoardDelete(FreeBoardDto dto){
		sqlSessionTemplate.delete("freeBoardDelete",dto);
	}

}
