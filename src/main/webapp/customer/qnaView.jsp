<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../header.jsp" %>
<%--@elvariable id="qnaVO" type="kim.present.kdt.shoesshop.dto.QnaVO"--%>

<section>

    <%@ include file="sub_image_menu.jsp" %>
    <article>
        <form>
            <h2> Q & A View </h2>
            <div class="field" style="border-top:2px solid blueviolet;">
                <label>작성자</label>
                <div>${qnaVO.userid}</div>
            </div>
            <div class="field" style="border-top:1px dotted blueviolet;">
                <label>제목</label>
                <div>${qnaVO.subject}</div>
            </div>
            <div class="field" style="border-top:1px dotted blueviolet;">
                <label>등록일</label>
                <div><fmt:formatDate value="${qnaVO.indate}" type="date"/></div>
            </div>
            <div class="field" style="border-top:1px dotted blueviolet;">
                <label>질문내용</label>
                <div>
                    <pre>${qnaVO.content}</pre>
                </div>
            </div>
            <div class="field" style="border-bottom:2px solid blueviolet;border-top:2px solid blueviolet;">
                <label>답변내용</label>
                <div style="padding:10px;">${qnaVO.reply}</div>
            </div>
            <div class="btn">
                <input type="button" value="목록으로" onClick="location.href='shop.do?command=qnaList'">
            </div>
        </form>
    </article>
</section>
</div>

<%@ include file="../footer.jsp" %>