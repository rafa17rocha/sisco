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
  <c:import url="ExcluirEmpresa.jsp"/>
  
    <div class="container-fluid">
      <div class="row">
      
<!--         <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main"> -->
        <div class="col-sm-12 col-md-12  main">
        
          <h2 class="sub-header">Empresas Cadastradas</h2>
          
          <div class="row ">
	          <div class="col-sm-12 col-md-12">
		          <div class="col-sm-10 col-md-10">
			          <form action="controller.do" method="post">
				          <div class="input-group h2">
					          <input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar Empresas">
						          <span class="input-group-btn">
						          <button class="btn btn-primary"  type="submit" name="command" value="ListarEmpresa">
						          <span class="glyphicon glyphicon-search"></span>
						          </button>
					          </span>
				          </div>
			          </form>
		          </div>
		          
		          <div class="col-sm-2 col-md-2">
			          <div class="input-group h2">
			              <a href="CadastrarEmpresa.jsp" class="btn btn-primary btn-block">Cadastrar</a>
			          </div>
			      </div>
	          </div>
          </div>
          
				<c:if test="${not empty listaEmpresas}">
					<div class="table-responsive">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>ID</th>
									<th>Razão Social</th>
									<th>CNPJ</th>
									<th>Conjunto</th>
									<th>Horário de Funcionamento</th>
									<th>Horário do Ar</th>
									<th>Temperatura do Ar</th>
									<th>Ação</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="empresa" items="${listaEmpresas}">
									<tr>
									<td>${empresa.id}</td>
									<td>${empresa.razaoSocial}</td>
									<td>${empresa.cnpj}</td>
									<td>${empresa.conjunto}</td>
									<td>${empresa.horarioDeFuncionamento}</td>
									<td>${empresa.horarioDoAr}</td>
									<td>${empresa.temperatura}</td>
									<td class="actions">
										<a href="controller.do?command=VisualizarEmpresa&id=${empresa.id}" class="btn btn-default btn-xs" role="button">
					                      <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
					                    </a>
										<a href="controller.do?command=AlterarEmpresa&id=${empresa.id}" class="btn btn-default btn-xs" role="button">
					                      <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
					                    </a>
					                    <button id="btn${empresa.id}%>" type="button" class="btn btn-default btn-xs" data-toggle="modal" data-target="#delete-modal" data-empresa="${empresa.id}">
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
            var recipient = button.data('empresa');
            $("#id_excluir").val(recipient);
        });
    </script>
  </body>
</html>