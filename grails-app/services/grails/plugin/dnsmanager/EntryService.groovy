package grails.plugin.dnsmanager
/**
 *
 */
class EntryService {

  def zoneService

  def create( Entry entry ) {
    log.info "Create Entry $entry"
    entry.save(flush:  true)
    zoneService.updateZoneDomains( entry.domain.zone )
  }

  def update( Entry entry ) {
    log.info "Update Entry $entry"
    entry.save( flush:  true )
    zoneService.updateZoneDomains( entry.domain.zone )
  }

  def delete( Entry entry ) {
    log.info "Delete Entry $entry"
    entry.delete( flush: true )
    zoneService.updateZoneDomains( entry.domain.zone )
  }

  /*
  The methods bellow handle only the interaction with the files in the Server
   */
  private def createEntry( Entry entry ){
    log.debug "Create entry in server zone file for $entry"

  }

  private def updateEntry( Entry entry ){
    log.debug "Update entry in server zone file for $entry"

  }

  private def deleteEntry( Entry entry ){
    log.debug "Delete entry in server zone file for $entry"

  }

}
