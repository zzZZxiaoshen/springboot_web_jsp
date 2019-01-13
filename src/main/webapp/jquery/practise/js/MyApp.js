
/*
 1. 鼠标移入显示,移出隐藏
 目标: 手机京东, 客户服务, 网站导航, 我的京东, 去购物车结算, 全部商品
 2. 鼠标移动切换二级导航菜单的切换显示和隐藏
 3. 输入搜索关键字, 列表显示匹配的结果
 4. 点击显示或者隐藏更多的分享图标
 5. 鼠标移入移出切换地址的显示隐藏
 6. 点击切换地址tab

 7. 鼠标移入移出切换显示迷你购物车
 8. 点击切换产品选项 (商品详情等显示出来)

 9. 点击向右/左, 移动当前展示商品的小图片
 10. 当鼠标悬停在某个小图上,在上方显示对应的中图
 11. 当鼠标在中图上移动时, 显示对应大图的附近部分区域
 */

/*
1. 对哪个/些元素绑定什么监听?
2. 对哪个/些元素进行什么DOM操作?
 */

$(function () {
    fristMun();
    senMun();
    serch();
    share()
   /* 1. 鼠标移入显示,移出隐藏
    目标: 手机京东, 客户服务, 网站导航, 我的京东, 去购物车结算, 全部商品*/
    function fristMun() {
      $("[name=show_hide]").hover(function () {
          var itemsId=$(this).children(":last").attr("id");
          $("#"+itemsId).show();
      },function () {
          var itemsId=$(this).children(":last").attr("id");
          $("#"+itemsId).hide();
      })
    }
    // 2. 鼠标移动切换二级导航菜单的切换显示和隐藏
    function senMun() {
      $("#category_items >div").hover(function () {
          $(this).find("div").show();
      },function () {
          $(this).find("div").hide();
      })
    }

    // 3. 输入搜索关键字, 列表显示匹配的结果
   function serch() {
     $("#txtSearch").on('keyup focus',function () {
         // 如果输入框有文本才显示列表
         var txt = this.value.trim()
         if(txt) {
             $('#search_helper').show()
         }
     }).blur(function () {
         // 隐藏列表
         $('#search_helper').hide()
     })
   }

    // 4. 点击显示或者隐藏更多的分享图标
    function share() {
        var isOpen = false; //标识当前的状态(初始为关闭)
        var $shareMore = $("#shareMore");
        var $parent = $shareMore.parent();
        var $prevAll = $shareMore.prevAll("a:lt(2)");
        var $b = $shareMore.children("b");
        $shareMore.click(function () {

            if (isOpen) {  //去关闭
                $parent.css('width', 155)
                $prevAll.hide();
                $b.removeClass("backword");
            }else {  // 去打开
                $parent.css("width", 200);
                $prevAll.show();
                $b.addClass("backword");
            }
            isOpen = !isOpen;
        })

    }
})