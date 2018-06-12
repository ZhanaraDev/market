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
<%@ page import="org.zhanara.models.MarketTransactionHistoryEntity" %>
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
<div class="main-content">
    <!--left-fixed -navigation-->
    <div class=" sidebar" role="navigation">
        <div class="navbar-collapse">
            <nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1">
                <ul class="nav" id="side-menu">
                    <li>
                        <a href="/admin/" <%if(request.getAttribute("cashiersList") != null){%>class="active" <%}%> ></i>Cashiers</a>
                    </li>
                    <li>
                        <a href="/admin/items" <%if(request.getAttribute("itemsList") != null){%>class="active" <%}%>>Items </a>

                        <!-- /nav-second-level -->
                    </li>
                    <li>
                        <a href="/transactions/all" <%if(request.getAttribute("transactionsList") != null){%>class="active" <%}%>>Transactions </a>

                        <!-- /nav-second-level -->
                    </li>

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
            <!--notification menu end -->
            <div class="profile_details">
                <ul>
                    <li class="dropdown profile_details_drop">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                            <div class="profile_img">
                                <span class="prfil-img"><img src="/resources/img/profileImg.JPG" height="50px" width="50px" alt=""> </span>
                                <div class="user-name">
                                    <p>${user}</p>
                                    <span>Administrator</span>
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
    <%
        List<MarketCashierEntity> cashiersList = null;
        List<MarketItemsEntity> itemsList = null;
        List<MarketTransactionHistoryEntity> transactionsList = null;
        if(request.getAttribute("cashiersList") != null) {
            cashiersList = (List<MarketCashierEntity>) request.getAttribute("cashiersList");
        }else if(request.getAttribute("itemsList") != null){
            itemsList = (List<MarketItemsEntity>) request.getAttribute("itemsList");
        }else if(request.getAttribute("transactionsList") != null) {
            transactionsList = (List<MarketTransactionHistoryEntity>) request.getAttribute("transactionsList");
        }

    %>
    <div id="page-wrapper" style="min-height: 572px;">
        <div class="main-page general">
            <div class="panel-info" style="margin: 120px;">
                <%
                    if(cashiersList != null){
                %>
                <center>

                    <form method = "post" action="/admin/addCashier">
                        <div class="form-group">
                            <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">
                            <input class="form-control" type="text" placeholder="Enter login" name="login">
                            <input class="form-control" type="text" placeholder="Enter name" name="name">
                            <input class="form-control" type="text" placeholder="Enter surname" name="surname">
                            <input type="submit" class="btn btn-success" value = "Add Cashier">
                        </div>
                    </form>

                </center>
                <table class="table table-bordered" margin-top:50px;>
                <tr>
                    <th>Name</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                <%

                    if(!cashiersList.isEmpty()) {
                        for (MarketCashierEntity cashier :
                                cashiersList) {
                            out.print("<tr>"+"<td>"+cashier.getName()+" "+cashier.getSurname()+"</td>"+
                                    "<td> <a class = 'btn btn-info' href='/admin/editCashier?id="+cashier.getId()+"'>\n" +
                                    "Edit</a></td>"+
                                    " <td><a class = 'btn btn-danger' href='/admin/deleteCashier?id="+cashier.getId()+"'>\n" +
                                           "Delete</a></td>"+
                                    "</tr>");
                        }
                    }else {
                        out.print("<h4><span class=\"label label-danger\">There are no cashiers</span></h4>");
                    }

                %>
            </table>
                <%}else if(itemsList != null){
                %>
                <center>

                    <form method = "post" action="/admin/addItem">
                        <div class="form-group">
                            <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">
                            <input class="form-control" type="text" placeholder="Enter product name" name="name">
                            <input class="form-control" type="text" placeholder="Universal Product code" name="uniProdCode" maxlength="10">
                            <input class="form-control" type="number" placeholder="Enter price" name="price">
                            <input class="form-control" type="number" placeholder="Enter amounts" name="amounts">
                            <input type="submit" class="btn btn-success" value = "Add Item">
                        </div>
                    </form>

                </center>
                <table class="table table-bordered" margin-top:50px;>
                    <tr>
                        <th>Name</th>
                        <th>Universal Product code</th>
                        <th>Price</th>
                        <th>Amounts</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    <%

                        if(!itemsList.isEmpty()) {
                            for (MarketItemsEntity item :
                                    itemsList) {
                                out.print("<tr>"+"<td>"+item.getName()+"</td>"+
                                        "<td>"+item.getUniversalProductCode()+"</td>"+
                                        "<td>"+item.getPrice()+"</td>"+
                                        "<td>"+item.getAmounts()+"</td>"+
                                        "<td> <a class = 'btn btn-info' href='/admin/editItem?id="+item.getId()+"'>\n" +
                                        "Edit</a></td>"+
                                        " <td><a class = 'btn btn-danger' href='/admin/deleteItem?id="+item.getId()+"'>\n" +
                                        "Delete</a></td>"+
                                        "</tr>");
                            }
                        }else {
                            out.print("<h4><span class=\"label label-danger\">There are no items</span></h4>");
                        }

                    %>
                </table>
                <%
                }else if(transactionsList != null){
                    if(!(transactionsList.isEmpty())){
                 %>
                <table class="table table-bordered">
                    <tr>
                        <th>Num</th>
                        <th>Name of the product</th>
                        <th>Cashier Name</th>
                        <th>Amount</th>
                        <th>Time</th>
                        <th>Cost</th>
                    </tr>

                    <%
                        int i=0;
                        for (MarketTransactionHistoryEntity transaction:
                                transactionsList) {
                            i++;
                            out.print("<tr>"+
                                    "<td>"+i+"</td>"+
                                    "<td>"+transaction.getMarketItemsByItemId().getName()+"</td>"+
                                    "<td>"+transaction.getMarketCashierByCashierId().getName()+"</td>"+
                                    "<td>"+transaction.getAmount()+"</td>"+
                                    "<td>"+transaction.getTransactionTime()+"</td>"+
                                    "<td>"+transaction.getAmount()*transaction.getMarketItemsByItemId().getPrice()+"</td>"+
                                    "</tr>"
                            );

                        }
                    %>


                </table>
                <%
                    }
                }
                %>
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
<!--scrolling js-->
<script src="./jquery.nicescroll.js.Без названия"></script>
<script src="./scripts.js.Без названия"></script><div id="ascrail2000" class="nicescroll-rails" style="width: 6px; z-index: 1000; background: rgb(66, 79, 99); cursor: default; position: fixed; top: 0px; height: 100%; right: 0px; opacity: 0;"><div style="position: relative; top: 0px; float: right; width: 6px; height: 202px; background-color: rgb(242, 179, 63); border: 0px; background-clip: padding-box; border-radius: 10px;"></div></div><div id="ascrail2000-hr" class="nicescroll-rails" style="height: 6px; z-index: 1000; background: rgb(66, 79, 99); position: fixed; left: 0px; width: 100%; bottom: 0px; cursor: default; display: none; opacity: 0;"><div style="position: relative; top: 0px; height: 6px; width: 1366px; background-color: rgb(242, 179, 63); border: 0px; background-clip: padding-box; border-radius: 10px;"></div></div>
<!--//scrolling js-->
<!-- Bootstrap Core JavaScript -->
<script src="./bootstrap.js.Без названия"> </script>

<div class="jqvmap-label" style="display: none;"></div></body></html>
