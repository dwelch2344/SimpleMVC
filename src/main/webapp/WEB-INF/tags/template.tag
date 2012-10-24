<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/WEB-INF/includes/init.jsp" %>
<%@ attribute name="head" required="false" fragment="true" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title> Home : ${siteName}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="${_baseUrl}/resources/bootstrap/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
      .sidebar-nav {
        padding: 9px 0;
      }
    </style>
    <link href="${_baseUrl}/resources/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="${_baseUrl}/resources/bootstrap/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${_baseUrl}/resources/bootstrap/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${_baseUrl}/resources/bootstrap/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${_baseUrl}/resources/bootstrap/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="${_baseUrl}/resources/bootstrap/ico/apple-touch-icon-57-precomposed.png">
    
    <%-- Insert "head" content from the calling page, if any --%>
    <jsp:invoke fragment="head"/>
    
  </head>

  <body>

    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <a class="brand" href="#"> ${siteName} </a>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li class="active"><a href="#">Home</a></li>
              <li><a href="#about">About</a></li>
              <li><a href="#contact">Contact</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>

    <div class="container-fluid">
    	<%-- Insert the body content from the page --%>
    	<jsp:doBody />
    </div><!--/.fluid-container-->

	<%--
    <!-- Placed at the end of the document so the pages load faster -->    
 	<script src="${_baseUrl}/resources/bootstrap/js/jquery.js"></script>
    <script src="${_baseUrl}/resources/bootstrap/js/bootstrap-transition.js"></script>
    <script src="${_baseUrl}/resources/bootstrap/js/bootstrap-alert.js"></script>
    <script src="${_baseUrl}/resources/bootstrap/js/bootstrap-modal.js"></script>
    <script src="${_baseUrl}/resources/bootstrap/js/bootstrap-dropdown.js"></script>
    <script src="${_baseUrl}/resources/bootstrap/js/bootstrap-scrollspy.js"></script>
    <script src="${_baseUrl}/resources/bootstrap/js/bootstrap-tab.js"></script>
    <script src="${_baseUrl}/resources/bootstrap/js/bootstrap-tooltip.js"></script>
    <script src="${_baseUrl}/resources/bootstrap/js/bootstrap-popover.js"></script>
    <script src="${_baseUrl}/resources/bootstrap/js/bootstrap-button.js"></script>
    <script src="${_baseUrl}/resources/bootstrap/js/bootstrap-collapse.js"></script>
    <script src="${_baseUrl}/resources/bootstrap/js/bootstrap-carousel.js"></script>
    <script src="${_baseUrl}/resources/bootstrap/js/bootstrap-typeahead.js"></script>
	--%>

  </body>
</html>