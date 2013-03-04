package grails.plugin.dnsmanager

class Entry {
  String ip
  String ttl
  String namespace = "IN"
  String type
  static belongsTo = ["domain": Domain]

  static constraints = {
    type inList: ["A", "MX", "CNAME", "AAAA", "SOA", "NS", "PTR"]
    ip blank: false
  }
}
