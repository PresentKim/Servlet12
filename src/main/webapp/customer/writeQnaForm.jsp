<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../header.jsp" %>
<%--@elvariable id="loginUser" type="kim.present.kdt.shoesshop.dto.MemberVO"--%>

<section>

    <%@ include file="sub_image_menu.jsp" %>
    <article>
        <form action="shop.do?command=writeQna" method="post">
            <h2> Q & A Write</h2>
            <div class="field">
                <label>작성자 <input type="text" name="userid" value="${loginUser.userid}" readonly/> </label>
            </div>
            <div class="field">
                <label>제목 <input type="text" name="subject"></label>
            </div>
            <div class="field">
                <label>질문내용 <textarea name="content" rows="10" cols="85"></textarea></label>
            </div>
            <div class="btn">
                <input type="submit" value="작성하기"/>
            </div>
        </form>
    </article>
</section>
</div>