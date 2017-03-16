import grails.util.Environment

environments {
	development {
		grails.logging.jul.usebridge = true
		grails.plugin.springsecurity.debug.useFilter = true
	}
	production {
		grails.logging.jul.usebridge = false
	}
}

grails.databinding.dateFormats = ['MMddyyyy', 'yyyy-MM-dd HH:mm:ss.S', "yyyy-MM-dd'T'hh:mm:ss'Z'"]

grails.plugin.console.enabled = true

//grails.plugin.springsecurity.useBasicAuth = true
grails.plugin.springsecurity.password.algorithm = 'SHA-256'
grails.plugin.springsecurity.password.hash.iterations = 1
grails.plugin.springsecurity.logout.postOnly = false


// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'com.sacrederp.security.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'com.sacrederp.security.UserRole'
grails.plugin.springsecurity.authority.className = 'com.sacrederp.security.Role'
def staticRules = [
		[pattern: '/',               				access: ['permitAll']],
		[pattern: '/error',          				access: ['permitAll']],
		[pattern: '/index',          				access: ['permitAll']],
		[pattern: '/index.gsp',      				access: ['permitAll']],
		[pattern: '/shutdown',       				access: ['permitAll']],
		[pattern: '/assets/**',      				access: ['permitAll']],
		[pattern: '/congregado/**',      			access: ['ROLE_ADMIN']],
		[pattern: '/congregacao/**',      			access: ['ROLE_ADMIN']],
		[pattern: '/lancamento/**',      			access: ['ROLE_USER']],
		[pattern: '/membro/**',      				access: ['ROLE_ADMIN']],
		[pattern: '/movimentoEspiritual/**',      	access: ['ROLE_USER']],
		[pattern: '/perfil/**',      				access: ['ROLE_USER']],
		[pattern: '/home/**',      					access: ['ROLE_ADMIN']],
		[pattern: '/**/js/**',       				access: ['permitAll']],
		[pattern: '/**/css/**',      				access: ['permitAll']],
		[pattern: '/**/images/**',   				access: ['permitAll']],
		[pattern: '/**/favicon.ico', 				access: ['permitAll']]
]

if (Environment.current == Environment.DEVELOPMENT) {
	staticRules << [pattern: '/console/**', 		access: ['permitAll']]
	staticRules << [pattern: '/static/console/**', 	access: ['permitAll']]
} else {
	staticRules << [pattern: '/console/**', 		access: ['ROLE_SUPORTE']]
	staticRules << [pattern: '/static/console/**', 	access: ['ROLE_SUPORTE']]
}
grails.plugin.springsecurity.controllerAnnotations.staticRules = staticRules
grails.plugin.springsecurity.filterChain.chainMap = [
		[pattern: '/assets/**',      filters: 'none'],
		[pattern: '/**/js/**',       filters: 'none'],
		[pattern: '/**/css/**',      filters: 'none'],
		[pattern: '/**/images/**',   filters: 'none'],
		[pattern: '/**/favicon.ico', filters: 'none'],
		[pattern: '/**',             filters: 'JOINED_FILTERS']
//		[pattern: '/**',             filters: 'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter,-rememberMeAuthenticationFilter']
]

grails.plugin.springsecurity.roleHierarchy = '''
   ROLE_SUPORTE > ROLE_ADMIN
   ROLE_ADMIN > ROLE_USER
'''

// Added by the Spring Security OAuth2 Google Plugin:
grails.plugin.springsecurity.oauth2.domainClass = 'com.sacrederp.security.OAuthID'
