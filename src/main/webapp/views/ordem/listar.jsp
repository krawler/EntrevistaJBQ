<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false"%>

<div class="col-xs-12 marginTop sem-padding-esquerda">
	<a href="<c:url value="/ordem/cadastro"/>" class="btn btn-default sem-margin-esquerda">Nova
						ordem de serviço</a>	
</div>

<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-header">
				<div class="box-name">
					<div class="col-xs-4">

					</div>	
					<div class="col-xs-4">
						<span><h4 style="margin-top: 6px;">Listagem de Ordens
								de Serviço</h4></span>
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
							<th width="40%">Cliente</th>
							<th>Data Inicio</th>
							<th>Data Fim</th>
							<th>Dias Restantes</th>
							<th>Ações</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ordens}" var="ordem">							
							<tr>
								<td>${ordem.cliente.nome}</td>
								<td><fmt:formatDate pattern="dd/MM/yyyy" value="${ordem.dataInicio}"/></td>
								<td>${ordem.dataFim}</td>
								<td class="center">${ordem.diasRestantes}</td>
								<td>
									<table>
										<tr>
											<td><a
												href="<c:url value="/ordem/visualizar/${ordem.id}"/>"
												class="btn btn-default btn-margin-left">Visualizar/Finalizar</a></td>
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
