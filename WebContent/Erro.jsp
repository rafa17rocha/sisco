<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	
    <title>SISCO</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
  </head>
  <body>
  <!-- Menu Superior -->
  <c:import url="menuTop.jsp"/>
  <!-- Menu Lateral -->
<%--   <c:import url="menuLeft.jsp"/> --%>

    <div class="container-fluid">
      <div class="row">
<!--         <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main"> -->
        <div class="col-sm-12 col-md-12 main">
          <h1 class="page-header" align="center">Sistema de Controle Predial</h1>
          <br><br><br>
          
          <div class="alert alert-danger" role="alert">
			<h2 class="text-center"><span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
			<span class="sr-only">Erro:</span> Aconteceu um erro.</h2>
		  </div>
		  
		<p class="lead text-danger bg-danger text-justify"><strong>Causa:</strong> ${pageContext.errorData.throwable.message}</p>
		
		<p class="text-danger bg-danger text-justify"><strong>Pilha de Execução:</strong><br>
			<c:forEach var="trace" items="${pageContext.errorData.throwable.stackTrace}">
				 em ${trace.className}.${trace.methodName}
				 <c:if test="${trace.nativeMethod}">
				 	(Método Nativo)<br>
				 </c:if>
				 <c:if test="${not trace.nativeMethod}">
				 	(${trace.fileName}:${trace.lineNumber})<br>
				 </c:if>
			</c:forEach>	
		</p>
        </div>
      </div>
    </div>

    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>