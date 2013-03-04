package grails.plugin.dnsmanager

class ZoneService {
  def remotingService

  def create( Zone zone ) {
    log.info "Create zone $zone"
    try{
      zone.save()
    }catch (Exception e){
      log.error "Error creating $zone : $e.message"
      return false
    }
  }

  def update( Zone zone ) {
    log.info "Update zone $zone"
    try{
      zone.save()
    }catch (Exception e){
      log.error "Error updating $zone : $e.message"
      return false
    }
  }

  def delete( Zone zone ) {
    log.info "Delete zone $zone"
    try{
      zone.delete()
    }catch (Exception e){
      log.error "Error deleting $zone : $e.message"
      return false
    }
  }

  def updateZoneDomains( Zone zone ){
    log.info "Updating zone domains $zone"
    synchronized ( ZoneService.class ) {
      def list = Entry.withCriteria {
        eq "domain.zone", zone
      }
      def text = generateFile( list )
      remotingService.uploadFileContent( text, zone.domainFile, zone.server.ip )
    }
  }

}
