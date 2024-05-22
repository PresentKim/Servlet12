<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../header.jsp" %>

<section>
    <%@ include file="sub_image_menu.jsp" %>
    <article>
        <form method="post" action="shop.do?command=login" name="loginForm">
            <h2>LogIn</h2>
            <div class="field">
                <label>User ID<input name="userid" type="text"/></label>
            </div>
            <div class="field">
                <label>Password<input name="pwd" type="password"></label>
            </div>
            <div class="btn">
                <input type="submit" value="LOGIN" onClick="return loginCheck()">
                <input type="button" value="JOIN" onclick="">
                <input type="button" value="FIND ID" onclick="">
            </div>
            <div style="font-size:80%; font-weight:bold">${message} </div>
        </form>
    </article>
</section>

<%@ include file="../footer.jsp" %>