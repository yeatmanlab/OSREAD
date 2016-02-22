

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'appforliteracy.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'appforliteracy.UserRole'
grails.plugin.springsecurity.userLookup.usernamePropertyName = 'email'
grails.plugin.springsecurity.authority.className = 'appforliteracy.Role'
//grails.plugin.springsecurity.rejectIfNoRule = false
//grails.plugin.springsecurity.fii.rejectPublicInvocations = false
grails.plugin.springsecurity.auth.loginFormUrl = '/login/auth'
grails.plugin.springsecurity.successHandler.defaultTargetUrl = "/researcher/home"
grails.plugin.springsecurity.failureHandler.defaultFailureUrl = '/login/auth'
grails.plugin.springsecurity.logout.afterLogoutUrl = '/'
grails.plugin.springsecurity.logout.alwaysUseDefaultTargetUrl = true
grails.plugin.springsecurity.logout.postOnly = false
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['ROLE_RESEARCHER', 'ROLE_USER']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.securityConfigType = "InterceptUrlMap"
grails.plugin.springsecurity.interceptUrlMap = [
   [pattern: '/',               access: ['ROLE_RESEARCHER', 'ROLE_USER']],
   [pattern: '/error',          access: ['permitAll']],
   [pattern: '/index',          access: ['permitAll']],
   [pattern: '/index.gsp',      access: ['permitAll']],
   [pattern: '/shutdown',       access: ['permitAll']],
   [pattern: '/assets/**',      access: ['permitAll']],
   [pattern: '/**/js/**',       access: ['permitAll']],
   [pattern: '/**/css/**',      access: ['permitAll']],
   [pattern: '/**/images/**',   access: ['permitAll']],
   [pattern: '/**/favicon.ico', access: ['permitAll']],
   [pattern: '/login',          access: ['permitAll']],
   [pattern: '/login/**',       access: ['permitAll']],
   [pattern: '/logout',         access: ['permitAll']],
   [pattern: '/logout/**',      access: ['permitAll']],
   [pattern: '/researcher/**',  access: ['ROLE_RESEARCHER']],
   [pattern: '/learner/**',     access: ['IS_AUTHENTICATED_FULLY']],
   [pattern: '/fileInput/**',   access: ['ROLE_RESEARCHER']],
   [pattern: '/fileOutput/**',  access: ['ROLE_RESEARCHER']],
   [pattern: '/firstExample/**',access: ['ROLE_USER']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

grails.plugin.springsecurity.rememberMe.persistent = true
grails.plugin.springsecurity.rememberMe.persistentToken.domainClassName = 'appforliteracy.PersistentLogin'

