package grails.plugin.dnsmanager

class Domain {
  String name

  static belongsTo = ["zone": Zone]
  static hasMany = ["entries": Entry]
  static constraints = {
    name nullable: false, blank: false, matches: /^[a-zA-Z0-9][a-zA-Z0-9-]{1,63}[a-zA-Z0-9]+/
  }
}
