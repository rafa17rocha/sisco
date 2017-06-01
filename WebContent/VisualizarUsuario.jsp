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
    <link rel="stylesheet" type="text/css" href="css/bootstrap-clockpicker.min.css">
    <style type="text/css">
		.navbar h3 {
			color: #f5f5f5;
			margin-top: 14px;
		}
		.hljs-pre {
			background: #f8f8f8;
			padding: 3px;
		}
		.footer {
			border-top: 1px solid #eee;
			margin-top: 40px;
			padding: 40px 0;
		}
		.input-group {
			width: 110px;
			margin-bottom: 10px;
		}
		.pull-center {
			margin-left: auto;
			margin-right: auto;
		}
		@media (min-width: 768px) {
		  .container {
		    max-width: 730px;
		  }
		}
		@media (max-width: 767px) {
		  .pull-center {
		    float: right;
		  }
		}
	</style>
  </head>
  <body>
  <!-- Menu Superior -->
  <c:import url="menuTop.jsp"/>
  <!-- Menu Lateral -->
<%--   <c:import url="menuLeft.jsp"/> --%>
  <!-- Modal de Exclusão -->
  <c:import url="ExcluirUsuario.jsp"/>
  
<script type="text/javascript">
    $('.clockpicker').clockpicker();
</script>
    <div class="container-fluid">
      <div class="row">
<!--         <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main"> -->
        <div class="col-sm-12 col-md-12 main">
          <h1 class="page-header">Visualizar Usuário - ID ${usuario.id}</h1>
          
          <form class="form-horizontal">
			<fieldset class="col-md-6">
			
			<input type="hidden" name="id" value="${usuario.id}" disabled/>
			
			<!-- Select Basic -->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="selectbasic">Tipo</label>
			  <div class="col-md-8">
			    <select id="tipo" name="tipo" class="form-control" disabled>
			      <option value="0" <c:if test="${usuario.tipo == 0}">selected</c:if>>Funcionário</option>
			      <option value="1" <c:if test="${usuario.tipo == 1}">selected</c:if>>Atendente</option>
			      <option value="2" <c:if test="${usuario.tipo == 2}">selected</c:if>>Síndico</option>
			    </select>
			  </div>
			</div>
			
			<!-- Text input-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="nome">Nome</label>  
			  <div class="col-md-8">
			  <input name="nome" class="form-control input-md" id="nome" type="text" placeholder="Nome e sobrenome" value="${usuario.nome}" disabled>
			    
			  </div>
			</div>
			
			<!-- Text input-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="cpf">CPF</label>  
			  <div class="col-md-8">
			  <input name="cpf" class="form-control input-md" id="cpf" type="number" maxlength="11" placeholder="11 dígitos" value="${usuario.cpf}" disabled>
			    
			  </div>
			</div>
			
			<!-- Text input-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="empresa">Empresa</label>  
			  <div class="col-md-8">
			  <input name="empresa" class="form-control input-md" id="empresa" type="text" placeholder="Sistema Predial" value="${usuario.idEmpresa}" disabled>
			  
			  </div>
			</div>

			<!-- Select Basic -->
			<div class="form-group">
			<label class="col-md-4 control-label" for="expediente">Expediente</label>
			<div class="col-md-4">
				<div class="input-group-block clockpicker" data-placement="top" data-align="top" data-autoclose="true">
				<input type="text" class="form-control" id="expedienteEntrada" name="expedienteEntrada" value="${expedienteEntrada}" disabled>
				</div>
			</div>
			<div class="col-md-4">
				<div class="input-group-block clockpicker" data-placement="top" data-align="top" data-autoclose="true">
				<input type="text" class="form-control" id="expedienteSaida" name="expedienteSaida" value="${expedienteSaida}" disabled>
				</div>
			</div>
			</div>
			</fieldset>
			<fieldset class="col-md-6">
			<!-- Select Basic -->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="livreAcesso">Livre Acesso</label>
			  <div class="col-md-8">
			    <select name="livreAcesso" class="form-control" id="livreAcesso" disabled>
			      <option value="false">Não</option>
			      <option value="true" <c:if test="${usuario.livreAcesso}">selected</c:if> >Sim</option>
			    </select>
			  </div>
			</div>
			
			<!-- Select Basic -->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="alteraAr">Altera Ar</label>
			  <div class="col-md-8">
			    <select name="alteraAr" class="form-control" id="alteraAr" disabled>
			      <option value="false">Não</option>
			      <option value="true" <c:if test="${usuario.alteraAr}">selected</c:if> >Sim</option>
			    </select>
			  </div>
			</div>
			
			<!-- Text input-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="usuario">Usuário</label>  
			  <div class="col-md-8">
			  <input name="usuario" class="form-control input-md" id="usuario" type="text" placeholder="Fulano Pereira" value="${usuario.usuario}" disabled>
			    
			  </div>
			</div>
			
			<!-- Password input-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="senha">Senha</label>
			  <div class="col-md-8">
			    <input name="senha" class="form-control input-md" id="senha" type="password" placeholder="" value="${usuario.senha}" disabled>
			    
			  </div>
			</div>
			
			<!-- Button (Double) -->
			<div class="form-group">
			  <label class="col-md-4"></label>
			  <div class="col-md-4">
			  	<a href="controller.do?command=AlterarUsuario&id=${usuario.id}" class="btn btn-primary btn-block">Editar</a>
			  </div>
			  <div class="col-md-4">
			  	<button id="btn${usuario.id}%>" type="button" class="btn btn-danger btn-block" data-toggle="modal" data-target="#delete-modal" data-usuario="${usuario.id}">Excluir</button>
			  </div>
			</div>
			
			</fieldset>
			</form>
			
        </div>
      </div>
    </div>

    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/bootstrap-clockpicker.min.js"></script>
	<script type="text/javascript">
		$('.clockpicker').clockpicker()
			.find('input').change(function(){
				// TODO: time changed
				console.log(this.value);
		});
	</script>
    <script type="text/javascript">
        $("#delete-modal").on('show.bs.modal', function(event){
            var button = $(event.relatedTarget); //botao que disparou a modal
            var recipient = button.data('usuario');
            $("#id_excluir").val(recipient);
        });
    </script>

  </body>
</html>