package grails.plugin.dnsmanager
/**
 * Abstraction of the control commands for a dns server, like bind9
 */
class ServerType {

  String name
  String start
  String stop
  String reload
  String restart

  static constraints = {
    name blank: false
    start blank: false
    stop blank: false
    reload blank: false
    restart blank: false
  }
}
