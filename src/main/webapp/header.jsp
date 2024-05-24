<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--@elvariable id="loginUser" type="kim.present.kdt.shoesshop.dto.MemberVO"--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="css/header_footer.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/section.css">
    <link rel="stylesheet" href="css/product.css">
    <link rel="stylesheet" href="css/mypage.css">

    <script src="script/jquery-3.7.1.min.js"></script>
    <script src="script/member.js"></script>
    <script src="script/mypage.js"></script>

</head>
<body>

<div id="wrap">

    <header>
        <nav id="top_menu">
            <div id="logo">
                <a href="shop.do?command=index"><img alt="logo" src="images/logo.png" width="180px" height="100px"></a>
            </div>
            <div class="gnb">
                <c:choose>
                    <c:when test="${empty loginUser}">
                        <a href="shop.do?command=loginForm">LOGIN</a>
                        <a href="shop.do?command=contract">JOIN</a>
                    </c:when>
                    <c:otherwise>
                        <a href="#">${loginUser.name}(${loginUser.userid})</a>
                        <a href="shop.do?command=logout">LOGOUT</a>
                    </c:otherwise>
                </c:choose>
                <a href="shop.do?command=cartList">CART</a>
                <a href="shop.do?command=mypage">MY PAGE</a>
                <a href="shop.do?command=qnaList">고객센터</a>

            </div>
            <div class="hmenu">
                <div></div>
                <div></div>
                <div></div>
            </div>
        </nav>
        <nav id="category_menu">

            <a href="shop.do?command=category&kind=1">Heels</a>
            <a href="shop.do?command=category&kind=2">Boots</a>
            <a href="shop.do?command=category&kind=3">Sandals</a>
            <a href="shop.do?command=category&kind=4">Snickers</a>
            <a href="shop.do?command=category&kind=5">Slippers</a>

        </nav>
    </header>