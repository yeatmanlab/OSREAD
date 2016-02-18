<html>
	<head>
		<meta name="layout" content="${layoutUi}"/>
		<s2ui:title messageCode='spring.security.ui.user.search'/>
	</head>
	<body>
		<div>
			<s2ui:formContainer type='search' beanType='researcher'>
				<s2ui:searchForm colspan='4'>
					<tr>
						<td><g:message code='researcher.username.label' default='Username'/>:</td>
						<td colspan="3"><g:textField name='researchername' size='50' maxlength='255' autocomplete='off' value='${researchername}'/></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td><g:message code='spring.security.ui.search.true'/></td>
						<td><g:message code='spring.security.ui.search.false'/></td>
						<td><g:message code='spring.security.ui.search.either'/></td>
					</tr>
					<tr>
						<td><g:message code='researcher.enabled.label' default='Enabled'/>:</td>
						<g:radioGroup name='enabled' labels="['','','']" values='[1,-1,0]' value='${enabled ?: 0}'>
						<td><%=it.radio%></td>
						</g:radioGroup>
					</tr>
					<tr>
						<td><g:message code='researcher.accountExpired.label' default='Account Expired'/>:</td>
						<g:radioGroup name='accountExpired' labels="['','','']" values='[1,-1,0]' value='${accountExpired ?: 0}'>
						<td><%=it.radio%></td>
						</g:radioGroup>
					</tr>
					<tr>
						<td><g:message code='researcher.accountLocked.label' default='Account Locked'/>:</td>
						<g:radioGroup name='accountLocked' labels="['','','']" values='[1,-1,0]' value='${accountLocked ?: 0}'>
						<td><%=it.radio%></td>
						</g:radioGroup>
					</tr>
					<tr>
						<td><g:message code='researcher.passwordExpired.label' default='Password Expired'/>:</td>
						<g:radioGroup name='passwordExpired' labels="['','','']" values='[1,-1,0]' value='${passwordExpired ?: 0}'>
						<td><%=it.radio%></td>
						</g:radioGroup>
					</tr>
				</s2ui:searchForm>
			</s2ui:formContainer>
			<g:if test='${searched}'>
			<div class="list">
			<table>
				<thead>
				<tr>
					<s2ui:sortableColumn property='researchername' titleDefault='Researchername'/>
					<s2ui:sortableColumn property='enabled' titleDefault='Enabled'/>
					<s2ui:sortableColumn property='accountExpired' titleDefault='Account Expired'/>
					<s2ui:sortableColumn property='accountLocked' titleDefault='Account Locked'/>
					<s2ui:sortableColumn property='passwordExpired' titleDefault='Password Expired'/>
				</tr>
				</thead>
				<tbody>
				<g:each in='${results}' status='i' var='researcher'>
				<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
					<td><g:link action='edit' id='${researcher.id}'>${uiPropertiesStrategy.getProperty(researcher, 'researchername')}</g:link></td>
					<td><s2ui:formatBoolean bean='${researcher}' name='enabled'/></td>
					<td><s2ui:formatBoolean bean='${researcher}' name='accountExpired'/></td>
					<td><s2ui:formatBoolean bean='${researcher}' name='accountLocked'/></td>
					<td><s2ui:formatBoolean bean='${researcher}' name='passwordExpired'/></td>
				</tr>
				</g:each>
				</tbody>
			</table>
			</div>
			<s2ui:paginate total='${totalCount}'/>
			</g:if>
		</div>
		<s2ui:ajaxSearch paramName='researchername'/>
	</body>
</html>
