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
    var $points = $("#pointsDiv > span");
    var imgCount = $points.length;

    $("#prev").click(function () {
        nextPage(false);
    })

    $("#next").click(function () {
        nextPage(true);
    })
    // 实现定时偏移
    var timeInterval = setInterval(function () {
        nextPage(true);
    }, 1000);
    
    $("#container").hover(function () {
        clearInterval(timeInterval);
    },function () {
        setInterval(function () {
            nextPage(true);
        }, 1000);
    })
    function  nextPage(next){
        // 实现平滑偏移
        var time = 400;
        offset = next ? -pageWith : pageWith;
        var time_offset = 20;
        var item_offset = offset / (time / time_offset);
        // 定义总偏移量
        var targetOffset = currentOffset + offset;


        var offsetInterval = setInterval(function () {
            currentOffset  += item_offset;
            if (currentOffset === targetOffset) {
                clearInterval(offsetInterval);
                // 2. 无限循环切换: 第一页的上一页为最后页, 最后一页的下一页是第一页
                if (currentOffset == -(imgCount + 1) * pageWith) {
                    currentOffset = -pageWith;
                }else if (currentOffset == 0) {
                    currentOffset = -imgCount * pageWith;
                }
            }
            $list.css("left", currentOffset);
        }, time_offset);

        // 更新圆点
        update_styles(next);
    }

    var index = 0;
    function update_styles(next) {
        var targetPosition=0;
        if (typeof  next === "boolean") {
            if (next) {
                targetPosition = index + 1;
                if (targetPosition === imgCount) {
                    targetPosition = 0;
                }
            } else {
                targetPosition = index - 1;
                if (targetPosition === -1) {
                    targetPosition = imgCount-1;
                }
            }
        } else {
            targetPosition = next;
        }

        $points[index].className = "";
        $points[targetPosition].className = "on";
        index = targetPosition;

    }
})