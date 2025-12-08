<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="top.jsp" flush="true" />

<div class="container mt-5">

    <h2 class="mb-4 text-primary">📖 도서 상세 정보</h2>

    <div class="card shadow-sm">
        <div class="card-header bg-primary text-white">
            <h5 class="mb-0">${book.title}</h5>
        </div>
        <div class="card-body">
            <ul class="list-group list-group-flush">
                <li class="list-group-item d-flex justify-content-between align-items-center">
                    <strong>ID</strong>
                    <span>${book.id}</span>
                </li>
                <li class="list-group-item d-flex justify-content-between align-items-center">
                    <strong>저자</strong>
                    <span>${book.author}</span>
                </li>
                <li class="list-group-item d-flex justify-content-between align-items-center">
                    <strong>출판사</strong>
                    <span>${book.publisher}</span>
                </li>
                <li class="list-group-item d-flex justify-content-between align-items-center">
                    <strong>출판날짜</strong>
                    <span>${book.published_date}</span>
                </li>
                <li class="list-group-item d-flex justify-content-between align-items-center">
                    <strong>장르</strong>
                    <span>${book.genre}</span>
                </li>
                <li class="list-group-item d-flex justify-content-between align-items-center">
                    <strong>조회수</strong>
                    <span class="badge bg-secondary rounded-pill">${book.cnt}</span>
                </li>
            </ul>
        </div>
        <div class="card-footer d-flex justify-content-end">
            <a href="../editpost/${book.id}" class="btn btn-warning me-2">✏ 수정하기</a>
            <a href="javascript:deleteConfirm(${book.id})" class="btn btn-danger me-2">🗑 삭제하기</a>
            <a href="../list" class="btn btn-secondary">📚 목록 돌아가기</a>
        </div>
    </div>
</div>

<script>
    function deleteConfirm(bookId) {
        if(confirm("정말로 삭제하시겠습니까?")) {
            // '확인'을 누르면, 실제로 삭제를 처리할 페이지로 이동
            location.href = '../deleteok/' + bookId;
        }
    }
</script>

<jsp:include page="bottom.jsp" flush="true" />