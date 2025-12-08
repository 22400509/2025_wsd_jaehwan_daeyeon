<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="top.jsp" flush="true" />

<div class="container mt-5">
    <h2 class="mb-4 text-primary">➕ 새 도서 등록</h2>

    <form method="post" action = "addok">

        <div class="row mb-3">
            <div class="col-md-6">
                <label for="title" class="form-label">제목 (Title)</label>
                <input type="text" class="form-control" id="title" name="title" required>
            </div>
            <div class="col-md-6">
                <label for="author" class="form-label">저자 (Author)</label>
                <input type="text" class="form-control" id="author" name="author" required>
            </div>
        </div>

        <div class="mb-3">
            <label for="publisher" class="form-label">출판사 (Publisher)</label>
            <input type="text" class="form-control" id="publisher" placeholder="Publisher Name" name="publisher" required>
        </div>

        <div class="row mb-3">
            <div class="col-md-6">
                <label for="published_date" class="form-label">출판 날짜 (Published Date)</label>
                <input type="date" class="form-control" id="published_date" name="published_date" required>
            </div>

            <div class="col-md-6">
                <label for="genre" class="form-label">장르 (Genre)</label>
                <select id="genre" class="form-select" name="genre" required>
                    <option value="" selected disabled>장르를 선택하세요...</option>
                    <option value="판타지">판타지</option>
                    <option value="소설">소설</option>
                    <option value="SF">SF</option>
                    <option value="만화">만화</option>
                    <option value="기타">기타</option>
                </select>
            </div>
        </div>

        <div class="d-grid gap-2 d-md-flex justify-content-md-start mt-4">
            <button type="submit" class="btn btn-primary">저장 (Submit)</button>
            <a href="list" class="btn btn-secondary">목록으로</a>
        </div>
    </form>
</div>

<jsp:include page="bottom.jsp" flush="true" />