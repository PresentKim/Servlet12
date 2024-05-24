<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--@elvariable id="message" type="java.lang.String"--%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>admin Login</title>
    <link rel="stylesheet" href="admin/css/admin.css">
    <script src="admin/script/admin.js"></script>
</head>
<body>
<div id="wrap">
    <header>
        <div id="logo">
            <img src="admin/images/bar_01.gif" style="float:left;" alt="bar">
            <img src="admin/images/text.gif" alt="text">
        </div>
    </header>
    <div class="clear"></div>
    <article>
        <div id="loginform">
            <form name="frm" method="post" action="shop.do">
                <input type="hidden" name="command" value="adminLogin">
                <table>
                    <tr>
                        <td>아 이 디</td>
                        <td><label><input type="text" name="adminid" size="10"></label></td>
                    </tr>
                    <tr>
                        <td>비밀번호</td>
                        <td><label><input type="password" name="pwd" size="10"></label></td>
                    </tr>
                    <tr style="align-content: center">
                        <td colspan="2">
                            <input class="btn" type="submit" value="로그인" onClick="return workerCheck();">
                            <br><br>
                            <h4 style="color:red">${message}</h4>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </article>
</div>
</body>
</html>