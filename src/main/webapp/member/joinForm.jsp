<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../header.jsp" %>

<section>
    <%@ include file="sub_image_menu.jsp" %>
    <article>
        <form action="shop.do?command=join" method="post" name="joinForm">
            <h2>Join Us</h2>

            <h3>Basic Info</h3>
            <div class="field">
                <label>User ID</label>
                <div>
                    <input type="text" name="userid" size="12">
                    <input type="hidden" name="reid">
                    <input type="button" value="중복 체크" onclick="idcheck()">
                </div>
            </div>
            <div class="field"><label>Password<input type="password" name="pwd"></label></div>
            <div class="field">
                <label>Retype Password<input type="password" name="pwdCheck"></label></div>
            <div class="field"><label>Name<input type="text" name="name"></label></div>
            <div class="field"><label>Phone<input type="text" name="phone"/></label></div>
            <div class="field"><label>E-Mail<input type="text" name="email"/></label></div>

            <h3>Optional Info</h3>
            <div class="field">
                <label>Zip Code
                    <input type="text" name="zip_num" readonly>
                    <input type="button" value="우편번호 찾기" onclick="post_zip()">
                </label>
            </div>
            <div class="field">
                <label>Address<input type="text" name="address1" readonly/></label>
            </div>
            <div class="field">
                <label>detail Address<input type="text" name="address2"/></label>
            </div>

            <div class="btn">
                <input type="button" value="회원가입" onclick="go_save()">
                <input type="button" value="메인으로" onClick="location.href='shop.do?command=index'">
            </div>

        </form>
    </article>
</section>

<%@ include file="../footer.jsp" %>