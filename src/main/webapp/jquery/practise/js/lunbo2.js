/*
 功能说明:
 1. 点击向右(左)的图标, 平滑切换到下(上)一页
 2. 无限循环切换: 第一页的上一页为最后页, 最后一页的下一页是第一页
 3. 每隔3s自动滑动到下一页
 4. 当鼠标进入图片区域时, 自动切换停止, 当鼠标离开后,又开始自动切换
 5. 切换页面时, 下面的圆点也同步更新
 6. 点击圆点图标切换到对应的页
 bug: 快速点击时, 翻页不正常*/
$(function () {
    var $list = $("#list");
    var offset = 0;
    var currentOffset = $list.position().left;
    var pageWith = 600;
    var $ponint = $("#pointsDiv > span ");
    var imgCount = $ponint.length;

    // 1. 点击向右(左)的图标, 平滑切换到下(上)一页
    $("#prev").click(function () {
        nextPage(false);
    })
    $("#next").click(function () {
        nextPage(true);
    })
    // 3. 每隔3s自动滑动到下一页
    var auto_Intervel = setInterval(function () {
        nextPage(true);
    }, 1000);
    // 4. 当鼠标进入图片区域时, 自动切换停止, 当鼠标离开后,又开始自动切换
    $("#container").hover(function () {
        clearInterval(auto_Intervel);
    }, function () {
        auto_Intervel = setInterval(function () {
            nextPage(true);
        }, 1000);
    });

    function nextPage(next) {

        offset = next ? -pageWith : pageWith;
        // 实现平滑平移
        // 定义总时间
        var time = 400;
        // 定义毎多少秒移动一次
        var time_offset = 20;
        // 每次平移多少
        var item_offset = offset / (time / time_offset);
        // 定义一个目标平移量作为标记来关闭 定时器
        var targetOffset = currentOffset + offset;

        var item_intervel = setInterval(function () {
            currentOffset += item_offset;
            if (targetOffset === currentOffset) {
                clearInterval(item_intervel);
                // 2. 无限循环切换: 第一页的上一页为最后页, 最后一页的下一页是第一页
                if (currentOffset == -(imgCount + 1) * pageWith) {
                    currentOffset = -pageWith;
                } else if (currentOffset == 0) {
                    currentOffset = -imgCount * pageWith;
                }
            }
            $list.css("left", currentOffset);
        }, time_offset);
        updatePoint(next);
    }

    var index = 0;

    function updatePoint(next) {
        var targetIndex = 0;
        if (typeof next === "boolean") {
            if (next) {
             targetIndex = index + 1;
                if (targetIndex == imgCount) {
                    targetIndex = 0;
                }
            }else  {
                targetIndex = index - 1;
                if (targetIndex === -1) {
                    targetIndex = imgCount-1;
                }
            }
        }else {
            targetPosition = next;
        }
        $ponint[index].className = "";
        $ponint[targetIndex].className = "on";
        index = targetIndex;
    }
})