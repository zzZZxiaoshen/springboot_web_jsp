
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="" >天气服务调用</a>
</body>
<script type="application/javascript" src="js/jquery-3.3.1.min.js"/>
<script src="static/js/_city.json"></script>
<script>
    var city_code;
    $("a").attr("href", "http://t.weather.sojson.com/api/weather/city/" + city_code);
</script>
</html>
