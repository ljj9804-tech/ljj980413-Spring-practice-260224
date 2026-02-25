<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 26. 2. 13.
  Time: 오후 2:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <%--    5.0 버전--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <%--    5.3버전--%>
    <%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">--%>

    <title>Spring Todo List 연습 페이지_임시 글쓰기 폼</title>
    <style>
        .custom-check-inline {
            display: flex; /* 요소들을 가로로 배치 */
            align-items: center; /* 수직 중앙 정렬 */
            gap: 10px; /* 라벨과 체크박스 사이의 간격 설정 */
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <!--        <h1>Header</h1>-->
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
        <!--        추가1-->
        <div class="row content">
            <!--            추가2-->
            <div class="col">
                <!--                추가3 -->
                <div class="card">
                    <div class="card-header">
                        Featured
                    </div>
                    <div class="card-body">
                        <form action="/todo/register" method="post">
                            <%--                            부트스트랩 이용중이고, 폼 컨트롤 하나씩 적용해보기.--%>
                            <div class="input-group mb-3">
                                <span class="input-group-text">Title:</span>
                                <input class="form-control" type="text" name="title" placeholder="todo 제목을 입력해주세요">
                            </div>
                            <div class="input-group mb-3">
                                <span class="input-group-text">DueDate: </span>
                                <input class="form-control" type="date" name="dueDate">
                            </div>
                            <div class="input-group mb-3">
                                <span class="input-group-text"> Writer:  </span>
                                <input class="form-control" type="text" name="writer">
                            </div>
                            <div class="form-check mb-3">
                                <span class="form-check-label">  Finished:  </span>
                                <input class="form-check-input" type="checkbox" name="finished">
                            </div>
<%--                            <div class="custom-check-inline">--%>
<%--                                <label for="myCheck2">완료 여부: </label>--%>
<%--                                <input type="checkbox" id="myCheck2" name="finished">--%>
<%--                            </div>--%>
                            <%--                            <div class="form-check mb-3">--%>
                            <%--                                <input class="form-check-input" type="checkbox" value="" id="checkDefault">--%>
                            <%--                                <label class="form-check-label" for="checkDefault">--%>
                            <%--                                    Default checkbox--%>
                            <%--                                </label>--%>
                            <%--                            </div>--%>
                            <div>
                                <button class="btn btn-secondary" type="reset">초기화</button>
                                <button class="btn btn-primary" type="submit">등록하기</button>
                            </div>
                        </form>
                        <script>
                            // 자바스크립트 코드, 유효성체크시, 오류를 담아둘 빈 객체 정의
                            // 자바스크립트의 객체의 자료구조 형식 , { key:val, key2:val2,...}
                            const serverValidResult = {}
                            <c:forEach items="${errors}" var="error">
                            serverValidResult[`${error.getField()}`] = `${error.defaultMessage}`
                            </c:forEach>
                            console.log("유효성 오류가 난 부분들 : " , serverValidResult)
                        </script>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row content">
        <h1>Content</h1>
    </div>
    <div class="row footer">
        <!--        <h1>Footer</h1>-->
        <!--        추가1-->
        <div class="row fixed-bottom" style="z-index: -100">
            <!--            추가2-->
            <footer class="py-1 my-1">
                <!--                추가3-->
                <p class="text-center text-muted">
                    Footer
                </p>
            </footer>
        </div>
    </div>
</div>
<h1>부트스트랩 적용, register 화면</h1>

<%--5.0 버전--%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

<%--5.3 버전 --%>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>--%>
</body>
</html>
