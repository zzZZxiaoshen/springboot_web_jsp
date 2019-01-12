var table=[{
    checkbox: 'true'
},  {
    field: 'id',
    align: 'center',
    valign: 'middle'
},{
    field: 'orderno',
    align: 'center',
    valign: 'middle'
}, {
    formatter: function (value, rows, index) {
        return  dateFormat("yyyy-MM-dd",rows.orderdate);
    },
    align: 'center',
    valign: 'middle'
}, {
    field: 'receiver',
    align: 'center',
    valign: 'middle'
}]
$(function () {

    /**
     * 表格初始化
     */
    $table = $('#table');
    $table.bootstrapTable({
        columns: table
    })
    searchUserList();
})

/**
 * 查询用户列表
 */
function searchUserList() {
    $('#table').bootstrapTable("destroy");
    $('#table').bootstrapTable({
        method: "post",
        dataType: "json",
      /*注意这是es6的语法在页面进行声明然后进行引用${rootPath}*/
        url: `${rootPath}/order`,
        contentType: "application/x-www-form-urlencoded",
        cache: false,
        striped: false,
        sortable: true,
        sortOrder: 'asc',
        pagination: true,
        singleSelect: false,
        sidePagination: 'server',
        pageSize: 10,
        pageList: [10],
        columns:table,
        queryParams: function (params) {
            return {
                start: params.offset,
                limit: params.limit
            };
        }
    });

}

/**
 * 时间格式化处理
 */
function dateFormat(fmt, date) {
    if (typeof date !== "object") {
        date = new Date(date);
    }
    let o = {
        // 月份
        "M+": date.getMonth() + 1,
        // 日
        "d+": date.getDate(),
        // 小时
        "h+": date.getHours(),
        // 分
        "m+": date.getMinutes(),
        // 秒
        "s+": date.getSeconds(),
        // 季度
        "q+": Math.floor((date.getMonth() + 3) / 3),
        // 毫秒
        "S": date.getMilliseconds()
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (let k in o)
        if (new RegExp("(" + k + ")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length === 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}