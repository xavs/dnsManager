import grails.plugin.dnsmanager.*

class S5CoreBootStrap {

  def init = { servletContext ->
    log.info "Executing Bootstrap"
    def st = ServerType.findByName("bind9-ubuntu")
    if ( !st ){
      log.info "No default bind9-ubuntu server type found, creating"
      st = new ServerType(
              [name:"bind-ubuntu",start:"/etc/init.d/bind9 start", stop:"/etc/init.d/bind9 stop", reload:"/etc/init.d/bind9 reload",
                      restart:"/etc/init.d/bind9 restart"]
      )
    }

    log.info "Executed BootStrap"
  }
}