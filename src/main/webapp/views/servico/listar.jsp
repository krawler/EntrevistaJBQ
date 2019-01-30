<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>

<div class="box-header form-incluir-listagem">
	<sf:form modelAttribute="servico" action="incluir" method="POST">

		<div class="form-group col-sm-12">
			<label for="descricao" class="col-sm-1 control-label"> <sf:errors
					cssClass="has-error" path="descricao" /> Descrição:
			</label>
			<div class="col-sm-7">
				<sf:input path="descricao" class="form-control" />
			</div>
			<div class="col-sm-3">
				<button type="submit" class="btn btn-primary">Incluir</button>
			</div>
		</div>

	</sf:form>

</div>

<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-header">
				<div class="box-name">
					<div class="col-xs-9">
						<span class="center"><h4 class="marginTop">Listagem de Serviços</h4></span>
					</div>
				</div>
				<div class="box-icons">
					<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
					</a> <a class="expand-link"> <i class="fa fa-expand"></i>
					</a> <a class="close-link"> <i class="fa fa-times"></i>
					</a>
				</div>
				<div class="no-move"></div>
			</div>
			<div class="box-content no-padding table-responsive">
				<table
					class="table table-bordered table-striped table-hover table-heading table-datatable"
					id="datatable-2">
					<thead>
						<tr>
							<th>Descrição</th>
							<th>Ações</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${servicos}" var="servico">
							<tr>
								<td>${servico.descricao}</td>
								<td><a href="excluir/${servico.id}" class="btn btn-danger">Excluir</a></td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr>

						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>
</div>
