package com.example.dao;

import com.example.bean.BookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //쿼리문
    private final String BOOK_SELECT = "SELECT * FROM BOOK ORDER BY id ASC";
    private final String BOOK_SELECTID = "SELECT * FROM BOOK WHERE id = ?";
    private final String BOOK_SELECTTITLE = "SELECT * FROM BOOK WHERE title LIKE ?";
    private final String BOOK_INSERT = "INSERT INTO BOOK (title, author, publisher, published_date, genre) VALUES (?, ?, ?, ?, ?)";
    private final String BOOK_UPDATE = "UPDATE BOOK SET title = ?, author = ?, publisher = ?, published_date = ?, genre = ? WHERE ID = ?";
    private final String BOOK_DELETE = "DELETE FROM BOOK WHERE ID = ?";

    public List<BookVO> getBookList(){
        return jdbcTemplate.query(BOOK_SELECT, new RowMapper<BookVO>() {
            @Override
            public BookVO mapRow(ResultSet rs, int rowNum) throws SQLException{
                BookVO data = new BookVO();
                data.setId(rs.getInt("ID"));
                data.setTitle(rs.getString("title"));
                data.setAuthor(rs.getString("author"));
                data.setPublisher(rs.getString("publisher"));
                data.setPublished_date(rs.getString("published_date"));
                data.setGenre(rs.getString("genre"));
                data.setCnt(rs.getInt("cnt"));
                return data;
            }
        });
    }

    public List<BookVO> searchBooks(String keyword){
        String searchPattern = "%" + keyword + "%";
        return jdbcTemplate.query(BOOK_SELECTTITLE, new RowMapper<BookVO>() {
            @Override
            public BookVO mapRow(ResultSet rs, int rowNum) throws SQLException{
                BookVO data = new BookVO();
                data.setId(rs.getInt("ID"));
                data.setTitle(rs.getString("title"));
                data.setAuthor(rs.getString("author"));
                data.setPublisher(rs.getString("publisher"));
                data.setPublished_date(rs.getString("published_date"));
                data.setGenre(rs.getString("genre"));
                data.setCnt(rs.getInt("cnt"));
                return data;
            }
        }, searchPattern);
    }

    public BookVO getBook(int id){
        return jdbcTemplate.queryForObject(BOOK_SELECTID,
                new Object[] {id},
                new BeanPropertyRowMapper<BookVO>(BookVO.class));
    }

    public int insertBook(BookVO vo) {
        return jdbcTemplate.update(BOOK_INSERT, new
                Object[] {vo.getTitle(), vo.getAuthor(), vo.getPublisher(), vo.getPublished_date(), vo.getGenre()});
    }

    public int updateBook(BookVO vo){
        return jdbcTemplate.update(BOOK_UPDATE,
                new Object[] {vo.getTitle(), vo.getAuthor(), vo.getPublisher(), vo.getPublished_date(), vo.getGenre(), vo.getId()});
    }

    public int deleteBook(int id){
        return jdbcTemplate.update(BOOK_DELETE, new Object[] {id});
    }
}
