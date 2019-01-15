(function ($, window) {
    /**
     *  添加单个键直对cookie
     * @param key 键
     * @param value 值
     * @param day 过期时间
     * @param path 设置存储cookie的路径
     * @param domain 设置跨域
     */
    var addCookie = function (key, value, day, path, domain) {
        // 处理设置cookie存储路径问题
        var index = window.location.pathname.lastIndexOf("/");
        var curentPath = window.location.pathname.slice(0, index);
        path = path || curentPath;
        // 处理设置cookie跨域问题
        domain = domain || document.domain;
        // 处理设置cookie过期时间问题 这里的逻辑是 如果是空如要进入判断然后设置默认过期时间
        if (!day) {
            document.cookie = key + "=" + value + ";path=" + path + ";domain=" + domain + ";";
        } else {
            var date = new Date();
            date.setDate(date.getDate() + day);
            document.cookie = key + "=" + value + ";expires=" + date.toGMTString() + ";path=" + path + ";domain=" + domain + ";";
        }

    }

    /**
     * 获取cookie中的信息
     * @param key 获取的键
     * @returns {string} 返回键对应的值
     */
    var getCookie = function (key) {
        var res = document.cookie.split(";");
        for (var i = 0; i < res.length; i++) {
            var temp = res[i].split("=");
            if (temp[0].trim() === key) {
                return temp[1];
            }
        }
    }

    /**
     * 删除cookie
     * @param key  需要被删除的cookie键
     */
    var delCookie = function (key) {
        addCookie(key, getCookie(key), -1);
    }


    $.extend({
        addCookie: addCookie,
        getCookie: getCookie,
        delCookie: delCookie,
        max:function (a,b) {
            return a > b ? a : b;
        }
    })

})(jQuery, window)


