#!/usr/bin/env groovy

//see https://sites.google.com/a/athaydes.com/renato-athaydes/posts/agroovywebservertoservestaticandgroovlet-generatedcontent

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.*
import groovy.servlet.*
 
@Grab(group='org.eclipse.jetty.aggregate', module='jetty-all', version='7.6.15.v20140411')
def startJetty() {
	def server = new Server(8080)

	def handler = new ServletContextHandler(ServletContextHandler.SESSIONS)
	handler.contextPath = '/'
	handler.resourceBase = '.'
	handler.addServlet(GroovyServlet, '/scripts/*')
	def filesHolder = handler.addServlet(DefaultServlet, '/')
	filesHolder.setInitParameter('resourceBase', 'build/updateSite')

	server.handler = handler
	server.start()
}

println "Starting Jetty, press Ctrl+C to stop."
startJetty()
