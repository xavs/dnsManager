package grails.plugin.dnsmanager

class RemotingService {

  def grailsApplication

  boolean FAIL_ON_ERROR =  grailsApplication?.config?.dnsManager?.remoting?.failOnError ?: false
  boolean TRUST =  grailsApplication?.config?.dnsManager?.remoting?.failOnError ?: false

  def execute( String cmd, String hostname, username, password , failonerror, trust  ) {
    log.info "Execute ssh command: $cmd server: $hostname"
    AntBuilder ant = new AntBuilder()
    ant.sshexec(failonerror:false,trust:true,
            host:"${hostname}",username:"${username}",password:"${password}",command: cmd
            ,outputproperty:"execResult")
    def result = ant?.project?.properties?.execResult
    log.info "Execute result: $result"
  }

  def execute( String cmd, String hostname, String username, String password ){
    execute( cmd, hostname, username, password, FAIL_ON_ERROR, TRUST )
  }
}
