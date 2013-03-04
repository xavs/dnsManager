package grails.plugin.dnsmanager

class Server {
  String ip
  ServerType serverType
  String user
  String password

  static constraints = {
    serverType nullable: false
    ip nullable: false
  }
}
