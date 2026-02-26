<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 26. 2. 13.
  Time: 오후 2:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Spring Todo List 연습 페이지</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <!--        네비게이션 추가 작업-->
        <div class="col">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="/todo/list">Navbar</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="/todo/register">글쓰기</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Features</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Pricing</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
        <!--        네비게이션 추가 작업-->
        <div class="row content">
            <div class="col">
                <div class="card">
                    <div class="card-header">
                        전체목록
                    </div>
                    <div class="card-body">
                        <table class="table">
                            <thead>
                            <tr>
                                <th scope="col">Tno</th>
                                <th scope="col">Title</th>
                                <th scope="col">Writer</th>
                                <th scope="col">DueDate</th>
                                <th scope="col">Finished</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${dtoList}" var="dto">
<%--                            responseDTO.dtoList 호출하는 것은 responseDTO의 getter 를 호출하는 효과와 동일--%>
<%--                        <c:forEach items="${responseDTO.dtoList}" var="dto">--%>
                                <tr>
                                    <th><c:out value="${dto.tno}"/></th>
                                    <td>
                                        <a href="/todo/read?tno=${dto.tno}" class="text-decoration-none">
                                            <c:out value="${dto.title}"/>
                                        </a>
                                    </td>
                                    <td><c:out value="${dto.writer}"/></td>
                                    <td><c:out value="${dto.dueDate}"/></td>
                                    <td><c:out value="${dto.finished}"/></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>

                        <div class="d-flex justify-content-center">
                            <ul class="pagination flex-wrap">
                                <c:if test="${responseDTO.prev}">
                                    <li class="page-item">
                                        <a class="page-link" data-num="${responseDTO.start - 1}">이전</a>
                                    </li>
                                </c:if>
                                <c:forEach begin="${responseDTO.start}" end="${responseDTO.end}" var="num">
                                    <li class="page-item ${responseDTO.page == num ? "active" : ""}">
                                        <a class="page-link" data-num="${num}">${num}</a>
                                    </li>
                                </c:forEach>
                                <c:if test="${responseDTO.next}">
                                    <li class="page-item">
                                        <a class="page-link" data-num="${responseDTO.end + 1}">다음</a>
                                    </li>
                                </c:if>
                            </ul>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row content">
        <%--        <h1>임시리스트</h1>--%>
    </div>
    <div class="row footer">
        <%--        <div class="row fixed-bottom" style="z-index: -100">--%>
        <%--    <div class="row fixed-bottom">--%>
        <footer class="py-3 mt-auto">
            <p class="text-center text-muted mb-0">
                Footer
            </p>
        </footer>
    </div>
    <%--    </div>--%>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

</body>
</html>
