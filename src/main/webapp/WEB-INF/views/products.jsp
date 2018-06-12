<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 09.12.2017
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="org.zhanara.models.MarketCashierEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="org.zhanara.models.MarketItemsEntity" %>
<!DOCTYPE html>
<!-- saved from url=(0052)https://p.w3layouts.com/demos/novus_admin_panel/web/ -->
<html class=" js " style="overflow: hidden;"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Admin</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <meta name="keywords" content="Novus Admin Panel Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design">
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- Bootstrap Core CSS -->
    <link href="/resources/css/bootstrap.css" rel="stylesheet" type="text/css">
    <!-- Custom CSS -->
    <link href="/resources/css/style_2.css" rel="stylesheet" type="text/css">
    <!-- font CSS -->
    <!-- font-awesome icons -->
    <link href="/resources/css/font-awesome.css" rel="stylesheet">



</head>
<body class="cbp-spmenu-push">
<% MarketCashierEntity cashierEntity = (MarketCashierEntity) request.getAttribute("cashier"); %>
<div class="main-content">
    <!--left-fixed -navigation-->
    <div class=" sidebar" role="navigation">
        <div class="navbar-collapse">
            <nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1">
                <ul class="nav" id="side-menu">
                    <li>
                        <a href="/cashier/"></i>Profile</a>
                    </li>
                    <li>
                        <a href="/products/" class="active"></i>Products</a>
                    </li>
                    <%--<li>--%>
                    <%--<a href="/admin/items" <%if(request.getAttribute("itemsList") != null){%>class="active" <%}%>>Items </a>--%>

                    <%--<!-- /nav-second-level -->--%>
                    <%--</li>--%>

                </ul>
                <!-- //sidebar-collapse -->
            </nav>
        </div>
    </div>
    <!--left-fixed -navigation-->
    <!-- header-starts -->
    <div class="sticky-header header-section ">
        <div class="header-left">
            <!--toggle button start-->
            <button id="showLeftPush"><i class="fa fa-bars"></i></button>
            <!--toggle button end-->
            <!--logo -->
            <div class="logo">
                <a href="/">
                    <h1>MARKET</h1>
                    <span>AdminPanel</span>
                </a>
            </div>
            <!--//logo-->
            <!--search-box-->
            <div class="search-box">
                <form class="input">
                    <input class="sb-search-input input__field--madoka" placeholder="Search..." type="search" id="input-31">
                    <label class="input__label" for="input-31">
                        <svg class="graphic" width="100%" height="100%" viewBox="0 0 404 77" preserveAspectRatio="none">
                            <path d="m0,0l404,0l0,77l-404,0l0,-77z"></path>
                        </svg>
                    </label>
                </form>
            </div><!--//end-search-box-->
            <div class="clearfix"> </div>
        </div>
        <div class="header-right">
            <div class = "profile_details_left">
                <ul>
                    <a class="navbar-brand" style="margin-top:13px;height:100%;color:black;font-family: 'Franklin Gothic Medium Cond';margin-right:5px;background-color:rgba(0,0,259,0.2);" href="<c:url value="/logout" /> ">Logout</a>
                </ul>
            </div>

        </div>
        <%

            List<MarketItemsEntity> itemsList = null;
            if(request.getAttribute("itemsList") != null){
                itemsList = (List<MarketItemsEntity>) request.getAttribute("itemsList");
            }
        %>
        <!--notification menu end -->
        <div class="profile_details">
            <ul>
                <li class="dropdown profile_details_drop">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                        <div class="profile_img">
                            <span class="prfil-img"><img src="/resources/img/profileImg.JPG" height="50px" width="50px" alt=""> </span>
                            <div class="user-name">
                                <p><%out.print(cashierEntity.getName());%></p>
                                <span>Cashier</span>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </a>
                    <%--<ul class="dropdown-menu drp-mnu">--%>
                    <%--<li> <a href="/"></i> Settings</a> </li>--%>
                    <%--<li> <a href="/"></i> Profile</a> </li>--%>
                    <%--<li> <a href="/"></i> Logout</a> </li>--%>
                    <%--</ul>--%>
                </li>
            </ul>
        </div>
        <div class="clearfix"> </div>
    </div>
    <div class="clearfix"> </div>
</div>
<!-- MAIN INFO-->

<div id="page-wrapper" style="min-height: 572px;">
    <div class="main-page general">
        <div class="panel-info" style="margin: 120px;">

            <%
                System.out.println(request.getAttribute("errorMessage"));
                if(request.getAttribute("errorMessage") != null){
                out.print("<span class='label label-danger>"+request.getAttribute("errorMessage")+"</span>");
            }
            %>
            <table class="table table-bordered">
                <tr>
                    <th>Name of the product</th>
                    <th>Amount in store</th>
                    <th>Price</th>
                    <th>Transaction<br>Open</th>
                    <th>Product code</th>
                    <th>Necessary amount</th>
                    <th>Transaction<br>Close</th>
                </tr>

                    <%
                        for (MarketItemsEntity item:
                             itemsList) {
                            if(item.getAmounts() != 0) {
                                out.print("<tr><td>" + item.getName() + "</td>" +
                                        "<td>" + item.getAmounts() + "</td>" + "<td>" + item.getPrice() + "</td>" +
                                        "<td>" +
                                        "<input type='button' style=\"text-align:center;display:inline-block;\" class='btn btn-info' value='Open'" +
                                        "onclick=\"document.getElementById('"+item.getId()+"').removeAttribute('disabled')\">" +
                                        "</td>" +
                                        "<form id='form' action='/products/commitTransaction'>" +
                                        "<input name=\"${_csrf.parameterName}\" value=\"${_csrf.token}\" type=\"hidden\">" +
                                        "<input type='hidden' name='item_id' value = '" + item.getId() + "'>" +
                                        "<input type='hidden' name='cashier_id' value = '" + cashierEntity.getId() + "'>" +
                                        "<td><input " +
                                        "onkeypress=\"document.getElementById('p"+item.getId()+"').removeAttribute('disabled')\" " +
                                        "id='"+item.getId()+"' name='uniprodcode' class='form-control' type='text' maxlength=10" +
                                        " disabled></td>" +
                                        "<td><input onkeypress=\"document.getElementById('close"+item.getId()+"').removeAttribute('disabled')\" " +
                                        "id='p"+item.getId()+"' name = 'amount' type='number' class='form-control' disabled></td>" +
                                        "<td>" +
                                        "<input type='submit' id='close"+item.getId()+"'style=\"text-align:center;display:inline-block;\" " +
                                        "class='btn btn-success' value ='Close' disabled></td><tr></form>");
                            }else{
                                out.print("<tr><td>"+item.getName()+"</td>" +
                                        "<td>"+item.getAmounts()+"</td>"+
                                        "<td>"+item.getPrice()+"</td>"+
                                        "<td> Not available </td>"+
                                        "<td> Not available </td>"+
                                        "<td> Not available </td>"+
                                        "<td> Not available </td>"+
                                        "</tr>");
                            }
                        }
                    %>


            </table>

        </div>
    </div>

    <div class="clearfix"> </div>
</div>

<div class="clearfix"> </div>
</div>
</div>

<!--footer-->
<div class="footer">
    <p>Admin Panel.</p>
</div>
<!--//footer-->
</div>
<!-- Classie -->
<script>
    function showDiv() {
        document.getElementById('toShow').style.display = "block";
    }
</script>
<script>
    var menuLeft = document.getElementById( 'cbp-spmenu-s1' ),
        showLeftPush = document.getElementById( 'showLeftPush' ),
        body = document.body;

    showLeftPush.onclick = function() {
        classie.toggle( this, 'active' );
        classie.toggle( body, 'cbp-spmenu-push-toright' );
        classie.toggle( menuLeft, 'cbp-spmenu-open' );
        disableOther( 'showLeftPush' );
    };


    function disableOther( button ) {
        if( button !== 'showLeftPush' ) {
            classie.toggle( showLeftPush, 'disabled' );
        }
    }
</script>

