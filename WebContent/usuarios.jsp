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
  <!-- Modal de Exclusão -->
  <c:import url="ExcluirUsuario.jsp"/>
  
    <div class="container-fluid">
      <div class="row">
      
<!--         <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main"> -->
        <div class="col-sm-12 col-md-12  main">
        
          <h2 class="sub-header">Usuários Cadastrados</h2>
          
          <div class="row ">
	          <div class="col-sm-12 col-md-12">
		          <div class="col-sm-10 col-md-10">
			          <form action="controller.do" method="post">
				          <div class="input-group h2">
					          <input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar Usuários">
						          <span class="input-group-btn">
						          <button class="btn btn-primary"  type="submit" name="command" value="ListarUsuario">
						          <span class="glyphicon glyphicon-search"></span>
						          </button>
					          </span>
				          </div>
			          </form>
		          </div>
		          
		          <div class="col-sm-2 col-md-2">
			          <div class="input-group h2">
			              <a href="CadastrarUsuario.jsp" class="btn btn-primary btn-block">Cadastrar</a>
			          </div>
			      </div>
	          </div>
          </div>
          
				<c:if test="${not empty listaUsuarios}">
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
									<th>Ação<th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="usuario" items="${listaUsuarios}">
									<tr>
									<td>${usuario.id}</td>
									<td>
									<c:if test="${usuario.tipo == 0}">Funcionário</c:if>
									<c:if test="${usuario.tipo == 1}">Atendente</c:if>
									<c:if test="${usuario.tipo == 2}">Síndico</c:if>
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
									<td class="actions">
										<a href="controller.do?command=VisualizarUsuario&id=${usuario.id}" class="btn btn-default btn-xs" role="button">
					                      <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
					                    </a>
										<a href="controller.do?command=AlterarUsuario&id=${usuario.id}" class="btn btn-default btn-xs" role="button">
					                      <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
					                    </a>
					                    <button id="btn${usuario.id}%>" type="button" class="btn btn-default btn-xs" data-toggle="modal" data-target="#delete-modal" data-usuario="${usuario.id}">
					                    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
					                    </button>
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

    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $("#delete-modal").on('show.bs.modal', function(event){
            var button = $(event.relatedTarget); //botao que disparou a modal
            var recipient = button.data('usuario');
            $("#id_excluir").val(recipient);
        });
    </script>
  </body>
</html>