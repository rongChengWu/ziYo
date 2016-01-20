<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/WEB-INF/tags/tree.tld" prefix="nodeTag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>梓瑶兽药</title>
      <link href="/ziYo/js/metro/css/metro.css" rel="stylesheet">
    <link href="/ziYo/js/metro/css/metro-icons.css" rel="stylesheet">
    <link href="/ziYo/js/metro/css/metro-responsive.css" rel="stylesheet">
    <link href="/ziYo/js/metro/css/metro-schemes.css" rel="stylesheet">

    <link href="/ziYo/js/metro/css/docs.css" rel="stylesheet">

    <script type="text/javascript" src="/ziYo/js/jquery.min.js"></script>
    <script src="/ziYo/js/metro/js/metro.js"></script>
    <script src="/ziYo/js/metro/js/docs.js"></script>
    <script src="/ziYo/js/metro/js/prettify/run_prettify.js"></script>
    <script src="/ziYo/js/metro/js/ga.js"></script>
    
     <style>
        html, body {
            height: 100%;
        }
        body {
        }
        .page-content {
            padding-top: 3.125rem;
            min-height: 100%;
            height: 100%;
        }
        .table .input-control.checkbox {
            line-height: 1;
            min-height: 0;
            height: auto;
        }

        @media screen and (max-width: 800px){
            #cell-sidebar {
                flex-basis: 52px;
            }
            #cell-content {
                flex-basis: calc(100% - 52px);
            }
        }
    </style>

    <script>
        function pushMessage(t){
            var mes = 'Info|Implement independently';
            $.Notify({
                caption: mes.split("|")[0],
                content: mes.split("|")[1],
                type: t
            });
        }

        $(function(){
            $('.sidebar').on('click', 'li', function(){
                if (!$(this).hasClass('active')) {
                    $('.sidebar li').removeClass('active');
                    $(this).addClass('active');
                }
            })
        })
    </script>
  </head>  
<body class="bg-steel">
 <div class="app-bar fixed-top darcula" data-role="appbar">
   <a class="app-bar-element branding">首页</a>
        <span class="app-bar-divider"></span>
  		<ul  class="app-bar-menu">
  			<nodeTag:TopTag/>
		</ul>
      <div class="app-bar-element place-right">
            <span class="dropdown-toggle"><span class="mif-cog"></span> ${userLogin.userName}</span>
            <div class="app-bar-drop-container padding10 place-right no-margin-top block-shadow fg-dark" data-role="dropdown" data-no-close="true" style="width: 220px">
                <h2 class="text-light">Quick settings</h2>
                <ul class="unstyled-list fg-dark">
                    <li><a href="" class="fg-white1 fg-hover-yellow">Profile</a></li>
                    <li><a href="" class="fg-white2 fg-hover-yellow">Security</a></li>
                    <li><a href="" class="fg-white3 fg-hover-yellow">Exit</a></li>
                </ul>
            </div>
        </div>
</div>
</body>
</html>