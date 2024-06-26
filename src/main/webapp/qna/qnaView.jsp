<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/header.jsp" %>
<%@ include file="sub_image_menu.jsp" %>
<%--@elvariable id="qnaVO" type="kim.present.kdt.shoesshop.dto.QnaVO"--%>

<article>
    <h2> 고객 게시판 </h2>
    <h3> 고객님의 질문에 대해서 운영자가 1:1 답변을 드립니다.</h3>
    <form>
        <table>
            <tr>
                <th>작성자</th>
                <td style="text-align:left; width: 500px">${qnaVO.userid}</td>
            </tr>
            <tr>
                <th>제목</th>
                <td style="text-align:left; width: 500px">${qnaVO.subject}</td>
            </tr>
            <tr>
                <th>등록일</th>
                <td style="text-align:left;"><fmt:formatDate value="${qnaVO.indate}" type="date"/></td>
            </tr>
            <tr>
                <th>질문내용</th>
                <td style="text-align:left;font-size:115%;">
                    <pre>${qnaVO.content}</pre>
                </td>
            </tr>
            <tr>
                <th>답변 내용</th>
                <td style="text-align:left;color:white;">${qnaVO.reply}</td>
            </tr>
        </table>
        <div class="clear"></div>
        <div id="buttons" style="float:right">
            <input type="button" value="목록보기" class="submit" onclick="location.href='shop.do?command=qnaList'">
        </div>
    </form>
</article>
<%@ include file="../footer.jsp" %> 