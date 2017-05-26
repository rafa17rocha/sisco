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

    <div class="container-fluid">
      <div class="row">
      <!-- Menu Lateral -->
        <c:import url="menuLeft.jsp"/>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
<!--           <h1 class="page-header">Usuários</h1> -->

          <h2 class="sub-header">Usuários Cadastrados</h2>
          
          <form action="controller.do" method="post">
          <div class="input-group h2">
	          <input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar Clientes">
		          <span class="input-group-btn">
		          <button class="btn btn-primary"  type="submit" name="command" value="ListarUsuario">
		          <span class="glyphicon glyphicon-search"></span>
		          </button>
	          </span>
          </div>
          </form>
          
				<c:if test="${not empty lista}">
					<div class="table-responsive">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>ID</th>
									<th>Tipo</th>
									<th>Nome</th>
									<th>CPF</th>
									<th>Expediente</th>
									<th>Livre Acesso</th>
									<th>Altera Ar</th>
									<th>Usuário</th>
									<th>Senha</th>
									<th>Ação<th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="usuario" items="${lista}">
									<tr>
									<td>${usuario.id}</td>
									<td>
									<c:if test="${usuario.tipo == 0}">[0] Funcionário</c:if>
									<c:if test="${usuario.tipo == 1}">[1] Atendente</c:if>
									<c:if test="${usuario.tipo == 2}">[2] Síndico</c:if>
									</td>
									<td>${usuario.nome}</td>
									<td>${usuario.cpf}</td>
									<td>${usuario.expediente}</td>
									<td>
										<c:choose>
											<c:when test="${usuario.livreAcesso eq true}">Sim</c:when>
											<c:otherwise>Não</c:otherwise>
										</c:choose>
									</td>
									<td>
									<c:choose>
											<c:when test="${usuario.alteraAr eq true}">Sim</c:when>
											<c:otherwise>Não</c:otherwise>
										</c:choose>
									</td>
									<td>${usuario.usuario}</td>
									<td>${usuario.senha}</td>
									<td class="actions">
										<a href="controller.do?command=AlterarUsuario&cpf=${usuario.cpf}" class="btn btn-default btn-xs" role="button">
					                      <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
					                    </a>
					                    <a href="controller.do?command=RemoverUsuario&cpf=${usuario.cpf}" class="btn btn-default btn-xs" role="button">
					                      <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
					                    </a>
					                </td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
			</c:if>

        </div>
      </div>
    </div>

    <script src="js/jquery-1.12.4.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>