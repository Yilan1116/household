<!DOCTYPE html>
<html lang="en">

<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8"%>

    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge"/>
    <title>Home Shopping</title>
    <!--写base标签，永远固定相对路径跳转的结果-->
    <base href="<%=request.getContextPath()+"/"%>">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <link rel="stylesheet" href="assets/css/vendor/vendor.min.css"/>
    <link rel="stylesheet" href="assets/css/plugins/plugins.min.css"/>
    <link rel="stylesheet" href="assets/css/style.min.css"/>
    <script type="text/javascript" src="script/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
        // 页面加载完成之后


            $(function () {



            $(function(){

                $("#username").blur(function () {
                    alert("hello");
                })
                if("${requestScope.active}" == "register"){
                    $("#register_tab")[0].click();
                }
            })



            $(function () {
                $("#codeImg").click(function(){
                    this.src="<%=request.getContextPath()%>/kaptchaServlet?d="+new Date();
                })

            })
            // 给注册绑定单击事件
            $("#sub-btn").click(function () {
                // 验证用户名：必须由字母，数字下划线组成，并且长度为3到10位
                //1 获取用户名输入框里的内容
                var usernameVal = $("#username").val();
                //2 创建正则表达式对象
                var usernamePatt = /^\w{3,10}$/;
                //3 使用test方法验证
                if (!usernamePatt.test(usernameVal)) {
                    //4 提示用户结果
                    $("span.errorMsg").text("Incorrect username format");
                    return false;
                }

                // 验证密码：必须由字母，数字下划线组成，并且长度为6到10位
                //1 获取用户名输入框里的内容
                var passwordVal = $("#password").val();
                //2 创建正则表达式对象
                var passwordPatt = /^\w{6,10}$/;
                //3 使用test方法验证
                if (!passwordPatt.test(passwordVal)) {
                    //4 提示用户结果
                    $("span.errorMsg").text("Incorrect password format");
                    return false;
                }

                // 验证确认密码：和密码相同
                //1 获取确认密码内容
                var repwdVal = $("#repwd").val();
                //2 和密码相比较
                if (repwdVal != passwordVal) {
                    $("span.errorMsg").text("Inconsistent password");
                    return false;
                }

                //邮箱验证
                //1 获取邮箱里的内容
                var emailVal = $("#email").val();
                //2 创建正则表达式对象
                var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.[a-z]+)+$/;
                //3 使用test方法验证是否合法
                if (!emailPatt.test(emailVal)) {
                    //4 提示用户
                    $("span.errorMsg").text("Incorrect email");
                    return false;
                }

                var codeText = $("#code").val();
                codeText = $.trim(codeText);
                if(codeText = null || codeText == ""){
                    $("span.errorMsg").text("The code cannot be empty");
                    return false;
                }

                // 给出注册Info通过
                $("span.errorMsg").text("Registration successfully");
                return true; //暂时不提交.
            });
        });
    </script>
</head>
<body>
<!-- Header Area start  -->
<div class="header section">
    <!-- Header Top Message Start -->
    <!-- Header Top  End -->
    <!-- Header Bottom  Start -->
    <div class="header-bottom d-none d-lg-block">
        <div class="container position-relative">
            <div class="row align-self-center">
                <!-- Header Logo Start -->
                <div class="col-auto align-self-center">
                    <div class="header-logo">
                        <a href="index.html"><img src="assets/images/logo/logo.png" alt="Site Logo"/></a>
                    </div>
                </div>
                <!-- Header Logo End -->
            </div>
        </div>
    </div>
    <!-- Header Bottom  Start 手机端的header -->
    <div class="header-bottom d-lg-none sticky-nav bg-white">
        <div class="container position-relative">
            <div class="row align-self-center">
                <!-- Header Logo Start -->
                <div class="col-auto align-self-center">
                    <div class="header-logo">
                        <a href="index.html"><img width="280px" src="assets/images/logo/logo.png"
                                                  alt="Site Logo"/></a>
                    </div>
                </div>
                <!-- Header Logo End -->
            </div>
        </div>
    </div>
    <!-- Main Menu Start -->
    <div style="width: 100%;height: 50px;background-color: black"></div>
    <!-- Main Menu End -->
</div>
<!-- Header Area End  -->
<!-- login area start -->
<div class="login-register-area pt-70px pb-100px">
    <div class="container">
        <div class="row">
            <div class="col-lg-7 col-md-12 ml-auto mr-auto">
                <div class="login-register-wrapper">
                    <div class="login-register-tab-list nav">
                        <a class="active" data-bs-toggle="tab" href="#lg1">
                            <h4>Log in</h4>
                        </a>
                        <a data-bs-toggle="tab" href="#lg2">
                            <h4>Register</h4>
                        </a>
                    </div>
                    <div class="tab-content">
                        <div id="lg1" class="tab-pane active">
                            <div class="login-form-container">
                                <div class="login-register-form">
                                    <span style="font-size: 18pt;font-weight: bold;float: right;color: gray">
                                    ${requestScope.msg}
                                    </span>
                                    <form action="memberServlet" method="post">
                                        <input type="hidden" name = "action" value="login">
                                        <input type="text" name="username" value = "${requestScope.username}" placeholder="Username"/>
                                        <input type="password" name="password" placeholder="Password"/>
                                        <div class="button-box">
                                            <div class="login-toggle-btn">
                                                <input type="checkbox"/>
                                                <a class="flote-none" href="javascript:void(0)">Remember me</a>
                                                <a href="#">Forgot Password?</a>
                                            </div>
                                            <button type="submit"><span>Login</span></button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div id="lg2" class="tab-pane">
                            <div class="login-form-container">
                                <div class="login-register-form">
                                    <span class="errorMsg"
                                          style="float: right; font-weight: bold; font-size: 18pt; margin-left: 10px;">
                                        ${requestScope.msg}
                                    </span>
                                    <form action="memberServlet" method="post">

                                        <input type="hidden" name = "action" value="register">
                                        <input type="text" id="username" name="username" placeholder="Username"/>
                                        <input type="password" id="password" name="password" placeholder="password"/>
                                        <input type="password" id="repwd" name="user-password" placeholder="confirm password"/>
                                        <input name="email" id="email" placeholder="email" type="email"/>
                                        <input type="text" id="code" name="code" style="width: 50%"
                                               placeholder="验证码"/>　　<img id="codeImg" alt="" src="kaptchaServlet">
                                        <div class="button-box">
                                            <button type="submit" id="sub-btn"><span>Register</span></button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- login area end -->

<!-- Footer Area Start -->
<div class="footer-area">
    <div class="footer-container">
        <div class="footer-top">
            <div class="container">
                <div class="row">
                    <!-- Start single blog -->
                    <!-- End single blog -->
                    <!-- Start single blog -->
                    <div class="col-md-6 col-sm-6 col-lg-3 mb-md-30px mb-lm-30px" data-aos="fade-up"
                         data-aos-delay="400">
                        <div class="single-wedge">
                            <h4 class="footer-herading">Info</h4>
                            <div class="footer-links">
                                <div class="footer-row">
                                    <ul class="align-items-center">
                                        <li class="li"><a class="single-link" href="about.html">About</a></li>
                                        <li class="li"><a class="single-link" href="#">Information</a></li>
                                        <li class="li"><a class="single-link" href="privacy-policy.html">Privacy</a></li>
                                        <li class="li"><a class="single-link" href="#">Terms</a></li>
                                        <li class="li"><a class="single-link" href="#">Manufacture</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- End single blog -->
                    <!-- Start single blog -->
                    <div class="col-md-6 col-lg-2 col-sm-6 mb-lm-30px" data-aos="fade-up" data-aos-delay="600">
                        <div class="single-wedge">
                            <h4 class="footer-herading">My account</h4>
                            <div class="footer-links">
                                <div class="footer-row">
                                    <ul class="align-items-center">
                                        <li class="li"><a class="single-link" href="my-account.html">My account</a>
                                        </li>
                                        <li class="li"><a class="single-link" href="cart.html">Cart</a></li>
                                        <li class="li"><a class="single-link" href="login.jsp">Log in</a></li>
                                        <li class="li"><a class="single-link" href="wishlist.html">Wishlist</a></li>
                                        <li class="li"><a class="single-link" href="checkout.html">Checkout</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- End single blog -->
                    <!-- Start single blog -->
                    <div class="col-md-6 col-lg-3" data-aos="fade-up" data-aos-delay="800">

                    </div>
                    <!-- End single blog -->
                </div>
            </div>
        </div>
        <div class="footer-bottom">
            <div class="container">
                <div class="row flex-sm-row-reverse">
                    <div class="col-md-6 text-right">
                        <div class="payment-link">
                            <img src="#" alt="">
                        </div>
                    </div>
                    <div class="col-md-6 text-left">
                        <p class="copy-text"> ~</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Footer Area End -->
<script src="assets/js/vendor/vendor.min.js"></script>
<script src="assets/js/plugins/plugins.min.js"></script>
<!-- Main Js -->
<script src="assets/js/main.js"></script>
</body>
</html>