package kyorugi

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class DojangController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Dojang.list(params), model:[dojangCount: Dojang.count()]
    }

    def show(Dojang dojang) {
        respond dojang
    }

    def create() {
        respond new Dojang(params)
    }

    @Transactional
    def save(Dojang dojang) {
        if (dojang == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (dojang.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond dojang.errors, view:'create'
            return
        }

        dojang.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'dojang.label', default: 'Dojang'), dojang.id])
                redirect dojang
            }
            '*' { respond dojang, [status: CREATED] }
        }
    }

    def edit(Dojang dojang) {
        respond dojang
    }

    @Transactional
    def update(Dojang dojang) {
        if (dojang == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (dojang.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond dojang.errors, view:'edit'
            return
        }

        dojang.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'dojang.label', default: 'Dojang'), dojang.id])
                redirect dojang
            }
            '*'{ respond dojang, [status: OK] }
        }
    }

    @Transactional
    def delete(Dojang dojang) {

        if (dojang == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        dojang.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'dojang.label', default: 'Dojang'), dojang.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'dojang.label', default: 'Dojang'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
