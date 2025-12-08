package com.example;

import com.example.bean.BookVO;
import com.example.dao.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    BookDAO  bookDAO;

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("classlist")
    public String list(Model model){
        List<String> list = new ArrayList<String>();
        list.add("사과");
        list.add("바나나");
        list.add("키위");

        model.addAttribute("classlist", list);
        String msg = "과일 리스트";
        model.addAttribute("msg", msg);
        return "clist";
    }

    @RequestMapping(value = "/board/list", method = {RequestMethod.GET, RequestMethod.POST})
    public String boardList( @RequestParam(value = "search", required = false) String searchKeyword,
        Model model) {
            List<BookVO> bookList;

            // 검색어가 있을 경우 (null이 아니고 빈 문자열이 아닐 때)
            if (searchKeyword != null && !searchKeyword.trim().isEmpty()) {
                bookList = bookDAO.searchBooks(searchKeyword);
                model.addAttribute("search", searchKeyword);
            } else {
                bookList = bookDAO.getBookList();
            }
        model.addAttribute("list", bookList);
        return "list";
    }

    @RequestMapping(value = "/board/add", method = RequestMethod.GET)
    public String add(){
        return "write";
    }

    @RequestMapping(value = "/board/addok", method = RequestMethod.POST)
    public String addOk(BookVO vo){
        int i = bookDAO.insertBook(vo);
        if(i == 0) System.out.println("데이터 추가 실패");
        else System.out.println("데이터 추가 성공!");

        return "redirect:list";
    }

    @RequestMapping(value = "/board/details/{id}", method = RequestMethod.GET)
    public String viewPost(@PathVariable("id") int id, Model model){
        BookVO bookVO = bookDAO.getBook(id);
        model.addAttribute("book", bookVO);
        return "view";
    }

    @RequestMapping(value = "/board/editpost/{id}", method = RequestMethod.GET)
    public String editpost(@PathVariable("id") int id, Model model){
        BookVO bookVO = bookDAO.getBook(id);
        model.addAttribute("book", bookVO);
        return "edit";
    }

    @RequestMapping(value = "/board/editok", method = RequestMethod.POST)
    public String editOk(BookVO vo){
        int i = bookDAO.updateBook(vo);
        if(i == 0) System.out.println("데이터 추가 실패");
        else System.out.println("데이터 추가 성공!");

        return "redirect:list";
    }

    @RequestMapping(value = "/board/deleteok/{id}", method = RequestMethod.GET)
    public String editpost(@PathVariable("id") int id){
        int i = bookDAO.deleteBook(id);
        if(i == 0) System.out.println("데이터 삭제 실패");
        else System.out.println("데이터 삭제 성공");
        return "redirect:../list";
    }

}
