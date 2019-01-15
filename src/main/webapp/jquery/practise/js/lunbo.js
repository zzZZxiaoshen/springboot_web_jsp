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

    var $container = $("#container");
    var $list = $("#list");
    var $points = $("#pointsDiv > span");
    var imgCount = $points.length;
    var currentOffset = $list.position().left;
    var pageWith = 600;
    var index = 0; // 标识当前圆点

    
    // 1. 点击向右(左)的图标, 平滑切换到下(上)一页

   $("#prev").click(function () {
       nextPage(false);
   })
    $("#next").click((function () {
        nextPage(true);
    }))

    // 自动进行翻页
    var stopauto= setInterval(function () {
    nextPage(true)
    }, 1000);

   // 鼠标移入停止翻页，鼠标移出继续翻页
   $container.hover(function () {
       clearInterval(stopauto);
   },function () {
       stopauto = setInterval(function () {
           nextPage(true)
       }, 1000);
   })

    // 采用事件委托的方式进行绑定事件 点击圆点的时候更新翻页的图片
    var poinstsParent = $points.parent();
    poinstsParent.delegate("span", "click", function () {
      var targetIndex =  $(this).index();
        // console.log(index);
        nextPage(targetIndex)
    });


    function nextPage(next) {
        // 定义总偏移量
        var offset = 0;
        if (typeof next === "boolean") {
            offset = next ? -pageWith : pageWith;
        } else {
            offset = -(next-index) * pageWith;
        }
        // 定义总时间
        var time  = 400;
        // 定义单位时间偏移量
        var time_offset = 20;
         // 定义单位偏移量
        var itemOffset = offset / (time / time_offset);
        // 得到目标处的偏移量 作为标识判断是否需要关闭定时器
        var targetPosition = currentOffset + offset;

        // 定时器实现平滑偏移
         var interval = setInterval(function () {
            currentOffset +=  itemOffset;
            // 当平移到相应的位置之后关闭定时器
            if (currentOffset === targetPosition) {
                clearInterval(interval);
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
        updateRidous(next);
    }

    /**
     * 更新圆点
     * @param next
     */
    function updateRidous(next) {

        var targetIndex = 0; // 标识目标圆点

        if (typeof  next === "boolean") {
            if (next) { // 考虑正向翻页的时候
                targetIndex = index + 1;
                if (targetIndex == imgCount) {
                    targetIndex = 0;
                }
            } else { // 考虑逆向翻页的时候
                targetIndex = index - 1;
                if (targetIndex === -1) {
                    targetIndex = imgCount-1;
                }
            }
        } else {
            targetIndex = next;
        }
        
        //修改圆点的样式
        $points[index].className = "";
        $points[targetIndex].className = "on";
        index = targetIndex;
    }
})