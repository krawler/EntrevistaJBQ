<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<link rel="stylesheet" href="<c:url value="/recursos/plugins/bootstrap/bootstrap.css"/>" />
	<link rel="stylesheet" href="<c:url value="/recursos/plugins/jquery-ui/jquery-ui.min.css"/>" />
	<link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
	<link href='http://fonts.googleapis.com/css?family=Righteous' rel='stylesheet' type='text/css'>
	<link href="<c:url value="/recursos/plugins/fancybox/jquery.fancybox.css"/>" rel="stylesheet">
	<link href="<c:url value="/recursos/plugins/fullcalendar/fullcalendar.css"/>" rel="stylesheet">
	<link href="<c:url value="/recursos/css/style.css"/>" rel="stylesheet">
	<link href="<c:url value="/recursos/plugins/select2/select2.css" />" rel="stylesheet">
	<title><tiles:getAsString name="titulo" /></title>
</head>
<body>

	<tiles:insertAttribute name="cabecalho"/>
	
	<div id="main" class="container-fluid">
		<div class="row">	
			<tiles:insertAttribute name="menu"/>
			<!--Start Content-->
			<div id="content" class="col-xs-12 col-sm-10">
				<tiles:insertAttribute name="conteudo"/>
				<!-- 
				<div class="preloader">
					<img src="<c:url value="recursos/img/devoops_getdata.gif" />" class="devoops-getdata" alt="preloader"/>
				</div>
				<div id="ajax-content"></div>
				 -->
			</div>
		<!--End Content-->
		</div>
	</div>

	<tiles:insertAttribute name="rodape"/>


</body>
</html>