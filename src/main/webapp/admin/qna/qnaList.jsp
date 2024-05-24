<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>
<%--@elvariable id="qnaList" type="java.util.List<kim.present.kdt.shoesshop.dto.QnaVO>"--%>
<%--@elvariable id="key" type="java.lang.String"--%>

<article>
<h1>Q&amp;A 게시글 리스트</h1>  
<form name="frm" method="post">
<table style="float: right;">
	<tr><td>
		<label>제목+내용 검색&nbsp;&nbsp;<input type="text" name="key" value="${key}" ></label>&nbsp;&nbsp;
	    <input class="btn" type="button" value="검색" onClick="go_search('adminQnaList');">&nbsp;&nbsp;
    </td></tr>
</table>
</form>
<table id="orderList">
	<tr><th>번호(답변여부)</th> <th>제목</th> <th>작성자</th><th>작성일</th></tr>
  	<c:forEach items="${qnaList}" var="qnaVO">
    	<tr><td>${qnaVO.qseq}  
      		<c:choose>          
        		<c:when test='${empty qnaVO.reply}'>(미처리)</c:when>
        		<c:otherwise>(답변처리완료)</c:otherwise>
      		</c:choose></td>
      		<td align="left"><a href="#" onClick="go_view('${qnaVO.qseq}');">${qnaVO.subject}</a></td>
      		<td> ${qnaVO.userid} </td><td> <fmt:formatDate value="${qnaVO.indate}"/></td></tr>
    </c:forEach>
</table><br>
<jsp:include page="/admin/paging/paging.jsp">
	<jsp:param name="address" value="shop.do?command=adminQnaList" />
</jsp:include>
</article>
<%@ include file="/admin/footer.jsp"%>