"use strict";function menuClick(e,t,o,s){$("."+e).click(function(){var e=$(this).index();$(this).addClass(o).siblings().removeClass(o),$("."+t+":eq("+e+")").addClass(s).siblings().removeClass(s)})}self!=top&&(top.location=self.location);var zto=zto||{};zto.config=zto.config||{};var currentHots=window.location.host;"10.9.21.33:8005"===currentHots||0===currentHots.indexOf("localhost")?(zto.config.serviceUrl="https://hdgateway-test.zto.cn",zto.config.centerceUrl="http://10.9.36.169:8004",zto.config.serviceUrl="https://hdgateway.zto.com",zto.config.centerceUrl="https://my.zto.com",zto.config.domain="10.9.21.33",zto.config.image_serviceUrl="https://mapi-test.zto.cn"):"10.9.36.169:8005"===currentHots?(zto.config.serviceUrl="https://hdgateway-test.zto.cn",zto.config.centerceUrl="http://10.9.36.169:8004",zto.config.domain="10.9.36.169",zto.config.image_serviceUrl="https://mapi-test.zto.cn"):(zto.config.serviceUrl="https://hdgateway.zto.com",zto.config.centerceUrl="https://my.zto.com",zto.config.domain="zto.com",zto.config.image_serviceUrl="https://mapi.zto.com"),zto.utils=zto.utils||{},zto.utils.$c=function(e){return"."===e.substr(0,1)?document.getElementsByClassName(e.substr(1,e.length-1))[0]:document.getElementById(e.substr(1,e.length-1))},zto.utils.setCookieValue=function(e,t,o,s,i){var c=encodeURIComponent(e)+"=";t&&(c+=encodeURIComponent(t)),o&&(c=c+"; expires="+o.toUTCString()),s&&(c=c+"; path="+s),i&&(c=c+";domain="+i),document.cookie=c},zto.utils.getCookieValue=function(e){for(var t=document.cookie.split("; "),o=0;o<t.length;o++)if(t[o]){var s=t[o].split("=");if(2==s.length&&decodeURIComponent(s[0])===e)return decodeURIComponent(s[1]||"")}return null},zto.utils.deleteCookie=function(e,t){var o=encodeURIComponent(e)+"=";o=o+"; expires="+new Date((new Date).getTime()-864e5).toUTCString(),t&&(o=o+"; path="+t),document.cookie=o},zto.utils.decodeURI=function(e){return filterXSS(e)},zto.utils.getQueryString=function(e){var t=new RegExp("(^|&)"+e+"=([^&]*)(&|$)","i"),o=zto.utils.decodeURI(window.location.search).substr(1).match(t);return null!=o?unescape(o[2]):null},zto.client=zto.client||{},zto.client.code={},zto.client.code.wechatMp="wechatMp",zto.client.code.alipayFuwu="alipayFuwu",zto.client.code.qqMp="qqMp",zto.client.code.androidApp="androidApp",zto.client.code.iosApp="iosApp",zto.client.code.wap="wap",zto.client.code.pc="pc",zto.client.agent={},zto.client.agent.wechatMp="MicroMessenger",zto.client.agent.alipayFuwu="AlipayClient",zto.client.agent.qqMp="QQ/",zto.client.agent.androidApp="ZtoAndroid",zto.client.agent.iosApp="ZtoIos",zto.client.agent.wap="Mobile",zto.client.getClientCode=function(){var e=navigator.userAgent;return 0<=e.indexOf(zto.client.agent.wechatMp)?zto.client.code.wechatMp:0<=e.indexOf(zto.client.agent.alipayFuwu)?zto.client.code.alipayFuwu:0<=e.indexOf(zto.client.agent.qqMp)?zto.client.code.qqMp:0<=e.indexOf(zto.client.agent.androidApp)?zto.client.code.androidApp:0<=e.indexOf(zto.client.agent.iosApp)?zto.client.code.iosApp:0<=e.indexOf(zto.client.agent.wap)?zto.client.code.wap:zto.client.code.pc},zto.auth=zto.auth||{},function(){zto.auth.tokenCookieName="OFFICIAL_TOKEN",zto.auth.getTokenInfoByToken=function(e){try{if(!e)return{};var t=e.match(/\..+\./);if(!t||t.length<=0)return{};t=t[0].replace(/\./g,"");var o=window.atob(t);return JSON.parse(o)}catch(e){return{}}},zto.auth.getTokenInfo=function(){var e=zto.auth.getToken();return zto.auth.getTokenInfoByToken(e)},zto.auth.setToken=function(e){zto.utils.setCookieValue(zto.auth.tokenCookieName,e,null,"/",zto.config.domain)},zto.auth.getToken=function(e){return zto.utils.getCookieValue(zto.auth.tokenCookieName)},zto.auth.deleteToken=function(){zto.utils.deleteCookie(zto.auth.tokenCookieName,"/",zto.config.domain)},zto.auth.isAuth=function(e){null==e&&(e=!0);var t=zto.auth.getTokenInfo();if(!t)return!1;if(!t.exp)return!1;var o=(new Date).getTime();return!((1e12<=t.exp?t.exp:1e3*t.exp)-6e5<=o)&&!(e&&!t.userId)};window.location.search.split("=")[1]}();var sendToTimeArr=[];function sendToTime(e){HrPost("getBillArrivalTime",{billCode:e},function(e){if(e.result.status){var t={};t.billCode=e.result.billCode,t.time=e.result.extimaterDate,sendToTimeArr.push(t)}return sendToTimeArr})}function cutOut(e){if(e){return e.replace(/(\d{4})/g,"$1 ").replace(/\s*$/,"")}}function expressCheck(v,b){$(".result-list").html(""),HrPost("WayBill_GetDetail",{billCode:v},function(e){if(e.result){if(null!=e.result){var t,o,s,i,c=e.result,a="";switch(e.result.prescriptionStatus){case 1:t="已取件",o=1,s="telWebsite",i="联系网点","用时"+c.billPrescription;break;case 2:t="运输中",o=2,s="telWebsite",i="联系网点";break;case 3:t="派件中",o=3,s="telCourier",i="联系派件员";break;case 4:t="已送达",o=4,s="graded",i="满意度评分";break;case 5:t="已签收",o=4,s="graded",i="满意度评分"}a+='<div class="result-item">                            <div class="result-top">                                <strong class="numbers"><em>运单号:</em><span>'+cutOut(c.billCode)+'</span><i style="" class="sendTime"></i> </strong>                                <div class="result-static static-'+o+'">                                    <em class="static-text">'+t+'</em>                                </div>                            </div>                            <div class="branch-list">';for(var n=0,l=c.logisticsRecord.length;n<l;n++)for(var r=0,d=c.logisticsRecord[n].length;r<d;r++){var p=c.logisticsRecord[n][r].scanDate.replace("T"," ");switch(0==n&&0==r?(a+='<div class="branch-item first">                                            <div class="branch-circle">最新</div>                                            <div class="branch-line"></div>',"联系派件员"==i?"派件"===c.logisticsRecord[n][r].scanType&&(a+='<span data-order="'+c.billCode+'" class="branch-contact '+s+'" id="btn_telCourier" data-tel="'+c.logisticsRecord[n][r].operateUserPhone+'">'+i+"</span>"):a+='<span data-order="'+c.billCode+'" class="branch-contact '+s+'">'+i+"</span>",a+='<a href="javascript:;" class="map-link" target="_blank">切换地图</a><a href="javascript:;" onclick="jumpService('+c.billCode+')" class="service-link" target="_blank">在线客服</a>',a+='<a href="javascript:;" class="way" target="_blank" data-code="'+c.billCode+'"></a>'):n==c.logisticsRecord.length-1&&r==c.logisticsRecord[n].length-1?a+='<div class="branch-item last">                                        <div class="branch-circle"><em></em></div>                                        <div class="branch-line"></div>':a+='<div class="branch-item">                                        <div class="branch-circle"><em></em></div>                                        <div class="branch-line"></div>',c.logisticsRecord[n][r].scanType){case"签收":console.log("签收",c.logisticsRecord[n][r].scanSite.phone);var g=null;g=1<=(f=(h=c.logisticsRecord[n][r].scanSite.phone)?h.split(/_|、|；|,|，/):[]).length?f[0]:"95311",a+='<p class="branch-text"><em class="city">'+(c.logisticsRecord[n][r].scanSite.city?"【"+c.logisticsRecord[n][r].scanSite.city+"】":"")+'</em>                                        <span>快件已在 <em class="color">【'+(c.logisticsRecord[n][r].scanSite.name?c.logisticsRecord[n][r].scanSite.name:"")+'】</em> 签收，签收人：<em class="color">'+(c.logisticsRecord[n][r].signMan?c.logisticsRecord[n][r].signMan:"")+'</em>，如有疑问请电联：<a href="tel:'+(c.logisticsRecord[n][r].operateUserPhone?c.logisticsRecord[n][r].operateUserPhone:"")+'">（'+(c.logisticsRecord[n][r].operateUserPhone?c.logisticsRecord[n][r].operateUserPhone:"")+"/"+g+"）</a>，您的快递已经妥投，如果您对我们的服务感到满意，请给个五星好评，鼓励一下我们【请在评价快递员处帮忙点亮五颗星星哦~】</span></p>";break;case"第三方签收":a+='<p class="branch-text"><em class="city">'+(c.logisticsRecord[n][r].scanSite.city?"【"+c.logisticsRecord[n][r].scanSite.city+"】":"")+'</em>                                        <span>快件已投递 <em class="color">【'+(c.logisticsRecord[n][r].scanSite.name?c.logisticsRecord[n][r].scanSite.name:"")+'】</em>，如有问题请电联 <a href="tel:'+(c.logisticsRecord[n][r].operateUserPhone?c.logisticsRecord[n][r].operateUserPhone:"")+'">（'+(c.logisticsRecord[n][r].operateUserPhone?c.logisticsRecord[n][r].operateUserPhone:"")+"）</a> 感谢使用中通快递，期待再次为您服务！</span></p>";break;case"退件签收":a+='<p class="branch-text"><em class="city">【'+(c.logisticsRecord[n][r].scanSite.city?c.logisticsRecord[n][r].scanSite.city:"")+'】</em>                                        <span>快件已在 <em class="color">【'+(c.logisticsRecord[n][r].scanSite.name?c.logisticsRecord[n][r].scanSite.name:"")+'】</em> 被 <em class="color">'+(c.logisticsRecord[n][r].scanType?c.logisticsRecord[n][r].scanType:"")+'</em>，签收人：<em class="color">'+(c.logisticsRecord[n][r].signMan?c.logisticsRecord[n][r].signMan:"")+"</em>，感谢使用中通快递，期待再次为您服务！</span></p>";break;case"派件":if(c.logisticsRecord[n][r].internationalPieces.dispCount<=1){a+='<p class="branch-text"><em class="city">【'+(c.logisticsRecord[n][r].scanSite.city?c.logisticsRecord[n][r].scanSite.city:"")+'】</em>                                            <span><em class="color">【'+(c.logisticsRecord[n][r].scanSite.name?c.logisticsRecord[n][r].scanSite.name:"")+'】</em><a class="color" href="tel:'+(c.logisticsRecord[n][r].scanSite.phone?c.logisticsRecord[n][r].scanSite.phone:"")+'">（'+(c.logisticsRecord[n][r].scanSite.phone?c.logisticsRecord[n][r].scanSite.phone:"")+'）</a> 的业务员 <em class="color">'+(c.logisticsRecord[n][r].operateUser?c.logisticsRecord[n][r].operateUser:"")+'</em><a class="operateUserPhone" href="tel:'+(c.logisticsRecord[n][r].operateUserPhone?c.logisticsRecord[n][r].operateUserPhone:"")+'">（'+(c.logisticsRecord[n][r].operateUserPhone?c.logisticsRecord[n][r].operateUserPhone:"")+"）</a> 正在派件【95720为中通快递员外呼专属号码，请放心接听】</span></p>";break}if(1<c.logisticsRecord[n][r].internationalPieces.dispCount){a+='<p class="branch-text"><em class="city">【'+(c.logisticsRecord[n][r].scanSite.city?c.logisticsRecord[n][r].scanSite.city:"")+'】</em>                                            <span>快件已到达 <em class="color">【'+(c.logisticsRecord[n][r].scanSite.name?c.logisticsRecord[n][r].scanSite.name:"")+'】</em><a class="color" href="tel:'+(c.logisticsRecord[n][r].scanSite.phone?c.logisticsRecord[n][r].scanSite.phone:"")+'">（'+(c.logisticsRecord[n][r].scanSite.phone?c.logisticsRecord[n][r].scanSite.phone:"")+'）</a> 业务员<em class="color">'+(c.logisticsRecord[n][r].operateUser?c.logisticsRecord[n][r].operateUser:"")+'</em><a class="operateUserPhone" href="tel:'+(c.logisticsRecord[n][r].operateUserPhone?c.logisticsRecord[n][r].operateUserPhone:"")+'">['+(c.logisticsRecord[n][r].operateUserPhone?c.logisticsRecord[n][r].operateUserPhone:"")+']</a> 正在第<em class="color">'+(c.logisticsRecord[n][r].internationalPieces.dispCount?c.logisticsRecord[n][r].internationalPieces.dispCount:"")+"</em>次派件【95720为中通快递员外呼专属号码，请放心接听】</span></p>";break}case"退件":a+='<p class="branch-text"><em class="city">【'+(c.logisticsRecord[n][r].scanSite.city?c.logisticsRecord[n][r].scanSite.city:"")+'】</em>                                        <span>快件已在 <em class="color">【'+(c.logisticsRecord[n][r].scanSite.name?c.logisticsRecord[n][r].scanSite.name:"")+"】</em> 被退回</span></p>";break;case"问题件":g=null;g=1<=(f=(h=c.logisticsRecord[n][r].scanSite.phone)?h.split(/_|、|；|,|，/):[]).length?"("+f[0]+")":"";var u=c.logisticsRecord[n][r].scanSite.name,m=u.substr(u.length-3);console.log(m),"中转部"===m&&(g=""),a+='<p class="branch-text"><em class="city">【'+(c.logisticsRecord[n][r].scanSite.city?c.logisticsRecord[n][r].scanSite.city:"")+'】</em>                                        <span><em class="color">【'+(c.logisticsRecord[n][r].scanSite.name?c.logisticsRecord[n][r].scanSite.name:"")+'】</em><a href="tel:'+g+'">'+g+'</a> 的业务员 ，<em class="color">'+(c.logisticsRecord[n][r].operateUser?c.logisticsRecord[n][r].operateUser:"")+'</em>已进行<em class="color">'+(c.logisticsRecord[n][r].scanType?c.logisticsRecord[n][r].scanType:"")+'</em>上报，原因：<em class="color">'+(c.logisticsRecord[n][r].problemItemDescription?c.logisticsRecord[n][r].problemItemDescription:"")+"</em></span></p>";break;case"到件":a+='<p class="branch-text"><em class="city">【'+(c.logisticsRecord[n][r].scanSite.city?c.logisticsRecord[n][r].scanSite.city:"")+'】</em>                                        <span>快件已经到达 <em class="color">【'+(c.logisticsRecord[n][r].scanSite.name?c.logisticsRecord[n][r].scanSite.name:"")+"】</em></span></p>";break;case"发件":a+='<p class="branch-text"><em class="city">【'+(c.logisticsRecord[n][r].scanSite.city?c.logisticsRecord[n][r].scanSite.city:"")+'】</em>                                        <span>快件离开 <em class="color">【'+c.logisticsRecord[n][r].scanSite.name+'】</em> 已发往 <em class="color">'+(c.logisticsRecord[n][r].upOrDownSiteInfo?c.logisticsRecord[n][r].upOrDownSiteInfo.name:"【】")+"</em></span></p>";break;case"收件":a+='<p class="branch-text"><em class="city">【'+(c.logisticsRecord[n][r].scanSite.city?c.logisticsRecord[n][r].scanSite.city:"")+'】</em>                                        <span><em class="color">【'+c.logisticsRecord[n][r].scanSite.name+'】</em><a class="color" href="tel:'+c.logisticsRecord[n][r].scanSite.phone+'">（'+c.logisticsRecord[n][r].scanSite.phone+'）</a> 的业务员 <em class="color">'+c.logisticsRecord[n][r].operateUser+'</em><a href="tel:'+c.logisticsRecord[n][r].operateUserPhone+'">（'+c.logisticsRecord[n][r].operateUserPhone+"）</a> 已揽收</span></p>";break;case"ARRIVAL":a+='<p class="branch-text"><em class="city">'+(c.logisticsRecord[n][r].scanSite.city?"【"+c.logisticsRecord[n][r].scanSite.city+"】":"")+'</em>                                        <span>快件已被 <em class="color">【'+c.logisticsRecord[n][r].scanSite.name+'】</em>代收，如有问题请电联<a href="tel:'+c.logisticsRecord[n][r].scanSite.phone+'">（'+(c.logisticsRecord[n][r].scanSite.phone?c.logisticsRecord[n][r].scanSite.phone:"95311")+"）</a>，感谢使用中通快递，期待再次为您服务！</span></p>";break;case"SIGNED":console.log("SIGNED",c.logisticsRecord[n][r].scanSite.phone);var h,f=(h=c.logisticsRecord[n][r].scanSite.phone)?h.split(/_|、|；|,|，/):[];g=null;console.log(f),g=1<=f.length?f[0]:"95311",a+='<p class="branch-text"><em class="city">'+(c.logisticsRecord[n][r].scanSite.city?"【"+c.logisticsRecord[n][r].scanSite.city+"】":"")+'</em>                                        <span>已签收，签收人凭取货码签收，如有疑问请电联：<a href="tel:'+c.logisticsRecord[n][r].operateUserPhone+'">（'+(c.logisticsRecord[n][r].operateUserPhone?c.logisticsRecord[n][r].operateUserPhone:"")+"/"+g+"）</a>，您的快递已经妥投，如果您对我们的服务感到满意，请给个五星好评，鼓励一下我们【请在评价快递员处帮忙点亮五颗星星哦~】</span></p>";break;case"国际处理":if(""==c.logisticsRecord[n][r].scanSite.city){a+='<p class="branch-text"><em class="color">'+c.logisticsRecord[n][r].operateUser+'</em>进行处理：<em class="color">'+c.logisticsRecord[n][r].internationalPieces.optReason+"</em></span></p>";break}a+='<p class="branch-text"><em class="city">【'+c.logisticsRecord[n][r].scanSite.city+'】</em><em class="color">'+c.logisticsRecord[n][r].operateUser+'</em>进行处理：<em class="color">'+c.logisticsRecord[n][r].internationalPieces.optReason+"</em></span></p>";break;case"国际出入库":if(""==c.logisticsRecord[n][r].scanSite.city){a+='<p class="branch-text"><em class="color">'+c.logisticsRecord[n][r].scanSite.name+'</em>的<em class="color">'+c.logisticsRecord[n][r].operateUser+'</em>进行处理：<em class="color">'+c.logisticsRecord[n][r].internationalPieces.optReason+"</em></span></p>";break}a+='<p class="branch-text"><em class="city">【'+c.logisticsRecord[n][r].scanSite.city+'】</em><em class="color">'+c.logisticsRecord[n][r].scanSite.name+'</em>的<em class="color">'+c.logisticsRecord[n][r].operateUser+'</em>进行处理：<em class="color">'+c.logisticsRecord[n][r].internationalPieces.optReason+"</em></span></p>";break;default:a+='<p class="branch-text"><span>'+c.logisticsRecord[n][r].stateDescription+"</span></p>"}a+='<p class="branch-time">'+p+"</p>                                </div>"}a+='<span class="result-add"><span>展开更多</span><i></i></span>                            </div>                        </div>';var R=$(a);$(".result-list").append(R),HrPost("getBillArrivalTime",{billCode:""},function(e){if("已签收"!==R.find(".static-text").text()&&"已送达"!==R.find(".static-text").text()||R.find(".sendTime").html(" "),console.log("extimaterDate",e),e.result.extimaterDate&&"已签收"!=R.find(".static-text").text()&&"已送达"!=R.find(".static-text").text()){var t=new Date(e.result.extimaterDate.replace(/-/g,"/")),o=null;o=11<t.getHours()?"下午":"上午",new Date>new Date(e.result.extimaterDate)&&(t=new Date);var s="预计"+t.getDate()+"号"+o+"送达";R.find(".sendTime").html(s)}else R.find(".sendTime").html("")}),ztoIsLogin&&HrPost("Order_CheckMobileByCod",{billCode:v},function(e){e.status&&(e.result.isReceiver||e.result.isSender)&&(R.find(".way").attr("class","way e-waybill"),R.find(".way").text("电子底单"))}),$(".result-item:eq(0)").find(".branch-item").addClass("show"),$(".result-item:eq(0)").find(".result-add").addClass("hide").find("span").html("收起内容"),codeCookie(v,t),b&&HrPost("waybill_qrCodeCreate",{billCode:v},function(e){e.status&&$("#subscribeQrCode").attr("src",e.result).show()})}}else $(".result-list").append('<div class="result-item">                                        <div class="result-top">                                            <strong class="numbers"><em>运单号:</em><span>'+v+'</span></strong>                                        </div>                                        <div class="result-message">没有运单信息</div>                                      </div>');$(".search_btn").removeClass("notclick")})}var billInfoList=[],ztoIsLogin=zto.auth.getToken();function codeCookie(e,t){var o=0,s=getCookie("codes");if(null==s||null==s)setCookie("codes",e+"-"+t),"无"!=$(".lately-record i").html()&&($(".lately-record").removeClass("not"),$(".record-arrow").after('<em class="record-item"><span>'+e+"</span><i></i></em>")),$(".lately-record i").html(e.split(",").length);else{for(var i=s.split(","),c=0;c<i.length;c++){e!=i[c].split("-")[0]&&o++}if(o==i.length){10<=i.length&&(i.shift(),$(".record-item").last().remove()),$(".record-arrow").after('<em class="record-item"><span>'+e+"</span><i></i></em>"),i.push(e+"-"+t),setCookie("codes",i.join(","));var a;(a=Number(e.split(",").length)+Number($(".lately-record i").html()))<11&&$(".lately-record i").html(a)}}}function HrPost(e,t,o,s,i){if(i=$.isFunction(s)?i||"json":null==s?"json":s,o&&$.isFunction(o)&&(s=o,o=!1),o){$("body").append('<div class="ajaxLoading"><div class="loader">加载中...</div></div>'),$(".ajaxLoading").show(),o=!1}t&&t.HEADERS?$.ajax({type:"post",url:zto.config.serviceUrl+"/"+e,headers:{"x-token":zto.auth.getToken(),"x-clientCode":zto.client.getClientCode(),"x-captcha-id":t.HEADERS.id,"x-captcha-code":t.HEADERS.code},data:t,cache:!1,crossDomain:1==!document.all}).done(function(e){o||$(".ajaxLoading").hide(),null!=e&&""!=e&&s&&($.isFunction(s)?s(e):console.log("callBack is not a function"))}).fail(function(e){console.log("数据请求失败")}):$.ajax({type:"post",url:zto.config.serviceUrl+"/"+e,headers:{"x-token":zto.auth.getToken(),"x-clientCode":zto.client.getClientCode()},data:t,cache:!1,crossDomain:1==!document.all}).done(function(e){o||$(".ajaxLoading").hide(),null!=e&&""!=e&&s&&($.isFunction(s)?s(e):console.log("callBack is not a function"))}).fail(function(e){console.log("数据请求失败")})}function WebsitePost(e,t,o,s,i){if(i=$.isFunction(s)?i||"json":null==s?"json":s,o&&$.isFunction(o)&&(s=o,o=!1),o){$("body").append('<div class="ajaxLoading"><div class="loader">加载中...</div></div>'),$(".ajaxLoading").show(),o=!1}$.ajax({type:"post",url:zto.config.serviceUrl+"/"+e,headers:{"x-token":zto.auth.getToken(),"x-clientCode":zto.client.getClientCode()},data:t,cache:!1,contentType:"application/json",crossDomain:1==!document.all}).done(function(e){o||$(".ajaxLoading").hide(),null!=e&&""!=e&&s&&($.isFunction(s)?s(e):console.log("callBack is not a function"))}).fail(function(e){console.log("数据请求失败")})}function ImgRunOpcity_html5(t,o,s,i,c,a,n,l){var r=$(t+" "+o).size(),e=0;for(e=0;e<r;e++)$(""+s).append("<span class='"+i+"'>"+(e+1)+"</span>");function n(e){$(t+" "+o).removeClass("run"),$(t+" "+o).eq(e).addClass("run"),$(s+" ."+i).removeClass("cur"),$(s+" ."+i).eq(e).addClass("cur")}c=null,$(t+" "+o).eq(0).addClass("run"),$(s+" ."+i).eq(0).addClass("cur"),$(s+" ."+i).each(function(e){$(this).click(function(){a(e),n(e)})}),a=function(e){clearInterval(c),c=setInterval(function(){n(++e<r?e:e=0)},l),$(""+t).hover(function(){clearInterval(c)},function(){clearInterval(c),c=setInterval(function(){n(++e<r?e:e=0)},l)})},1<r?a(0):($(t+" "+o).eq(0).addClass("run"),$(s).hide())}function ImgRunOpcity(t,o,s,i,c,a,n,l){var r=$(t+" "+o).size(),e=0;for(e=0;e<r;e++)$(""+s).append("<span class='"+i+"'>"+(e+1)+"</span>");function n(e){$(t+" "+o).fadeOut(200),$(t+" "+o).eq(e).fadeIn(400),$(s+" ."+i).removeClass("cur"),$(s+" ."+i).eq(e).addClass("cur")}c=null,$(t+" "+o).eq(0).show(),$(s+" ."+i).eq(0).addClass("cur"),$(s+" ."+i).each(function(e){$(this).click(function(){a(e),n(e)})}),a=function(e){clearInterval(c),c=setInterval(function(){n(++e<r?e:e=0)},l),$(""+t).hover(function(){clearInterval(c)},function(){clearInterval(c),c=setInterval(function(){n(++e<r?e:e=0)},l)})},1<r?a(0):($(t+" "+o).eq(0).fadeIn(500),$(s).hide())}function GetQueryString(e){var t=new RegExp("(^|&)"+name+"=([^&]*)(&|$)"),o=zto.utils.decodeURI(window.location.search).substr(1).match(t);return null!=o?unescape(o[2]):null}function getCookie(e){var t,o=new RegExp("(^| )"+e+"=([^;]*)(;|$)");return(t=document.cookie.match(o))?unescape(t[2]):null}function delCookie(e){var t=new Date;t.setTime(t.getTime()-1);var o=getCookie(e);null!=o&&(document.cookie=e+"="+o+";expires="+t.toGMTString()+"; path=/")}function setCookie(e,t){var o=new Date;o.setTime(o.getTime()+2592e6),document.cookie=e+"="+escape(t)+";expires="+o.toGMTString()+"; path=/"}function ztoAlert(e,t,o,s){$("body").append('<div class="alert">\t\t\t\t\t\t<span class="alert-close"></span>\t\t\t\t\t\t<strong class="alert-title">'+e+'</strong>\t\t\t\t\t\t<div class="alert-text">\t\t\t\t\t\t\t<p>'+t+'</p>\t\t\t\t\t\t</div>\t\t\t\t\t\t<em class="alert-btn '+s+'">'+o+"</em>\t\t\t\t\t</div>"),$(".alert").addClass("show").css("margin-top","-"+($(".alert").height()/2+40)+"px")}billInfoList=[{billCode:"776687777"},{billCode:"47392749347329"},{billCode:"424242342342",info:{sendName:"fdfs",sendPro:"上海"}}],$(document).on("click",".alert-close,.alert-btn",function(){$(".alert").remove()}),$(document).on("click",".toLogin",function(){$(this).parent().data("code");location.href=zto.config.centerceUrl});var data=[];function getAddressId(e,t,o){for(var s=null,i=null,c=null,a=0,n=data.length;a<n;a++)if(e&&~e.indexOf(data[a].text)){s=data[a].value;for(var l=0,r=data[a].children.length;l<r;l++)if(t&&~t.indexOf(data[a].children[l].text)){i=data[a].children[l].value;for(var d=0,p=data[a].children[l].children.length;d<p;d++)if(o&&~o.indexOf(data[a].children[l].children[d].text)){c=data[a].children[l].children[d].value;break}break}break}return s+","+i+","+c}function aaa(){var o="";HrPost("DoubleGen_GetList",function(e){for(var t=0;t<e.resultResponse.items.length;t++)o+='<li><div><a href="/companyIntroduce/innovationDetails?id=7d679289-6b91-420c-9375-305564988c10"><img src="'+e.resultResponse.items[t].imagesUrl+'" alt="推荐人物"></a></div><h1><a href="/companyIntroduce/innovationDetails?id=7d679289-6b91-420c-9375-305564988c10">'+e.resultResponse.items[t].figureName+":"+e.resultResponse.items[t].figureMotto+"</a></h1><span>"+e.resultResponse.items[t].figureArea+"</span></li>";$(".new-recommend").append(o)})}function jumpService(e){var t=zto.auth.getToken(),o="https://kfapi.zto.com/im?channel=official";e&&(o+="&billCode="+e),t&&(o+="&token="+t),window.open(o)}function pubService(){var e=zto.auth.getToken(),t="https://kfapi.zto.com/im?channel=official";e&&(t+="&token="+e),$("#contactUs").attr("href",t)}function getRegionData(t){var e=sessionStorage.getItem("allRegionData");e?t(JSON.parse(e)):$.ajax({type:"POST",url:"https://hdgatewaycdn.zto.com/get_basearea",dataType:"json",success:function(e){t(e.result),sessionStorage.setItem("allRegionData",JSON.stringify(e.result))},error:function(e){console.warn(e)}})}getRegionData(function(e){data=e}),pubService();