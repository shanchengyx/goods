<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>
    <%@include file="../common/head.jsp" %>
    <script>
        $(function () {
            $('#username').blur(function () {
                let username = this.value;
                $.getJSON(
                    "${pageScope.basePath}userServlet",
                    "action=existUsername&username=" + username,
                    function (data) {
                        if (data.isExistUsername) {
                            $('span.errorMsg').text("用户名已存在");
                        } else {
                            $('span.errorMsg').text("");
                        }
                    }
                );
            });

            $('#code_img').click(function () {
                this.src = '${pageScope.basePath}kaptcha.jpg?d=' + new Date();
            });

            $('#sub_btn').click(function () {
                //验证用户名
                let username = $('#username').val();
                let usernamePatt = /^\w{5,12}$/;
                if (!usernamePatt.test(username)) {
                    $('span.errorMsg').text("用户名不合法");
                    return false;
                }
                //验证密码
                let password = $('#password').val();
                let passwordPatt = /^\w{5,12}$/;
                if (!passwordPatt.test(username)) {
                    $('span.errorMsg').text("密码不合法");
                    return false;
                }
                //确认密码
                let repwd = $('#repwd').val();
                if (repwd != password) {
                    $('span.errorMsg').text("两次输入的密码不一致");
                    return false;
                }
                //验证邮箱
                let email = $('#email').val();
                let emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
                if (!emailPatt.test(email)) {
                    $('span.errorMsg').text("邮箱不合法");
                    return false;
                }
                //验证码
                let code = $('#code').val();
                code = $.trim(code);
                if (code == null || code == '') {
                    $('span.errorMsg').text("验证码不合法");
                    return false;
                }
                //如果都合法，就把不合法的提示去掉
                $('span.errorMsg').text("");
            });
        });
    </script>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }
    </style>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="../../static/img/logo.jpg">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册账户</h1>
                    <span class="errorMsg">
                        ${requestScope.msg}
                    </span>
                </div>
                <div class="form">
                    <form action="${pageScope.basePath}userServlet" method="post">
                        <input type="hidden" name="action" value="register"/>
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1"
                               name="username" id="username"
                               value="${requestScope.username}"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1"
                               name="password" id="password"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1"
                               name="repwd" id="repwd"/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1"
                               name="email" id="email"
                               value="${requestScope.email}"/>
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" name="code" style="width: 130px;" id="code"/>
                        <img id='code_img' alt="" src="${pageScope.basePath}kaptcha.jpg"
                             style="float: right; margin-right: 40px; width:100px;height:40px">
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>

                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%@include file="../common/footer.jsp" %>
</body>
</html>