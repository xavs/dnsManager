package grails.plugin.dnsmanager

class Zone {
  String name
  String file //file with the zone config
  String domainFile //file with the domain config for the zone
  String serial //the current serial for the domainFile
  String serialStrategy   // A strategy used to generate serials, for now, it will be sequential
  String allowTransfer
  static belongsTo = ["server": Server]
  static hasMany = ["domains": Domain]

  static constraints = {
    name nullable: false, blank: false
    file nullable: false, blank: false
    server nullable: false, blank: false
    allowTransfer nullable: true
  }
}
