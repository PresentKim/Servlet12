<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/admin/header.jsp" %>
<%@ include file="/admin/sub_menu.jsp" %>
<%--@elvariable id="kind" type="java.lang.String"--%>
<%--@elvariable id="kindList" type="java.util.List<java.lang.String>"--%>

<article>
    <form name="productWriteFrm" method="post" enctype="multipart/form-data">
        <h2> Product Write Form </h2>
        <div class="field">
            <label>상품분류</label>
            <div>
                <label>
                    <select name="kind">
                        <option value="">선택하세요</option>
                        <c:forEach items="${kindList}" var="kind" varStatus="status">
                            <option value="${status.count}">${kind}</option>
                        </c:forEach>
                    </select>
                </label>
            </div>
        </div>
        <div class="field">
            <label>상품명<input type="text" name="name"/></label>
        </div>
        <div class="field">
            <label>원가 <input type="text" name="price1" style="margin-right:20px;" onKeyup="cals();"/></label>
            <label>판매가 <input type="text" name="price2" style="margin-right:20px;" onKeyup="cals();"/></label>
            <label>마진 <input type="text" name="price3" readonly/></label>
        </div>
        <div class="field">
            <label>상세설명 <textarea name="content" rows="8" style="flex:4;"></textarea></label>
        </div>
        <div class="field">
            <label>상품이미지 </label><input type="file" name="image">
        </div>
        <div class="btn">
            <input type="button" value="상품등록" onClick="go_save()">
            <input type="button" value="목록으로" onClick="location.href='shop.do?command=adminProductList'">
        </div>
    </form>
</article>

<%@ include file="/admin/footer.jsp" %>