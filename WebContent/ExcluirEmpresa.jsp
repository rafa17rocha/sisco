<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
 
<div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="modalLabel">Excluir Empresa</h4>
            </div>
            <div class="modal-body">
                Deseja realmente excluir esta empresa?
            </div>
            <div class="modal-footer">
                <form action="controller.do" method="post">
                    <input type="hidden" name="id" id="id_excluir" />
                    <button type="submit" class="btn btn-danger" name="command" value="ExcluirEmpresa">Sim</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Não</button>
                </form>
            </div>
        </div>
    </div>
</div>