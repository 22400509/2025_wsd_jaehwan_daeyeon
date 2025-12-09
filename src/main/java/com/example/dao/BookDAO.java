package com.example.dao;

import com.example.bean.BookVO;
import java.util.List;

// [변경] class -> interface
public interface BookDAO {

    // 1. 전체 목록 조회
    List<BookVO> getBookList();

    // 2. 도서 검색 (제목 기준)
    List<BookVO> searchBooks(String keyword);

    // 3. 상세 보기 (ID 기준)
    BookVO getBook(int id);

    // 4. 도서 추가
    int insertBook(BookVO vo);

    // 5. 도서 수정
    int updateBook(BookVO vo);

    // 6. 도서 삭제
    int deleteBook(int id);
}