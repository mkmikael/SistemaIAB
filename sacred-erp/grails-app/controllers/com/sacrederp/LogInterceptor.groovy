package com.sacrederp

import com.sacrederp.security.User
import grails.plugin.springsecurity.SpringSecurityService
import org.hibernate.Session
import org.springframework.security.core.context.SecurityContextHolder


class LogInterceptor {

    SpringSecurityService springSecurityService

    LogInterceptor() {
        matchAll()
    }

    boolean before() {
        def p = new HashMap(params)
        def ip = request.remoteAddr
        def user = 'ANON'
        if (springSecurityService.isLoggedIn()) {
            def id = springSecurityService.currentUserId
            try {
                User.withNewSession { Session session ->
                    User userInstance = session.load(User, id)
                    if (userInstance)
                        user = userInstance.username
                }
            } catch (Exception e) {
                try {
                    if (springSecurityService.currentUser)
                        user = springSecurityService.currentUser.username
                } catch (Exception e_) {
                    log.debug("Erro ao obter usuário atual")
                    SecurityContextHolder.clearContext()
                }
            }
        }
        def controller = p.remove('controller') ?: ''
        def action = p.remove('action') ?: ''
        def format = p.remove('format') ?: ''
        log.debug("[${user ?: 'ANON'}@$ip][URI: $request.requestURI, M: $request.method, F: $format] P=${p}")
        true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
