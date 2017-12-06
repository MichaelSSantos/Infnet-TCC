<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page" %>

<page:template titulo="Editar quest�o">
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h3>Editar quest�o</h3>
				<form:form action="${s:mvcUrl('QC#atualizar').build()}" method="POST" commandName="questao">
					<input type="hidden" name="id" value="${questao.id}" />
					<div class="form-group">
						<label>T�pico:</label>
						<form:select path="grupoQuestoes.id" cssClass="form-control">
							<form:options items="${gruposQuestoes}" itemValue="id" itemLabel="descricao" />
						</form:select>
					</div>
					<div class="form-group">
						<label for="pergunta">Pergunta:</label>
						<textarea rows="6" cols="10" id="pergunta" name="pergunta" class="form-control">${questao.pergunta}</textarea>
					</div>
					<button type="submit" class="btn btn-primary">Salvar</button>
				</form:form>
			</div>
		</div>
	</div>
	
</page:template>