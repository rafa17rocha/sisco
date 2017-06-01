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
  <c:import url="ExcluirEmpresa.jsp"/>

    <div class="container-fluid">
      <div class="row">
      
<!--         <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main"> -->
        <div class="col-sm-12 col-md-12 main">
          <h1 class="page-header">Visualizar Empresa '${empresa.razaoSocial}'</h1>
          
          <form class="form-horizontal">
			<fieldset class="col-md-6">
			
			<input type="hidden" name="id" value="${empresa.id}" disabled/>
			
			<!-- Text input-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="id">ID</label>  
			  <div class="col-md-8">
			  <input name="id" class="form-control input-md" id="id" type="text" value="${empresa.id}" disabled>
			  </div>
			</div>
			
			<!-- Text input-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="nome">Razão Social</label>  
			  <div class="col-md-8">
			  <input name="razaoSocial" class="form-control input-md" id="razaoSocial" type="text" placeholder="Sistema de Controle Predial" value="${empresa.razaoSocial}" disabled>
			  </div>
			</div>
			
			<!-- Text input-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="cpf">CNPJ</label>  
			  <div class="col-md-8">
			  <input name="cnpj" class="form-control input-md" id="cnpj" type="number" maxlength="14" placeholder="14 dígitos" value="${empresa.cnpj}" disabled>
			  </div>
			</div>
			
			<div class="form-group">
			  <label class="col-md-4 control-label" for="conjunto">Conjunto</label>
			  <div class="col-md-8">
			    <select name="conjunto" class="form-control" id="conjunto" disabled>
			      <option value="11" <c:if test="${empresa.conjunto eq 11}">selected</c:if>>11</option>
			      <option value="12" <c:if test="${empresa.conjunto eq 12}">selected</c:if>>12</option>
			      <option value="21" <c:if test="${empresa.conjunto eq 21}">selected</c:if>>21</option>
			      <option value="22" <c:if test="${empresa.conjunto eq 22}">selected</c:if>>22</option>
			      <option value="31" <c:if test="${empresa.conjunto eq 31}">selected</c:if>>31</option>
			      <option value="32" <c:if test="${empresa.conjunto eq 32}">selected</c:if>>32</option>
			    </select>
			  </div>
			</div>
			</fieldset>
			
			<fieldset class="col-md-6">
			
			<!-- Select Basic -->
			<div class="form-group">
			<label class="col-md-4 control-label" for="horarioFuncionamento">Funcionamento</label>
			<div class="col-md-4">
				<div class="input-group-block clockpicker" data-placement="top" data-align="top" data-autoclose="true">
				<input type="text" class="form-control" id="horarioFuncionamentoInicial" name="horarioFuncionamentoInicial" value="${horarioFuncionamentoInicial}" disabled>
				</div>
			</div>
			<div class="col-md-4">
				<div class="input-group-block clockpicker" data-placement="top" data-align="top" data-autoclose="true">
				<input type="text" class="form-control" id="horarioFuncionamentoFinal" name="horarioFuncionamentoFinal" value="${horarioFuncionamentoFinal}" disabled>
				</div>
			</div>
			</div>
			
			<!-- Select Basic -->
			<div class="form-group">
			<label class="col-md-4 control-label" for="horarioFuncionamento">Horário do Ar</label>
			<div class="col-md-4">
				<div class="input-group-block clockpicker" data-placement="top" data-align="top" data-autoclose="true">
				<input type="text" class="form-control" id="horarioArInicial" name="horarioArInicial" value="${horarioArInicial}" disabled>
				</div>
			</div>
			<div class="col-md-4">
				<div class="input-group-block clockpicker" data-placement="top" data-align="top" data-autoclose="true">
				<input type="text" class="form-control" id="horarioArFinal" name="horarioArFinal" value="${horarioArFinal}" disabled>
				</div>
			</div>
			</div>
			
			<div class="form-group">
			  <label class="col-md-4 control-label" for="conjunto">Temperatura</label>
			  <div class="col-md-8">
			    <select name="conjunto" class="form-control" id="conjunto" disabled>
					<option value="16" <c:if test="${empresa.temperatura eq 16}">selected</c:if>>16</option>
					<option value="17" <c:if test="${empresa.temperatura eq 17}">selected</c:if>>17</option>
					<option value="18" <c:if test="${empresa.temperatura eq 18}">selected</c:if>>18</option>
					<option value="19" <c:if test="${empresa.temperatura eq 19}">selected</c:if>>19</option>
					<option value="20" <c:if test="${empresa.temperatura eq 20}">selected</c:if>>20</option>
					<option value="21" <c:if test="${empresa.temperatura eq 21}">selected</c:if>>21</option>
					<option value="22" <c:if test="${empresa.temperatura eq 22}">selected</c:if>>22</option>
					<option value="23" <c:if test="${empresa.temperatura eq 23}">selected</c:if>>23</option>
					<option value="24" <c:if test="${empresa.temperatura eq 24}">selected</c:if>>24</option>
					<option value="25" <c:if test="${empresa.temperatura eq 25}">selected</c:if>>25</option>
					<option value="26" <c:if test="${empresa.temperatura eq 26}">selected</c:if>>26</option>
					<option value="27" <c:if test="${empresa.temperatura eq 27}">selected</c:if>>27</option>
					<option value="28" <c:if test="${empresa.temperatura eq 28}">selected</c:if>>28</option>
					<option value="29" <c:if test="${empresa.temperatura eq 29}">selected</c:if>>29</option>
					<option value="30" <c:if test="${empresa.temperatura eq 30}">selected</c:if>>30</option>
			    </select>
			  </div>
			</div>
			
			<div class="form-group">
			  <label class="col-md-4"></label>
			  <div class="col-md-4">
			  	<a href="controller.do?command=AlterarEmpresa&id=${empresa.id}" class="btn btn-primary btn-block">Editar</a>
			  </div>
			  <div class="col-md-4">
			  	<button id="btn${empresa.id}%>" type="button" class="btn btn-danger btn-block" data-toggle="modal" data-target="#delete-modal" data-usuario="${empresa.id}">Excluir</button>
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