package grails.plugin.dnsmanager

class ServerService {

  def create( Server server ) {
    log.info "Create server $server"
  }

  def update( Server server ) {
    log.info "Update server $server"
  }

  def delete( Server server ) {
    log.info "Delete server $server"
  }
}
