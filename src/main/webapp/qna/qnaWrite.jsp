<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../header.jsp" %>
<%@ include file="sub_image_menu.jsp" %>

<article>
    <h2> 1:1 고객 게시판 </h2>
    <h3> 고객님의 질문에 대해서 운영자가 1:1 답변을 드립니다.</h3>
    <form name="formm" method="post" action="shop.do">
        <input type="hidden" name="command" value="qnaWrite">
        <fieldset>
            <legend>Board Info</legend>
            <label>Title<input type="text" name="subject" size="60"></label>
            <br>
            <label>Content<textarea rows="8" cols="65" name="content"></textarea></label>
        </fieldset>
        <div class="clear"></div>
        <div id="buttons" style="float:right">
            <input type="submit" value="글쓰기" class="submit">
            <input type="button" value="목록으로" class="submit" onclick="location.href='shop.do?command=qnaList'">
        </div>
    </form>
</article>

<%@ include file="../footer.jsp" %>