<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/admin/header.jsp" %>
<%@ include file="/admin/sub_menu.jsp" %>
<%--@elvariable id="kind" type="java.lang.String"--%>
<%--@elvariable id="productVO" type="kim.present.kdt.shoesshop.dto.ProductVO"--%>
<%--@elvariable id="kindList" type="java.util.List<java.lang.String>"--%>

<article>
    <h1>상품수정</h1>
    <form name="frm" method="post" enctype="multipart/form-data">
        <!-- 입력란에 입력되지 않지만 같이 전달되어야할 내용들을  hidden 테그에 넣습니다 -->
        <input type="hidden" name="pseq" value="${productVO.pseq}">
        <input type="hidden" name="oldImage" value="${productVO.image}">

        <table id="list">
            <tr>
                <th>상품분류</th>
                <td colspan="5">
                    <label>
                        <select name="kind">
                            <c:forEach items="${kindList}" var="kind" varStatus="status">
                                <c:choose>
                                    <c:when test="${productVO.kind==status.count}">
                                        <option value="${status.count}" selected="selected">${kind}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${status.count}">${kind}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </label>
                </td>
            </tr>
            <tr>
                <th>상품명</th>
                <td style="width: 340px" colspan="5">
                    <label>
                        <input type="text" name="name" size="30" maxlength="80" value="${productVO.name}">
                    </label>
                </td>
            </tr>
            <tr>
                <th>원가[A]</th>
                <td style="width: 70px">
                    <label>
                        <input type="text" name="price1" size="11" value="${productVO.price1}" onKeyup="cals()">
                    </label>
                </td>
                <th>판매가[B]</th>
                <td style="width: 70px">
                    <label>
                        <input type="text" name="price2" size="11" value="${productVO.price2}" onKeyup="cals()">
                    </label>
                </td>
                <th>마진[B-A]</th>
                <td style="width: 72px">
                    <label>
                        <input type="text" name="price3" size="11" value="${productVO.price2-productVO.price1}">
                    </label>
                </td>
            </tr>
            <tr>
                <th>베스트상품</th>
                <td>
                    <c:choose>
                        <c:when test='${productVO.bestyn=="Y"}'>
                            <label><input type="radio" name="bestyn" value="Y" checked="checked">사용</label>
                            <label><input type="radio" name="bestyn" value="N">미사용</label>
                        </c:when>
                        <c:otherwise>
                            <label><<input type="radio" name="bestyn" value="Y">사용</label>
                            <label><<input type="radio" name="bestyn" value="N" checked="checked">미사용</label>
                        </c:otherwise>
                    </c:choose>
                </td>
                <th>사용유무</th>
                <td>
                    <c:choose>
                        <c:when test='${productVO.useyn=="Y"}'>
                            <label><input type="radio" name="useyn" value="Y" checked="checked">사용</label>
                            <label><input type="radio" name="useyn" value="N">미사용</label>
                        </c:when>
                        <c:otherwise>
                            <label><<input type="radio" name="useyn" value="Y">사용</label>
                            <label><<input type="radio" name="useyn" value="N" checked="checked">미사용</label>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <th>상세설명</th>
                <td colspan="5">
                    <label>
                        <textarea name="content" rows="8" cols="70">${productVO.content}</textarea>
                    </label>
                </td>
            </tr>
            <tr>
                <th>상품이미지</th>
                <td colspan="5">
                    <img src="product_images/${productVO.image}" style="width: 200px" alt="product_image"><br>
                    <input type="file" name="image">
                </td>
            </tr>
        </table>
        <input class="btn" type="button" value="수정" onClick="go_mod_save()">
        <input class="btn" type="button" value="취소"
               onClick="location.href='shop.do?command=adminProductDetail&pseq=${productVO.pseq}'">
    </form>
</article>

<%@ include file="/admin/footer.jsp" %>