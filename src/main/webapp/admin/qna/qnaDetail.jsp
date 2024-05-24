<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/admin/header.jsp" %>
<%@ include file="/admin/sub_menu.jsp" %>
<%--@elvariable id="qnaVO" type="kim.present.kdt.shoesshop.dto.QnaVO"--%>

<article>
    <h1>Q&amp;A 게시판</h1>
    <form name="frm" method="post">
        <input type="hidden" name="qseq" value="${qnaVO.qseq}">
        <table id="orderList"> <!-- 게시물의 내용 -->
            <tr>
                <th style="width: 20%">작성자</th>
                <td style="align-content: start"> ${qnaVO.userid} </td>
            </tr>
            <tr>
                <th style="width: 20%">제목</th>
                <td style="align-content: start"> ${qnaVO.subject} </td>
            </tr>
            <tr>
                <th>등록일</th>
                <td style="align-content: start"><fmt:formatDate value="${qnaVO.indate}"/></td>
            </tr>
            <tr>
                <th>내용</th>
                <td style="align-content: start">
                    <pre>${qnaVO.content}</pre>
                </td>
            </tr>
        </table>
        <c:choose>
            <c:when test='${empty qnaVO.reply}'> <!-- 관리자 답변 전 표시 -->
                <table id="orderList">
                    <tr>
                        <td colspan="2"><img src="admin/images/opinionimg01.gif" alt="opinion"></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <label><textarea name="content" rows="3" cols="50"></textarea></label>
                            <input type="button" class="btn" value="저장" onClick="go_rep()">
                        </td>
                    </tr>
                </table>
            </c:when>
            <c:otherwise>
                <table id="orderList">
                    <tr>
                        <th>댓글</th>
                        <td>${qnaVO.reply}</td>
                    </tr>
                </table>
            </c:otherwise>
        </c:choose>
        <input type="button" class="btn" value="목록" onClick="location.href='shop.do?command=adminQnaList'">
    </form>
</article>
<%@ include file="/admin/footer.jsp" %>