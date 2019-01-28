<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<sf:form modelAttribute="cliente" action="incluir" method="POST">
	
	<div class="form-group col-sm-12">
		<label for="nome" class="col-sm-1 control-label">
		 <sf:errors cssClass="has-error" path="nome"/>
		 Nome
		</label>
		<div class="col-sm-5">
			<sf:input path="nome" class="form-control"/>
		</div>
	</div>
	
	<div class="form-group col-sm-12">
		<label for="endereco" class="col-sm-1 control-label">
		 <sf:errors cssClass="has-error" path="endereco"/>
		 Endereço 	
		</label>
		<div class="col-sm-5">
			<sf:input path="endereco" class="form-control"/>
		</div>
	</div>
	
	
	<div class="form-group col-sm-4 col-sm-offset-2 right">
		<button type="submit" class="btn btn-primary">Gravar</button>
	</div>
</sf:form>
