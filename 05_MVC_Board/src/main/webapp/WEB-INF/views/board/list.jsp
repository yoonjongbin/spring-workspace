<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib prefix="fmt"
uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html data-bs-theme="dark">
  <head>
    <meta charset="UTF-8" />
    <title>List Page</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
      crossorigin="anonymous"
    />

    <style>
      h1 {
        margin-top: 70px;
      }

      .header {
        display: flex;
        justify-content: space-between;
        align-items: flex-end;
      }

      .pagination {
        display: flex;
        justify-content: center;
      }
    </style>
  </head>
  <body>
    <div class="container">
      <div class="header">
        <h1>List Page</h1>
        <a href="/board/insert" class="btn btn-outline-warning">게시물 등록</a>
      </div>

      <table class="table">
        <thead>
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
          </tr>
        </thead>

        <tbody>
          <c:forEach items="${list}" var="board">
            <tr>
              <td>${board.num}</td>
              <td><a href="/board/view?no=${board.no}">${board.title}</a></td>
              <td>${board.writer}</td>
              <td>
                <fmt:formatDate
                  value="${board.regdate}"
                  pattern="yyyy-MM-dd HH:mm:ss"
                />
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>

      <nav aria-label="Page navigation">
        <ul class="pagination">
          <c:if test="${paging.prev}">
            <li class="page-item">
              <a
                class="page-link"
                href="/board/list?page=${paging.startPage - 1}"
                >Prev</a
              >
            </li>
          </c:if>

          <c:forEach
            begin="${paging.startPage}"
            end="${paging.endPage}"
            var="num"
          >
            <li class="page-item">
              <a class="page-link ${paging.cri.page == num ? 'active' : ''}" href="list?page=${num}">${num}</a>
            </li>
          </c:forEach>

          <c:if test="${paging.next}">
            <li class="page-item">
              <a class="page-link" href="/board/list?page=${paging.endPage + 1}"
                >Next</a
              >
            </li>
          </c:if>
        </ul>
      </nav>

      
    </div>
  </body>
</html>
