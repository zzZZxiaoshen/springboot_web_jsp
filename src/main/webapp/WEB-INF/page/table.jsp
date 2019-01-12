<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <%@ include file="/WEB-INF/page/common/css.jspi" %>
    <%--注意这是es6的语法在页面进行声明然后进行引用--%>
    <script>
        const rootPath = "${pageContext.request.contextPath}";
    </script>
</head>
<body>
    <table id="table" class="table table-hover table-bordered">
        <thead>
        <tr>
            <th></th>
            <th>序号</th>
            <th>订单号</th>
            <th>订单时间</th>
            <th>收件人</th>
        </tr>
        </thead>
    </table>
</body>
<%@include file="/WEB-INF/page/common/js.jspi" %>
<%@include file="/WEB-INF/page/common/click-confirm-modal.jspi" %>
<script  src="${pageContext.request.contextPath}/static/js/person/table/table.js?version=111"></script>

</html>
