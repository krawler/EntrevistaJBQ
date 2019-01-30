<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>

<sf:form modelAttribute="ordemServico" action="../finalizar" method="POST">

	<div class="form-group col-sm-12">
		<label for="cliente" class="col-sm-1 control-label"> <sf:errors
				cssClass="has-error" path="cliente" /> Cliente
		</label>
		<div class="col-sm-5">
			<input type="text" value="${ordemServico.cliente.nome}" disabled="true"  class="form-control" />
		</div>
	</div>
	<div class="form-group col-sm-12">
		<label for="servicos" class="col-sm-1 control-label"> <sf:errors
				cssClass="has-error" path="servicos" /> Serviços
		</label>
		<div class="col-sm-5">
			<sf:select path="servicos" class="form-control">
				<sf:options items="${ordemServico.servicos}" itemValue="id" itemLabel="descricao" />
			</sf:select>
		</div>
	</div>
	<div class="form-group col-sm-4 col-sm-offset-2 right">
		<a href="../listar" class="btn btn-default">Voltar</a>
		<button type="submit" class="btn btn-primary">Finalizar
			Serviço</button>
	</div>

</sf:form>