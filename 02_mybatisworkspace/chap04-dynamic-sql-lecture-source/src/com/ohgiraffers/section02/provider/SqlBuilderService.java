package com.ohgiraffers.section02.provider;

import org.apache.ibatis.session.SqlSession;

import static com.ohgiraffers.common.Template.getSqlSession;

import com.ohgiraffers.common.MenuDTO;

public class SqlBuilderService {

	private SqlBuilderMapper mapper;
	
	public void registMenu(MenuDTO menu) {
		
		
	SqlSession sqlSession = getSqlSession();
	
	mapper = sqlSession.getMapper(SqlBuilderMapper.class);
	
	int result = mapper.registMenu(menu);
		
	// insert, update, delete의 경우 트랜젝션 처리가 필요하다.
	
	if(result > 0) {
		System.out.println("신규 메뉴 등록에 성공하였습니다.");
		sqlSession.commit();
	} else {
		System.out.println("신규 메뉴 등록에 실패하였습니다.");
		sqlSession.rollback();
	}
	
	sqlSession.close();
	
	}

	public void modifyMenu(MenuDTO menu) {
		
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(SqlBuilderMapper.class);
		
		int result = mapper.modifyMenu(menu);
			
		// insert, update, delete의 경우 트랜젝션 처리가 필요하다.
		
		if(result > 0) {
			System.out.println("메뉴 수정에 성공하였습니다.");
			sqlSession.commit();
		} else {
			System.out.println("메뉴 수정에 실패하였습니다.");
			sqlSession.rollback();
		}
		
		sqlSession.close();
	}

	public void deleteMenu(int code) {
		
		SqlSession sqlSession = getSqlSession();
		
		mapper = sqlSession.getMapper(SqlBuilderMapper.class);
		
		int result = mapper.deleteMenu(code);
		
		if(result > 0) {
			System.out.println("메뉴 삭제에 성공하였습니다.");
			sqlSession.commit();
		} else {
			System.out.println("메뉴 삭제에 실패하였습니다.");
			sqlSession.rollback();
		}
		
		sqlSession.close();
	}
	

}
