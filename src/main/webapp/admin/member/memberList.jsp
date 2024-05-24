<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/admin/header.jsp" %>
<%@ include file="/admin/sub_menu.jsp" %>
<%--@elvariable id="memberList" type="java.util.List<kim.present.kdt.shoesshop.dto.MemberVO>"--%>
<%--@elvariable id="key" type="int"--%>

<article>
    <h1>회원리스트</h1>
    <form name="frm" method="post">
        <table style="float:right">
            <tr>
                <td>
                    <label>회원 이름<input type="text" name="key" value="${key}"> </label>
                    <input class="btn" type="button" value="검색" onclick="go_search('adminMemberList')">
        </table>
        <br>
        <table id="orderList">
            <tr>
                <th>아이디(탈퇴여부)</th>
                <th> 이름</th>
                <th>이메일</th>
                <th>우편번호</th>
                <th>주소</th>
                <th>전화</th>
                <th>가입일</th>
            </tr>
            <c:forEach items="${memberList}" var="memberVO">
                <tr>
                    <td>${memberVO.userid}
                        <c:choose>
                            <c:when test='${memberVO.useyn=="Y"}'>
                                <label>
                                    <input type="checkbox" name="useyn" onChange="changeN('${memberVO.userid}');">
                                </label>
                            </c:when>
                            <c:otherwise>
                                <label>
                                    <input type="checkbox" name="useyn" checked="checked"
                                           onChange="changeY('${memberVO.userid}');">
                                </label>
                            </c:otherwise>
                        </c:choose></td>
                    <td>${memberVO.name}</td>
                    <td>${memberVO.email}</td>
                    <td>${memberVO.zip_num}</td>
                    <td>${memberVO.address1}</td>
                    <td>${memberVO.phone}</td>
                    <td><fmt:formatDate value="${memberVO.indate}"/></td>
                </tr>
            </c:forEach>
        </table>
        <jsp:include page="/admin/paging/paging.jsp">
            <jsp:param value="shop.do?command=adminMemberList" name="address"/>
        </jsp:include>
    </form>
</article>

<%@ include file="/admin/footer.jsp" %>