<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="addressList" type="java.util.List<kim.present.kdt.shoesshop.dto.AddressVO>"--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <script src="script/member.js"></script>
</head>
<body>
<div id="popup">
    <form method="post" name="formm" action="shop.do?command=findZipnum">
        <label>
            동 이름 : <input name="dong" type="text">
        </label>
        <input type="submit" value="찾기" class="submit">
    </form>

    <table id="zipcode" style="border: 1px">
        <tr>
            <th style="width: 100px">우편번호</th>
            <th>주소</th>
        </tr>
        <c:forEach items="${addressList}" var="add">
            <tr>
                <td>
                    <a href="#" onClick="addressOK('${add.zip_num}', '${add.sido}' , '${add.gugun}' , '${add.dong}')">
                            ${add.zip_num}
                    </a>
                </td>
                <td>
                    <a href="#" onClick="addressOK('${add.zip_num}', '${add.sido}' , '${add.gugun}' , '${add.dong}')">
                            ${add.sido} ${add.gugun} ${add.dong}
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>



