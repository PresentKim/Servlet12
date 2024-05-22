<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../header.jsp" %>
<%--@elvariable id="kind" type="java.lang.String"--%>
<%--@elvariable id="kindProduct" type="java.util.List<kim.present.kdt.shoesshop.dto.ProductVO>"--%>

<section>
    <div class="sub_img">
        <img src="images/product/sub_img.jpg" alt="sub_img"/>
    </div>
    <div class="sub_page">
        <article style="flex-direction:column">
            <h2>${kind}</h2>
            <div class="kindproducts">
                <c:forEach items="${kindProduct}" var="productVO">
                    <div class="kinditem"
                         onClick="location.href='shop.do?command=productDetail&pseq=${productVO.pseq}'">
                        <img src="product_images/${productVO.savefilename}" alt="product_image"/>
                        <div>${productVO.name}</div>
                        <div>${productVO.price2}</div>
                    </div>
                </c:forEach>
            </div>
        </article>
    </div>
</section>

<%@ include file="../footer.jsp" %>