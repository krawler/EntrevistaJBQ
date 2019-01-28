<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page isELIgnored="false"%>

<sf:form modelAttribute="ordemServico" action="incluir" method="POST">

	<div class="form-group col-sm-12">
		<label for="cliente" class="col-sm-1 control-label"> 
		  <sf:errors	cssClass="has-error" path="cliente" /> 
		  Cliente
		</label>
		<div class="col-sm-5">
			<sf:select path="cliente">
				<sf:options items="${ clientes }" itemValue="id" itemLabel="nome" />
			</sf:select>
		</div>
	</div>

	<div class="form-group col-sm-12">
		<label for="servico" class="col-sm-1 control-label"> <sf:errors
				cssClass="has-error" path="servico" /> Serviços
		</label>
		<div class="col-sm-5">
			<sf:select path="servico">
				<sf:options items="${ servicos }" itemValue="id" itemLabel="descricao" />
			</sf:select>
		</div>
	</div>
	
	<div class="form-group col-sm-12">
		<label for="dataFim" class="col-sm-1 control-label"> <sf:errors
				cssClass="has-error" path="dataFim" /> Data final
		</label>
		<div class="col-sm-5">
			<sf:input path="dataFim" class="form-control"/>
		</div>
	</div>
	
	<div class="form-group col-sm-1 col-sm-offset-2 right">
		<a href="/listar" class="btn btn-primary">Voltar</a>
	</div>
	<div class="form-group col-sm-1 col-sm-offset-2 right">
		<button type="submit" class="btn btn-primary">Gravar</button>
	</div>
</sf:form>