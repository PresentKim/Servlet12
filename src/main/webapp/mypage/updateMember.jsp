<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../header.jsp" %>
<%--@elvariable id="loginUser" type="kim.present.kdt.shoesshop.dto.MemberVO"--%>

<section>
    <%@ include file="sub_image_menu.jsp" %>
    <article>
        <form action="shop.do?command=updateMember" method="post" name="joinForm">
            <h2>Update Member</h2>

            <h3>Basic Info</h3>
            <div class="field">
                <label>User ID <input type="text" name="userid" value="${loginUser.userid}" readonly/></label>
            </div>
            <div class="field">
                <label>Password <input type="password" name="pwd"></label>
            </div>
            <div class="field">
                <label>Retype Password <input type="password" name="pwdCheck"></label>
            </div>
            <div class="field">
                <label>Name <input type="text" name="name" value="${loginUser.name}"></label>
            </div>
            <div class="field"><label>Phone</label>
                <label> <input type="text" name="phone" value="${loginUser.phone}"/></label>
            </div>
            <div class="field"><label>E-Mail</label>
                <label> <input type="text" name="email" value="${loginUser.email}"/></label>
            </div>

            <h3>Optional Info</h3>
            <div class="field">
                <label>Zip Code <input type="text" name="zip_num" readonly value="${loginUser.zip_num}"></label>
                <input type="button" value="우편번호 찾기" onclick="post_zip()">
            </div>
            <div class="field">
                <label>Address <input type="text" name="address1" value="${loginUser.address1}" readonly/></label>
            </div>
            <div class="field">
                <label>detail Address</label>
                <input type="text" name="address2" value="${loginUser.address2}"/>
            </div>

            <div class="btn">
                <input type="button" value="회원정보수정" onclick="go_updateMember()">
            </div>

        </form>
    </article>
</section>
</div>

<%@ include file="../footer.jsp" %>