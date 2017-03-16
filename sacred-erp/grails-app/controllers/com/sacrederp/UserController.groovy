package com.sacrederp

import com.sacrederp.security.User
import grails.transaction.Transactional

@Transactional(readOnly = true)
class UserController {

    def index() {
        def userList = User.list(params)
        [userList: userList]
    }

    @Transactional
    def save() {

    }

    @Transactional
    def delete(Long id) {

    }

    def show() {

    }
}
