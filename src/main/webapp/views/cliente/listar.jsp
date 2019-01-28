<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>

<div class="col-xs-12 marginTop sem-padding-esquerda">
	<a href="<c:url value="/cliente/cadastro"/>" class="btn btn-default sem-margin-esquerda">Novo Cliente</a>
</div>
<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-header">
				<div class="box-name">					
					<div class="col-xs-9"><span><h4 class="marginTop">Listagem de Clientes</h4></span></div>
					
				</div>
				<div class="box-icons">
					<a class="collapse-link">
						<i class="fa fa-chevron-up"></i>
					</a>
					<a class="expand-link">
						<i class="fa fa-expand"></i>
					</a>
					<a class="close-link">
						<i class="fa fa-times"></i>
					</a>
				</div>
				<div class="no-move"></div>
			</div>
			<div class="box-content no-padding table-responsive">
				<table class="table table-bordered table-striped table-hover table-heading table-datatable" id="datatable-2">
					<thead>
						<tr>
							<th width="40%">Nome</th>
							<th width="40%">Endereço</th>
							<th>Ações</th>				
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${clientes}" var="cliente">
							<tr>
								<td>${cliente.nome}</td>
								<td>${cliente.endereco}</td>
								<td>
									<table>
										<tr>
										   <td><a href="<c:url value="/ordem/ordens-cliente/${cliente.id}"/>" class="btn btn-default">Serviços</a></td>
										   <td><a href="<c:url value="/cliente/cadastro/${cliente.id}"/>" class="btn btn-default btn-margin-left">Editar</a></td>
										   <td><a href="<c:url value="/cliente/excluir/${cliente.id}"/>" class="btn btn-danger btn-margin-left">Excluir</a></td>	
										</tr>
									</table>
								</td>
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
