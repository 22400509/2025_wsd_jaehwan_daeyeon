<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="top.jsp" flush="true" />


<div class="container mt-5">
    <h2 class="mb-4 text-primary">✏ 도서 정보 수정</h2>

    <form method="post" action="../editok">
        <input type="hidden" name="id" value="${book.id}">

        <div class="row mb-3">
            <div class="col-md-6">
                <label for="title" class="form-label">제목 (Title)</label>
                <input type="text" class="form-control" id="title" name="title" value="${book.title}" required>
            </div>
            <div class="col-md-6">
                <label for="author" class="form-label">저자 (Author)</label>
                <input type="text" class="form-control" id="author" name="author" value="${book.author}" required>
            </div>
        </div>

        <div class="mb-3">
            <label for="publisher" class="form-label">출판사 (Publisher)</label>
            <input type="text" class="form-control" id="publisher" name="publisher" value="${book.publisher}" required>
        </div>

        <div class="row mb-3">
            <div class="col-md-6">
                <label for="published_date" class="form-label">출판 날짜 (Published Date)</label>
                <input type="date" class="form-control" id="published_date" name="published_date"  value="${book.published_date}" required>
            </div>

            <div class="col-md-6">
                <label for="genre" class="form-label">장르 (Genre)</label>
                <select class="form-select" id="genre" name="genre" required>
                    <option value="">장르를 선택하세요</option>

                    <option value="소설" <c:if test="${book.genre eq '소설'}">selected</c:if>>소설</option>
                    <option value="에세이" <c:if test="${book.genre eq '에세이'}">selected</c:if>>에세이</option>
                    <option value="자기계발" <c:if test="${book.genre eq '자기계발'}">selected</c:if>>자기계발</option>
                    <option value="인문학" <c:if test="${book.genre eq '인문학'}">selected</c:if>>인문학</option>
                    <option value="과학" <c:if test="${book.genre eq '과학'}">selected</c:if>>과학</option>
                    <option value="IT" <c:if test="${book.genre eq 'IT'}">selected</c:if>>IT</option>
                    <option value="예술" <c:if test="${book.genre eq '예술'}">selected</c:if>>예술</option>
                    <option value="기타" <c:if test="${book.genre eq '기타'}">selected</c:if>>기타</option>
                </select>
            </div>
        </div>

        <div class="d-grid gap-2 d-md-flex justify-content-md-start mt-4">
            <button type="submit" class="btn btn-primary">저장 (Update)</button>
            <a href="../list" class="btn btn-secondary">목록으로</a>
        </div>
    </form>
</div>

<jsp:include page="bottom.jsp" flush="true" />