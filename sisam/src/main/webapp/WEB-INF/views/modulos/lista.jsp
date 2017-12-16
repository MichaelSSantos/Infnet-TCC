<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page" %>

<page:template titulo="Modulos">
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				
				<c:if test="${not empty sucesso}">	
					<div class="alert alert-success" role="alert">${sucesso}</div>
				</c:if>
				
				<div class="page-header">
					<h3>Modulos do SISAM
						<a href="${s:mvcUrl('MC#novo').build()}" class="btn btn-info pull-right">Novo</a>
					</h3>
				</div>
				
				
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>Nome do Modulo</th>
							<th>Nome do Bloco</th>
							<th class="text-center">Editar</th>
							<th class="text-center">Remover</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${modulos}" var="modulo">
							<tr>
								<td>${modulo.nome}</td>
								<td>${modulo.bloco.nome}</td>
								<td class="text-center">
									<a href="${s:mvcUrl('MC#buscar').arg(0,modulo.id).build()}">
										<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
									</a>
								</td>
								<td class="text-center">
									<a href="${s:mvcUrl('MC#remover').arg(0, modulo.id).build()}">
										<i class="fa fa-trash-o" aria-hidden="true"></i>
									</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
			</div>
		</div>
	</div>
</page:template>