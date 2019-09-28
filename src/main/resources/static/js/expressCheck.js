!function (s) {
    var t = {};

    function n(e) {
        if (t[e]) {
            return t[e].exports;
        }
        var i = t[e] = {exports: {}, id: e, loaded: !1};
        return s[e].call(i.exports, i, i.exports, n), i.loaded = !0, i.exports
    }

    n.m = s, n.c = t, n.p = "", n(0)
}({
    0: function (e, i, s) {
        e.exports = s(16)
    }, 3: function (e, i) {
        function s() {
        }

        $.extend(s.prototype, {
            init: function () {
                this.fixed(), this.footerLoad(), this.handleClickSucc(), this.login()
            }, footerLoad: function () {
                $("#js-footer-wrap").on("mouseenter", ".friendLink a", function () {
                    $(this).next().css({display: "block"}), $(this).find("span").addClass("actived")
                }).on("mouseout", ".friendLink a", function () {
                    $(this).next().css({display: "none"}), $(this).find("span").removeClass("actived")
                })
            }, login: function () {
                0 <= navigator.userAgent.indexOf("Mobile") && (window.location.href = "https://m.zto.com/"), zto.auth.getToken() && HrPost("auth_account_getUserLoginProvider", null, function (e) {
                    e.status && ($(".login,.registere").hide(), $(".header-right").append('<div class="user">\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src="./images/login.png" alt="用户"><a href="' + zto.config.centerceUrl + '" data-phone="' + e.result.mobile + '">' + e.result.mobile + "</a>\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>"), $(".user").show())
                })
            }, fixed: function () {
                if (0 < $(".js-nav-fixed").size()) {
                    var t = $(".js-nav-fixed"), n = $(".content-main").offset().top;
                    $(document).on("scroll", function () {
                        var e = $(document).scrollTop();
                        if (n < e) {
                            t.css("top", e - n + "px");
                            var i = t.offset().top - n, s = $(".content-main").height() - t.height();
                            s <= i ? t.css("top", s + "px") : t.css("top", e - n + "px")
                        } else {
                            t.css({position: "absolute", top: "0px"})
                        }
                    })
                }
            }, handleClickSucc: function () {
                $(".nav-item").bind("click", $.proxy(this.handleCliclNav, this)), $(document).on("click", ".js-back-top", $.proxy(this.handleClickBackTop, this)), $(".js-job").bind("click", $.proxy(this.handleClickJob, this)), $(".js-finance").bind("click", $.proxy(this.handleClickFinance, this)), $(".js-goHr").bind("click", $.proxy(this.handleClickJob, this)), $(".js-investor-relations").bind("click", $.proxy(this.handleClickInvestorRelations, this)), $(".js-join").bind("click", $.proxy(this.handleClickCooperation, this)), $(".js-about").bind("click", $.proxy(this.handleClickAbout, this)), $(".js-home-page").bind("click", $.proxy(this.handleClickHomePage, this)), $(".js-express-check").bind("click", $.proxy(this.handleClickExpressCheck, this)), /*$(".js-express-website").bind("click", $.proxy(this.handleClickExpressWebsite, this)),*/ $(".js-express-price").bind("click", $.proxy(this.handleClickExpressPrice, this)), $(".js-express-prohibited").bind("click", $.proxy(this.handleClickExpressProhibited, this)), $(".js-express-questions").bind("click", $.proxy(this.handleClickExpressQuestions, this)), $(".js-express-suggest").bind("click", $.proxy(this.handleClickExpressSuggest, this)), $(".js-business,.js-business-morrow").bind("click", $.proxy(this.handleClickBusinessMorrow, this)), $(".js-business-onAlternateDays").bind("click", $.proxy(this.handleClickBusinessOnAlternateDays, this)), $(".js-business-triduum").bind("click", $.proxy(this.handleClickBusinessTriduum, this)), $(".js-business-privacySurfaceSingle").bind("click", $.proxy(this.handleClickBusinessPrivacySurfaceSingle, this)), $(".js-business-freshDelivery").bind("click", $.proxy(this.handleClickBusinessFreshDelivery, this)), $(".js-business-recheneinheit").bind("click", $.proxy(this.handleClickBusinessRecheneinheit, this)), $(".js-business-enterpriseOrder").bind("click", $.proxy(this.handleClickBusinessEnterpriseOrder, this)), $(".js-business-cloudPrint").bind("click", $.proxy(this.handleClickBusinessCloudPrint, this)), $(".js-business-theDoorToTake").bind("click", $.proxy(this.handleClickBusinessTheDoorToTake, this)), $(".js-business-generationOfPickup").bind("click", $.proxy(this.handleClickBusinessGenerationOfPickup, this)), $(".js-business-payOnDelivery").bind("click", $.proxy(this.handleClickBusinessPayOnDelivery, this)), $(".js-business-freightCollectExpressItem").bind("click", $.proxy(this.handleClickBusinessFreightCollectExpressItem, this)), $(".js-business-signTheBillToReturn").bind("click", $.proxy(this.handleClickBusinessSignTheBillToReturn, this)), $(".js-business-supportValue").bind("click", $.proxy(this.handleClickBusinessSupportValue, this)), $(".js-business-afterSalesService").bind("click", $.proxy(this.handleClickBusinessAfterSalesService, this)), $(".js-business-hongkong").bind("click", $.proxy(this.handleClickBusinessHongkong, this)), $(".js-business-hongkongDhl").bind("click", $.proxy(this.handleClickBusinessHongkongDhl, this)), $(".js-business-taiwan").bind("click", $.proxy(this.handleClickBusinessTaiwan, this)), $(".js-business-ztoEms").bind("click", $.proxy(this.handleClickBusinessZtoEms, this)), $(".js-business-russia").bind("click", $.proxy(this.handleClickBusinessRussia, this)), $(".js-business-more").bind("click", $.proxy(this.handleClickMore, this)), $(".js-business-russian").bind("click", $.proxy(this.handleClickBusinessRussian, this)), $(".js-business-india").bind("click", $.proxy(this.handleClickBusinessIndia, this)), $(".js-business-europe").bind("click", $.proxy(this.handleClickBusinessEurope, this)), $(".js-business-england").bind("click", $.proxy(this.handleClickBusinessEngland, this)), $(".js-business-switzerlandOne").bind("click", $.proxy(this.handleClickBusinessSwitzerlandOne, this)), $(".js-business-switzerlandTwo").bind("click", $.proxy(this.handleClickBusinessSwitzerlandTwo, this)), $(".js-business-international").bind("click", $.proxy(this.handleClickBusinessInternational, this)), $(".js-business-australia").bind("click", $.proxy(this.handleClickBusinessAustralia, this)), $(".js-business-cloudPrint").bind("click", $.proxy(this.handleClickBusinessCloudPrint, this)), $(".js-case-personage").bind("click", $.proxy(this.handleClickCasePersonage, this)), $(".js-case-merchant").bind("click", $.proxy(this.handleClickCaseMerchant, this)), $(".js-case-website").bind("click", $.proxy(this.handleClickCaseWebsite, this)), $(".js-case-detail_01").bind("click", $.proxy(this.handleClickCaseDetail_01, this)), $(".js-legal-statement").bind("click", $.proxy(this.handleClickLegalStatement, this)), $(".js-privacy-protection").bind("click", $.proxy(this.handleClickPrivacyProtection, this)),
                    $(".js-cookie-protection").bind("click", $.proxy(this.handleClickCookieProtection, this)),
                    /*$(".js-express-ship").bind("click", $.proxy(this.expressShip, this)),*/ $(".logo-box").bind("click", $.proxy(this.toIndex, this)), $(".js-business-korea").bind("click", $.proxy(this.handleClickContactKorea, this)), $(".js-business-japan").bind("click", $.proxy(this.handleClickContactJapan, this)), $(".js-contact-us").bind("click", $.proxy(this.handleClickContactUs, this)), $(".js-company-profile").bind("click", $.proxy(this.handleClickCompanyProfile, this)), $(".js-enterprise-video").bind("click", $.proxy(this.handleClickEnterpriseVideo, this)), $(".js-leadership-concern").bind("click", $.proxy(this.handleClickLeadershipConcern, this)), $(".js-corporate-development").bind("click", $.proxy(this.handleClickCorporateDevelopment, this)), $(".js-corporate-culture").bind("click", $.proxy(this.handleClickCorporateCulture, this)), $(".js-responsibility-honor").bind("click", $.proxy(this.handleClickResponsibilityHonor, this)), $(".js-charity").bind("click", $.proxy(this.handleClickCharity, this)), $(".js-new-list").bind("click", $.proxy(this.handleClickNewList, this)), $(".js-one-day").bind("click", $.proxy(this.handleClickOneDay, this)), $(".js-innovation").bind("click", $.proxy(this.handleClickInnovation, this)), $(".js-industry-new").bind("click", $.proxy(this.handleClickIndustryNews, this)), $(".js-express-outlets").bind("click", $.proxy(this.handleClickExpressOutlets, this)), $(".js-cooperate").bind("click", $.proxy(this.handleClickBusiness, this)), $(".js-supplier").bind("click", $.proxy(this.handleClicksupplier, this)), $(".js-case").bind("click", $.proxy(this.handleBotton, this)), $(".js-zpa").bind("click", $.proxy(this.handleClickZpaHome, this)), $(".js-zop").bind("click", $.proxy(this.handleClickZopHome, this)), $(".js-supermarket").bind("click", $.proxy(this.handleClickSupermarket, this)), $(".js-business-cloudChamber").bind("click", $.proxy(this.handleClickCloudChamber, this)), $(".js-business-serviceProducts").bind("click", $.proxy(this.handleClickServiceProducts, this)), $(".js-business-serviceScope").bind("click", $.proxy(this.handleClickServiceScope, this)), $(".js-business-cooperativePartner").bind("click", $.proxy(this.handleClickCooperativePartner, this)), $(".js-business-electronicsSurfaceSingle").bind("click", $.proxy(this.handleClickElectronicsSurfaceSingle, this)), $(".js-business-americaSmall").bind("click", $.proxy(this.handleClickBusinessAmericaSmall, this)), $(".js-business-americaFba").bind("click", $.proxy(this.handleClickBusinessAmericaFba, this)), $(".js-business-australiaFba").bind("click", $.proxy(this.handleClickBusinessAustraliaFba, this)), $(".js-business-canadaFba").bind("click", $.proxy(this.handleClickBusinessCanadaFba, this)), $(".js-business-europeFba").bind("click", $.proxy(this.handleClickBusinessEuropeFba, this)), $(".js-business-ctamSmall").bind("click", $.proxy(this.handleClickBusinessCtamSmall, this)), $(".js-business-depx").bind("click", $.proxy(this.handleClickBusinessDepx, this)), $(".js-investor-news").bind("click", $.proxy(this.handleClickInvestorNew, this)), $(".js-investor-report").bind("click", $.proxy(this.handleClickInvestorReport, this)), $(".js-investor-corporate").bind("click", $.proxy(this.handleClickInvestorCorporate, this)), $(".js-investor-email").bind("click", $.proxy(this.handleClickInvestorEmail, this)), $(".js-investor-vedio").bind("click", $.proxy(this.handleClickInvestorVedio, this)), $(".js-investor-liaison").bind("click", $.proxy(this.handleClickInvestorLiaison, this)), $(".js-report-financial").bind("click", $.proxy(this.handleClickFinancial, this)), $(".js-report-notice").bind("click", $.proxy(this.handleClickNotice, this)), $(".js-stock-price").bind("click", $.proxy(this.handleClickStockPrice, this)), $(".js-report-investor-relations").bind("click", $.proxy(this.handleClickReportInvestorRelations, this)), $(".js-report-social-responsibility").bind("click", $.proxy(this.handleClickSocialResponsibility, this)), $(".header-middle ul li").hover(function () {
                    var e = $(this).index();
                    $(".business-menu").removeClass("index-1"), $(".business-menu").removeClass("index-2"), $(".business-menu").removeClass("index-3"), $(".business-menu").removeClass("index-4"), $(".business-menu").removeClass("index-5"), $(this).find(".business-menu").addClass("index-" + e).show()
                }, function () {
                    $(this).find(".business-menu").hide()
                }), $(".siteTxt").click(function (e) {
                    SelCity(this, e)
                }), $(".stateTxt").click(function (e) {
                    SelState(this, e)
                }),$(".registere").click(function () {
                    location.href = "login-nose.html"
                }),$(".login").click(function () {
                    window.open(zto.config.centerceUrl, "_blank")
                })
            }, handleCliclNav: function (e) {
                var i = $(e.target).parent();
                0 < i.find(".nav-zto-menu").length && (i.hasClass("show") ? i.removeClass("show") : i.addClass("show"))
            }, handleClickHomePage: function () {
                location.href = "../../templates/nose.html"
            }, handleClickBackTop: function () {
                $("body, html").animate({scrollTop: "0"}, 200)
            }, handleClickAbout: function () {
                location.href = "../companyIntroduce/companyProfile.html"
            }, handleClickJob: function () {
                window.open("http://hr.zto.com")
            }, handleClickFinance: function () {
                window.open("https://www.ztofinance.com/")
            }, gohrclick: function () {
                window.open("http://www.hotjob.cn/wt/ZTO/web/index?brandCode=1")
            }, handleClickInvestorRelations: function () {
                window.open("http://zto.investorroom.com/")
            }, handleClickCooperation: function () {
                location.href = "../league/expressOutlets.html"
            }, handleClickExpressCheck: function () {
                location.href = "../express/expressCheck.html"
            }, handleClickExpressWebsite: function () {
                location.href = "../express/expressWebsite.html"
            }, handleClickExpressPrice: function () {
                location.href = "../express/expressPrice.html"
            }, handleClickExpressProhibited: function () {
                location.href = "../express/expressProhibited.html"
            }, handleClickExpressComplain: function () {
                location.href = "../express/expressComplain.html"
            }, handleClickExpressQuestions: function () {
                location.href = "https://my.zto.com/faq"
            }, handleClickExpressSuggest: function () {
                location.href = "https://my.zto.com/feedback"
            }, handleClickBusinessMorrow: function () {
                location.href = "../business/morrow.html"
            }, handleClickBusinessOnAlternateDays: function () {
                location.href = "../business/onAlternateDays.html"
            }, handleClickBusinessTriduum: function () {
                location.href = "../business/triduum.html"
            }, handleClickBusinessPrivacySurfaceSingle: function () {
                location.href = "../business/privacySurfaceSingle.html"
            }, handleClickBusinessFreshDelivery: function () {
                location.href = "../business/freshDelivery.html"
            }, handleClickBusinessRecheneinheit: function () {
                location.href = "../business/recheneinheit.html"
            }, handleClickBusinessEnterpriseOrder: function () {
                location.href = "../business/enterpriseOrder.html"
            }, handleClickBusinessCloudPrint: function () {
                location.href = "../business/cloudPrint.html"
            }, handleClickBusinessTheDoorToTake: function () {
                location.href = "../business/theDoorToTake.html"
            }, handleClickBusinessGenerationOfPickup: function () {
                location.href = "../business/generationOfPickup.html"
            }, handleClickBusinessPayOnDelivery: function () {
                location.href = "../business/payOnDelivery.html"
            }, handleClickBusinessFreightCollectExpressItem: function () {
                location.href = "../business/freightCollectExpressItem.html"
            }, handleClickBusinessSignTheBillToReturn: function () {
                location.href = "../business/signTheBillToReturn.html"
            }, handleClickBusinessSupportValue: function () {
                location.href = "../business/supportValue.html"
            }, handleClickBusinessAfterSalesService: function () {
                location.href = "../business/afterSalesService.html"
            }, handleClickBusinessHongkong: function () {
                location.href = "../business/hongkong.html"
            }, handleClickBusinessHongkongDhl: function () {
                location.href = "../business/hongkongDhl.html"
            }, handleClickBusinessTaiwan: function () {
                location.href = "../business/taiwan.html"
            }, handleClickBusinessRussia: function () {
                location.href = "../business/russia.html"
            }, handleClickMore: function () {
                window.open("http://g.zto.com")
            }, handleClickBusinessZtoEms: function () {
                location.href = "../business/ztoEms.html"
            }, handleClickBusinessRussian: function () {
                location.href = "../business/russian.html"
            }, handleClickBusinessEurope: function () {
                location.href = "../business/europe.html"
            }, handleClickBusinessEngland: function () {
                location.href = "../business/england.html"
            }, handleClickBusinessIndia: function () {
                location.href = "../business/india.html"
            }, handleClickBusinessAmericaSmall: function () {
                location.href = "../business/americaSmall.html"
            }, handleClickBusinessSwitzerlandOne: function () {
                location.href = "../business/switzerlandOne.html"
            }, handleClickBusinessSwitzerlandTwo: function () {
                location.href = "../business/switzerlandTwo.html"
            }, handleClickBusinessInternational: function () {
                location.href = "../business/international.html"
            }, handleClickBusinessAustralia: function () {
                location.href = "../business/australia.html"
            }, handleClickBusinessCloudPrint: function () {
                location.href = "../business/cloudPrint.html"
            }, handleClickCasePersonage: function () {
                location.href = "../case/personage.html"
            }, handleClickCaseMerchant: function () {
                location.href = "../case/merchant.html"
            }, handleClickCaseWebsite: function () {
                location.href = "../case/website.html"
            }, handleClickCaseDetail_01: function () {
                location.href = "../case/caseDetail_01.html"
            }, handleClickLegalStatement: function () {
                location.href = "../legal&privacy/legal.html"
            }, handleClickPrivacyProtection: function () {
                location.href = "../legal&privacy/privacy.html"
            }, handleClickCookieProtection: function () {
                location.href = "../legal&privacy/cookie.html"
            }, toIndex: function () {
                location.href = "../../templates/nose.html"
            }, handleClickContactKorea: function () {
                location.href = "../business/korea.html"
            }, handleClickContactJapan: function () {
                location.href = "../business/japan.html"
            }, handleClickContactUs: function () {
                location.href = "../companyIntroduce/contactUs.html"
            }, handleClickCompanyProfile: function () {
                location.href = "../companyIntroduce/companyProfile.html"
            }, handleClickEnterpriseVideo: function () {
                location.href = "../companyIntroduce/enterpriseVideo.html"
            }, handleClickCharity: function () {
                location.href = "../companyIntroduce/charityProgram.html"
            }, handleClickNewList: function () {
                location.href = "../companyIntroduce/newList.html"
            }, handleClickLeadershipConcern: function () {
                location.href = "../companyIntroduce/leadershipConcern.html"
            }, handleClickCorporateDevelopment: function () {
                location.href = "../companyIntroduce/corporateDevelopment.html"
            }, handleClickCorporateCulture: function () {
                location.href = "../companyIntroduce/corporateCulture.html"
            }, handleClickResponsibilityHonor: function () {
                location.href = "../companyIntroduce/responsibilityHonor.html"
            }, handleClickOneDay: function () {
                location.href = "../companyIntroduce/oneDay.html"
            }, handleClickInnovation: function () {
                location.href = "../companyIntroduce/innovation.html"
            }, handleClickIndustryNews: function () {
                location.href = "../companyIntroduce/industryNews.html"
            }, handleClickExpressOutlets: function () {
                location.href = "../league/expressOutlets.html"
            }, handleClickBusiness: function () {
                location.href = "../league/cooperate.html"
            }, handleClicksupplier: function () {
                location.href = "../league/supplier.html"
            }, handleBotton: function () {
                location.href = "../case/merchant.html"
            }, handleClickZpaHome: function () {
                window.open("https://zpa.zto.com")
            }, handleClickZopHome: function () {
                window.open("http://zop.zto.com")
            }, handleClickSupermarket: function () {
                window.open("https://wjsso.zto.com/oauth2/authorize?appid=zt-oNKHuI_ViWtkBdmbiIk1w&redirect_uri=http%3a%2f%2fwj.zto.com%2fAccount%2fAuthorize&response_type=code&scope=userinfo&state=3eb79d2915844534a23f4c3ff1c3cedb")
            }, handleClickCloudChamber: function () {
                location.href = "../business/cloudChamber.html"
            }, handleClickServiceProducts: function () {
                location.href = "../business/serviceProducts.html"
            }, handleClickServiceScope: function () {
                location.href = "../business/serviceScope.html"
            }, handleClickCooperativePartner: function () {
                location.href = "../business/cooperativePartner.html"
            }, handleClickElectronicsSurfaceSingle: function () {
                location.href = "../business/electronicsSurfaceSingle.html"
            }, expressShip: function () {
                window.open("https://my.zto.com/create")
            }, handleClickBusinessAmericaFba: function () {
                location.href = "../business/americaFba.html"
            }, handleClickBusinessAustraliaFba: function () {
                location.href = "../business/australiaFba.html"
            }, handleClickBusinessCanadaFba: function () {
                location.href = "../business/canadaFba.html"
            }, handleClickBusinessEuropeFba: function () {
                location.href = "../business/europeFba.html"
            }, handleClickBusinessCtamSmall: function () {
                location.href = "../business/ctamSmall.html"
            }, handleClickBusinessDepx: function () {
                location.href = "../business/depx.html"
            }, handleClickInvestorNew: function () {
                location.href = "../investorRelations/newsInformation.html"
            }, handleClickInvestorReport: function () {
                location.href = "../investorRelations/periodicReport.html"
            }, handleClickInvestorCorporate: function () {
                location.href = "../investorRelations/corporateGovernance.html"
            }, handleClickInvestorEmail: function () {
                location.href = "../investorRelations/mailSubscriptions.html"
            }, handleClickInvestorVedio: function () {
                location.href = "../investorRelations/companyVedio.html"
            }, handleClickInvestorLiaison: function () {
                location.href = "../investorRelations/investorLiaison.html"
            }, handleClickFinancial: function () {
                location.href = "../investorRelations/periodicReport.html?checkedId=0"
            }, handleClickNotice: function () {
                location.href = "../investorRelations/periodicReport.html?checkedId=1"
            }, handleClickReportInvestorRelations: function () {
                location.href = "../investorRelations/periodicReport.html?checkedId=2"
            }, handleClickSocialResponsibility: function () {
                location.href = "../investorRelations/periodicReport.html?checkedId=3"
            }, handleClickStockPrice: function () {
                location.href = "../investorRelations/stockPrice.html"
            }
        }), (new s).init()
    }, 16: function (e, i, s) {
        function m() {
            if (0 < $(".ex_item").size()) {
                $(this).addClass("notclick");
                var e = [];
                $(".search_txt .ex_item").each(function () {
                    e.push($(this).find("span").html())
                });
                for (var i = 0; i < e.length; i++) {
                    var s = 0 === i;
                    expressCheck(e[i], s)
                }
                $(".ship-again").css("display", "block"), $("html,body").animate({scrollTop: 700}, 500)
            } else {
                ztoAlert("提示", "请正确填写运单号码!", "确定", "close")
            }
        }

        function f(e, i) {
            e ? 0 <= e.indexOf(" ") ? i && i("手机号不能含有空格") : /^1\d{10}$/.test(e) || /^[0,4]\d{2,3}-?\d{7,8}$/.test(e) ? i && i() : i && i("手机号格式不正确") : i && i("手机号不能为空")
        }

        s(3), $(function () {
            0 < location.href.indexOf("txtBill") && (setTimeout(function () {
                $("html,body").animate({scrollTop: 700}, 500)
            }, 500), $(".wayExpress").addClass("selectedExCheck"), $(".phoneExpressBox").addClass("hidden"), $(".phoneExpress").removeClass("selectedExCheck")), 0 < location.href.indexOf("phoneBill") && ($(".phoneExpress").addClass("selectedExCheck"), $(".wayExpressBox").addClass("hidden"), $(".wayExpress").removeClass("selectedExCheck"), $(".phoneInput").val(function (e) {
                var i = document.location.toString().split("?");
                {
                    if (1 < i.length) {
                        for (var s, t = i[1].split("&"), n = 0; n < t.length; n++) if (null != (s = t[n].split("=")) && s[0] == e) {
                            return s[1];
                        }
                        return ""
                    }
                    return ""
                }
            }("phoneBill")), $(".phoneExpressBox").removeClass("hidden")), $(".wayExpress").click(function () {
                $(".wayExpress").addClass("selectedExCheck"), $(".phoneExpressBox").addClass("hidden"), $(".phoneExpress").removeClass("selectedExCheck"), $(".wayExpressBox").removeClass("hidden")
            }), $(".phoneExpress").click(function () {
                $(".phoneExpress").addClass("selectedExCheck"), $(".wayExpressBox").addClass("hidden"), $(".wayExpress").removeClass("selectedExCheck"), $(".phoneExpressBox").removeClass("hidden")
            });
            var i = "";

            function s() {
                $.ajax({
                    type: "post",
                    url: zto.config.image_serviceUrl + "/captcha/image",
                    headers: {"x-token": zto.auth.getToken(), "x-clientCode": zto.client.getClientCode()},
                    cache: !1,
                    crossDomain: 1 == !document.all
                }).done(function (e) {
                    e.status && (i = e.result.id, $("#picValidate").attr("src", e.result.image))
                }).fail(function (e) {
                    console.log("数据请求失败")
                })
            }

            window.onload = function () {
                s()
            }, $("#picValidate").click(function () {
                s()
            });
            var t = !1, n = 60;
/*            $(".validateInputBtn").click(function () {
                f($(".phoneInput").val(), function (e) {
                    if (e) {
                        ztoAlert("提示", e, "确定", "");
                    } else {
                        if ("" == $("#picValidateCode").val()) {
                            return void ztoAlert("提示", "图形验证码不能为空", "确定", "");
                        }
                        t || 60 != n || (s(), HrPost("auth_account_sendLoginOrRegisterSmsVerifyCode", {
                            mobile: Number($(".phoneInput").val()),
                            HEADERS: {id: i, code: $("#picValidateCode").val()}
                        }, function (e) {
                            if (e) {
                                if (1 == e.status) {
                                    var i = setInterval(function () {
                                        --n < 0 ? (t = !1, n = 60, clearInterval(i), $(".validateInputBtn").val("获取验证码")) : (t = !0, $(".validateInputBtn").val(n + "s后重新获取"))
                                    }, 1e3);
                                    ztoAlert("", "验证码发送成功", "确定", "close")
                                } else {
                                    t = !1, ztoAlert("", e.message, "确定", "close")
                                }
                            }
                        }))
                    }
                })
            });*/
            var o = !0;

            /*function l() {
                o && (o = !1, HrPost("auth_account_loginOrRegisterBySmsVerifyCode", {
                    isAgainBind: !1,
                    mobile: Number($(".phoneInput").val()),
                    verifyCode: Number($(".validateInput").val())
                }, function (e) {
                    o = !0, e && (1 == e.status ? (zto.auth.setToken(e.result.token), location.href = zto.config.centerceUrl) : ($(".alert").remove(), ztoAlert("失败", e.message, "确定", "close")))
                }))
            }*/

            /*if ($(".submitLogin").click(function () {
                f($(".phoneInput").val(), function (e) {
                    e ? ztoAlert("提示", e, "确定", "") : $(".validateInput").val() ? zto.auth.getToken() ? HrPost("auth_account_getUserLoginProvider", null, function (e) {
                        e.status ? e.result.mobile === Number($(".phoneInput").val()) ? window.open(zto.config.centerceUrl, "_blank") : ($("body").append('<div class="alert">\t            <span class="alert-close"></span>\t            <span>亲爱的用户，您好</span>\t            <div class="alert-text">\t                <p><img src="../imgs/express/sun.png"/></p>\t            </div>\t            <strong style="font-size: 20px; display: block; margin-bottom: 20px;">您已经登录了中通个人中心</strong>\t            <div style="color:#818181;margin-bottom: 30px;">是否切换手机号登录查询?</div>\t            <div>\t                <input type="button" style="border: none;padding: 10px 20px;border-radius: 4px;background: #33A2F7;color: #fff;cursor: pointer;" class="yesLogin" value="是的，切换登录">\t                <input type="button" style="position: relative;display: inline-block;margin-left: 30px;    width: auto;height: auto;background: #B0C0C7;border: none;border-radius: 4px;color: #fff;padding: 10px 20px;" class="alert-close" value="否，不查询">\t            </div>\t        </div>'), $(".alert").addClass("show").css("margin-top", "-" + ($(".alert").height() / 2 + 40) + "px"), $(".yesLogin").click(function () {
                            l()
                        })) : l()
                    }) : l() : ztoAlert("提示", "请输入验证码", "确定", "")
                })
            }), thisCodes = getCookie("codes"), null == thisCodes || null == thisCodes) {
                $(".lately-record i").html("无"), $(".lately-record").addClass("not");
            } else {
                var e = (d = thisCodes.split(",")).length;
                $(".lately-record").removeClass("not"), $(".lately-record i").html(e);
                for (var a = e - 1; -1 < a; a--) {
                    var c = d[a].split("-");
                    $(".record").append('<em class="record-item"><span>' + c[0] + "</span><i></i></em>")
                }
                5 < e && $(".record").css("text-align", "left")
            }*/
            /*$(".search_btn").click(function () {
                var e = $(".query_txt").val(), i = e.length;
                if ($(".ex_item").size() < 1) {
                    e && 12 <= i && i <= 16 ? 13 == i ? ztoAlert("提示", "请正确输入中通运单号，13位暂时不支持，最少12位,最大16位，多个用；号隔开！", "确定", "") : ($(".query_txt").before('<div class="ex_item">\t                                        <span>' + e + "</span>\t                                        <i></i>\t                                    </div>"), $(".query_txt").blur(), $(".query_txt").val("").attr("placeholder", ""), m()) : ztoAlert("提示", "请正确输入中通运单号，最少12位,最大16位，多个用；号隔开！", "确定", "");
                } else if (12 <= i && i <= 16) {
                    if (13 == i) {
                        ztoAlert("提示", "请正确输入中通运单号，13位暂时不支持，最少12位,最大16位，多个用；号隔开！", "确定", "");
                    } else {
                        var s = $(".ex_item").size();
                        if (s < 10) {
                            for (var t = 0, n = 0; n < s; n++) e != $(".ex_item:eq(" + n + ") span").html() && t++;
                            t == s ? e ? ($(".query_txt").before('<div class="ex_item">\t                                    <span>' + e + "</span>\t                                    <i></i>\t                                </div>"), $(".query_txt").blur(), $(".query_txt").val("").attr("placeholder", ""), m()) : ztoAlert("提示", "请正确输入中通运单号，最少12位,最大16位，多个用；号隔开！", "确定", "") : ztoAlert("提示", "您输入的订单号重复啦！", "确定", "queryToText")
                        } else {
                            ztoAlert("提示", "单次查询订单数量最多为10条！", "确定", "")
                        }
                    }
                } else {
                    m()
                }
            })*/
            $(document).on("click", ".record-item span", function () {
                var e = $(this).html();
                e.split(",");
                $(".ex_item").remove(), $(".query_txt").before('<div class="ex_item"><span>' + e + "</span><i></i></div>"), expressCheck(e, !0), $(".record").removeClass("show"), $(".search_box").css("margin-bottom", "15px"), $(".query_txt").attr("placeholder", ""), $(".query_txt").focus(), $("html,body").animate({scrollTop: 700}, 500)
            }), $(document).on("click", ".record-item i", function () {
                var e = $(this).parent(), i = e.index(), s = $(".record-item").size() - i;
                e.remove();
                var t = getCookie("codes").split(",");
                if (1 < t.length) {
                    for (var n = 0; n < t.length; n++) n == s && t.splice(n, 1);
                } else {
                    t = "";
                }
                if ("" != t) {
                    var o = t.join(",");
                    setCookie("codes", o);
                    var l = $(".lately-record i").html();
                    $(".lately-record i").html(l - 1)
                } else {
                    delCookie("codes"), $(".lately-record i").html("无"), $(".lately-record").addClass("not")
                }
            });
            var r,
                h = filterXSS(zto.utils.getQueryString("txtBill")).replace(/=/g, "") || filterXSS(zto.utils.getQueryString("txtbill")).replace(/=/g, "");
            if (null != h) {
                $(".query_txt").attr("placeholder", "");
                a = 0;
                for (var d, u = (d = h.split(",")).length; a < u; a++) {
                    var p = d[a].toString();
                    p && ($(".query_txt").before('<div class="ex_item"><span>' + p + "</span><i></i></div>"), expressCheck(p, !0))
                }
                $(".query_txt").focus()
            }
            /*$(".query_txt").keyup(function () {
                var e = $(this), i = e.val().replace(/\,|\，|\;|\；|\s+/g, ","), s = (i.length, $(".ex_item").size());
                if (s < 10) {
                    var t = i.split(",");
                    if (1 < t.length) {
                        for (var n = 0; n < t.length; n++) if (12 <= t[n].length && t[n].length <= 16) {
                            if (13 == t[n].length) {
                                ;
                            } else if (s < 10) {
                                for (var o = 0, l = 0; l < s; l++) t[n] != $(".ex_item:eq(" + l + ") span").html() && o++;
                                o == s ? (10 <= n ? ztoAlert("提示", "单次查询订单数量最多为10条！", "确定", "") : e.before('<div class="ex_item">\t                                            <span>' + t[n] + "</span>\t                                            <i></i>\t                                        </div>"), e.val("").attr("placeholder", ""), n === t.length - 1 && (t = "", e.val("").attr("placeholder", ""), e.blur())) : ztoAlert("提示", "您输入的订单号重复啦！", "确定", "queryToText")
                            }
                        } else {
                            16 < t[n].length || e.val("").attr("placeholder", "在此输入单号")
                        }
                    }
                } else {
                    e.val("").attr("placeholder", "在此输入单号"), e.blur(), ztoAlert("提示", "单次查询订单数量最多为10条！", "确定", "")
                }
            }),*/ /*$(".query_txt").keydown(function (e) {
                var i, s, t = $(this), n = (i = t.val()).length;
                8 == e.keyCode && ("" != (i = t.val()) && null != i && " " != i || $(".ex_item").last().remove());
                if (13 == e.keyCode) {
                    if ($(".ex_item").size() < 1) {
                        12 <= n && n <= 16 ? i ? 13 == n ? (t.val("").attr("placeholder", "在此输入单号"), ztoAlert("提示", "请正确输入中通运单号，最少12位,最大16位，多个用；号隔开！", "确定", "")) : (s = $(".ex_item").size()) < 10 ? (t.before('<div class="ex_item">\t                                    <span>' + i + "</span>\t                                    <i></i>\t                                </div>"), t.blur(), t.val("").attr("placeholder", "在此输入单号"), m()) : ztoAlert("提示", "单次查询订单数量最多为10条！", "确定", "") : ztoAlert("提示", "请正确输入中通运单号，最少12位,最大16位，多个用；号隔开！", "确定", "") : ztoAlert("提示", "请正确输入中通运单号，最少12位，最大16位！", "确定", "");
                    } else if (12 <= n && n <= 16) {
                        if (13 == n) {
                            t.val("").attr("placeholder", ""), ztoAlert("提示", "请正确输入中通运单号，最少12位，最大16位，多个用；号隔开！", "确定", "");
                        } else if ((s = $(".ex_item").size()) < 10) {
                            for (var o = 0, l = 0; l < s; l++) i != $(".ex_item:eq(" + l + ") span").html() && o++;
                            o == s ? i ? (t.before('<div class="ex_item">\t                                    <span>' + i + "</span>\t                                    <i></i>\t                                </div>"), t.blur(), t.val("").attr("placeholder", ""), m()) : ztoAlert("提示", "请正确输入中通运单号，最少12位，最大16位，多个用；号隔开！", "确定", "") : ztoAlert("提示", "您输入的订单号重复啦！", "确定", "queryToText")
                        } else {
                            ztoAlert("提示", "单次查询订单数量最多为10条！", "确定", "");
                        }
                    } else {
                        m()
                    }
                }
            }),*/ $(".search_txt").click(function () {
                $(".query_txt").focus()
            }), $(".inputGray").click(function () {
            }), $(".inputItem").click(function (e) {
                e.stopPropagation(), e.preventDefault()
            }), $(".inputItem").on("click", ".ex_item span", function (e) {
                var i = $(this).html(), s = $(this).parent();
                s.addClass("ex_item_edit"), $(this).parent().html('<input type="text" id="input" value="' + i + '">'), setTimeout(function () {
                    s.children().focus()
                }, 50)
            }), $(document).on("blur", ".ex_item input", function () {
                var e = $(this).val(), i = $(this).parent();
                if (12 <= e.length && e.length <= 16) {
                    if (13 == e.length) {
                        $(this).parent().remove(), ztoAlert("提示", "请正确输入中通运单号，最少12位，最大16位，多个用；号隔开！", "确定", "");
                    } else {
                        for (var s = $(".ex_item").size(), t = 0, n = 0; n < s; n++) e != $(".ex_item:eq(" + n + ") span").html() && t++;
                        t == s ? ($(this).parent().html("<span>" + e + "</span><i></i>"), i.removeClass("ex_item_edit")) : (ztoAlert("提示", "您输入的订单号重复啦,请重新输入！", "确定", "queryToText"), $(this).parent().remove())
                    }
                } else {
                    ztoAlert("提示", "请正确输入中通运单号，最少12位，最大16位！", "确定", ""), $(this).parent().remove()
                }
            }), $(".inputItem").on("click", ".ex_item i", function () {
                $(this).parent().remove()
            }), $(document).on("click", ".queryToText", function () {
                $("#txtbill").val(""), $("#txtbill").focus()
            }), $(".lately-record").click(function () {
                $(".record").hasClass("show") ? ($(".record").removeClass("show"), $(".search_box").css("margin-bottom", "15px")) : ($(".record").addClass("show"), $(".search_box").css("margin-bottom", "82px"))
            }), $(document).on("click", ".result-add", function () {
                var e = $(this);
                e.hasClass("hide") ? (e.parent().find(".branch-item").removeClass("show"), e.removeClass("hide").find("span").html("展开更多")) : (e.parent().find(".branch-item").addClass("show"), e.addClass("hide").find("span").html("收起内容"))
            }), $(".sel-title").click(function () {
                var e = $(this).parent();
                e.hasClass("show") ? e.removeClass("show") : e.addClass("show")
            }), $(".sel-item").click(function () {
                var e = $(this);
                e.addClass("checked").siblings().removeClass("checked"), $(".sel-title").attr("data-type", e.attr("data-type")).find("em").html(e.html()), $(".sel-box").removeClass("show")
            }), $(".jump-close,.jump-btn.submit").click(function () {
                $(".jump,.jump-cont").hide()
            }), $(document).on("click", ".branch-contact.graded", function () {
                var e = $(this).attr("data-order");
                $(".jump").show(), $(".jump .jump-cont.grade .order-code em").html(e), $(".jump .jump-cont.grade").show(), $(".jump .jump-box").css("margin-top", "-" + ($(".jump-box").height() / 2 + 20) + "px")
            }), $(document).on("click", ".branch-contact.telCourier", function () {
                if (zto.auth.getToken()) {
                    var e = $(".user a").data("phone"), i = $(this).data("tel");
                    $("#phone1").html(e), $("#phone2").html(e), $(".courier-phone em").html(i), $(".jump").show(), $(".jump .jump-cont.contact").show(), $(".jump .jump-box").css("margin-top", "-" + ($(".jump-box").height() / 2 + 20) + "px"), $(".jump-box").attr("data-order", $(this).attr("data-order"))
                } else {
                    ztoAlert("提示", "登录后才能更快联系到派件员哦~", "去登录", "toLogin");
                    var s = $(this).parent().parent().parent().find(".numbers").find("span").html();
                    $(".alert").attr("data-code", s)
                }
            }), $("#phoneForm").validate({
                debug: !0, submitHandler: function () {
                    var e = $(".jump-box").attr("data-order"), i = $("#phone1").val();
                    HrPost("Reminder_Phone", {customerPhone: i, billCode: e}, function (e) {
                        e && (1 == e.status ? ($(".jump,.jump-cont").hide(), ztoAlert("成功", "已请注意接听95720的来电电话，接听后我们将为您免费呼叫派送员。", "确定", "close")) : ($(".jump,.jump-cont").hide(), ztoAlert("失败", "呼叫失败。", "确定", "close")))
                    })
                }
            }), $("#messageForm").validate({
                debug: !0, submitHandler: function () {
                    var e = $(".jump-box").attr("data-order"), i = $("#phone2").val();
                    HrPost("Reminder_Sms", {customerPhone: i, billCode: e}, function (e) {
                        e && (1 == e.status ? ($(".jump,.jump-cont").hide(), ztoAlert("成功", "向快递员成功催件", "确定", "close")) : ($(".jump,.jump-cont").hide(), ztoAlert("失败", "发送失败。", "确定", "close")))
                    })
                }
            }), $("#phone1").rules("add", {
                required: !0,
                minlength: 11,
                isMobile: !0,
                messages: {required: "请填写您的手机号码！", minlength: "确认手机不能小于11个字符", isMobile: "手机号格式不正确"}
            }), $("#phone2").rules("add", {
                required: !0,
                minlength: 11,
                isMobile: !0,
                messages: {required: "请填写您的手机号码！", minlength: "确认手机不能小于11个字符", isMobile: "手机号格式不正确"}
            }), $.validator.addMethod("isMobile", function (e, i) {
                var s = e.length;
                return this.optional(i) || 11 == s && /^1[0-9]{1}[0-9]{9}$/.test(e)
            }, "请正确填写您的手机号码"), $(".star").hover(function () {
                for (var e = $(this).index(), i = $(this).parent(), s = 0; s < e + 1; s++) i.find(".star").eq(s).addClass("cur");
                for (var t = 4; e < t; t--) i.find(".star").eq(t).removeClass("cur")
            }, function () {
            }), $(".star").click(function () {
                var e = $(this).index(), i = $(this).parent();
                i.removeClass("num-1"), i.removeClass("num-2"), i.removeClass("num-3"), i.removeClass("num-4"), i.removeClass("num-5"), i.addClass("num-" + (e + 1)), r = e
            }), $(".grade-list").hover(function () {
                for (var e = 1; e < 6; e++) $(this).hasClass("num-" + e) && (r = e, $(this).removeClass("num-" + e))
            }, function () {
                $(this).find(".star").removeClass("cur"), $(this).addClass("num-" + r), r = 0
            }), $(".jump-btn.gradeok").click(function () {
                $(".jump,.jump-cont").hide(), ztoAlert("成功", "评价已提交成功，非常感谢！", "确定", "close")
            }), /*$(".result-list").on("click", ".map-link", function () {
                var e = $(this), i = e.parents(".result-item"), s = i.children(".branch-list"),
                    t = '<div class="map-iframe"><iframe src="https://apimapgis.zt-express.com/nose.html?billCode=' + i.children(".result-top").children(".numbers").find("span").text().replace(/\s+/g, "") + '"></iframe></div>';
                "切换地图" === e.text() ? (i.append(t), s.find(".branch-circle").hide(), s.find(".branch-text").hide(), s.find(".result-add").hide(), s.find(".branch-line").hide(), s.find(".branch-time").hide(), s.find(".branch-item").removeClass("show"), e.text("切换详细")) : (i.children(".map-iframe").remove(), s.find(".branch-circle").show(), s.find(".branch-text").show(), s.find(".result-add").show(), s.find(".branch-line").show(), s.find(".branch-time").show(), s.find(".branch-item").addClass("show"), e.text("切换地图"))
            }),*/ $(".result-list").on("click", ".e-waybill", function () {
                $(".detail").remove();
                var o = $(this).data("code"), l = $(this).parents(".result-item");
                HrPost("Order_QueryDetailByCode", {billCode: o}, function (e) {
                    var i, s = e.result, t = (i = e.result.recEmpDate, function (e, i) {
                            var s = {
                                "M+": i.getMonth() + 1,
                                "d+": i.getDate(),
                                "h+": i.getHours(),
                                "m+": i.getMinutes(),
                                "s+": i.getSeconds(),
                                "q+": Math.floor((i.getMonth() + 3) / 3),
                                S: i.getMilliseconds()
                            };
                            for (var t in /(y+)/.test(e) && (e = e.replace(RegExp.$1, (i.getFullYear() + "").substr(4 - RegExp.$1.length))), s) new RegExp("(" + t + ")").test(e) && (e = e.replace(RegExp.$1, 1 == RegExp.$1.length ? s[t] : ("00" + s[t]).substr(("" + s[t]).length)));
                            return e
                        }("yyyy-MM-dd hh:mm:ss", new Date(i))),
                        n = '<div class="detail"><div class="topline"><div class="title">电子底单</div><div class="dzclose">X</div></div><div class="barcode"><img class="barcode imgcode"/> </div><p class="billno"><span>' + s.waybillCode + '</span></p><table class="package"><tr><td class="tit"><p>寄&nbsp;件</p></td><td colspan="3" class="con"><div><span class="name">' + s.senderName + "</span><span>" + s.senderMobile + "</span></div><div><span>" + s.senderProvince + s.senderCity + s.senderCounty + "</span><span>" + s.senderAddress + '</span></div></td></tr><tr><td class="tit"><p>收&nbsp;件</p></td><td class="con"><div><span class="name">' + s.receiverName + "</span><span>" + s.receiverMobile + "</span></div><div><span>" + s.receiverProvince + s.receiverCity + s.receiverCounty + "</span><span>" + s.receiverAddress + '</span></div></td></tr><tr><td class="tit"><p>其&nbsp;它</p></td><td class="con"><div><span>内容品名:</span><span>' + (s.category ? s.category : "") + "</span></div><div><span>计费重量:</span><span>" + s.weight + "KG</span></div><div><span>代收货款:</span><span>" + s.vasCollectSum + "元</span></div><div><span>取件快递员:</span><span>" + (s.recSite ? s.recSite + "--" : "") + (s.recEmp ? s.recEmp : "") + "</span></div><div><span>快递员电话:</span><span>" + (s.recMobile ? s.recMobile : "") + "</span></div><div><span>取件时间:</span><span>" + t + "</span></div></td></tr></table></div>";
                    l.append(n), JsBarcode(".imgcode", o, {
                        format: "CODE128",
                        width: 3.5,
                        height: 120,
                        textMargin: 0,
                        text: "",
                        fontSize: 0
                    })
                })
            }), $(".result-list").on("click", ".dzclose", function () {
                $(this).parent().parent().remove()
            })
        })
    }
});