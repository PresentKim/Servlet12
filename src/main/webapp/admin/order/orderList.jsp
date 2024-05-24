<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/admin/header.jsp" %>
<%@ include file="/admin/sub_menu.jsp" %>
<%--@elvariable id="orderList" type="java.util.List<kim.present.kdt.shoesshop.dto.OrderVO>"--%>
<%--@elvariable id="key" type="java.lang.String"--%>

<article>
    <h1>주문리스트</h1>
    <form name="frm" method="post">
        <table style="float: right;">
            <tr>
                <td>
                    <label>주문상품 이름<input type="text" name="key" value="${key}"></label>
                    <input class="btn" type="button" value="검색" onClick="go_search('adminOrderList');">
                </td>
            </tr>
        </table>
        <table id="orderList">
            <tr>
                <th>주문번호(처리)</th>
                <th>주문자</th>
                <th>상품명</th>
                <th>수량</th>
                <th>우편</th>
                <th>주소</th>
                <th>전화</th>
                <th>주문일</th>
            </tr>
            <c:forEach items="${orderList}" var="orderVO">
                <tr>
                    <td>${orderVO.oseq}
                        <c:if test="${orderVO.result=='1'}">
                            (<label>
                            <input type="checkbox" name="result" value="${orderVO.odseq}"> 주문완료)
                            </label>
                        </c:if>
                        <c:if test="${orderVO.result=='2'}">
                            (<label>
                            <input type="checkbox" name="result" value="${orderVO.odseq}"> 배송중)
                            </label>
                        </c:if>
                        <c:if test="${orderVO.result=='3'}">
                            (<span style="font-weight: bold; color: blue">배송완료</span>)
                        </c:if>
                        <c:if test="${orderVO.result=='4'}">
                            (<span style="font-weight: bold; color: red">구매확정 </span>)
                        </c:if>
                    </td>
                    <td>${orderVO.mname}</td>
                    <td>${orderVO.pname}</td>
                    <td>${orderVO.quantity}</td>
                    <td>${orderVO.zip_num}</td>
                    <td>${orderVO.address1}</td>
                    <td>${orderVO.phone}</td>
                    <td><fmt:formatDate value="${orderVO.indate}"/></td>
                </tr>
            </c:forEach>
        </table>
        <div class="clear"></div>
        <input type="button" class="btn" style="width: 200px" value="다음 단계로" onClick="go_order_save()">
        <br><br>
        <jsp:include page="/admin/paging/paging.jsp">
            <jsp:param name="address" value="shop.do?command=adminOrderList"/>
        </jsp:include>
    </form>

</article>

<%@ include file="/admin/footer.jsp" %>